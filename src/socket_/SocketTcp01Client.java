package socket_;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

//客户端，连接服务器端9999端口，发送hello sever
public class SocketTcp01Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//思路
		//1.连接服务器（ip，端口号）
		//   这段代码的意思是： 建立一个Socket对象，数据通道对象是InetAddress.getLocalHost()，也就是本机
		//                      连接端口号是9999
		Socket socket =new Socket(InetAddress.getLocalHost(),9999);
		System.out.println("客户端建立连接");
		//注意，这里必须先运行服务器端，再来运行客户端
		
		//2.连接上后，生成Socket对象，通过Socket.getOutputStream()
		//          得到 和Socket对象相关联的输出流对象,
		OutputStream out=socket.getOutputStream();
		//3.通过输出流，写入数据到数据通道
		out.write("hello sever".getBytes());
		
		//        设置一个结束标记
		socket.shutdownOutput();//很必要，这个标记告诉服务器端写入结束，这样服务器端程序才会进行
		
		
		//获取输入流
		InputStream in=socket.getInputStream();
		byte[] buf=new byte[1024];
		int len=0;
		while((len=in.read(buf))!=-1) {
			System.out.println(new String(buf,0,len));
		}
		
		
		//4.关闭数据流和socket 
		out.close();
		in.close();
		socket.close();

	}
}
