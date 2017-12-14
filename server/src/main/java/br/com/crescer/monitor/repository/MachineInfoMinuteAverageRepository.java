package br.com.crescer.monitor.repository;

import br.com.crescer.monitor.entity.MachineInfoMinuteAverage;
import br.com.crescer.monitor.entity.MachineRegister;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author alvaro.schmidt
 */
public interface MachineInfoMinuteAverageRepository extends CrudRepository<MachineInfoMinuteAverage, Long>{

    
    
}