/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.payapi.entity;

/**
 *
 * @author jk
 */


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class PayAPI implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo_debito;
    
    @Column(name = "cpf_cnpj", nullable = false)
    private String cpf_cnpj;
    
    @Column(name = "met_pag" , nullable = false)
    private String met_pag;
    
    @Column(name = "num_card")
    private String num_card;
    
    @Column(name = "valor", nullable = false)
    private String valor;
    
    @Column(name = "status", nullable = false)
    private String status;
    
}
