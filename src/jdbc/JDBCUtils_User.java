package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//���ʹ��JDBCUtils
public class JDBCUtils_User {

	public static void main(String[] args) {
		//sql_Dml();

		sql_Select();
	}

	// DML
	public static void sql_Dml() {
		// 1,�õ�����
		Connection connect = null;
		// ������ΪgetConnectionҲ���׳�һ������ʱ�쳣���Ͱ����ŵ�try����ȥ�����쳣��һ�𲶻���
		// 2.����sql
		String sql_add = "insert into `admin` values (?,?)";
		PreparedStatement preparedStatement = null;
		try {
			connect = JDBCUtils.getConnection();
			preparedStatement = connect.prepareStatement(sql_add);
			// ��ռλ����ֵ
			preparedStatement.setString(1, "TOM");
			preparedStatement.setString(2, "123");
			// ִ��
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			//���쳣������������쵽����ʱ�쳣
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} finally {
			// �ر���Դ
			JDBCUtils.close(null, preparedStatement, connect);
		}
	}
	
	//Select
	public static void sql_Select() {
		//1.��ȡ����
		Connection connect=null;
		//2.����sql
		String sql_Select= "select * from `admin` where king like ? ";
		PreparedStatement preparedStatement=null;
		try {
			
			connect=JDBCUtils.getConnection();
			preparedStatement = connect.prepareStatement(sql_Select);
		    
			preparedStatement.setString(1, "J%");
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getString(1)+"\t"+resultSet.getString(2));
			}
		
		
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			JDBCUtils.close(null, preparedStatement, connect);
		}
		
		
		
	}
}
