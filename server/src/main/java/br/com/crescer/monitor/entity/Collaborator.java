/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.entity;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;
import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE;


/**
 *
 * @author Leonardo Bork
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "COLLABORATOR")
public class Collaborator implements Serializable {

    private static final String SQ_NAME = "SQ_COLLABORATOR";

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SQ_NAME)
    @SequenceGenerator(name = SQ_NAME, sequenceName = SQ_NAME, allocationSize = 1)
    @Column(name = "ID_COLLABORATOR")
    private Long id;

    @Size(max = 255)
    @NotNull(message = "Field must not be null")
    @Basic(optional = false)
    @Column(name = "NAME", nullable = false, length = 255)
    private String name;

    @Email
    @NotNull(message = "Field must not be null")
    @Basic(optional = false)
    @Column(name = "DS_EMAIL", unique = true, nullable = false)
    private String email;

    @NotNull(message = "Field must not be null")
    @Basic(optional = false)
    @Column(name = "BIRTHDATE", nullable = false)
    @DateTimeFormat(iso = DATE )
    private LocalDate birthdate;

    @NotNull(message = "Field must not be null")
    @Size(max = 400)
    @Basic(optional = false)
    @Column(name = "DS_PASS", nullable = false)
    private String pass;
    
}
