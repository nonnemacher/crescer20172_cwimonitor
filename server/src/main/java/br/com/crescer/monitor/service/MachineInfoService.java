package br.com.crescer.monitor.service;

import br.com.crescer.monitor.dto.MachineInfoDto;
import br.com.crescer.monitor.entity.MachineInfo;
import br.com.crescer.monitor.entity.MachineRegister;
import br.com.crescer.monitor.repository.MachineInfoRepository;
import br.com.crescer.monitor.repository.MachineRegisterRepository;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Alvaro
 */
@Service
@RequiredArgsConstructor
public class MachineInfoService {

    @Autowired
    MachineInfoRepository machineInfoRepository;

    @Autowired
    MachineRegisterRepository machineRegisterRepository;

    public MachineInfo dtoToEntity(MachineInfoDto machineInfoDto, MachineRegister machineRegister) {

        final LocalDateTime date = Instant.ofEpochMilli(machineInfoDto.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        final MachineInfo info = MachineInfo.builder()
                .cpuUsagePercent(machineInfoDto.getCpu())
                .freeDisk(machineInfoDto.getFreeDisk())
                .occupiedDisk(machineInfoDto.getOccupiedDisk())
                .ramUsagePercent(machineInfoDto.getMemory())
                .execTime(date)
                .machineRegister(machineRegister)
                .build();
        return info;
    }

    public void saveList(List<MachineInfoDto> dtos) throws Exception {

        if (dtos.parallelStream().map(MachineInfoDto::getGeneratedKey).anyMatch(Objects::isNull)) {
            throw new Exception("Key  doesn't exist");
        }
        final MachineRegister machineRegister = dtos.parallelStream()
                .map(MachineInfoDto::getGeneratedKey)
                .findFirst()
                .map(machineRegisterRepository::findByGeneratedKey)
                .orElseThrow(() -> new Exception("Key  doesn't exist"));

        dtos.parallelStream()
                .map(machineInfoDto -> this.dtoToEntity(machineInfoDto, machineRegister))
                .forEach(machineInfoRepository::save);
    }
}
