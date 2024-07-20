package com.serb.projectapp.domain.Categoria;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("api/categoria")
public class CategoriaController {
    
    @Autowired 
    private CategoriaService categoriaService;

    @PostMapping("/")  /*** 1. Cadastrar */
    public CategoriaModel Inserir(@RequestBody CategoriaModel categoria) {
        return categoriaService.Inserir(categoria);
    }

    @GetMapping("/")    /*** 2. Listar Todos */
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

    @GetMapping("/{id}")
    public CategoriaModel BuscarPorId(@PathVariable Long id) {
        return categoriaService.ListarById(id);
    }

    /*** Outra opção de delete
    @DeleteMapping("/{id}")
    public void Deletar(@PathVariable Long id) {
        categoriaService.Excluir(id);
    }
    */

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Remover(@PathVariable Long id) {
        categoriaService.Excluir(id);
        return ResponseEntity.ok().build();
    }
}
