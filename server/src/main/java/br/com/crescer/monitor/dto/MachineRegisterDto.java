/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Leonardo Bork
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MachineRegisterDto {

    private Long id;

    private String generatedKey;
    
    private String machineNickname;

    private String name;

    List<String> tags;
}
