package br.com.crescer.monitor.entity;

import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author leonardo.bork
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MACHINE_INFO_MINUTE_AVG")
public class MachineInfoMinuteAverage {

    private static final String SQ_NAME = "SQ_MACHINE_INFO_MINUTE_AVG";
    
    // Constructor para o JPQL
    public MachineInfoMinuteAverage(double ramUsagePercent, 
                                    double cpuUsagePercent, 
                                    double diskUsagePercent, 
                                    LocalDateTime execTime, 
                                    long registerTotal, 
                                    MachineRegister machineRegister) {
        this.ramUsagePercent = ramUsagePercent;
        this.cpuUsagePercent = cpuUsagePercent;
        this.diskUsagePercent = diskUsagePercent;
        this.execTime = execTime;
        this.registerTotal = registerTotal;
        this.machineRegister = machineRegister;
    }

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SQ_NAME)
    @SequenceGenerator(name = SQ_NAME, sequenceName = SQ_NAME, allocationSize = 1)
    @Column(name = "ID_MACHINE_INFO")
    private Long id;

    @NotNull(message = "Field must not be null")
    @Basic(optional = false)
    @Column(nullable = false)
    private double ramUsagePercent;

    @NotNull(message = "Field must not be null")
    @Basic(optional = false)
    @Column(nullable = false)
    private double cpuUsagePercent;

    @NotNull(message = "Field must not be null")
    @Basic(optional = false)
    @Column(nullable = false)
    private double diskUsagePercent;

    @NotNull(message = "Field must not be null")
    @Basic(optional = false)
    @Column(name = "EXEC_TIME", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime execTime;
    
    @NotNull(message = "Field must not be null")
    @Basic(optional = false)
    @Column(name = "REGISTER_TOTAL", nullable = false)
    private long registerTotal;

    @ManyToOne
    @JoinColumn(name = "ID_MACHINE_REGISTER")
    private MachineRegister machineRegister;
}