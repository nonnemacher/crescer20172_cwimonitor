package br.com.cwi.monitor.agent;

import br.com.cwi.monitor.agent.collector.Collector;
import br.com.cwi.monitor.agent.digester.Digester;

/**
 * @author Alvaro
 */
public class Run {

    public static void main(String[] args) {
        // Pegar configuração em PATH ou PROPERTIES file afim de setar o tempo das Timers.
//        final String agentKey = System.getProperty("agent.key");
//        final String endpoint = System.getProperty("agent.endpoint");
//        final String collectorTime = System.getProperty("agent.collectorTime");
//        final String digestTime = System.getProperty("agent.collectorTime");
        
//        Long agentKeyLong =Long.parseLong(agentKey);
//        int collectorTimeInt = Integer.parseInt(collectorTime);
//        int digesterTime = Integer.parseInt(collectorTime);

        Collector c = new Collector(1000);
        Digester d = new Digester(1000);
        c.start();
        d.start();
    }
}
