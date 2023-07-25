package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//如何使用JDBCUtils
public class JDBCUtils_User {

	public static void main(String[] args) {
		//sql_Dml();

		sql_Select();
	}

	// DML
	public static void sql_Dml() {
		// 1,得到链接
		Connection connect = null;
		// 这里因为getConnection也会抛出一个运行时异常，就把他放到try块里去，有异常就一起捕获了
		// 2.导入sql
		String sql_add = "insert into `admin` values (?,?)";
		PreparedStatement preparedStatement = null;
		try {
			connect = JDBCUtils.getConnection();
			preparedStatement = connect.prepareStatement(sql_add);
			// 给占位符赋值
			preparedStatement.setString(1, "TOM");
			preparedStatement.setString(2, "123");
			// 执行
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			//把异常级别扩大，能侦察到运行时异常
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			// 关闭资源
			JDBCUtils.close(null, preparedStatement, connect);
		}
	}
	
	//Select
	public static void sql_Select() {
		//1.获取连接
		Connection connect=null;
		//2.导入sql
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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			JDBCUtils.close(null, preparedStatement, connect);
		}
		
		
		
	}
}
