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
        final InfoRepository infoRepository = new InfoRepositorySQLiteImplementation();
        infoRepository.createTable();
        
        String endPoint = System.getenv("AGENT-ENDPOINT");
        if(endPoint == null) {
            Scanner in = new Scanner(System.in);
            System.out.println("Insert the endpoint: ");
            endPoint = in.nextLine();
        }
        
        String key = System.getenv("AGENT-KEY");
        if(key == null) {
            Scanner in = new Scanner(System.in);
            System.out.println("Insert the key: ");
            key = in.nextLine();
        }
        
        String announcerEndPoint = endPoint + "/machineregister/machinename";
        String digesterEndPoint = endPoint + "/machineinfo/public";      
        
        int announcerTime = 2000;
        int collectorTime = 1000;
        int digesterTime = 5000;

        Announcer announcer = new Announcer(announcerTime, announcerEndPoint, key);
        Collector collector = new Collector(collectorTime);
        Digester digester = new Digester(digesterTime, digesterEndPoint, key);
        announcer.start();
        collector.start();
        digester.start();
    }
}