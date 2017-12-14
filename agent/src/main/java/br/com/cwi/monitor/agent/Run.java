package br.com.cwi.monitor.agent;

import br.com.cwi.monitor.agent.core.Announcer;
import br.com.cwi.monitor.agent.core.Collector;
import br.com.cwi.monitor.agent.core.Digester;
import br.com.cwi.monitor.agent.persistence.repository.InfoRepository;
import br.com.cwi.monitor.agent.persistence.repository.InfoRepositorySQLiteImplementation;
import java.util.Scanner;

/**
 * @author Alvaro
 */
public class Run {

    public static void main(String[] args) {

//        final String agentKey = System.getProperty("agent.key");
//        final String endpoint = System.getProperty("agent.endpoint");
//        final String collectorTime = System.getProperty("agent.collectorTime");
//        final String digesterTime = System.getProperty("agent.digesterTime");
//        Long agentKeyLong = Long.parseLong(agentKey);
//        int collectorTimeInt = Integer.parseInt(collectorTime);
//        int digesterTimeInt = Integer.parseInt(digesterTime);
        final InfoRepository infoRepository = new InfoRepositorySQLiteImplementation();

        String announcerEndPoint = "http://localhost:9090/machineregister/machinename";
        String digesterEndpoint = "http://localhost:9090/machineinfo/public";
        int collectorTimeInt = 1000;
        int digesterTimeInt = 5000;
        
        infoRepository.createTable();

        Scanner in = new Scanner(System.in);
        System.out.println("Insert your key: ");
        String agentKey = in.nextLine();
        //System.out.println("Insert the endpoint: ");
        //endpoint = in.nextLine();
        //System.out.println("Insert the collector parameter in milliseconds: ");
        //collectorTimeInt = in.nextInt();
        //System.out.println("Insert the digestor parameter in milliseconds: ");
        //digesterTimeInt = in.nextInt();

        Announcer announcer = new Announcer(5000, announcerEndPoint, agentKey);
        Collector collector = new Collector(collectorTimeInt);
        Digester digester = new Digester(digesterTimeInt, digesterEndpoint, agentKey);
        announcer.start();
        collector.start();
        digester.start();
    }
}