/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.controller;

import br.com.crescer.monitor.entity.Collaborator;
import br.com.crescer.monitor.repository.CollaboratorRepository;
import br.com.crescer.configurationTest.ConfigurationTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 *
 * @author Willian
 */
public class LoginControllerTest extends ConfigurationTest {
    
    
    @Autowired
    CollaboratorRepository collaboratorRepository;

    @Before
    public void setUp() {
        collaboratorRepository.deleteAll();
    }

    @Test
    @WithMockUser(username = "teste@teste.com", password = "teste")
    public void getLoggedPerson() throws Exception {
        Collaborator CollaboratorTest = collaboratorRepository.save(getCollaboratorOne());
        mockMvc.perform(MockMvcRequestBuilders.get("/user/access"))
                .andExpect(status().isOk())        
                .andExpect(jsonPath("username").value(CollaboratorTest.getEmail()))
                .andExpect(jsonPath("password").value(CollaboratorTest.getPass()));
                
    }

    private Collaborator getCollaboratorOne() {
        return Collaborator.builder()
                .name("Willian")
                .email("teste@teste.com")
                .pass("teste")
                .birthdate(LocalDate.now())
                .build();
    }


}
