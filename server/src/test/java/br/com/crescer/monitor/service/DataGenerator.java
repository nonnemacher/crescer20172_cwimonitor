/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.service;

import br.com.crescer.monitor.dto.CollaboratorDto;
import br.com.crescer.monitor.dto.MachineMonitoringGroupDto;
import br.com.crescer.monitor.dto.MachineRegisterDto;
import br.com.crescer.monitor.entity.Alert;
import br.com.crescer.monitor.entity.Collaborator;
import br.com.crescer.monitor.entity.MachineMonitoringGroup;
import br.com.crescer.monitor.entity.MachineRegister;
import br.com.crescer.monitor.entity.MachineTag;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
   

    public static MachineMonitoringGroup createMachineMonitoringGroup(List<MachineRegister> machines) {
        return MachineMonitoringGroup.builder().description("groupasso").groupIcon("icon").machines(machines).build();
    }

    public static MachineRegister createMachineRegister() {

        List<MachineRegister> machineRegisters = new ArrayList<>();

        return MachineRegister.builder().collaborator(createCollaborator())
                .machineName("Maqq")
                .machineNickname("Server")
                .groups(new ArrayList<MachineMonitoringGroup>())
                .alerts(new ArrayList<Alert>())
                .build();
    }

    public static MachineRegisterDto createMachineRegisterDto() {

        return MachineRegisterDto.builder().machineNickname("Server").name("Maqq").tags(new ArrayList<String>()).build();
    }

}
