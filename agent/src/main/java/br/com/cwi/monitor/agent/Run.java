package br.com.cwi.monitor.agent;

import br.com.cwi.monitor.agent.collector.Collector;
import br.com.cwi.monitor.agent.digester.Digester;
import br.com.cwi.monitor.agent.entity.Info;
import br.com.cwi.monitor.agent.persistence.repository.InfoRepositorySQLiteImplementation;
import java.time.LocalDateTime;

/**
 * @author Alvaro
 */
public class Run {

    public static void main(String[] args) {
        // Pegar configuração em PATH ou PROPERTIES file afim de setar o tempo das Timers.
        int collectorTime = 2000;
        int digesterTime = 1000;

        InfoRepositorySQLiteImplementation impl = new InfoRepositorySQLiteImplementation();
        impl.createTable();
        impl.save(Info.builder().cPU(0.5).disco(0.5).memoria(0.5).hora(LocalDateTime.now()).build());
        
        Collector c = new Collector(collectorTime);
        Digester d = new Digester(digesterTime);
        c.start();
        d.start();
    }
}
