package com.serb.projectapp.domain.Servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping("/")
    public List<ServicoModel> buscaTodos(){
        return servicoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoModel> servicoFindById(@PathVariable Long id){
        ServicoModel servico = servicoService.buscaUm(id);
        return ResponseEntity.ok(servico);
    }

    @GetMapping("/cancelados")
    public List<ServicoModel> buscaCancelado(){
        return servicoService.buscarCancelados();
    }
    
    @GetMapping("/entregue")
    public List<ServicoModel> buscaTodosEntregues(){
        return servicoService.buscarEntregues();
    }

    @GetMapping("/pendentes")
    public List<ServicoModel> buscaPendente(){
        return servicoService.buscarPendentes();
    }
    
    @PostMapping("/")
    public ServicoModel inserir(@RequestBody ServicoModel servico){
        return servicoService.inserir(servico);
    }
    @PutMapping("/")
    @CrossOrigin("*")
    public ServicoModel atualizar(@RequestBody ServicoModel servico){
        return servicoService.alterar(servico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        servicoService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
