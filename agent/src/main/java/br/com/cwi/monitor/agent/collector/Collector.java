/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.monitor.agent.collector;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import oshi.json.SystemInfo;


/**
 *
 * @author Leonardo Bork
 */

public class Collector {
    
    public static void main(String [] args){
        
        SystemInfo system = new SystemInfo();
        while(true){
        
        System.out.println(system.getHardware().getProcessor().getName());
        }
    }
}
