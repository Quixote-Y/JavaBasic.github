package socket_;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 
 * @author 86136
 *1.udp,������Э�飬ÿ�δ������ݱ�������64k
 *2.Tcp��������ͨ�����˼�Socket���������socket�����ṩ������ͨ����������ʵ�ֿͻ��˺ͷ���˵�ͨѶ
 *3.Udpû�пͻ��˷���˵�������ֻ�н��շ��ͷ��ͷ���������λ���ȣ�����������DatagramSocket��
 *     ���ܷ�������ͨ��DatagramSocket������ɣ�  �����ݷ�װ��DatagramPacket����װ������
 *     ��һ���յ�DatagramePacket����ʱ����Ҫ�����ȡ�����������
 *   DatagramePacket���� �������� ip ���ݳ���  �˿ڵ���Ϣ
 */
public class UdpReceiver01 {

	public static void main(String[] args) throws IOException {
		//���ն�
		//1.����һ��DatagramSocket����׼������9999�˿ڵ�����
		DatagramSocket socket=new DatagramSocket(9999);
		
		//2.����һ��DatagramPacket����׼����������
		//       ÿ�δ������ݱ�������64k
		byte[] buf=new byte[1024];
		//����Ϊ�����ݴ���أ���С
		DatagramPacket packet=new DatagramPacket(buf, buf.length);
		
		//3.���ý��շ�������ͨ�����紫���DatagramPacket������䵽packet����
		//    �����ݰ����͵�������9999�˿�ʱ���ͻ��������
		//           ���û�����ݰ����͵� 9999�˿� ���ͻ������ȴ�
		System.out.println("���ն� �ȴ���������");
		
		socket.receive(packet);
		
		//4.��packet ���в�� ��ȡ������ ����ʾ
		int length=packet.getLength();//ʵ�ʽ��յ��������ܳ�
		byte[] data=packet.getData();//���յ�������
		
		System.out.println(new String(data,0,length));
		
		
		//5.�������ݹ�ȥ
		byte[] data2="�õģ��������".getBytes();
		DatagramPacket packet1=new DatagramPacket(data2, data2.length, InetAddress.getByName("10.194.158.231"), 9998);
		
		socket.send(packet1);
		
		
		//�ر�socket
		socket.close();
	}
}
