package br.com.crescer.monitor.entity;

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
    //Ram memory percent left space
    private double memory;
    //Cpu usage percent 
    private double cpu;
    //Disk left space in m
    private double disk;
    
    private Long time;

}