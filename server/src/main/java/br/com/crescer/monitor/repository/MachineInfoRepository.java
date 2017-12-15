package br.com.crescer.monitor.repository;

import br.com.crescer.monitor.dto.Register;
import br.com.crescer.monitor.entity.MachineInfo;
import java.time.LocalDateTime;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author Leonardo Bork
 */
public interface MachineInfoRepository extends CrudRepository<MachineInfo, Long>{
    
    @Query("select new br.com.crescer.monitor.dto.Register("
            + "  m.execTime "
            + ", m.ramUsagePercent "
            + ", m.totalMemory "
            + ", m.cpuUsagePercent "
            + ", m.numberOfCores "
            + ", m.freeDisk "
            + ", m.occupiedDisk "
            + ") "
            + "from MachineInfo m "
            + "join m.machineRegister mr "
            + "where mr.id = :idParam "
            + "and m.execTime between :startDate and :endDate "
            + "order by m.execTime")
    List<Register> loadMachineInfoByPeriodAndId(@Param("idParam") Long idParam, @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime stopDate);
   
    @Transactional
    List<MachineInfo> removeByMachineRegisterId(Long id);   
}