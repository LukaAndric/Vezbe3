package demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
	
	private Socket sock;
	
	public ServerThread(Socket sock) {
		this.sock = sock;
	}
	
	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			String zahtev = reader.readLine();
			
			Thread.sleep(3000);
			
			System.out.println("Stigao je zahtev: " + zahtev);
			
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()), true);
			writer.println("Server odgovara: Zdravo");
			sock.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

}
