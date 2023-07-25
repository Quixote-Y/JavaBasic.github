package jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//将jdbc的操作中的 获取连接 ，释放资源 封装到工具类JDBCutils这个类里，
//别的类只用写sql代码，然后调用工具类就可以，就很方便
public class JDBCUtils {

	// 定义相关的4个属性，因为只需要一份，static
	static String username;
	static String password;
	static String driver;
	static String url;

	// 静态代码块里去初始化他们
	static {
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("src\\mysql.properties"));
			// 读取相关属性
			username = properties.getProperty("user");
			password = properties.getProperty("password");
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");

		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			// e.printStackTrace();

			// 在实际开发中，长把 编译异常转为运行时异常 来处理
			// 调用者可以选则捕获异常，也可以选择默认处理异常，自动向上抛出
			throw new RuntimeException(e);
		}
	}

	// 连接数据库 ，返回Connection
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			// e.printStackTrace();

			// 在实际开发中，长把 编译异常转为运行时异常 来处理
			// 调用者可以选则捕获异常，也可以选择默认处理异常，自动向上抛出
			throw new RuntimeException(e);
		}
	}

	// 断开连接
	/**
	 * 
	 * @param set       结果集
	 * @param statement Statement 或者 PreparedStatement
	 *                  ，因为preparedStatement接口继承Statement接口
	 * @param connectin 连接对象
	 */
	public static void close(ResultSet set, Statement statement, Connection connection) {

		//判断传入值那个不为null，就把他置空
		try {
			if (set != null) {
				set.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			// TODO: handle exception

			throw new RuntimeException(e);
		}
	}
}
