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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author Leonardo Bork
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MACHINE_TAG")
public class MachineTag implements Serializable {

    private static final String SQ_NAME = "SQ_MACHINE_TAG";

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SQ_NAME)
    @SequenceGenerator(name = SQ_NAME, sequenceName = SQ_NAME, allocationSize = 1)
    @Column(name = "ID_MACHINE_TAG")
    private Long id;

    @Email
    @NotNull(message = "Field must not be null")
    @Basic(optional = false)
    @Column(name = "DESCRIPTION", unique = true, nullable = false)
    private String description;

    @ManyToMany
    @JoinTable(name = "MACHINE_TAG_REGISTER",
            joinColumns = {
                @JoinColumn(name = "FK_TAG")},
            inverseJoinColumns = {
                @JoinColumn(name = "FK_REGISTER")})
    private List<MachineRegister> machines;
}
