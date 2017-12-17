/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.entity.view;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Embeddable;
import lombok.Data;

/**
 *
 * @author Willian
 */
@Data
@Embeddable
public class ViewGroupId implements Serializable  {
    
    
    private Long groupId;
    private LocalDateTime minu;
    private Double cpuAvg, freeDiskAvg, occupiedDiskAvg, ramAvg, totalMemoryAvg, numberOfCoresAvg;
    private Integer totalRegister;
}
