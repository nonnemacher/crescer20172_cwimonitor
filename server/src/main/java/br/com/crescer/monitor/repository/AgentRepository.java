package br.com.crescer.monitor.repository;

import br.com.crescer.monitor.entity.Machine;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Alvaro
 */
public interface AgentRepository extends CrudRepository<Machine, Long>{
    
}
