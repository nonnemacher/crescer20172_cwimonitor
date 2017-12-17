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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Leonardo Bork
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "MACHINE_MONITORING_GROUP")
public class MachineMonitoringGroup implements Serializable {

    private static final String SQ_NAME = "SQ_MACHINE_MONITORING_GROUP";

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SQ_NAME)
    @SequenceGenerator(name = SQ_NAME, sequenceName = SQ_NAME, allocationSize = 1)
    @Column(name = "ID_MACHINE_MONITORING_GROUP")
    private Long id;

     @Size(max = 512)
    @Basic(optional = true)
    @Column(name = "GROUP_ICON", nullable = true, length = 512)
    private String groupIcon;


    @NotNull(message = "Field must not be null")
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String description;
   
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "MACHINE_MONITORING_REGISTER",
            joinColumns = {
                @JoinColumn(name = "FK_MONITORING")},
            inverseJoinColumns = {
                @JoinColumn(name = "FK_REGISTER")})
    private List<MachineRegister> machines;
    
     public void addMachineRegister(MachineRegister machine){
        this.machines.add(machine);
    }
     
     public void removeMachineRegister(Long machineId){
        this.machines.remove(machineId);
    } 
}

