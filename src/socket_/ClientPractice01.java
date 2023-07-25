package socket_;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

//�ļ�����
public class ClientPractice01 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		String path="E:\\javaTestFile\\myTemp\\Clientpractice01Read.mp3";
		
		Socket socket=new Socket(InetAddress.getByName("10.194.61.163"),9998);
		
		System.out.println("client eatablish connection");
		
		BufferedOutputStream bo=new BufferedOutputStream(socket.getOutputStream());
		
		System.out.println("what musical do you want ?");
		Scanner scanner=new Scanner(System.in);
		String massage=scanner.next();
		//String massage="��ɽ��ˮ";
		bo.write(massage.getBytes());
		bo.flush();
		//
		/*
		 * OutputStream�е�flush()	    ˢ���������ǿ��д�����л��������ֽ�
           OutputStream�е�close()	    �رմ���������ͷ��������ص��κ�ϵͳ��Դ
           Socket�е�shutdownOutput()	���ô��׽��ֵ������
           ʹ��flush()���� ��û�йر�socket�е���������³�����Ϊ����д���ֽ�
           ʹ��clost()���� ���׹ر�������� ���һ���socketҲ���ͷ��ˣ����¿ͻ��˹�ͣ
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
		//����������Ҳ��������һ����sb���쳣����bo.close��ʱ����ʾsocket closed,, һֱ��Ϊ����Ϊsocket��ʲô�ط�����С�Ĺرգ����쳣������ob.close�ĵط������ɻ�
		// ���������Ϊû��дob.flush,����֡�
		//Ȼ����ǣ���ʹ��bufferedд֮��һ��Ҫflush
	}
}
