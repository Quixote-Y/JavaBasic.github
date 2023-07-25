package socket_;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

//udp���ӷ��Ͷ�
public class UdpSender01 {

	public static void main(String[] args) throws IOException {
		//���Ͷ�
		//1.����DatagramSocket����׼����9998�ӿڽ�������
		DatagramSocket socket=new DatagramSocket(9998);//��Ҫ��Ϊ���Ͷ˽��ն���һ̨�����ϣ����������ӿ�һ��
		
		//2.��Ҫ��������� ��װ�� DatagramPackett��
		byte[] data="Hello ����Ի����".getBytes();
		DatagramPacket packet=new DatagramPacket(data, data.length,InetAddress.getByName("10.194.158.231"),9999);
		//����Ĳ��������ݣ����ݳ��ȣ�Ŀ��ĵ�ַ������ͨ��ip��ַ��ȡ�ģ���Ŀ��˿ں�   ������캯������Ҫ
		
		//3.���ͳ�ȥ
		socket.send(packet);//�շ���ʹ��DatagramSocket
		
		//4.�������ݣ����
		//�Ƚ���һ��DatagramPacket�����ܶ��淢����������
		byte[] buf=new byte[1024];
		DatagramPacket packet2=new DatagramPacket(buf, buf.length);
		//�������ݵ�packet2
		socket.receive(packet2);
		
		int length =packet2.getLength();
		byte[] data2=packet2.getData();
		
		System.out.println(new String(data2,0,length));
		
		
		//�ر�socket
		socket.close();
		//�����н��նˣ������з��Ͷˣ������ڽ��ն˵��ն��Ͽ���Hello ����Ի��
	}
}
