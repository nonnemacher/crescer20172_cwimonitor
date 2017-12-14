package br.com.cwi.monitor.agent.service.http;

/**
 * @author Alvaro
 */
public interface HttpHandler {
    
    public int put(String url, String content);
    
    public int post(String url, String content);
    
}
