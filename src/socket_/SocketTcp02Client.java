package socket_;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

//01为使用字节流，现在02使用字符流
public class SocketTcp02Client {

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
		//3.使用转换流，将字节流转换为字符流
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(out));
		//  写入数据（输出数据）
		bw.write("hello sever 字符流");
		
		//        设置一个结束标记
		//socket.shutdownOutput();//很必要，这个标记告诉服务器端写入结束，这样服务器端程序才会进行
		//在字符流中，还可以使用 newLine（）方法来声明结束标记，但这样的话，服务器端必须使用readLine（）方法读取才行
		//bw.newLine();
		//在用while  readLine的时候，写newLine作为结束标志失效了，只能用socket.shutdownOutput
		
		//用字符流，写完数据必须刷新,不然不会刷新
		bw.flush();
		socket.shutdownOutput();
		
		
		//获取输入流
		InputStream in=socket.getInputStream();
		//转换流
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		String data="";
		while((data=br.readLine())!=null) {
			System.out.println(data);
		}


		//4.关闭数据流和socket 
		br.close();
		bw.close();
		socket.close();

	}
}
