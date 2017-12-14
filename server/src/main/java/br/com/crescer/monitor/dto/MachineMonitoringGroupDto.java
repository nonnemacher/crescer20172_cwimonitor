package br.com.crescer.monitor.dto;

import br.com.crescer.monitor.entity.MachineMonitoringGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Willian
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MachineMonitoringGroupDto {

    private String groupIcon;
    private String description;

    public static MachineMonitoringGroup converter(MachineMonitoringGroupDto dto) {
        return MachineMonitoringGroup.builder()
                .description(dto.getDescription())
                .groupIcon(dto.getGroupIcon())
                .build();
    }

}
