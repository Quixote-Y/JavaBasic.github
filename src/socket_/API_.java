package socket_;

import java.net.InetAddress;
import java.net.UnknownHostException;

//��ʼ������
//InetAddress ���ʹ��
public class API_ {

	public static void main(String[] args) throws UnknownHostException {
		
		//���Ǿ�̬����
		//1.��ȡ������InetAddress����
		InetAddress localHost=InetAddress.getLocalHost();
		System.out.println(localHost);
		//LAPTOP-IH1P83TQ/10.194.158.231  ������+IP��ַ
		
		//2.��������������ȡ������InetAddress����
		InetAddress localHost1=InetAddress.getByName("LAPTOP-IH1P83TQ");
	    System.out.println(localHost1);
	    
	    //3.������������ InetAddress���� 
	    InetAddress host2=InetAddress.getByName("www.baidu.com");
	    System.out.println(host2);
	    //www.baidu.com/110.242.68.3   ����+Ip��ַ
	    
	    //4.ͨ��InetAddress��ȡ��Ӧ ip��ַ
	    String  ip =host2.getHostAddress();//��ȡip��ַ
	    System.out.println(ip);//110.242.68.3
	    
	    //5.ͨ��InetAddress���󣬻�ȡ��Ӧ��������/����
	    String name=host2.getHostName();
	    System.out.println(name);//www.baidu.com
	}
}
