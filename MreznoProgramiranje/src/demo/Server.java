package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException, InterruptedException {
		int port = 9000;
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(port);
			
			System.out.println("Server slusa");
			
			while(true) {
				Socket sock = ss.accept();
				
				ServerThread thread = new ServerThread(sock);
				thread.start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			ss.close();
		}
	}

}
