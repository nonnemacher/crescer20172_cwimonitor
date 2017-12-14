package br.com.crescer.monitor.entity;

import br.com.crescer.monitor.entity.MachineMonitoringGroup;
import br.com.crescer.monitor.entity.MachineRegister;
import br.com.crescer.monitor.utility.LocalDateTimeConverter;
import br.com.crescer.monitor.utility.LocalDateTimeConverter;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
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

/**
 *
 * @author Leonardo Bork
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "GROUP_ALERT")
public class Alert implements Serializable {

    private static final String SQ_NAME = "SQ_GROUPALERT";

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SQ_NAME)
    @SequenceGenerator(name = SQ_NAME, sequenceName = SQ_NAME, allocationSize = 1)
    @Column(name = "ID_GROUPALERT")
    private Long id;

    @NotNull(message = "Field must not be null")
    @Basic(optional = false)
    @Column(name = "NAME", nullable = false)
    private String name;

    @NotNull(message = "Field must not be null")
    @Basic(optional = false)
    @Column(name = "METRIC", nullable = false)
    private String metric;

    @NotNull(message = "Field must not be null")
    @Basic(optional = false)
    @Column(name = "VALUE", nullable = false, length = 100)
    private double value;

    @NotNull(message = "Field must not be null")
    @Basic(optional = false)
    @Column(name = "BIGGER")
    private boolean bigger;

    @NotNull(message = "Field must not be null")
    @Basic(optional = false)
    @Column(name = "EMAIL", nullable = false, length = 120)
    private String email;

    @ManyToOne(optional = true)
    @JoinColumn(name = "ID_GROUP_REGISTER")
    private MachineMonitoringGroup group;

    @ManyToOne(optional = true)
    @JoinColumn(name = "ID_MACHINE_REGISTER")
    private MachineRegister machine;

    @NotNull(message = "Field must not be null")
    @Basic(optional = false)
    @Column(name = "TIME", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:MM:SS")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime time;

}
