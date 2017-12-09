/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.entity;

import java.io.Serializable;
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
import static javax.xml.datatype.DatatypeConstants.DATETIME;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Leonardo Bork
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MACHINE_INFO")
public class MachineInfo implements Serializable {

    private static final String SQ_NAME = "SQ_MACHINE_INFO";

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SQ_NAME)
    @SequenceGenerator(name = SQ_NAME, sequenceName = SQ_NAME, allocationSize = 1)
    @Column(name = "ID_MACHINE_INFO")
    private Long id;
    
    @NotNull(message = "Field must not be null")
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String generatedKey;

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
    @Column(name = "BIRTHDATE", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime execTime;

    @ManyToOne
    @JoinColumn(name = "ID_MACHINE_REGISTER")
    private MachineRegister machineRegister;

}
