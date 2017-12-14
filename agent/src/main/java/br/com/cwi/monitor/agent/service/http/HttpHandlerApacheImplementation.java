package br.com.cwi.monitor.agent.service.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * @author Alvaro
 */
public class HttpHandlerApacheImplementation implements HttpHandler{
    public int put(String url, String content) {
        int responseCode = -1;
        HttpClient httpClient = new DefaultHttpClient();
        try {
            HttpPut request = new HttpPut(url);
            StringEntity params = new StringEntity(content, "UTF-8");
            params.setContentType("application/json");
            request.addHeader("content-type", "application/json");
            request.addHeader("Accept", "application/json");
            request.addHeader("Accept-Encoding", "gzip,deflate,sdch");
            request.addHeader("Accept-Language", "en-US,en;q=0.8");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
            responseCode = response.getStatusLine().getStatusCode();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
        return responseCode;
    }

    public int post(String url, String content) {
        int responseCode = -1;
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-Type", "application/json");
        StringEntity params = new StringEntity(content, "UTF-8");
        post.setEntity(params);
        try {
            HttpResponse response = client.execute(post);
            return response.getStatusLine().getStatusCode();         
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseCode;
    }
}
