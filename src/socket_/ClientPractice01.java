package socket_;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

//文件下载
public class ClientPractice01 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		String path="E:\\javaTestFile\\myTemp\\Clientpractice01Read.mp3";
		
		Socket socket=new Socket(InetAddress.getByName("10.194.61.163"),9998);
		
		System.out.println("client eatablish connection");
		
		BufferedOutputStream bo=new BufferedOutputStream(socket.getOutputStream());
		
		System.out.println("what musical do you want ?");
		Scanner scanner=new Scanner(System.in);
		String massage=scanner.next();
		//String massage="高山流水";
		bo.write(massage.getBytes());
		bo.flush();
		//
		/*
		 * OutputStream中的flush()	    刷新输出流并强制写入所有缓冲的输出字节
           OutputStream中的close()	    关闭此输出流并释放与此流相关的任何系统资源
           Socket中的shutdownOutput()	禁用此套接字的输出流
           使用flush()方法 并没有关闭socket中的输出流导致程序以为还会写入字节
           使用clost()方法 彻底关闭了输出流 并且还把socket也给释放了，导致客户端关停
		 */
		socket.shutdownOutput();
		
		InputStream inputStream=socket.getInputStream();
		
		BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(path));
		bufferedOutputStream.write(inputStream.readAllBytes());
		bufferedOutputStream.flush();
		
		//
		inputStream.close();
		bufferedOutputStream.close();
		bo.close();
		socket.close();
		//这个程序最初也出现了以一个很sb的异常，在bo.close的时候显示socket closed,, 一直以为是因为socket在什么地方被不小心关闭，但异常出现在ob.close的地方，很疑惑
		// 最后发现是因为没有写ob.flush,很奇怪。
		//然后就是，在使用buffered写之后，一定要flush
	}
}
