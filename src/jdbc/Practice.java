package jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Practice {

	public static void main(String[] args) throws Exception {

		String path = "src\\mysql.properties";
		Properties properties = new Properties();
		properties.load(new FileInputStream(path));
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");

		Class.forName(driver);
		// ��ȡ����
		Connection connect = DriverManager.getConnection(url,user,password);
		// ��ȡPreparedStatementǰ��дsql
//      //�������10��
//		String sql_add = "insert into `admin` values (?,?)";
//
//		PreparedStatement preparedStatement = connect.prepareStatement(sql_add);
//		for (int i=0;i<10;i++) {
//			preparedStatement.setString(1 , "JACK" + i);
//			preparedStatement.setString(2 , "123");
//			// ��ӵ�sql����
//			preparedStatement.addBatch();
//			if (i == 9) {
//				int[] res = preparedStatement.executeBatch();
//				for (int m = 0; m < res.length; m++) {
//					if (res[m] == 0) {
//						System.out.println("��"+m+"��Ԫ�����ʧ�ܣ�");
//					}
//				}
//				break;
//			}
//		}
//      //�޸�����
//		String sql_update="alter table `admin` change `user` king varchar(32)";
//		PreparedStatement preparedStatement = connect.prepareStatement(sql_update);
//		int res=preparedStatement.executeUpdate();
//		//�ر�
//		preparedStatement.close();
//		connect.close();
//		
		//ɾ��Ԫ��
//		String sql_delete="delete from `admin` where king = 'JACK0'";
//		PreparedStatement preparedStatement = connect.prepareStatement(sql_delete);
//		int res=preparedStatement.executeUpdate();
		
		//��ѯȫ����¼
		String sql_select="select * from `admin` ";
		PreparedStatement preparedStatement = connect.prepareStatement(sql_select);
		 ResultSet res=preparedStatement.executeQuery();
		 while(res.next()) {
			 System.out.println(res.getString(1)+"\t"+res.getString(2));
		 }
		
		
		//�ر�
		preparedStatement.close();
		connect.close();
		
		
		
		
	}
}
