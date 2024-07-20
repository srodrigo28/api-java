package com.serb.projectapp.Servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public ServicoModel inserir(ServicoModel service){
        if( service.getValor_pago() == null 
            || service.getValor_pago() == 0 
            || service.getData_pagamento() == null
            ){
            service.setStatus("aguardando-orçamento");
        }
        ServicoModel servicoBanco = servicoRepository.saveAndFlush(service);
        return servicoBanco;
    }

    public List<ServicoModel> buscarTodos(){
        return servicoRepository.findAll();
    }

    public ServicoModel buscaUm(Long id) {
        return servicoRepository.findById(id).get();
    }

    public ServicoModel alterar(ServicoModel servico){
        // if( servico.getCliente() != null && servico.getValor_pago() > 0){
        //     servico.setStatus("relizado");
        // }
        return servicoRepository.saveAndFlush(servico);
    }

    public void excluir(Long id){
        ServicoModel servico = servicoRepository.findById(id).get();
        servicoRepository.delete(servico);
    }

    /*** @implSpec Ações Repository */

    /*** Inicio de filtros com GET */
    /***  */
    public List<ServicoModel> buscarCancelados(){
        return servicoRepository.buscarServicosCancelados();
    }

    public List<ServicoModel> buscarEntregues(){
        return servicoRepository.buscarEntregues();
    }

    public List<ServicoModel> buscarAguardandos(){
        return servicoRepository.buscarServicosAguardando();
    }

    public List<ServicoModel> buscarOrcamentos(){
        return servicoRepository.buscarServicosOrcamentos();
    }

    public List<ServicoModel> buscarPendentes(){
        return servicoRepository.buscarServicosPendentes();
    }
    
    /*** Fim de filtros com GET */
    
    public ServicoModel alterar_entregue(ServicoModel service){
        if( service.getValor_pago() > 0  // condição 1
            && service.getData_pagamento() != null // condição 2
            && service.getData_saida() != null)  { // condição 3

            service.setStatus("entregue"); // inserir o status
        }
        ServicoModel servicoBanco = servicoRepository.saveAndFlush(service);
        return servicoBanco;
    }

}


























