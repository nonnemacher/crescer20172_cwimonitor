/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.service;

import br.com.crescer.monitor.dto.AlertDto;
import br.com.crescer.monitor.entity.Alert;
import br.com.crescer.monitor.repository.AlertRepository;
import br.com.crescer.monitor.repository.GroupAlertRepository;
import br.com.crescer.monitor.repository.MachineMonitoringGroupRepository;
import br.com.crescer.monitor.repository.MachineRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Willian
 */
@Service
public class AlertService {

    @Autowired
    private AlertRepository alertRepository;

    @Autowired
    private MachineMonitoringGroupRepository groupRepository;

    @Autowired
    private MachineRegisterRepository machineRepository;

    public void save(AlertDto dto) {
        Alert group = dto.converterGroupAlert(dto);
        if (dto.isGrupo()) {
            group.setGroup(groupRepository.findOne(dto.getAgenteOuGrupo()));
        } else {
            group.setMachine(machineRepository.findOne(dto.getAgenteOuGrupo()));
        }
        alertRepository.save(group);
    }
    
    public void delete(Long id) {
        alertRepository.delete(id);
    }

    public Page<Alert> findByName(String name,Pageable pgbl){
        
        return alertRepository.findByNameContainingIgnoreCase(name,pgbl);
    }
    
    
   public Page<Alert> allAlert(Pageable pgbl) {
       
        return alertRepository.findAll(pgbl);
   }
}
