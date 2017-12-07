package br.com.cwi.monitor.agent.digester;

import br.com.cwi.monitor.agent.entity.Info;
import br.com.cwi.monitor.agent.persistence.repository.InfoRepository;
import br.com.cwi.monitor.agent.persistence.repository.InfoRepositorySQLiteImplementation;
import com.google.gson.Gson;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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
            List<Info> infos = infoRepository.retrieve(10);

            try {
                send(infos);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void send(Object obj) throws Exception {
        /**
         * Em progresso, não testado.
         */
        
        URL url = new URL("http://localhost:9090/");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json");

        Gson gson = new Gson();
        OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
        out.write(gson.toJson(obj));
        out.flush();
        out.close();
    }
}
