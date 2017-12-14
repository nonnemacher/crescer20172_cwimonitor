/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.dto;

import br.com.crescer.monitor.entity.Collaborator;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Willian
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CollaboratorDto {
    
    private String nome;
    private LocalDate data;
    private String email;    
    private String senha;
    
    public static Collaborator converter(CollaboratorDto dto) {
        return Collaborator.builder()
                .email(dto.getEmail())
                .name(dto.getNome())
                .pass(dto.getSenha())
                .birthdate(dto.getData())
                .build();
    }
    
        
}


