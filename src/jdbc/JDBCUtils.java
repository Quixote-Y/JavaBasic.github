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

//��jdbc�Ĳ����е� ��ȡ���� ���ͷ���Դ ��װ��������JDBCutils������
//�����ֻ��дsql���룬Ȼ����ù�����Ϳ��ԣ��ͺܷ���
public class JDBCUtils {

	// ������ص�4�����ԣ���Ϊֻ��Ҫһ�ݣ�static
	static String username;
	static String password;
	static String driver;
	static String url;

	// ��̬�������ȥ��ʼ������
	static {
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("src\\mysql.properties"));
			// ��ȡ�������
			username = properties.getProperty("user");
			password = properties.getProperty("password");
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");

		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			// e.printStackTrace();

			// ��ʵ�ʿ����У����� �����쳣תΪ����ʱ�쳣 ������
			// �����߿���ѡ�򲶻��쳣��Ҳ����ѡ��Ĭ�ϴ����쳣���Զ������׳�
			throw new RuntimeException(e);
		}
	}

	// �������ݿ� ������Connection
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			// e.printStackTrace();

			// ��ʵ�ʿ����У����� �����쳣תΪ����ʱ�쳣 ������
			// �����߿���ѡ�򲶻��쳣��Ҳ����ѡ��Ĭ�ϴ����쳣���Զ������׳�
			throw new RuntimeException(e);
		}
	}

	// �Ͽ�����
	/**
	 * 
	 * @param set       �����
	 * @param statement Statement ���� PreparedStatement
	 *                  ����ΪpreparedStatement�ӿڼ̳�Statement�ӿ�
	 * @param connectin ���Ӷ���
	 */
	public static void close(ResultSet set, Statement statement, Connection connection) {

		//�жϴ���ֵ�Ǹ���Ϊnull���Ͱ����ÿ�
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
