package com.example.demo;

/**
 * Created by ouyan on 7/7/2018.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;


import com.example.demo.model.Emp;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
        import org.apache.http.HttpResponse;
        import org.apache.http.client.ClientProtocolException;
        import org.apache.http.client.ResponseHandler;
        import org.apache.http.client.methods.HttpGet;
        import org.apache.http.impl.client.CloseableHttpClient;
        import org.apache.http.impl.client.HttpClients;
        import org.apache.http.util.EntityUtils;
import org.json.simple.*;


import org.json.simple.parser.*;


/**
 * This example demonstrates the use of the {@link ResponseHandler} to simplify
 * the process of processing the HTTP response and releasing associated resources.
 */
public class ClientWithResponseHandler {

    public final static void main(String[] args) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
          //  HttpGet httpget = new HttpGet("http://httpbin.org/");
          HttpGet httpget = new HttpGet("http://localhost:5555/demo/emps");
     //       HttpGet httpget = new HttpGet("http://localhost:8080/demo/emps/SMITH");
     //       HttpGet httpget = new HttpGet("https://localhost:8443/demo/emps/SMITH");
            System.out.println("Executing request " + httpget.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                @Override
                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        Header[] headers = response.getAllHeaders();
                        for (int i = 0; i < headers.length; i++) {
                            System.out.println("***********Header:   " +  headers[i]);
                        }

                        HttpEntity entity = response.getEntity();
//                        InputStream is = entity.getContent();
//                        BufferedReader br = new BufferedReader(new InputStreamReader(is));
//                        while (br.readLine() != null) {
//                            System.out.println(br.readLine());
//                        }

                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }

            };
            String responseBody = httpclient.execute(httpget, responseHandler);
            System.out.println("----------------------------------------");
         //   Gson gson = new GsonBuilder().setPrettyPrinting().create();

            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd")   .create();

            JSONParser parser = new JSONParser();
//            Object json = parser.parse(responseBody);
//     joJH
//            JSONArray array = (JSONArray) json;
//
//            String prettyJson = gson.toJson(json);

            Emp[] emps = gson.fromJson(responseBody, Emp[].class);
      //        Emp emp = new ObjectMapper().readValue(responseBody, Emp.class);

    System.out.println(Arrays.asList(emps));
         //   System.out.println(prettyJson);
        } finally {
            httpclient.close();
        }
    }

}

