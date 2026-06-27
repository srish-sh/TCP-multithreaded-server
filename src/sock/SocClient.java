package sock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		String ip = "localhost";
		int port =9999;
		Socket clientSoc= new Socket(ip,port);
		OutputStreamWriter os =new OutputStreamWriter(clientSoc.getOutputStream());
		PrintWriter out = new PrintWriter(os);
		out.println("srishti sharma");
		os.flush();
		
		BufferedReader br=new BufferedReader(new InputStreamReader(clientSoc.getInputStream()));
		String str= br.readLine();
		System.out.println("server data: "+ str);
		
		clientSoc.close();
		
	}
}
