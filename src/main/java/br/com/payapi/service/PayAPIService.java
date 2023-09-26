/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.com.payapi.service;


import br.com.payapi.entity.PayAPI;
import br.com.payapi.repository.PayAPIRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author jk
 */

@Service
public class PayAPIService {
    
    @Autowired
    private PayAPIRepository payapiRepository;
    
    public PayAPI salvar(PayAPI payapi){ //Save and Upload
       return payapiRepository.save(payapi);
    }
    
    public List<PayAPI> listaCliente(){
       return payapiRepository.findAll();
    }
    //FILTROS CODIGO_DEBITO
    public Optional<PayAPI> buscarPorCodigo_debito(Long codigo_debito){
       return payapiRepository.findById(codigo_debito);
    }
    //FILTROS CPFCNPJ
    /*public List<PayAPI> buscarPorCPF_CNPJ(String cpf_cnpj){
       //return payapiRepository.findAllByCPF_CNPJ(cpf_cnpj); // isso vem do ClienteRepository[INTERFACE]       
       return payapiRepository.findBycpgcnpj(cpf_cnpj); // isso vem do ClienteRepository[INTERFACE]       
    }*/
    //FILTROS STATUS
    /*public List<PayAPI> buscarPorSTATUS(String status){
       //return payapiRepository.findAllBySTATUS(status); // isso vem do ClienteRepository[INTERFACE]       
    }*/
    
    public void removerPorId(Long codigo_debito){
       payapiRepository.deleteById(codigo_debito);
    }
}
