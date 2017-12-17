/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.service;

import br.com.crescer.configurationTest.ConfigurationTest;
import br.com.crescer.monitor.entity.MachineTag;
import br.com.crescer.monitor.repository.MachineTagRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Leonardo Bork
 */
public class MachineTagTestService extends ConfigurationTest{
    
    @Autowired
    MachineTagService machineTagService;
    
    @Autowired
    MachineTagRepository machineTagRepository;
    
     @Before
    public void setUp() {
        machineTagRepository.deleteAll();
    }
    
    @Test
    public void testFindByDescription(){
    
        MachineTag machineTag = DataGenerator.createMachineTag();
    }
}
