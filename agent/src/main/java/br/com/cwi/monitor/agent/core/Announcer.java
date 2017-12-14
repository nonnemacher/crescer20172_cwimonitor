package br.com.cwi.monitor.agent.core;

import br.com.cwi.monitor.agent.entity.Info;
import br.com.cwi.monitor.agent.entity.MachineRegisterName;
import br.com.cwi.monitor.agent.service.http.HttpHandler;
import br.com.cwi.monitor.agent.service.http.HttpHandlerApacheImplementation;
import br.com.cwi.monitor.agent.service.machine.MachineInfo;
import br.com.cwi.monitor.agent.service.machine.MachineInfoOshiImplementation;
import com.google.gson.Gson;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Alvaro Classe responsável por comunicar ao servidor o nome da
 * máquina. Permanecerá executando um put no servidor tentando enviar o nome da
 * máquina até que este responda Ok.
 */
public class Announcer {

    private final Timer timer = new Timer();
    private final HttpHandler httpHandler;
    private final MachineInfo machineInfo;
    private final int milliseconds;
    private String endPoint;
    private String agentKey;

    public Announcer(int milliseconds, String endPoint, String agentKey) {
        this.milliseconds = milliseconds;
        this.endPoint = endPoint;
        this.agentKey = agentKey;
        this.httpHandler = new HttpHandlerApacheImplementation();
        this.machineInfo = new MachineInfoOshiImplementation();
    }

    public void start() {
        timer.scheduleAtFixedRate(new AnnouncerTask(), 0, milliseconds);
    }

    public class AnnouncerTask extends TimerTask {

        @Override
        public void run() {
            MachineRegisterName machineRegister = MachineRegisterName.builder().name(machineInfo.getComputerName()).generatedKey(agentKey).build();
            Gson gson = new Gson();
            String json = gson.toJson(machineRegister);
                        
            int responseCode = httpHandler.put(endPoint, json);
            if (responseCode == 200) {
                timer.cancel();
            }
        }
    }
}
