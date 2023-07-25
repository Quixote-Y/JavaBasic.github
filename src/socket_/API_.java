package socket_;

import java.net.InetAddress;
import java.net.UnknownHostException;

//开始网络编程
//InetAddress 类的使用
public class API_ {

	public static void main(String[] args) throws UnknownHostException {
		
		//大都是静态方法
		//1.获取本机的InetAddress对象
		InetAddress localHost=InetAddress.getLocalHost();
		System.out.println(localHost);
		//LAPTOP-IH1P83TQ/10.194.158.231  主机名+IP地址
		
		//2.根据主机名，获取主机的InetAddress对象
		InetAddress localHost1=InetAddress.getByName("LAPTOP-IH1P83TQ");
	    System.out.println(localHost1);
	    
	    //3.根据域名返回 InetAddress对象 
	    InetAddress host2=InetAddress.getByName("www.baidu.com");
	    System.out.println(host2);
	    //www.baidu.com/110.242.68.3   域名+Ip地址
	    
	    //4.通过InetAddress获取对应 ip地址
	    String  ip =host2.getHostAddress();//获取ip地址
	    System.out.println(ip);//110.242.68.3
	    
	    //5.通过InetAddress对象，获取对应的主机名/域名
	    String name=host2.getHostName();
	    System.out.println(name);//www.baidu.com
	}
}
