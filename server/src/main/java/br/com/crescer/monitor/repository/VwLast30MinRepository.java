/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.repository;

import br.com.crescer.monitor.entity.view.ViewId;
import br.com.crescer.monitor.entity.view.VwLast30Min;
import java.util.List;
import org.springframework.data.repository.Repository;

/**
 *
 * @author Leonardo Bork
 */
public interface VwLast30MinRepository extends Repository<VwLast30Min, ViewId>{
    
    List<VwLast30Min> findById_machineRegisterId(Long machineRegisterId);
    
}