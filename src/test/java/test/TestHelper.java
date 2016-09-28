package test;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

public class TestHelper {

    private final String host;
    private final int port;
    private final HttpClient httpClient;

    public TestHelper(String host, int port) {
        this.host = host;
        this.port = port;
        this.httpClient = HttpClientBuilder.create().build();
    }

    private String getUriString(String relativePath) {
        return UriComponentsBuilder.newInstance()
                .scheme("http")
                .host(host)
                .port(port)
                .path(relativePath)
                .build()
                .toUriString();
    }

    public SimpleHttpResponse get(String relativePath) {
        String greetingUri = getUriString(relativePath);
        HttpGet httpGet = new HttpGet(greetingUri);
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            String responseBody = EntityUtils.toString(httpResponse.getEntity());
            return new SimpleHttpResponse(statusCode, responseBody);
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }

}
