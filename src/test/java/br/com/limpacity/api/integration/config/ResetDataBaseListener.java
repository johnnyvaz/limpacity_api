package br.com.limpacity.api.integration.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class ResetDataBaseListener implements TestExecutionListener{
    private DataSource dataSource;

    @Override
    public void beforeTestClass(final TestContext testContext) {
        dataSource = testContext.getApplicationContext().getBean(DataSource.class);
    }

    @Override
    public void afterTestExecution(final TestContext testContext) throws Exception {
        resetDatabase();
    }

    private void resetDatabase() throws SQLException {

        log.info("M=resetDatabase, init reset database");

        Connection connection = dataSource.getConnection();

        Statement statement = connection.createStatement();

        try (connection; statement) {

            execute(statement, "SET REFERENTIAL_INTEGRITY FALSE");

            final ResultSet tableNames = executeQuery(statement, "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA='PUBLIC'");

            getRows(tableNames)
                    .forEach(tableName -> execute(statement, "TRUNCATE TABLE " + tableName));

            final ResultSet sequences = executeQuery(statement, "SELECT SEQUENCE_NAME FROM INFORMATION_SCHEMA.SEQUENCES WHERE SEQUENCE_SCHEMA='PUBLIC'");

            getRows(sequences)
                    .forEach(sequence -> execute(statement, "ALTER SEQUENCE " + sequence + " RESTART WITH 1"));

            execute(statement, "SET REFERENTIAL_INTEGRITY TRUE");

        } catch (Exception e) {
            log.error("M=resetDatabase, cannot be execute query", e);
        }
    }

    private ResultSet executeQuery(final Statement statement, final String sql) throws SQLException {
        return statement.executeQuery(sql);
    }

    private Set<String> getRows(final ResultSet resultSet) {
        try (resultSet) {
            HashSet<String> data = new HashSet<>();
            while (resultSet.next()) {
                data.add(resultSet.getString(1));
            }
            return data;
        } catch (Exception e) {
            log.error("M=getRows, cannot be extract rows", e);
            return null;
        }
    }

    private void execute(final Statement statement, final String sql) {
        try {
            statement.execute(sql);
        } catch (Exception e) {
            log.error("M=executeQuery, cannot be execute query, ", e);
        }
    }
}
