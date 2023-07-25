package socket_;
//服务器端： 监听9999接口，读取数据通道信息，输出
//字节流

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTcp01Server {

	public static void main(String[] args) throws IOException {
		//思路
		//1.在本机的9999端口进行监听
		//    细节：要求在本机没有其他服务在监听9999端口
		//    细节：这个ServerSocket 可以通过 accept（）方法 返回多个Socket【】对象，支持多个客户端来连接服务器
		ServerSocket serverSocket=new ServerSocket(9999);
		System.out.println("服务端正在监听，等待连接");
		
		//2.accept 当没有客户端连接9999端口时，程序会阻塞在这里
		//         如果有客户端连接，那么accept 会返回一个Socket对象，程序继续执行
		Socket socket=serverSocket.accept();
		
		System.out.println("服务器端 socket ="+socket.getClass());
		
		//3.通过Socket 方法getInputStream（）
		//获取和socket相关联的 输入流对象
		InputStream in=socket.getInputStream();
		
		//4.输出流对象中的数据，没有获得数据就在这停着
		byte[] buf=new byte[1024];
		int readLen=0;
		while((readLen=in.read(buf))!=-1) {
			System.out.println(new String(buf,0,readLen));
		}
		
		//获取输出流
		OutputStream out=socket.getOutputStream();
		System.out.println("服务器写数据到输入流里");
		out.write("hello cilent".getBytes());
		socket.shutdownOutput();
		
		//关闭流，socket ，SeverSocket
		in.close();
		out.close();
		socket.close();
		serverSocket.close();
		
	}
}
