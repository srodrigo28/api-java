package com.serb.projectapp.Usuario;

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
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/users")
    public UsuarioModel inserir(@RequestBody UsuarioModel usuario){
        return usuarioService.inserir(usuario);
    }

    @GetMapping("/users")
    public List<UsuarioModel> listarTodos(){
        return usuarioService.buscarTodos();
    }
    
    @GetMapping("/users/{id}")
    public ResponseEntity<UsuarioModel> usuarioFindById(@PathVariable Long id){
        UsuarioModel usuario = usuarioService.buscaUm(id);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/users/f")
    public List<UsuarioModel> buscarMulheres(){
        return usuarioService.buscarFeminino();
    }

    @GetMapping("/users/m")
    public List<UsuarioModel> buscarMasculinos(){
        return usuarioService.buscarMasculinos();
    }

    @PutMapping("/users")
    @CrossOrigin("*")
    public UsuarioModel atualizar(@RequestBody UsuarioModel usuario){
        return usuarioService.alterar(usuario);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        usuarioService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
