package br.com.cwi.monitor.agent.entity;

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
public class MachineRegisterName {
    
    private String generatedKey;

    private String name;
    
}
