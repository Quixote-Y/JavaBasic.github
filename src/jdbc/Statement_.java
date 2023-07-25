package jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

//statement 存在sql注入问题
public class Statement_ {

	/*何为sql注入:
	 *    通过传入参数的时候添加' '符号，让sql语句语义发生变化，使不合法的条件变得合法
	 *    
	 *    假设：一个查询：
	 *      Select * from admin
	 *      where name= ? and pwd = ? 
	 *      这样的一个查询本意是通过你传入的参数的不同，返回表里有没有这条记录，多用于核对用户是否合法
	 *      
	 *      但如果传入参数变成这样：
	 *       ?  : 1' or
	 *       ?  : or '1' ='1
	 *       那么构成的查询语句就变成了：
	 *       select * from admin
	 *       where name = '1'  or ' and pwd = 'or '1'='1';
	 *       因为传入参数时，字符串类型你要在两边加上一个''，配合上传入参数里的'就使语义发生了变化
	 *       where 里 name ='1'  或者 ' and pwd =' 或者 '1'='1'，显然第三个条件变成了永真式，这个查询语句一定会返回值  
	 * 
	 *       试了一下，在mysql中运行：select * from jdbctest_db where true ，他会返回所有的记录
	 *        那带入上面的语境，这个注入就可以返回所有的用户名和密码，数据库就被攻破了
	 *        
	 */
	
	public static void main(String[] args) throws Exception {
		//演示sql注入，创建了一个表，里面存有一个tom 密码 123
		Scanner scanner =new Scanner(System.in);
		
		System.out.print("请输入用户名:");
		String user=scanner.nextLine();
		System.out.print("请输入密码:");
		String password =scanner.nextLine();
		
		//开始建立连接
		Properties properties=new Properties();
		properties.load(new FileInputStream("src\\mysql.properties"));
		String user2=properties.getProperty("user");
		String password2=properties.getProperty("password");
		String driver=properties.getProperty("driver");
		String url=properties.getProperty("url");
		
		Class.forName(driver);
		Connection connect =DriverManager.getConnection(url,user2,password2);

		//获取statement
		Statement statement=connect.createStatement();
		//写sql语句
		//sql语句加参数，''单引号别漏了，老漏了出问题，然后就是反引号``下次先在navicate里写一遍在抄过来
		String sql="select * from `admin` where `user`= '"
		                     +user+"' and `password`= '"+password+"'";
		//执行
		ResultSet resultSet=statement.executeQuery(sql);
		if(resultSet.next()) {
			System.out.println(resultSet.getString(1)+"\t"+resultSet.getString(2));
		}else {
			System.out.println("该用户不存在");
		}
		/*
		 * 请输入用户名:1' or
           请输入密码: or '1'='1---》就成了万能密码
            tom	123
            sql注入发生了
            Statement是不安全的

		 */
		//关闭连接
		resultSet.close();
		statement.close();
		connect.close();
	}
	
	
}
