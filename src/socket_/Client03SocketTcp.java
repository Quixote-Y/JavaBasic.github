package socket_;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;



public class Client03SocketTcp {

	public static void main(String[] args) throws Exception  {
		
		Socket socket=new Socket(InetAddress.getLocalHost(),8888);
		
		String path="E:\\javaTestFile\\1.png";
		BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream(path));
		
		byte[] data=StreamUtils.streamToByteArray(bufferedInputStream);
		
		BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(socket.getOutputStream());
		bufferedOutputStream.write(data);
		bufferedOutputStream.flush();
		socket.shutdownOutput();
		
		InputStream in=socket.getInputStream();
		byte[] dataReturn=in.readAllBytes();
		System.out.println(new String(dataReturn));
		
		//
		in.close();
		bufferedInputStream.close();
		bufferedOutputStream.close();
		socket.close();
	}
}
