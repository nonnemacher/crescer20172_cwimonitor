/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.repository;

import br.com.crescer.monitor.entity.view.ViewGroupId;
import br.com.crescer.monitor.entity.view.ViewId;
import br.com.crescer.monitor.entity.view.VwLast15minGroup;
import br.com.crescer.monitor.entity.view.VwLast15Min;
import java.util.List;
import org.springframework.data.repository.Repository;

/**
 *
 * @author Willian
 */
public interface VwLast15MinGroupRepository extends Repository<VwLast15minGroup, ViewGroupId> {
    
    List<VwLast15minGroup> findById_GroupId(Long machineRegisterId);
    
}
