package com.serb.projectapp.Taxa;

import java.math.BigDecimal;
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
@Entity()
@Table( name = "taxas" )
public class TaxaModel {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( unique = true, nullable = false )
    private Long parcela;

    @Column( unique = true, nullable = false )
    private BigDecimal valor;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data_entrada;

    @Temporal(TemporalType.DATE)
    private Date data_pagamento;

    @Temporal(TemporalType.DATE)
    private Date data_saida;
    
}
