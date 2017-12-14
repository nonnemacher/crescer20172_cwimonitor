/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.repository;
import br.com.crescer.monitor.entity.view.VwLast12Hours;

import br.com.crescer.monitor.entity.view.ViewId;
import java.util.List;
import org.springframework.data.repository.Repository;

/**
 *
 * @author leonardo.bork
 */
public interface VwLast12HoursRepository extends Repository<VwLast12Hours, ViewId> {
    
       List<VwLast12Hours> findById_machineRegisterId(Long machineRegisterId);
}
