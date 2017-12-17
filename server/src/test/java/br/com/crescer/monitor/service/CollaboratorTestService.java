/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.service;

import br.com.crescer.configurationTest.ConfigurationTest;
import br.com.crescer.monitor.dto.CollaboratorDto;
import br.com.crescer.monitor.entity.Collaborator;
import br.com.crescer.monitor.repository.CollaboratorRepository;
import br.com.crescer.monitor.utility.BadRequestException;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Willian
 */
public class CollaboratorTestService extends ConfigurationTest {
    
    @Autowired
    CollaboratorService collaboratorService;

    @Autowired
    CollaboratorRepository collaboratorRepository;

    @Before
    public void setUp() {
        collaboratorRepository.deleteAll();
    }

    @Test(expected = BadRequestException.class)   
    public void testSaveException() {           
       
        CollaboratorDto dto = DataGenerator.createCollaboratorDto();
        
        collaboratorService.save(dto);
        collaboratorService.save(dto);
        
    }
    
    @Test
    public void testFindByEmail() {
        Collaborator collaborator = DataGenerator.createCollaborator();
        
        collaboratorRepository.save(collaborator);
        
        Collaborator result = collaboratorService.findByEmail(collaborator.getEmail());

        assertEquals(collaborator.getId(), result.getId());
        assertEquals(collaborator.getName(), result.getName());
        assertEquals(collaborator.getEmail(), result.getEmail());
        assertEquals(collaborator.getPass(), result.getPass());
        
        collaboratorRepository.delete(collaborator.getId());
    }
    
    @Test
    public void testSave() {
        final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();     
       
        CollaboratorDto dto = DataGenerator.createCollaboratorDto();
        
        collaboratorService.save(dto);
        
        Collaborator result = collaboratorService.findByEmail(dto.getEmail());
        
        assertEquals(dto.getNome(), result.getName());
        assertEquals(dto.getEmail(), result.getEmail());                
        assertTrue(passwordEncoder.matches(dto.getSenha(), result.getPass()));
        collaboratorRepository.delete(result.getId());
    }
    
   
    
    @Test
    public void testDelete() {
        final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();     
       
        CollaboratorDto dto = DataGenerator.createCollaboratorDto();
        
        Long collaboratorId =collaboratorService.save(dto);
        
        Collaborator result = collaboratorRepository.findOne(collaboratorId);
        
        assertEquals(dto.getNome(), result.getName());
        assertEquals(dto.getEmail(), result.getEmail());                
        assertTrue(passwordEncoder.matches(dto.getSenha(), result.getPass()));
        collaboratorRepository.delete(result.getId());
        
        Collaborator result2 = collaboratorRepository.findOne(collaboratorId);
        assertNull(result2);
    }
    
    @Test
    public void testFindAll() {
        final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();     
       
        CollaboratorDto dtoWillian = DataGenerator.createCollaboratorDto();
        CollaboratorDto dtoBork = DataGenerator.createCollaboratorDto2();
        CollaboratorDto dtoAlvaro = DataGenerator.createCollaboratorDto3();
        
        collaboratorService.save(dtoWillian);
        collaboratorService.save(dtoBork);
        collaboratorService.save(dtoAlvaro);
        
        List<Collaborator> dtos = collaboratorService.findAll();
        assertEquals(dtos.size(),3);
        assertEquals(dtos.get(0).getName(),"Willian");
        assertEquals(dtos.get(0).getEmail(),"willian.velhos@cwi.com.br");
        assertEquals(dtos.get(1).getName(),"Bork");
        assertEquals(dtos.get(1).getEmail(),"bork@cwi.com.br");
        assertEquals(dtos.get(2).getName(),"Alvaro");
        assertEquals(dtos.get(2).getEmail(),"alvaro@cwi.com.br");
        
    }
}
