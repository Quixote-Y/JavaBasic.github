package socket_;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

//�ͻ��ˣ����ӷ�������9999�˿ڣ�����hello sever
public class SocketTcp01Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//˼·
		//1.���ӷ�������ip���˿ںţ�
		//   ��δ������˼�ǣ� ����һ��Socket��������ͨ��������InetAddress.getLocalHost()��Ҳ���Ǳ���
		//                      ���Ӷ˿ں���9999
		Socket socket =new Socket(InetAddress.getLocalHost(),9999);
		System.out.println("�ͻ��˽�������");
		//ע�⣬������������з������ˣ��������пͻ���
		
		//2.�����Ϻ�����Socket����ͨ��Socket.getOutputStream()
		//          �õ� ��Socket��������������������,
		OutputStream out=socket.getOutputStream();
		//3.ͨ���������д�����ݵ�����ͨ��
		out.write("hello sever".getBytes());
		
		//        ����һ���������
		socket.shutdownOutput();//�ܱ�Ҫ�������Ǹ��߷�������д������������������˳���Ż����
		
		
		//��ȡ������
		InputStream in=socket.getInputStream();
		byte[] buf=new byte[1024];
		int len=0;
		while((len=in.read(buf))!=-1) {
			System.out.println(new String(buf,0,len));
		}
		
		
		//4.�ر���������socket 
		out.close();
		in.close();
		socket.close();

	}
}
