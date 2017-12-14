package br.com.crescer.monitor.controller;

import br.com.crescer.monitor.dto.Register;
import br.com.crescer.monitor.entity.view.VwLast12Hours;
import br.com.crescer.monitor.entity.view.VwLast15Min;
import br.com.crescer.monitor.entity.view.VwLast30Min;
import br.com.crescer.monitor.entity.view.VwLast6Hours;
import br.com.crescer.monitor.entity.view.VwLastDay;
import br.com.crescer.monitor.entity.view.VwLastHour;
import br.com.crescer.monitor.repository.MachineInfoRepository;
import br.com.crescer.monitor.repository.VwLast12HoursRepository;
import br.com.crescer.monitor.repository.VwLast15MinRepository;
import br.com.crescer.monitor.repository.VwLast30MinRepository;
import br.com.crescer.monitor.repository.VwLast6HoursRepository;
import br.com.crescer.monitor.repository.VwLastDayRepository;
import br.com.crescer.monitor.repository.VwLastHourRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leonardo.bork
 */
@RestController
@RequestMapping("/graphs")
@RequiredArgsConstructor
public class VwLastAvgController {

    @Autowired
    private final VwLastHourRepository lastHourRepository;

    @Autowired
    private final VwLastDayRepository lastDayRepository;

    @Autowired
    private final VwLast6HoursRepository last6HoursRepository;

    @Autowired
    private final VwLast30MinRepository last30MinRepository;

    @Autowired
    private final VwLast15MinRepository last15MinRepository;
    
    @Autowired
    private final VwLast12HoursRepository last12HoursRepository;
    
    @Autowired
    private final MachineInfoRepository infoRepository;

    @GetMapping("/last-hour/{machineRegisterId}")
    public List<VwLastHour> findByMachineRegister(@PathVariable Long machineRegisterId) {
        return lastHourRepository.findById_machineRegisterId(machineRegisterId);
    }

    @GetMapping("/last-day/{machineRegisterId}")
    public List<VwLastDay> findByMachineDay(@PathVariable Long machineRegisterId) {
        return lastDayRepository.findById_machineRegisterId(machineRegisterId);
    }

    @GetMapping("/last-15-min/{machineRegisterId}")
    public List<VwLast15Min> findByMachine15Min(@PathVariable Long machineRegisterId) {
        return last15MinRepository.findById_machineRegisterId(machineRegisterId);
    }

        @GetMapping("/last-6-hours/{machineRegisterId}")
    public List<VwLast6Hours> findByMachine6Hours(@PathVariable Long machineRegisterId) {
        return last6HoursRepository.findById_machineRegisterId(machineRegisterId);
    }

    @GetMapping("/last-30-min/{machineRegisterId}")
    public List<VwLast30Min> findByMachine30Min(@PathVariable Long machineRegisterId) {
        return last30MinRepository.findById_machineRegisterId(machineRegisterId);
    }
    
    @GetMapping("/last-12-hours/{machineRegisterId}")
    public List<VwLast12Hours> findByMachine12Hours(@PathVariable Long machineRegisterId) {
        return last12HoursRepository.findById_machineRegisterId(machineRegisterId);
    }
    
    @GetMapping("/realtime/{machineRegisterId}")
    public List<Register> findByRealtime(@PathVariable Long machineRegisterId) {
        return  infoRepository.loadMachineInfoByPeriodAndId(machineRegisterId, LocalDateTime.now().minusMinutes(1), LocalDateTime.now());
    }
}
