package tests.api;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class HttpClientTest {

    @Test

    public void simpleApiTest() throws IOException {
        String restURL = "https://reqres.in";

        // Create Object and pass the url
        HttpUriRequest request = new HttpGet(restURL);

        // send the request
        HttpResponse httpResponse = HttpClientBuilder
                .create()
                .build()
                .execute(request);

        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(),
                HttpStatus.SC_OK);
    }

}
