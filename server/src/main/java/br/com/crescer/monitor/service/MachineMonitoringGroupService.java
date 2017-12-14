/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.service;

import br.com.crescer.monitor.dto.MachineMonitoringGroupDto;
import br.com.crescer.monitor.entity.MachineMonitoringGroup;
import br.com.crescer.monitor.entity.MachineRegister;
import br.com.crescer.monitor.repository.MachineMonitoringGroupRepository;
import br.com.crescer.monitor.repository.MachineRegisterRepository;
import br.com.crescer.monitor.utility.BadRequestException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Willian
 */
@Service
public class MachineMonitoringGroupService {

    @Autowired
    private MachineMonitoringGroupRepository groupRepository;
    @Autowired
    private MachineRegisterRepository machineRepository;

    public MachineMonitoringGroup save(MachineMonitoringGroupDto dto) {
        if (groupRepository.existsByDescriptionIgnoreCase(dto.getDescription())) {
            throw new BadRequestException("Já existe um grupo com esse nome");
        }

        MachineMonitoringGroup group = dto.converter(dto);

        return groupRepository.save(group);
    }

    public void addMachineRegister(Long idGroup, Long idAgent) throws Exception {

        MachineMonitoringGroup group = groupRepository.findOne(idGroup);

        if (null == group) {
            throw new Exception("Não existe grupo com esse id");
        }

        MachineRegister machine = machineRepository.findOne(idAgent);

        group.addMachineRegister(machine);

        groupRepository.save(group);
    }

    public void delete(Long id) {
        groupRepository.delete(id);

    }

    public void removeMachineRegister(Long idGroup, Long idAgent) throws Exception {
        MachineMonitoringGroup group = groupRepository.findOne(idGroup);
        if (group == null) {
            throw new Exception("Não existe grupo com esse id");
        }

        MachineRegister machine = machineRepository.findOne(idAgent);

        if (machine == null) {
            throw new Exception("Não existe agente com esse id");
        }

        group.removeMachineRegister(machine);

        groupRepository.save(group);

    }

    public Page<MachineMonitoringGroup> allGroup(Pageable pgbl) {

        return groupRepository.findAll(pgbl);
    }

    public List<MachineMonitoringGroup> allGroup() {

        return (List<MachineMonitoringGroup>) groupRepository.findAll();
    }

}
