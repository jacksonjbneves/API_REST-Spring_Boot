/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.payapi.controller;

import br.com.payapi.entity.PayAPI;
import br.com.payapi.service.PayAPIService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.modelmapper.ModelMapper;


import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author jk
 */


@RestController
@RequestMapping("/paylaod")

public class PayAPIController {
    @Autowired
    private PayAPIService payapiService;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PayAPI salvar(@RequestBody PayAPI payapi){ //Save and Upload
        return payapiService.salvar(payapi);
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PayAPI> ListaPayAPI(){
        return payapiService.listaCliente();
    }
    
    @GetMapping("/cd/{codigo_debito}")
    @ResponseStatus(HttpStatus.OK)
    public PayAPI buscarPayAPIPorcodigo_debito(@PathVariable("codigo_debito") Long codigo_debito){
        return payapiService.buscarPorCodigo_debito(codigo_debito)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "BUSCA: CODIGO_DEBITO não Encontrado!"));
    }
    
    @DeleteMapping("/del/{codigo_debito}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable("codigo_debito") Long codigo_debito){
        payapiService.removerPorId(codigo_debito);
    }
    
    @PutMapping("/up/{codigo_debito}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarCliente(@PathVariable("codigo_debito") Long codigo_debito, @RequestBody PayAPI payapi){
        payapiService.buscarPorCodigo_debito(codigo_debito)
                .map(payapiBase -> {
                    modelMapper.map(codigo_debito, payapiBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "UPLOAD: ID não encontrado!"));
    }
    
    /*@GetMapping("/cc/{cpf_cnpj}")
    @ResponseStatus(HttpStatus.OK)
    public List<PayAPI> buscarPayAPIPorCPF_CNPJ(@PathVariable("cpf_cnpj") String cpf_cnpj){
        List<PayAPI> resultado = payapiService.buscarPorCPF_CNPJ(cpf_cnpj);
        if(resultado.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "BUSCA: CPF_CNPJ não Encontrado!");
        }
        return resultado;
    }*/
    
    /*@GetMapping("/cc/{cpf_cnpj}")
    @ResponseStatus(HttpStatus.OK)
    public List<PayAPI> buscarPayAPIPorCPF_NPJ(@PathVariable("cpf_cnpj") String cpf_cnpj){
        //return payapiService.buscarPorCPF_CNPJ(cpf_cnpj)
        //        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "BUSCA: CPF CNPJ não Encontrado!"));
        //if(payapiService.buscarPorCPF_CNPJ(cpf_cnpj) == null){ throw new ResponseStatusException(HttpStatus.NOT_FOUND, "BUSCA: CPF CNPJ não Encontrado!"); }
        //return payapiService.buscarPorCPF_CNPJ(cpf_cnpj);        
        List<PayAPI> resultado = payapiService.buscarPorCPF_CNPJ(cpf_cnpj);
        if(resultado.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "BUSCA: CPF_CNPJ não Encontrado!");
        }
        return resultado;
    }*/
    
    //POR NOME
    /*@GetMapping("/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> buscarClientePorNome(@PathVariable("nome") String nome){
        //return payapiService.buscarPorNome(nome).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "BUSCA: NOME não Encontrado!"));        
     List<Cliente> clientesOptional = payapiService.buscarPorNome(nome);
    
        if (clientesOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "BUSCA: NOME não Encontrado!");
        } else {
            return clientesOptional;
        }
    }*/
    
}
