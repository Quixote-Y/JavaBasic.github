package socket_;

// TCP    0.0.0.0:8888           0.0.0.0:0              LISTENING
//在cmd上输入netstat -an|more 可以分页查看所有本机的端口情况
//以管理员身法运行netstat  -anb 可以查看本机所有端口都是那些软件在使用
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server03SocketTcp {

	public static void main(String[] args) throws Exception {
		
		ServerSocket serverSocket=new ServerSocket(8888);
		System.out.println("Sever Listerning");
		
		Socket socket=serverSocket.accept();
		String path="src\\1Copy.png";
		BufferedInputStream bufferedInputStream=new BufferedInputStream(socket.getInputStream());
		BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(path));
		
//		/*相似问题：
//		对接远程服务端，报文能成功发送，但是报Connection reset。
//         原因:就是客户端在接受服务端的响应时，没有对循环while ((info = br.readLine()) != null)读出的信息进行判断，导致无法跳出循环直至对端关闭连接，然后客户端抛异常。
//		 */
//		/*
//		 * java.net.SocketException: Connection reset/Connect reset by peer: Socket write error指连接被重置。
//		 * 这里有两种情况，分别对应两种错误：第一种情况是通信的一方已经将 Socket 关闭，可能是主动关闭或者是因为异常退出，
//		 * 这时如果通信的另一方还在写数据，就会触发这个异常（Connect reset by peer）；如果对方还在尝试从 TCP 连接中读数据，
//		 * 则会抛出 Connection reset 异常。为了避免这些异常发生，在编写网络通信程序时要确保：程序退出前要主动关闭所有的网络连接。
//		 * 检测通信的另一方的关闭连接操作，当发现另一方关闭连接后自己也要关闭该连接。
//		 */
		
		//这里遇到了一个异常，服务器抛出java.net.SocketException: Connection reset  ，然后另一个客户端抛出了Exception in thread "main" java.io.FileNotFoundException: E:\javaTestFil\1.png (系统找不到指定的路径。)
		//没看到，nnd，文件路径打错了，导致我去找服务器这边的问题
		//服务器抛出java.net.SocketException: Connection reset的原因应该是客户端因为异常没有正常传入数据，然后内边结束了socket关闭，这边没有检测到输入，程序就一值在reade这个地方阻塞着，然后客户端socket关闭后，这边
		//被通知也应该关闭socket，所以抛出了连接重置的异常
		
		bufferedOutputStream.write(bufferedInputStream.readAllBytes());
//		byte[] data=StreamUtils.streamToByteArray(bufferedInputStream);
//		bufferedOutputStream.write(data);
		
		
		System.out.println("Copy complement");
		OutputStream out=socket.getOutputStream();
		out.write("收到数据  服务器".getBytes());
		
		//
		out.close();
		bufferedInputStream.close();
		bufferedOutputStream.close();
		socket.close();
		serverSocket.close();
		
	}
}
