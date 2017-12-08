/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.entity;

import java.io.Serializable;
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
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Leonardo Bork
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ALERT")
public class Alert implements Serializable {

    private static final String SQ_NAME = "SQ_ALERT";

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SQ_NAME)
    @SequenceGenerator(name = SQ_NAME, sequenceName = SQ_NAME, allocationSize = 1)
    @Column(name = "ID_ALERT")
    private Long id;

    @NotNull(message = "Field must not be null")
    @Basic(optional = false)
    @Column(name = "METRIC", nullable = false)
    private double metric;

    @NotNull(message = "Field must not be null")
    @Basic(optional = false)
    @Column(name = "COMPONENT", nullable = false, length = 100)
    private String component;

    @NotNull(message = "Field must not be null")
    @Basic(optional = false)
    @Column(name = "EMAIL", nullable = false, length = 120)
    private String emal;

    @ManyToOne
    @JoinColumn(name = "ID_MACHINE_REGISTER")
    private MachineRegister machine;

}
