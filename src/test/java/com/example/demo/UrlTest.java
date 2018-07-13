package com.example.demo;

import org.junit.Test;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.*;
import java.security.cert.CertificateException;


/**
 * Created by ouyan on 7/8/2018.
 */
public class UrlTest {

    @Test
    public void testUrl() {

        String uri = "http://localhost:5555/demo/emps/SMITH";
        String line = "xxxx";



        try {
            URL url = new URL(uri);
            URLConnection conn = url.openConnection();
//            System.out.println(conn.getContentEncoding());
            InputStream is = conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch ( IOException e ) {
                e.printStackTrace();
        }




        System.out.print("hello, welcome");

    }

    @Test
    public void testSSL() {
        String uri = "https://localhost:8443/demo/emps/SMITH";
        String line = "xxxx";
        System.setProperty("javax.net.ssl.trustStore", "C:\\temp\\trash2\\workspace1\\src\\main\\resources\\keystore.p12");
        System.setProperty("javax.net.ssl.trustStoreType", "PKCS12");
   //     System.setProperty("javax.net.ssl.keyStorePassword", "mypassword");
        System.setProperty("javax.net.ssl.trustStorePassword",  "mypassword");


        try {
            URL url = new URL(uri);

            SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();

          //  URLConnection conn = url.openConnection();
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
//            System.out.println(conn.getContentEncoding());

            conn.setSSLSocketFactory(sslsocketfactory);
            InputStream is = conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch ( IOException e ) {
                e.printStackTrace();
        }




    }


    public void testSSL2 () {

        String uri = "https://localhost:8443/demo/emps/SMITH";
        SSLContext sslContext;
        String line = "xxxx";

                try {

            KeyStore ks=KeyStore.getInstance("PKCS12");
            ks.load(new FileInputStream("C:\\temp\\trash2\\workspace1\\src\\main\\resources\\keystore.p12" ), "mypassword".toCharArray());


            KeyManagerFactory kmf = KeyManagerFactory.getInstance(getAlgorithm());
            kmf.init(ks, "mypassword".toCharArray());



            // Create trust manager
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(getAlgorithm());
            trustManagerFactory.init(ks);
            TrustManager[] tm = trustManagerFactory.getTrustManagers();


            sslContext = SSLContext.getInstance("TLS");
            sslContext.init(kmf.getKeyManagers(), tm, null);

            // Create socket factory
         //   SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            SSLSocketFactory sslsocketfactory = (SSLSocketFactory)SSLSocketFactory.getDefault();
            SSLSocket sslSocket = (SSLSocket)sslsocketfactory.createSocket("localhost",8443);



            // Create socket
         //   SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket("localhost", 8443);




            sslSocket.startHandshake();

            // Get session after the connection is established
            SSLSession sslSession = sslSocket.getSession();

            System.out.println("SSLSession : " + sslSession);
            System.out.println("\tProtocol : "+sslSession.getProtocol());
            System.out.println("\tCipher suite : "+sslSession.getCipherSuite());

            System.out.println("Input : ");

            // Start handling application content
            InputStream inputStream = sslSocket.getInputStream();
           // OutputStream outputStream = sslSocket.getOutputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
           // PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream));

            System.out.println("Inut0 : " + line);
            line = bufferedReader.readLine();
            System.out.println("Inut1 : " + line);


            while((line = bufferedReader.readLine()) != null){
                System.out.println("Inut2 : "+line);

//                if(line.trim().equals("HTTP/1.1 200\r\n")){
//                    break;
//                }
            }



      //  } catch (IOException |KeyStoreException | CertificateException | NoSuchAlgorithmException | UnrecoverableKeyException | KeyManagementException e) {

        } catch (Exception e) {

            e.printStackTrace();
        }

    }




    private String getAlgorithm() {
        String algorithm = Security.getProperty(
                "ssl.KeyManagerFactory.algorithm");
        if (algorithm == null) {
            algorithm = "SunX509";
        }
        return algorithm;
    }

}
