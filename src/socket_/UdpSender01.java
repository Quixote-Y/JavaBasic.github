package socket_;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

//udp连接发送端
public class UdpSender01 {

	public static void main(String[] args) throws IOException {
		//发送端
		//1.建立DatagramSocket对象，准备在9998接口接收数据
		DatagramSocket socket=new DatagramSocket(9998);//主要因为发送端接收端在一台主机上，不能两个接口一样
		
		//2.将要传输的数据 封装到 DatagramPackett里
		byte[] data="Hello 明天吃火锅！".getBytes();
		DatagramPacket packet=new DatagramPacket(data, data.length,InetAddress.getByName("10.194.158.231"),9999);
		//这里的参数：数据，数据长度，目标的地址（这是通过ip地址获取的），目标端口号   这个构造函数很重要
		
		//3.发送出去
		socket.send(packet);//收发是使用DatagramSocket
		
		//4.接受数据，输出
		//先建立一个DatagramPacket来接受对面发过来的数据
		byte[] buf=new byte[1024];
		DatagramPacket packet2=new DatagramPacket(buf, buf.length);
		//接收数据到packet2
		socket.receive(packet2);
		
		int length =packet2.getLength();
		byte[] data2=packet2.getData();
		
		System.out.println(new String(data2,0,length));
		
		
		//关闭socket
		socket.close();
		//先运行接收端，再运行发送端，可以在接收端的终端上看到Hello 明天吃火锅
	}
}
