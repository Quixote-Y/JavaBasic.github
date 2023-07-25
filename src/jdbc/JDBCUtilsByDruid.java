package jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

//基于Druid数据库连接池的jdbc工具类
public class JDBCUtilsByDruid {

	// DataSource，最上层的数据库连接池接口
	private static DataSource ds;

	// 在静态代码块完成ds初始化
	static {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("src\\druid.properties"));
			ds = DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	// 编写geConnection方法
	public static Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			throw new RuntimeException(e);
		}
	}

	// 关闭连接，数据库连接池中的连接和直接调用DriverManager获取的连接不同，一个是和数据库连接池的连接，一个是和mysql数据库的连接
	// 所以 关闭的连接也自然不同，一个只是断开和数据库连接池的连接
	public static void close(ResultSet resultSet, Statement statement, Connection connection) {
		try {
			if (resultSet != null) {
				resultSet.close();
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
