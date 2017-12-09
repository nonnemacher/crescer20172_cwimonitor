/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "MACHINE_REGISTER")
public class MachineRegister implements Serializable {

    private static final String SQ_NAME = "SQ_MACHINE_REGISTER";

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SQ_NAME)
    @SequenceGenerator(name = SQ_NAME, sequenceName = SQ_NAME, allocationSize = 1)
    @Column(name = "ID_MACHINE_REGISTER")
    private Long id;

    @NotNull(message = "Field must not be null")
    @Basic(optional = false)
    @Column(nullable = false, length = 255, unique = true)
    private String generatedKey;

    @NotNull(message = "Field must not be null")
    @Basic(optional = true)
    @Column(nullable = false, length = 255)
    private String machineName;
    
    @NotNull(message = "Field must not be null")
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String machineNickname;

    @ManyToOne
    @JoinColumn(name = "ID_COLLABORATOR")
    private Collaborator collaborator;
    
    @OneToMany(mappedBy="machine")
    private List<Alert> alerts;

    @ManyToMany(mappedBy = "machines")
    private List<MachineTag> tags;
    
    @ManyToMany(mappedBy = "machines")
    private List<MachineMonitoringGroup> groups;
    
}
