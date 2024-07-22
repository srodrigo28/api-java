package com.serb.projectapp.Taxa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class TaxaController {
    
    @Autowired
    private TaxaService service;

    @PostMapping("/api/taxa")
    public TaxaModel salvar(@RequestBody TaxaModel taxa) {
        return service.inserir(taxa);
    }

    @GetMapping("/api/taxa")
    public Iterable<TaxaModel> listarTodas() {
        return service.listarTodos();
    }

    @GetMapping("/api/taxa/{id}")
    public TaxaModel buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/api/taxa")
    public TaxaModel atualizar(@RequestBody TaxaModel taxa) {
        return service.atualizar(taxa);
    }

    @DeleteMapping("/api/taxa/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
