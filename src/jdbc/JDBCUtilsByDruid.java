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

//����Druid���ݿ����ӳص�jdbc������
public class JDBCUtilsByDruid {

	// DataSource�����ϲ�����ݿ����ӳؽӿ�
	private static DataSource ds;

	// �ھ�̬��������ds��ʼ��
	static {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("src\\druid.properties"));
			ds = DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

	// ��дgeConnection����
	public static Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			throw new RuntimeException(e);
		}
	}

	// �ر����ӣ����ݿ����ӳ��е����Ӻ�ֱ�ӵ���DriverManager��ȡ�����Ӳ�ͬ��һ���Ǻ����ݿ����ӳص����ӣ�һ���Ǻ�mysql���ݿ������
	// ���� �رյ�����Ҳ��Ȼ��ͬ��һ��ֻ�ǶϿ������ݿ����ӳص�����
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
