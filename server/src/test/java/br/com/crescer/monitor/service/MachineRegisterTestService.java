/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.service;

import br.com.crescer.configurationTest.ConfigurationTest;
import br.com.crescer.monitor.dto.MachineRegisterDto;
import br.com.crescer.monitor.entity.MachineRegister;
import br.com.crescer.monitor.repository.MachineRegisterRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Leonardo Bork
 */
public class MachineRegisterTestService extends ConfigurationTest {

    @Autowired
    MachineRegisterService machineRegisterService;

    @Autowired
    MachineRegisterRepository machineRegisterRepository;

    @Before
    public void setUp() {
        machineRegisterRepository.deleteAll();
    }

    @Test
    public void saveTest() {
        MachineRegisterDto machineRegisterDto = DataGenerator.createMachineRegisterDto();
        machineRegisterService.save(machineRegisterDto);

        assertEquals(machineRegisterService.findById(new Long(1)).getMachineNickname(), "Server");
        machineRegisterRepository.deleteAll();
    }

    @Test
    public void testFindAll() {

        for (int i = 0; i < 3; i++) {
            MachineRegisterDto machineRegisterDto = DataGenerator.createMachineRegisterDto();
            machineRegisterService.save(machineRegisterDto);
        }

        ArrayList<MachineRegister> machineRegisters = (ArrayList<MachineRegister>) machineRegisterService.allMachine();

        assertEquals(machineRegisters.get(0).getMachineNickname(), "Server");
        assertEquals(machineRegisters.get(1).getMachineNickname(), "Server");
        assertEquals(machineRegisters.get(2).getMachineNickname(), "Server");

        machineRegisterRepository.deleteAll();
    }

    @Test
    public void testDelete() {

        MachineRegisterDto machineRegisterDto = DataGenerator.createMachineRegisterDto();
        Long id = machineRegisterService.save(machineRegisterDto);
        
        machineRegisterService.delete(id);
        
        assertNull(machineRegisterRepository.findOne(id));

        machineRegisterRepository.deleteAll();
    }
}
