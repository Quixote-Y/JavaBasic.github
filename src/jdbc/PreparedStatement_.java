package jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

//PreparedStatement 接口用法
public class PreparedStatement_ {

	public static void main(String[] args) throws Exception {
		//Statement因为传入参数的时候需要手动添加' ,出现sql注入问题，且传入参数麻烦，易出错
		//因此提出了PreparedStatement接口，他是Statement的子接口，提供更多的方法，最关键的是占位符
		
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

		//sql语句
		//？就是占空符
		//这里就能看出占空符的优越性了，使用占空符，不用像statement一样因为传入参数导致语句是否混乱复杂，且易出错
		String sql="select * from `admin` where `user`=? and `password`=?";

		PreparedStatement preparedStatement=connect.prepareStatement(sql);
				//获取PreparedStatement,通过链接获取PreparedStatement必须要传入一个sql语句

		//创建PreparedStatement成功后要给占空符传入值
		//用set方法
		preparedStatement.setString(1, user);//第一个问号传入值为 user
		preparedStatement.setString(2, password);//第二个问号
		
		
		//执行
		//执行时： 查询语句用 executeQuery() ,返回值为 ResultSet 
		//         增删改语句 用 executeUpdate() ，返回值为 int ，表示语句影响了几行，返回0表示失败
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet.next()) {
			System.out.println(resultSet.getString(1)+"\t"+resultSet.getString(2));
		}else {
			System.out.println("该用户不存在");
		}
		/*
             请输入用户名:1' or
             请输入密码:or '1'='1
              该用户不存在
            sql注入解决了，原理还不清楚，具体得看占空符的传值机制如何
		 */
		//关闭连接
		resultSet.close();
		preparedStatement.close();
		connect.close();
	}
}
/*PreparedStament 比较Statement的区别：
 * 1.PreparedStatement 是Statement 的子接口
   2.代码的可读性和可维护性
   3.PreparedStatement 能最大可能提高性能：
   4.DBServer会对预编译语句提供性能优化。因为预编译语句有可能被重复调用，所以语句在被DBServer的编译器编译后的执行代码被缓存下来，那么下次调用时只要是相同的预编译语句就不需要编译，只要将参数直接传入编译过的语句执行代码中就会得到执行。
     在statement语句中,即使是相同操作但因为数据内容不一样,所以整个语句本身不能匹配,没有缓存语句的意义.事实是没有数据库会对普通语句编译后的执行代码缓存。这样每执行一次都要对传入的语句编译一次。
     (语法检查，语义检查，翻译成二进制命令，缓存)
   5.PreparedStatement 可以防止 SQL 注入
*/
