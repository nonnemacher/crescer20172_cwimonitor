package br.com.cwi.monitor.agent.collector;

import br.com.cwi.monitor.agent.entity.Info;
import br.com.cwi.monitor.agent.persistence.repository.InfoRepository;
import br.com.cwi.monitor.agent.persistence.repository.InfoRepositorySQLiteImplementation;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.software.os.OSFileStore;

/**
 * @author Leonardo Bork
 */
public class Collector {

    private final Timer timer = new Timer();
    private final InfoRepository infoRepository;
    private final int milliseconds;

    public Collector(int milliseconds) {
        this.milliseconds = milliseconds;
        this.infoRepository = new InfoRepositorySQLiteImplementation();
    }

    public void start() {
        timer.scheduleAtFixedRate(new CollectorTask(), 0, milliseconds);
    }

    public class CollectorTask extends TimerTask {

        @Override
        public void run() {
            /**
             * Temporário, até conseguirmos a info do pc.
             */
            SystemInfo si = new SystemInfo();
            final CentralProcessor processor = si.getHardware().getProcessor();
            final int cores = processor.getPhysicalProcessorCount();
            double memoryPercentageUsed = si.getHardware().getMemory().getAvailable() / si.getHardware().getMemory().getAvailable();
            double totalUsableSpace = 0;
            

            for (OSFileStore s : si.getOperatingSystem().getFileSystem().getFileStores()) {
                System.out.println(s.getDescription() + " == " + s.getMount() + " == " + (s.getTotalSpace() / 1024 / 1024) + "m == " + (s.getUsableSpace() / 1024 / 1024));
                totalUsableSpace += s.getUsableSpace();
            }

            Info info = Info.builder().memory(memoryPercentageUsed).cpu(processor.getSystemCpuLoad() * 100).disk(totalUsableSpace).time(LocalDateTime.now()).build();
            infoRepository.save(info);
        }
    }

}
