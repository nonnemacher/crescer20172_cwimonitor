/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.repository;

import br.com.crescer.monitor.entity.MachineRegister;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Leonardo Bork
 */
public interface MachineRegisterRepository extends CrudRepository<MachineRegister, Long>{
    List<MachineRegister> findByGeneratedKey(String generatedKey);
}
