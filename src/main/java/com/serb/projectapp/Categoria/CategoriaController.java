package com.serb.projectapp.Categoria;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin("*")
public class CategoriaController {
    
    @Autowired 
    private CategoriaService categoriaService;

    @PostMapping("/api/categoria")  /*** 1. Cadastrar */
    @CrossOrigin("*")
    public CategoriaModel Inserir(@RequestBody CategoriaModel categoria) {
        return categoriaService.Inserir(categoria);
    }

    @GetMapping("/api/categoria")    /*** 2. Listar Todos */
    @CrossOrigin("*")
    public Iterable<CategoriaModel> ListarTodos() {
        return categoriaService.ListarTodos();
    }

    /** *********************************************************************************************** */

    /*** Outra opção de listar
    @GetMapping
    public List<CategoriaModel> ListarTodos2() {
        return categoriaService.ListarTodos();
    }
    */

    @GetMapping("/api/categoria/{id}")
    public CategoriaModel BuscarPorId(@PathVariable Long id) {
        return categoriaService.ListarById(id);
    }

    /*** Outra opção de delete
    @DeleteMapping("/{id}")
    public void Deletar(@PathVariable Long id) {
        categoriaService.Excluir(id);
    }
    */

    @DeleteMapping("/api/categoria/{id}")
    public ResponseEntity<Void> Remover(@PathVariable Long id) {
        categoriaService.Excluir(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/categoria")
    public CategoriaModel Atualizar(@RequestBody CategoriaModel categoria){
        return categoriaService.Alterar(categoria);
      
    }
}
