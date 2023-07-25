package jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;

import com.alibaba.druid.pool.DruidDataSourceFactory;

//Druid ���ݿ����ӳ� �÷�
public class Druid_DataSource {

	@Test
	public void DruidTest() throws Exception {
		//1.���Druid jar ��
		//2.���durid �����ļ� properties ����ĿĿ¼��
		//3.����Properties���󣬶�ȡ �����ļ�
		Properties properties = new Properties();
		properties.load(new FileInputStream("src\\druid.properties"));
		
		//����һ��ָ�����������ݿ����ӳ� Druid ���ӳ�
		DataSource dataSource = 
				DruidDataSourceFactory.createDataSource(properties);
		
		long start = System.currentTimeMillis();
		for(int i=0;i<5000;i++) {
			Connection connection = dataSource.getConnection();
			
			connection.close();
		}
		long end = System.currentTimeMillis();
		System.out.println("��·�׵½���5000�����Ӻ�ʱ��"+(end-start));
	}//��·�׵½���5000�����Ӻ�ʱ��849 ,����ε���ʱ��Druid������ʤ c3P0

	
	//
}
