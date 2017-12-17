/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.repository;

import br.com.crescer.monitor.entity.view.ViewGroupId;
import br.com.crescer.monitor.entity.view.ViewId;
import br.com.crescer.monitor.entity.view.VwLast6HoursGroup;
import java.util.List;
import org.springframework.data.repository.Repository;

/**
 *
 * @author Willian
 */
public interface VwLast6HourGroupRepository extends Repository<VwLast6HoursGroup, ViewGroupId> {
    
    List<VwLast6HoursGroup> findById_GroupId(Long machineRegisterId);
    
}
