package com.serb.projectapp.domain.Servico;

import java.util.List;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<ServicoModel, Long> {

    @Query("select s from tb_servicos s where s.status = 'pendente'")
    List<ServicoModel> buscarServicosPendentes();

    @Query("select s from tb_servicos s where s.status = 'cancelado' ")
    List<ServicoModel> buscarServicosCancelados();
    
    @Query("select s from tb_servicos s where s.status = 'aguardando-orçamento' ")
    List<ServicoModel> buscarServicosAguardando();

    @Query("select s from tb_servicos s where s.status = 'orçamento' ")
    List<ServicoModel> buscarServicosOrcamentos();

    @Query("select s from tb_servicos s where s.status = 'entregue' ")
    List<ServicoModel> buscarEntregues();
}



















