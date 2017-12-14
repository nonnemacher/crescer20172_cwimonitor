package br.com.crescer.monitor.repository;

import br.com.crescer.monitor.entity.view.ViewId;
import br.com.crescer.monitor.entity.view.VwLastDay;
import java.util.List;
import org.springframework.data.repository.Repository;

/**
 * @author leonardo.bork
 */
public interface VwLastDayRepository extends Repository<VwLastDay, ViewId>{
    
    List<VwLastDay> findById_machineRegisterId(Long machineRegisterId);
    
}
