package br.com.crescer.monitor.repository;

import org.springframework.data.repository.CrudRepository;
import br.com.crescer.monitor.entity.Machine;

/**
 * @author Alvaro
 */
public interface MachineRepository extends CrudRepository<Machine, Long>{
    
}
