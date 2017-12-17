/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.entity.view;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Willian
 */
@Data
@Entity
@Table(name = "VW_GROUP_Last_30_MIN")
public class VwLast30minGroup implements Serializable {
    
    @Id
    private ViewGroupId id;
}
