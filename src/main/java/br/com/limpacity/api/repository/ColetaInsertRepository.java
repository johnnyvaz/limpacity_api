package br.com.limpacity.api.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

@Repository
public class ColetaInsertRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertWithQuery(Long postoId, String uuid, String obs) {
        Date data = new Date();
        entityManager.createNativeQuery("INSERT INTO coleta_qrcode " +
                " ( posto_id, uuid, creation_date, ativo, observacao , qtde_not_email, integration_status ) " +
                " VALUES (?,?,?,1,?,0,'N') ")
                .setParameter(1, postoId.intValue())
                .setParameter(2, uuid)
                .setParameter(3, data)
                .setParameter(4, obs)
                .executeUpdate();
    }
}
