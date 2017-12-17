/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.service;

import br.com.crescer.configurationTest.ConfigurationTest;
import br.com.crescer.monitor.dto.MachineMonitoringGroupDto;
import br.com.crescer.monitor.dto.MachineRegisterDto;
import br.com.crescer.monitor.entity.MachineMonitoringGroup;
import br.com.crescer.monitor.entity.MachineRegister;
import br.com.crescer.monitor.repository.MachineMonitoringGroupRepository;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Willian
 */
public class MachineMonitoringGroupTestService extends ConfigurationTest {

    @Autowired
    MachineMonitoringGroupService groupService;

    @Autowired
    MachineRegisterService machineService;

    @Autowired
    MachineMonitoringGroupRepository groupRepository;

    @Before
    public void setUp() {
        groupRepository.deleteAll();
    }

    @Test
    public void testSave() {

        MachineMonitoringGroupDto dto = DataGenerator.createMachineMonitoringGroupDto();
        MachineMonitoringGroup result = groupService.save(dto);
        assertEquals(dto.getDescription(), result.getDescription());
        assertEquals(dto.getGroupIcon(), result.getGroupIcon());
        groupService.delete(result.getId());
    }
    
    @Test
    public void testDelete() {

        MachineMonitoringGroupDto dto = DataGenerator.createMachineMonitoringGroupDto();
        MachineMonitoringGroup result = groupService.save(dto);
        assertEquals(dto.getDescription(), result.getDescription());
        assertEquals(dto.getGroupIcon(), result.getGroupIcon());
        groupService.delete(result.getId());
        
        assertNull(groupRepository.findOne(result.getId()));
    }

    @Test
    public void testAddMachineRegister() throws Exception {

        MachineMonitoringGroupDto dto = DataGenerator.createMachineMonitoringGroupDto();
        MachineMonitoringGroup result = groupService.save(dto);
        assertEquals(dto.getDescription(), result.getDescription());
        assertEquals(dto.getGroupIcon(), result.getGroupIcon());

        MachineRegisterDto machine = DataGenerator.createMachineRegisterDto();
        Long machineId = machineService.save(machine);

        groupService.addMachineRegister(result.getId(), machineId);

        MachineMonitoringGroup result1 = groupRepository.findOne(result.getId());

        assertEquals(result1.getMachines().size(), 1);

        
        assertEquals(result1.getMachines().get(0).getMachineNickname(), "Server");
        assertEquals(result1.getMachines().get(0).getId(), machineId);
        
        

    }
    
    @Test
    public void testRemoveMachineRegister() throws Exception {

        MachineMonitoringGroupDto dto = DataGenerator.createMachineMonitoringGroupDto();
        MachineMonitoringGroup result = groupService.save(dto);
        assertEquals(dto.getDescription(), result.getDescription());
        assertEquals(dto.getGroupIcon(), result.getGroupIcon());

        MachineRegisterDto machine = DataGenerator.createMachineRegisterDto();
        Long machineId = machineService.save(machine);

        groupService.addMachineRegister(result.getId(), machineId);

        result = groupRepository.findOne(result.getId());

        assertEquals(result.getMachines().size(), 1);

        
        assertEquals(result.getMachines().get(0).getMachineNickname(), "Server");
        assertEquals(result.getMachines().get(0).getId(), machineId);
        
        groupService.removeMachineRegister(result.getId(), machineId);
        
        
        
       // assertEquals(result.getMachines().size(), 0);
        
        groupRepository.delete(result.getId());

    }
}
