package br.com.cwi.monitor.agent.core;

import br.com.cwi.monitor.agent.entity.Info;
import br.com.cwi.monitor.agent.persistence.repository.InfoRepository;
import br.com.cwi.monitor.agent.persistence.repository.InfoRepositorySQLiteImplementation;
import br.com.cwi.monitor.agent.service.http.HttpHandler;
import br.com.cwi.monitor.agent.service.http.HttpHandlerApacheImplementation;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.http.client.ClientProtocolException;

/**
 * @author Alvaro
 * Classe responsável por coletar o dado do banco para enviar ao servidor e também exclui-lo caso receba um Ok como resposta.
 */
public class Digester {
    private final Timer timer = new Timer();
    private final InfoRepository infoRepository;
    private final HttpHandler httpHandler;
    private final int milliseconds;
    private final String agentKey;
    private final String endPoint;

    public Digester(int milliseconds, String endPoint, String agentKey) {
        this.milliseconds = milliseconds;
        this.endPoint = endPoint;
        this.agentKey = agentKey;
        this.infoRepository = new InfoRepositorySQLiteImplementation();
        this.httpHandler = new HttpHandlerApacheImplementation();
    }

    public void start() {
        timer.scheduleAtFixedRate(new DigesterTask(), 5000l, milliseconds);
    }

    public class DigesterTask extends TimerTask {
        @Override
        public void run() {
            List<Info> infos = infoRepository.retrieve(100);
            infos.stream().forEach(info -> info.setGeneratedKey(agentKey));
            
            send(infos);
        }
    }
    
    public void send(List<Info> infos) {
        Gson gson = new Gson();
        String json = gson.toJson(infos);
        
        int responseCode = httpHandler.post(endPoint, json);
        if(responseCode == 200) {
            infoRepository.delete(infos);
        }
    }
}
