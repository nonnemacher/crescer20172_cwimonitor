/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.service;

import br.com.crescer.monitor.dto.CollaboratorDto;
import br.com.crescer.monitor.dto.MachineMonitoringGroupDto;
import br.com.crescer.monitor.entity.Collaborator;
import java.time.LocalDate;

/**
 *
 * @author Willian
 */
public class DataGenerator {

    public static Collaborator createCollaborator() {
        Collaborator collaborator = new Collaborator();

        collaborator.setName("Willian");
        collaborator.setPass("12345");
        collaborator.setEmail("willian.velhos@cwi.com.br");
        collaborator.setBirthdate(LocalDate.now());

        return collaborator;
    }

    public static CollaboratorDto createCollaboratorDto() {
        CollaboratorDto dto = new CollaboratorDto();

        dto.setNome("Willian");
        dto.setSenha("12345");
        dto.setEmail("willian.velhos@cwi.com.br");
        dto.setData(LocalDate.now());

        return dto;
    }

    public static CollaboratorDto createCollaboratorDto2() {
        CollaboratorDto dto = new CollaboratorDto();

        dto.setNome("Bork");
        dto.setSenha("12345");
        dto.setEmail("bork@cwi.com.br");
        dto.setData(LocalDate.now());

        return dto;
    }

    public static CollaboratorDto createCollaboratorDto3() {
        CollaboratorDto dto = new CollaboratorDto();

        dto.setNome("Alvaro");
        dto.setSenha("12345");
        dto.setEmail("alvaro@cwi.com.br");
        dto.setData(LocalDate.now());

        return dto;
    }

    public static MachineMonitoringGroupDto createMachineMonitoringGroupDto() {
        MachineMonitoringGroupDto dto = new MachineMonitoringGroupDto();

        dto.setGroupIcon("imagem.jpg");
        dto.setDescription("Servidore Web"); 
        return dto;
    }

}
