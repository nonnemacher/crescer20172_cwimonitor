package br.com.cwi.monitor.agent;

import br.com.cwi.monitor.agent.collector.Collector;
import br.com.cwi.monitor.agent.digester.Digester;

/**
 * @author Alvaro
 */
public class Run {

    public static void main(String[] args) {
        // Pegar configuração em PATH ou PROPERTIES file afim de setar o tempo das Timers.
        int collectorTime = 2000;
        int digesterTime = 1000;

        Collector c = new Collector(collectorTime);
        Digester d = new Digester(digesterTime);
        c.start();
        d.start();
    }
}
