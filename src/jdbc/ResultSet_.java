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

//ResultSet结果集用法
public class ResultSet_ {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		
		//先建立连接
		Properties properties=new Properties();
		properties.load(new FileInputStream("src\\mysql.properties"));
		String user=properties.getProperty("user");
		String password=properties.getProperty("password");
		String driver=properties.getProperty("driver");
		String url=properties.getProperty("url");
		
		Class.forName(driver);
		Connection connect =DriverManager.getConnection(url,user,password);
		
		//得到statement
		Statement statement=connect.createStatement();
		
		//写sql
		String sql="select * from jdbcTest_db";
		
		ResultSet resultSet=statement.executeQuery(sql);//执行executeQuery（）返回一个结果集ResultSet
	    
		//resultSet的机制和迭代器一样，初始指针指向头元素上一位，使用next下移指针，当没有元素的时候返回false，因此与while连用
		while(resultSet.next()) {
			//取出元素
			int id=resultSet.getInt(1);//取出第一列的内容，赋给int id
			String name=resultSet.getString(2);//第二列
			String sex=resultSet.getString(3);
			int age=resultSet.getInt(4);
			System.out.println(id+"\t"+name+"\t"+sex+"\t"+age);
		}
		
		//关闭连接
		resultSet.close();
		statement.close();
		connect.close();
	
	}
}

/*
 * 这里研究一下Resultset的底层机制：
 *   1.首先，ResultSet是一个java接口：public interface ResultSet extends Wrapper, AutoCloseable 
 *     他在这里是接口引用指向实现类，那关键就在于他的实现类
 *   2.不知道怎么设置的，我打不开他的实现类，就按着视频的梳理一下把
 *     ：ResultSet底层其实是一个ArrayList集合类，他维护的是一个elemDate的数组，elemDate数组又存放一个
 *       byte数组的数组，一个elemDate位存放数据表一行的数据，一个byte数组是这一行某一列的数据，通过存多组byte数组
 *       就能存下一行的完整数据，以此来存放数据表数据
 * 
*/
