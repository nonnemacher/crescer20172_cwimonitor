package br.com.crescer.monitor.repository;

import br.com.crescer.monitor.entity.view.ViewId;
import br.com.crescer.monitor.entity.view.VwLastHour;
import java.util.List;
import org.springframework.data.repository.Repository;

/**
 * @author leonardo.bork
 */
public interface VwLastHourRepository extends Repository<VwLastHour, ViewId>{
    
    List<VwLastHour> findById_machineRegisterId(Long machineRegisterId);
    
}
