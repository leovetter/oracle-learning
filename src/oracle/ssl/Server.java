package oracle.ssl;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class Server {

	
	public static void main(String[] args) {
		
		int port = 8447;
		ServerSocketFactory factory = SSLServerSocketFactory.getDefault();
		
		try (ServerSocket listener = factory.createServerSocket(port)) {
			
		    SSLServerSocket sslListener = (SSLServerSocket) listener;
//		    sslListener.setNeedClientAuth(true);
		    sslListener.setEnabledCipherSuites(new String[] { "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256" });
		    sslListener.setEnabledProtocols(new String[] { "TLSv1.2" });
		    
		    while (true) {
		        try (Socket socket = sslListener.accept()) {
		            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		            out.println("Hello World!");
		        }
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
