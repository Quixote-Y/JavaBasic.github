package socket_;
//�������ˣ� ����9999�ӿڣ���ȡ����ͨ����Ϣ�����
//�ֽ���

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTcp01Server {

	public static void main(String[] args) throws IOException {
		//˼·
		//1.�ڱ�����9999�˿ڽ��м���
		//    ϸ�ڣ�Ҫ���ڱ���û�����������ڼ���9999�˿�
		//    ϸ�ڣ����ServerSocket ����ͨ�� accept�������� ���ض��Socket��������֧�ֶ���ͻ��������ӷ�����
		ServerSocket serverSocket=new ServerSocket(9999);
		System.out.println("��������ڼ������ȴ�����");
		
		//2.accept ��û�пͻ�������9999�˿�ʱ�����������������
		//         ����пͻ������ӣ���ôaccept �᷵��һ��Socket���󣬳������ִ��
		Socket socket=serverSocket.accept();
		
		System.out.println("�������� socket ="+socket.getClass());
		
		//3.ͨ��Socket ����getInputStream����
		//��ȡ��socket������� ����������
		InputStream in=socket.getInputStream();
		
		//4.����������е����ݣ�û�л�����ݾ�����ͣ��
		byte[] buf=new byte[1024];
		int readLen=0;
		while((readLen=in.read(buf))!=-1) {
			System.out.println(new String(buf,0,readLen));
		}
		
		//��ȡ�����
		OutputStream out=socket.getOutputStream();
		System.out.println("������д���ݵ���������");
		out.write("hello cilent".getBytes());
		socket.shutdownOutput();
		
		//�ر�����socket ��SeverSocket
		in.close();
		out.close();
		socket.close();
		serverSocket.close();
		
	}
}
