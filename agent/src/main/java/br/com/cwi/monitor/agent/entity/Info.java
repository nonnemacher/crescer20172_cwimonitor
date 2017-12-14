package br.com.cwi.monitor.agent.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Alvaro
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Info {

    private Long id;
    
    private double memory;
    
    private double totalMemory;
    
    private double cpu;
    
    private int numberOfCores;
    
    private double freeDisk;
    
    private double occupiedDisk;

    private Long time;

    private String generatedKey;
    
    private LocalDateTime localDateTime;
}
