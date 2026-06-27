package sock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocServer { 

	public static void main(String[] args) throws IOException {
		System.out.println("server created");
		ServerSocket serverSoc = new ServerSocket(9999);//main socket
		
		System.out.println("server waiting ");
		Socket s=serverSoc.accept();//socket for individual client
		System.out.println("client connected");
		
		BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
		String str= br.readLine();
		System.out.println("client data "+ str);
		
		String nickName= str.substring(0, 3);
		
		OutputStreamWriter os =new OutputStreamWriter(s.getOutputStream());
		PrintWriter out = new PrintWriter(os);
		out.write(nickName);
		System.out.println("data sent from server");
		os.flush();
		
		s.close();
		serverSoc.close();
		
	}
}
