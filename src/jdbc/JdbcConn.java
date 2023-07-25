package jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.jupiter.api.Test;

import com.mysql.cj.jdbc.Driver;

//�ܽ���mysqlͨ��jdbc����java��5�ַ�ʽ
public class JdbcConn {

	public static void main(String[] args) {

	}

	@Test
	public  void connect01() throws SQLException {
		// ��ʽ1
		//���ַ�ʽֱ�Ӵ���һ��driver����driver�����������ǵ���İ��������������׷����������
		Driver driver = new Driver();
		String url = "jdbc:mysql://localhost:3306/yyf_db01";
		// ���û��� ����ŵ�Properties������
		Properties properties = new Properties();
		// ������������ݿ���û�������
		properties.put("user", "root");
		properties.put("password", "1234");
		// ��������
		Connection connect = driver.connect(url, properties);
		System.out.println(connect);
		// com.mysql.cj.jdbc.ConnectionImpl@387a8303���ӳɹ�
	}
	//��ʽ2��ʹ�÷�����ƣ������
	@Test
	public void connect02() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		//ʹ�÷������Driver�࣬��̬���أ����ٱ���ʱ���󣬸������
		Class<?> aclass =Class.forName("com.mysql.cj.jdbc.Driver");
		Driver driver=(Driver) aclass.newInstance();
		
		String url="jdbc:mysql://localhost:3306/yyf_db01";
		Properties properties =new Properties();
		properties.setProperty("user", "root");
		properties.setProperty("password", "1234");
		Connection connect=driver.connect(url, properties);
		System.out.println(connect);
		//Ҳ�õ���
	}
	
	//��ʽ3 ʹ��DriverManager��driver����ͳһ���� 
	@Test
	public void connect03() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		Class<?> aclass=Class.forName("com.mysql.cj.jdbc.Driver");
		Driver driver=(Driver) aclass.newInstance();
		
		//����url��user��password
		String url="jdbc:mysql://localhost:3306/yyf_db01";
		String user="root";
		String password="1234";
		
		//����DriverManagerע������
		DriverManager.registerDriver(driver);
		
		Connection connect=DriverManager.getConnection(url,user,password);
		System.out.println(connect);
	}
	
	//��ʽ4��ʹ��class.forName�Զ��������ע�ᣬ��3�Ĵ���
	@Test
	public void connect04() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		/*
		 *��������Ϊʲô����ע��DriverManger������
		 *     ��Ϊ��Driver��������л��д�ľ�̬�����飬�����ʼ��
		 *     ע����DriverManager  
		 *DriverManager.registerDriver(new Driver());
		 *      ���Է�ʽ3�������Եö�����
		 */
		//����url��user��password
		String url="jdbc:mysql://localhost:3306/yyf_db01";
		String user="root";
		String password="1234";
		Connection connect=DriverManager.getConnection(url, user, password);
		
		System.out.println(connect);
	}
	
	/*����ķ�����صķ�ʽ�У����Ƚ�������ʽ�ķ�������
	 *  Class.forName() 
	 *  ��ʵ�������汾5.7.1֮�󶼿��Բ�д������䣬��Ϊ������jar������һ��
	 *  �ļ���META-INF\\services\\java.sql.Driver
	 *  ��������������ʱ��������Զ����� com.mysql.cj.jdbc.Driver�����ע�� 
	 *  ��˿��Բ�������ȥ��ʽ����
	 *  ��д�Ͽ϶�����û����ģ�������ȷ
	 */
	
	
	//5.ʹ�������ļ���������mysql�������
	@Test
	public void connect05() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		//�Ȼ�ȡproperties�ļ���Ϣ
		Properties properties=new Properties();
		properties.load(new FileInputStream("src\\mysql.properties"));
		
		//��ȡ��Ϣ
		String user=properties.getProperty("user");
		String password=properties.getProperty("password");
		String driver=properties.getProperty("driver");
		String url=properties.getProperty("url");
		//����Ҳ���һ��driver���Է�����ڸ�������
		//������ʽ����һ����������
		Class.forName(driver);
		//��ȡ����
		Connection connect=DriverManager.getConnection(url,user,password);
		System.out.println(connect);	
	}
	//�����͸��������
}
