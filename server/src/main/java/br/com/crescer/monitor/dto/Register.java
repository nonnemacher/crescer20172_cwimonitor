package br.com.crescer.monitor.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author alvaro.schmidt
 */
@Getter
@Setter
@ToString
public class Register {

    private Double ramAvg, cpuAvg, totalMemory, freeDiskAvg, occupiedDiskAvg, diskTotal;
    private Double numberOfCores;
    private LocalDateTime minu;

    public Register(
            LocalDateTime execTime,
            Double ramUsagePercent,
            Double totalMemory,
            Double cpuUsagePercent,
            Double numberOfCores,
            Double freeDisk,
            Double occupiedDisk
    ) {
        this.ramAvg = ramUsagePercent;
        this.totalMemory = totalMemory;
        this.cpuAvg = cpuUsagePercent;
        this.diskTotal = (freeDisk + occupiedDisk);
        this.freeDiskAvg = freeDisk;
        this.occupiedDiskAvg = occupiedDisk;
        this.numberOfCores = numberOfCores;
        this.minu = execTime;
    }
}
