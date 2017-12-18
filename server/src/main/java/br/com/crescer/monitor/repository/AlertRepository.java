/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.repository;

import br.com.crescer.monitor.entity.Alert;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Leonardo Bork
 */
public interface AlertRepository extends CrudRepository<Alert, Long>{
    
    Page<Alert> findByNameContainingIgnoreCase(String descricao, Pageable page);
    
    Page<Alert> findAll(Pageable page);
    
}
