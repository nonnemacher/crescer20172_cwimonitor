package br.com.crescer.monitor.entity.view;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Embeddable;
import lombok.Data;

/**
 * @author leonardo.bork
 */
@Data
@Embeddable
public class ViewId implements Serializable {

    private Long machineRegisterId;
    private LocalDateTime minu;
    private Double cpuAvg, freeDiskAvg, occupiedDiskAvg, ramAvg, totalMemoryAvg, numberOfCoresAvg;
    private Integer totalRegister;

}
