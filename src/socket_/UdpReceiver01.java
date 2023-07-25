package socket_;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 
 * @author 86136
 *1.udp,无连接协议，每次传输数据报不超过64k
 *2.Tcp是在数据通道两端加Socket类对象，利用socket对象提供的数据通道相连的流实现客户端和服务端的通讯
 *3.Udp没有客户端服务端的区别，他只有接收方和发送方，两方地位均等，在两方建立DatagramSocket，
 *     接受发送数据通过DatagramSocket对象完成，  将数据封装到DatagramPacket对象（装包），
 *     当一方收到DatagramePacket对象时，需要拆包，取出里面的数据
 *   DatagramePacket对象 包含数据 ip 数据长度  端口等信息
 */
public class UdpReceiver01 {

	public static void main(String[] args) throws IOException {
		//接收端
		//1.创建一个DatagramSocket对象，准备接受9999端口的数据
		DatagramSocket socket=new DatagramSocket(9999);
		
		//2.构建一个DatagramPacket对象，准备接收数据
		//       每次传输数据报不超过64k
		byte[] buf=new byte[1024];
		//参数为，数据存入地，大小
		DatagramPacket packet=new DatagramPacket(buf, buf.length);
		
		//3.调用接收方法，将通过网络传输的DatagramPacket对象填充到packet对象
		//    当数据包发送到本机的9999端口时，就会接收数据
		//           如果没有数据包发送到 9999端口 ，就会阻塞等待
		System.out.println("接收端 等待接收数据");
		
		socket.receive(packet);
		
		//4.把packet 进行拆包 ，取出数据 ，显示
		int length=packet.getLength();//实际接收到的数据总长
		byte[] data=packet.getData();//接收到的数据
		
		System.out.println(new String(data,0,length));
		
		
		//5.发送数据过去
		byte[] data2="好的，明天见！".getBytes();
		DatagramPacket packet1=new DatagramPacket(data2, data2.length, InetAddress.getByName("10.194.158.231"), 9998);
		
		socket.send(packet1);
		
		
		//关闭socket
		socket.close();
	}
}
