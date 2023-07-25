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

//总结了mysql通过jdbc连接java的5种方式
public class JdbcConn {

	public static void main(String[] args) {

	}

	@Test
	public  void connect01() throws SQLException {
		// 方式1
		//这种方式直接创建一个driver对象，driver是驱动，他是导入的包，这样创建容易发生编译错误
		Driver driver = new Driver();
		String url = "jdbc:mysql://localhost:3306/yyf_db01";
		// 将用户名 密码放到Properties对象里
		Properties properties = new Properties();
		// 这就是连接数据库的用户和密码
		properties.put("user", "root");
		properties.put("password", "1234");
		// 建立连接
		Connection connect = driver.connect(url, properties);
		System.out.println(connect);
		// com.mysql.cj.jdbc.ConnectionImpl@387a8303连接成功
	}
	//方式2，使用反射机制，类加载
	@Test
	public void connect02() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		//使用反射加载Driver类，动态加载，减少编译时错误，更加灵活
		Class<?> aclass =Class.forName("com.mysql.cj.jdbc.Driver");
		Driver driver=(Driver) aclass.newInstance();
		
		String url="jdbc:mysql://localhost:3306/yyf_db01";
		Properties properties =new Properties();
		properties.setProperty("user", "root");
		properties.setProperty("password", "1234");
		Connection connect=driver.connect(url, properties);
		System.out.println(connect);
		//也拿到了
	}
	
	//方式3 使用DriverManager对driver对象统一管理 
	@Test
	public void connect03() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		Class<?> aclass=Class.forName("com.mysql.cj.jdbc.Driver");
		Driver driver=(Driver) aclass.newInstance();
		
		//创建url和user和password
		String url="jdbc:mysql://localhost:3306/yyf_db01";
		String user="root";
		String password="1234";
		
		//创建DriverManager注册驱动
		DriverManager.registerDriver(driver);
		
		Connection connect=DriverManager.getConnection(url,user,password);
		System.out.println(connect);
	}
	
	//方式4，使用class.forName自动完成驱动注册，简化3的代码
	@Test
	public void connect04() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		/*
		 *关于这里为什么不用注册DriverManger驱动：
		 *     因为在Driver这个类里有汇编写的静态方法块，里面初始化
		 *     注册了DriverManager  
		 *DriverManager.registerDriver(new Driver());
		 *      所以方式3内样就显得多余了
		 */
		//创建url，user，password
		String url="jdbc:mysql://localhost:3306/yyf_db01";
		String user="root";
		String password="1234";
		Connection connect=DriverManager.getConnection(url, user, password);
		
		System.out.println(connect);
	}
	
	/*上面的反射相关的方式中，都先进行了显式的反射声明
	 *  Class.forName() 
	 *  其实在驱动版本5.7.1之后都可以不写这条语句，因为在驱动jar包里有一个
	 *  文件：META-INF\\services\\java.sql.Driver
	 *  当我们启动驱动时，程序会自动创建 com.mysql.cj.jdbc.Driver，完成注册 
	 *  因此可以不用我们去显式定义
	 *  但写上肯定还是没问题的，更加明确
	 */
	
	
	//5.使用配置文件，是连接mysql更加灵活
	@Test
	public void connect05() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		//先获取properties文件信息
		Properties properties=new Properties();
		properties.load(new FileInputStream("src\\mysql.properties"));
		
		//获取信息
		String user=properties.getProperty("user");
		String password=properties.getProperty("password");
		String driver=properties.getProperty("driver");
		String url=properties.getProperty("url");
		//这里也添加一个driver可以方便后期更改驱动
		//还是显式创建一下类对象更好
		Class.forName(driver);
		//获取连接
		Connection connect=DriverManager.getConnection(url,user,password);
		System.out.println(connect);	
	}
	//这样就更加灵活了
}
