package socket_;
//�������ˣ� ����9999�ӿڣ���ȡ����ͨ����Ϣ�����
//�ֽ���

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTcp02Server {

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
		// ת����
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		// �������
		String data="";
		while((data=br.readLine())!=null) {
			System.out.println(data);
		}
		
		//��ȡ�����
		OutputStream out=socket.getOutputStream();

		//ת����
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(out));
		//д������
		bw.write("hello client �ַ���");
		//���ý������
		bw.newLine();
		//ˢ��
		bw.flush();
		socket.shutdownOutput();
		
		//�ر�����socket ��SeverSocket
		bw.close();
		br.close();
		socket.close();
		serverSocket.close();
		
	}
}
