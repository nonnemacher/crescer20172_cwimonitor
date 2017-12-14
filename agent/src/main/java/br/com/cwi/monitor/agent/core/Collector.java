package br.com.cwi.monitor.agent.core;

import br.com.cwi.monitor.agent.entity.Info;
import br.com.cwi.monitor.agent.persistence.repository.InfoRepository;
import br.com.cwi.monitor.agent.persistence.repository.InfoRepositorySQLiteImplementation;
import br.com.cwi.monitor.agent.service.machine.MachineInfo;
import br.com.cwi.monitor.agent.service.machine.MachineInfoOshiImplementation;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Leonardo Bork
 * Classe responsável por coletar e persistir no banco a informação da máquina.
 */
public class Collector {

    private final Timer timer = new Timer();
    private final InfoRepository infoRepository;
    private final MachineInfo machineInfo;
    private final int milliseconds;

    public Collector(int milliseconds) {
        this.milliseconds = milliseconds;
        this.infoRepository = new InfoRepositorySQLiteImplementation();
        this.machineInfo = new MachineInfoOshiImplementation();
    }

    public void start() {
        timer.scheduleAtFixedRate(new CollectorTask(), 0, milliseconds);
    }

    public class CollectorTask extends TimerTask {

        @Override
        public void run() {
            Info info = Info.builder()
                    .memory(machineInfo.getMemory())
                    .cpu(machineInfo.getCpu())
                    .freeDisk(machineInfo.getFreeDisk())
                    .occupiedDisk(machineInfo.getOccupiedDisk())
                    .time(System.currentTimeMillis())
                    .localDateTime(LocalDateTime.now())
                    .build();
                        
            infoRepository.save(info);
        }
    }
}
