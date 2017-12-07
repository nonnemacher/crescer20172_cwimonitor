package br.com.cwi.monitor.agent;

/**
 * @author alvaro.schmidt
 */
public class StopWatch {

    long startTime, totalTimeMillis = 0l;

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void stop() {
        totalTimeMillis = System.currentTimeMillis() - startTime;
    }

    public double getTotalTimeSeconds() {
        return this.totalTimeMillis / 1000.0;
    }
    public double getTotalTimeMillis() {
        return this.totalTimeMillis;
    }

}
