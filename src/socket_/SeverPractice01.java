package socket_;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


//�ļ�����
public class SeverPractice01 {

	public static void main(String[] args) throws Exception {
		String path="E:\\javaTestFile\\��ɽ��ˮ.mp3";
		String pathDefult="E:\\javaTestFile\\Two Steps From Hell - Empire Of Angels (V0).mp3";
		
		ServerSocket serverSocket=new ServerSocket(9998);
	    System.out.println("sever listerning");
	    
	    Socket socket=serverSocket.accept();
	    System.out.println("estabilsh connection");
	    
	    BufferedInputStream bi=new BufferedInputStream(socket.getInputStream());
	    String massage="";
	    byte[] buf= new byte[1024];
	    int len=0;
	    while((len=bi.read(buf))!=-1) {
	    	massage+=new String(buf,0,len);
	    }
	   
    	
	    System.out.println(massage);

	    BufferedOutputStream bufferedOutputStream =new BufferedOutputStream(socket.getOutputStream());
    	
    	
	    if(massage.equals("��ɽ��ˮ")) {
	    	BufferedInputStream bufferedInputStream =new BufferedInputStream(new FileInputStream(path));
	 
	    	bufferedOutputStream.write(StreamUtils.streamToByteArray(bufferedInputStream));
	    	
	    	bufferedInputStream.close();
	    }else {
	    	BufferedInputStream bufferedInputStream =new BufferedInputStream(new FileInputStream(pathDefult));
	    	
	    	bufferedOutputStream.write(StreamUtils.streamToByteArray(bufferedInputStream));
	        
	    	// 
	    	 bufferedInputStream.close();
	    }
	    socket.shutdownOutput();
	    
	    //
	    bufferedOutputStream.close();
	    bi.close();
	    socket.close();
	    serverSocket.close();
	}
}
