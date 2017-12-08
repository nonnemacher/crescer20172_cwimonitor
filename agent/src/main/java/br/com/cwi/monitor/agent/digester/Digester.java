package br.com.cwi.monitor.agent.digester;

import br.com.cwi.monitor.agent.entity.Info;
import br.com.cwi.monitor.agent.persistence.repository.InfoRepository;
import br.com.cwi.monitor.agent.persistence.repository.InfoRepositorySQLiteImplementation;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * @author Alvaro
 */
public class Digester {
    private final Timer timer = new Timer();
    private final InfoRepository infoRepository;
    private final int milliseconds;

    public Digester(int milliseconds) {
        this.milliseconds = milliseconds;
        this.infoRepository = new InfoRepositorySQLiteImplementation();
    }

    public void start() {
        timer.scheduleAtFixedRate(new DigesterTask(), 0, milliseconds);
    }

    public class DigesterTask extends TimerTask {
        @Override
        public void run() {
            List<Info> infos = infoRepository.retrieve(1);
            try {
                send(infos);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void send(List<Info> infos) throws ClientProtocolException, IOException {
        String url = "http://localhost:9090/usuario/info";
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        
        Gson gson = new Gson();
        String json = gson.toJson(infos);
        
        System.out.println(">> " + json);
        
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");
        CloseableHttpResponse response = client.execute(httpPost);
        
        if(response.getStatusLine().getStatusCode() == 200){
            infoRepository.delete(infos);
        }
        client.close();
    }
}
