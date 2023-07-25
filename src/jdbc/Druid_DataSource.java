package jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;

import com.alibaba.druid.pool.DruidDataSourceFactory;

//Druid 数据库连接池 用法
public class Druid_DataSource {

	@Test
	public void DruidTest() throws Exception {
		//1.添加Druid jar 包
		//2.添加durid 配置文件 properties 到项目目录下
		//3.创建Properties对象，读取 配置文件
		Properties properties = new Properties();
		properties.load(new FileInputStream("src\\druid.properties"));
		
		//创建一个指定参数的数据库连接池 Druid 连接池
		DataSource dataSource = 
				DruidDataSourceFactory.createDataSource(properties);
		
		long start = System.currentTimeMillis();
		for(int i=0;i<5000;i++) {
			Connection connection = dataSource.getConnection();
			
			connection.close();
		}
		long end = System.currentTimeMillis();
		System.out.println("得路易德建立5000次连接耗时："+(end-start));
	}//得路易德建立5000次连接耗时：849 ,当多次调用时，Druid性能完胜 c3P0

	
	//
}
