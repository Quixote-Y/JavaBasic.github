package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;


//jdbc第一个程序
public class JdbcTest01 {

	public static void main(String[] args) {
		//首先，jdbc是java规定给数据库的统一接口，数据库厂商实现接口，java程序员
		//调用接口实现来完成对数据库的操作，为了能操纵mysql数据库，必须先导入mysql
		//的jdbc实现类这个包，我使用的是：mysql-connector-j-8.0.31.jar，
		//采用的方法是：在项目目录下创建一个文件夹，然后把下载的mysql实现类拉进来，
		//然后点击 ：构建路径-构建配置路径  这样就引入了
		//这个实现类 也就是 mysql的 驱动
		
		try {
			//1.注册驱动
			  //第一个错误：导入的包一定是：import com.mysql.cj.jdbc.Driver;不然报错
			Driver driver =new Driver();
            
			
			//2.得到链接
			/*参数详解：
			 *       jdbc.mysql:// 规定号表示的协议，通过jdbc的方式连接mysql
			 *       localhost   主机，也可以是ip地址
			 *       3306        mysql的监听端口
			 *       yyf_db01    连接到mysql 数据管理系统的那个数据库
			 *  本质就是socket连接
			 * 
			 */
			//别打错字母
			String url="jdbc:mysql://localhost:3306/yyf_db01";
			//将用户名 密码放到Properties对象里
			Properties properties =new Properties();
			
			//这就是连接数据库的用户和密码
			properties.put("user", "root");
			properties.put("password", "1234");
			//建立连接
			Connection connect =driver.connect(url, properties);
			
			//3.执行sql
			String sql="insert into jdbcTest_db values (null,'张三','男','30')";
			//使用statement用于执行静态sql语句并返回其生成的结果对象
			Statement statement =connect.createStatement();
			//如果是dml（增删改）语句，返回的就是影响行数
			int rows =statement.executeUpdate(sql);
			
			System.out.println(rows>0?"成功":"失败");
			
			//4.关闭资源
			statement.close();
			connect.close();
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("登录mysql失败");
		}
		
	}
}
