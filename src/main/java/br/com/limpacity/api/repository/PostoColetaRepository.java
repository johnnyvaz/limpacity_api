package br.com.limpacity.api.repository;

import br.com.limpacity.api.model.PostoColetaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostoColetaRepository extends JpaRepository<PostoColetaModel, Long> {

    @Query(" select m from PostoColetaModel m " +
            " where m.active = true ")
    List<PostoColetaModel> findAllAndSendQueue();

    @Query(" select m from PostoColetaModel m " +
            " where m.active = true " +
            " and m.qr_code = :qr_code ")
    List<PostoColetaModel> findByQr_codeAndActive(@Param("qr_code") String qr_code);
    
}
