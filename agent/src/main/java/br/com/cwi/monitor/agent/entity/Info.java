package br.com.cwi.monitor.agent.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Alvaro
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Info {

    private Long id;
    //Ram memory percent left space
    private double memory;
    //Cpu usage percent 
    private double cpu;
    //Disk left space in m
    private double disk;
    
    private Long time;

    @Override
    public String toString() {
        return "Info{" + "id=" + id + ", memory=" + memory + ", cpu=" + cpu + ", disk=" + disk + ", time=" + time + '}';
    }
}
