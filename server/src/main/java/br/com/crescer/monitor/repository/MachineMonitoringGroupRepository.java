package br.com.crescer.monitor.repository;

import br.com.crescer.monitor.entity.MachineMonitoringGroup;
import java.awt.print.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Leonardo Bork
 */
public interface MachineMonitoringGroupRepository extends PagingAndSortingRepository<MachineMonitoringGroup, Long> {

    boolean existsByDescriptionIgnoreCase(String description);

}
