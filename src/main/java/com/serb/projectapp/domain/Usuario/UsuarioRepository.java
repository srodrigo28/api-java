package com.serb.projectapp.domain.Usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    @Query("select s from tb_usuario s where s.sexo = 'f' ")
    List<UsuarioModel> buscaSexoF();

    @Query("select s from tb_usuario s where s.sexo = 'm' ")
    List<UsuarioModel> buscaSexoM();

}



















