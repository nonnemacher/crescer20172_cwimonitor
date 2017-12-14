/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.service;

import br.com.crescer.monitor.entity.MachineTag;
import br.com.crescer.monitor.repository.MachineMonitoringGroupRepository;
import br.com.crescer.monitor.repository.MachineTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author willian.velhos
 */
@Service
public class MachineTagService {
    
    @Autowired
    private MachineTagRepository tagRepository;
    
    
    public Page<MachineTag> findByDescription(String descripition, Pageable page){
        
        return tagRepository.findByDescriptionContainingIgnoreCase(descripition, page);
        
    }
    
}