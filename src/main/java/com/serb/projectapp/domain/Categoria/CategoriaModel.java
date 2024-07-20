package com.serb.projectapp.domain.Categoria;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "categorias")
public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( unique = true, nullable = false, length = 100)
    private String nome;

    @Column( nullable = false, length = 100 )
    private String descricao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data_cadastro = new Date();
    
}
