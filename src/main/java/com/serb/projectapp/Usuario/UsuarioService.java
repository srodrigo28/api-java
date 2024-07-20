package com.serb.projectapp.Usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioModel inserir(UsuarioModel usuario){
        if( usuario.getNome() == null 
            || usuario.getTelefone() == null
            || usuario.getCidade() == null
            ){
            throw new IllegalArgumentException("Preceisa preencher: nome, cidade, telefone");
        }
        UsuarioModel servicoBanco = usuarioRepository.saveAndFlush(usuario);
        return servicoBanco;
    }

    public List<UsuarioModel> buscarTodos(){
        return usuarioRepository.findAll();
    }

    public UsuarioModel buscaUm(Long id) {
        return usuarioRepository.findById(id).get();
    }

    public UsuarioModel alterar(UsuarioModel usuario){
        return usuarioRepository.saveAndFlush(usuario);
    }

    public void excluir(Long id){
        UsuarioModel usuario = usuarioRepository.findById(id).get();
        usuarioRepository.delete(usuario);
    }

    /*** @implSpec Ações Repository */
    
    public List<UsuarioModel> buscarMasculinos(){
        return usuarioRepository.buscaSexoM();
    }

    public List<UsuarioModel> buscarFeminino(){
        return usuarioRepository.buscaSexoF();
    }
}


























