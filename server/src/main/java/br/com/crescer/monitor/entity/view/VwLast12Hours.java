/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.entity.view;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author leonardo.bork
 */
@Data
@Entity
@Table(name = "VW_LAST_12_HOUR")
public class VwLast12Hours {
    
    @Id
    private ViewId id;
}
