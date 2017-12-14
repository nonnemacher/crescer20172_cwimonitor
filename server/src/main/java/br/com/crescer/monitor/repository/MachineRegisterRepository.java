package br.com.crescer.monitor.repository;

import br.com.crescer.monitor.entity.Collaborator;
import br.com.crescer.monitor.entity.MachineMonitoringGroup;
import br.com.crescer.monitor.entity.MachineRegister;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Leonardo Bork
 */
public interface MachineRegisterRepository extends PagingAndSortingRepository<MachineRegister, Long> {

    MachineRegister findByGeneratedKey(String generatedKey);

    Page<MachineRegister> findByGroups(MachineMonitoringGroup group, Pageable pgbl);

    Page<MachineRegister> findByIdNotIn(List<Long> ids, Pageable pgbl);

    List<MachineRegister> findByGroups(MachineMonitoringGroup group);
    
    Page<MachineRegister> findByCollaborator(Collaborator collaborator, Pageable pgbl);
}
