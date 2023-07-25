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

//01Ϊʹ���ֽ���������02ʹ���ַ���
public class SocketTcp02Client {

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
		//3.ʹ��ת���������ֽ���ת��Ϊ�ַ���
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(out));
		//  д�����ݣ�������ݣ�
		bw.write("hello sever �ַ���");
		
		//        ����һ���������
		//socket.shutdownOutput();//�ܱ�Ҫ�������Ǹ��߷�������д������������������˳���Ż����
		//���ַ����У�������ʹ�� newLine��������������������ǣ��������Ļ����������˱���ʹ��readLine����������ȡ����
		//bw.newLine();
		//����while  readLine��ʱ��дnewLine��Ϊ������־ʧЧ�ˣ�ֻ����socket.shutdownOutput
		
		//���ַ�����д�����ݱ���ˢ��,��Ȼ����ˢ��
		bw.flush();
		socket.shutdownOutput();
		
		
		//��ȡ������
		InputStream in=socket.getInputStream();
		//ת����
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		String data="";
		while((data=br.readLine())!=null) {
			System.out.println(data);
		}


		//4.�ر���������socket 
		br.close();
		bw.close();
		socket.close();

	}
}
