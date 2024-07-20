package com.serb.projectapp.Servico;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity(name="tb_servicos")
public class ServicoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String cliente;

    @Column(nullable = false)
    private String descricao;

    private Double valor;

    private Double valor_pago;

    @Column(nullable = true)
    private String status; 
    // orçamento, pago-entregue, aguardando-aprovação, cancelado

    @Temporal(TemporalType.TIMESTAMP)
    private Date data_entrada;

    @Temporal(TemporalType.DATE)
    private Date data_pagamento;

    @Temporal(TemporalType.DATE)
    private Date data_saida;
}
