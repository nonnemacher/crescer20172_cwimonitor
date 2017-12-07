package br.com.cwi.monitor.agent.collector;

import br.com.cwi.monitor.agent.entity.Info;
import br.com.cwi.monitor.agent.persistence.repository.InfoRepository;
import br.com.cwi.monitor.agent.persistence.repository.InfoRepositorySQLiteImplementation;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

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
            Info info = Info.builder().memoria(0.5).cPU(0.5).disco(0.5).hora(LocalDateTime.now()).build();
            infoRepository.save(info);
        }
    }   
}
