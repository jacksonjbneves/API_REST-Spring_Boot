/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.payapi.repository;

import br.com.payapi.entity.PayAPI;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jk
 */
public interface PayAPIRepository extends JpaRepository<PayAPI, Long>{
    //FILTROS CODIGO_DEBITO
    //List<PayAPI> findAllByCODIGO_DEBITO(Long codigo_debito);
    
    //FILTROS CPF_CNPJ
    //List<PayAPI> findAllByCPF_CNPJ(String cpf_cnpj);
    //@Query("SELECT cc.* FROM PAYAPI cc WHERE cc.cpf_cnpj = :cpf_cnpj")
    //List<PayAPI> findBycpgcnpj(@Param("cpf_cnpj") String cpf_cnpj);
    //List<PayAPI> findBycpf_cnpj(String cpfcnpj);
    
    //FILTROS STATUS
    //List<PayAPI> findAllBySTATUS(String status);
}
