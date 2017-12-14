/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.dto;

import br.com.crescer.monitor.entity.Alert;;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Willian
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlertDto {
    
    private String metrica;
    private String nome;    
    private double valor;
    private boolean isMaior;    
    private String email;    
    private long agenteOuGrupo;
    private boolean isGrupo;
    private LocalDateTime horario;
    
   
    
    public static Alert converterGroupAlert(AlertDto dto) {
        return Alert.builder()
                .time(dto.getHorario())
                .name(dto.getNome())
                .email(dto.getEmail())
                .bigger(dto.isMaior())
                .metric(dto.getMetrica())
                .value(dto.getValor())
                .build();
    }
    
}