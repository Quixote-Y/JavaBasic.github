package jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Wrapper;
import java.util.Properties;

//ResultSet������÷�
public class ResultSet_ {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		
		//�Ƚ�������
		Properties properties=new Properties();
		properties.load(new FileInputStream("src\\mysql.properties"));
		String user=properties.getProperty("user");
		String password=properties.getProperty("password");
		String driver=properties.getProperty("driver");
		String url=properties.getProperty("url");
		
		Class.forName(driver);
		Connection connect =DriverManager.getConnection(url,user,password);
		
		//�õ�statement
		Statement statement=connect.createStatement();
		
		//дsql
		String sql="select * from jdbcTest_db";
		
		ResultSet resultSet=statement.executeQuery(sql);//ִ��executeQuery��������һ�������ResultSet
	    
		//resultSet�Ļ��ƺ͵�����һ������ʼָ��ָ��ͷԪ����һλ��ʹ��next����ָ�룬��û��Ԫ�ص�ʱ�򷵻�false�������while����
		while(resultSet.next()) {
			//ȡ��Ԫ��
			int id=resultSet.getInt(1);//ȡ����һ�е����ݣ�����int id
			String name=resultSet.getString(2);//�ڶ���
			String sex=resultSet.getString(3);
			int age=resultSet.getInt(4);
			System.out.println(id+"\t"+name+"\t"+sex+"\t"+age);
		}
		
		//�ر�����
		resultSet.close();
		statement.close();
		connect.close();
	
	}
}

/*
 * �����о�һ��Resultset�ĵײ���ƣ�
 *   1.���ȣ�ResultSet��һ��java�ӿڣ�public interface ResultSet extends Wrapper, AutoCloseable 
 *     ���������ǽӿ�����ָ��ʵ���࣬�ǹؼ�����������ʵ����
 *   2.��֪����ô���õģ��Ҵ򲻿�����ʵ���࣬�Ͱ�����Ƶ������һ�°�
 *     ��ResultSet�ײ���ʵ��һ��ArrayList�����࣬��ά������һ��elemDate�����飬elemDate�����ִ��һ��
 *       byte��������飬һ��elemDateλ������ݱ�һ�е����ݣ�һ��byte��������һ��ĳһ�е����ݣ�ͨ�������byte����
 *       ���ܴ���һ�е��������ݣ��Դ���������ݱ�����
 * 
*/
