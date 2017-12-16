/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.service;

import br.com.crescer.configurationTest.ConfigurationTest;
import br.com.crescer.monitor.dto.MachineMonitoringGroupDto;
import br.com.crescer.monitor.entity.MachineMonitoringGroup;
import br.com.crescer.monitor.repository.MachineMonitoringGroupRepository;
import static org.junit.Assert.assertEquals;
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
    MachineMonitoringGroupRepository groupRepository;

    @Before
    public void setUp() {
        groupRepository.deleteAll();
    }
    
    @Test
    public void testSave() {         
       
        MachineMonitoringGroupDto dto = DataGenerator.createMachineMonitoringGroupDto();
        MachineMonitoringGroup result =groupService.save(dto);
        assertEquals(dto.getDescription(), result.getDescription());
        assertEquals(dto.getGroupIcon(), result.getGroupIcon());
        groupService.delete(result.getId());
    }
}
