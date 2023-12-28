package com.serb.projectapp.domain.Usuario;

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
@RequestMapping("/api/users")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/")
    public UsuarioModel inserir(@RequestBody UsuarioModel usuario){
        return usuarioService.inserir(usuario);
    }

    @GetMapping("/")
    public List<UsuarioModel> listarTodos(){
        return usuarioService.buscarTodos();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> usuarioFindById(@PathVariable("id") Long id){
        UsuarioModel usuario = usuarioService.buscaUm(id);
        return ResponseEntity.ok(usuario);
    }


    @GetMapping("/f")
    public List<UsuarioModel> buscarMulheres(){
        return usuarioService.buscarFeminino();
    }

    @GetMapping("/m")
    public List<UsuarioModel> buscarMasculinos(){
        return usuarioService.buscarMasculinos();
    }

    @PutMapping("/")
    @CrossOrigin("*")
    public UsuarioModel atualizar(@RequestBody UsuarioModel usuario){
        return usuarioService.alterar(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable("id")Long id) {
        usuarioService.excluir(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public Optional<UsuarioModel> listarUm(@PathVariable Long id){
        return usuarioService.findById(id);
    }
}
