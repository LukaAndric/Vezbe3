package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws IOException {
		InetAddress addr = InetAddress.getByName("127.0.0.1");
		int port = 9000;
		Socket sock = null;
		try {
			sock = new Socket(addr, port);
			
			String poruka = "Zdravo svete";
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()), true);
			writer.println(poruka);
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			String odgovor = reader.readLine();
			
			System.out.println("Server odgovorio: " + odgovor);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			sock.close();
		}
	}

}
