/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.repository;

import br.com.crescer.monitor.entity.Alert;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Willian
 */
public interface GroupAlertRepository extends PagingAndSortingRepository<Alert, Long> {
    
}