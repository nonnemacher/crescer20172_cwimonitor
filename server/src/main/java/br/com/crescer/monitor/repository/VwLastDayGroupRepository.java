/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.repository;

import br.com.crescer.monitor.entity.view.ViewGroupId;
import br.com.crescer.monitor.entity.view.VwLastDayGroup;
import java.util.List;
import org.springframework.data.repository.Repository;

/**
 *
 * @author Willian
 */
public interface VwLastDayGroupRepository extends Repository<VwLastDayGroup, ViewGroupId> {
    
    List<VwLastDayGroup> findById_GroupId(Long machineRegisterId);
    
}
