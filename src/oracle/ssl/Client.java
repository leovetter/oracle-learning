package oracle.ssl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.net.SocketFactory;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class Client {

	
	public void runClient() {
		
		String host = "localhost";
		int port = 8447;
		SocketFactory factory = SSLSocketFactory.getDefault();
		try (Socket connection = factory.createSocket(host, port)) {
			
		    ((SSLSocket) connection).setEnabledCipherSuites(new String[] { "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256" });
		    ((SSLSocket) connection).setEnabledProtocols(new String[] { "TLSv1.2" });
		    
		    SSLParameters sslParams = new SSLParameters();
		    sslParams.setEndpointIdentificationAlgorithm("HTTPS");
		    ((SSLSocket) connection).setSSLParameters(sslParams);
		    
		    BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		    
		    System.out.println(input.readLine());
		    
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
