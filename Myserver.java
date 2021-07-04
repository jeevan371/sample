import java.io.*;
import java.net.*;
class Myserver {
	public static void main(String args[])throws Exception
	{
		ServerSocket ss=new ServerSocket(3333);
		Socket s=ss.accept();
		DataInputStream din=new DataInputStream(s.getInputStream());
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
		String str="";
		while(!str.equals("stop")) {
			str=din.readUTF();
			System.out.println("Client says "+str);
			dout.writeUTF(str);
			dout.flush();
		}
		din.close();
		s.close();
		ss.close();
	}
}