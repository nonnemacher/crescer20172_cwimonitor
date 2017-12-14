package br.com.crescer.monitor.dto;

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
public class MachineRegisterNameDto {

    private String generatedKey;

    private String name;

}
