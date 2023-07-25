package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

//批处理一次性处理多条sql语句，大大提高效率
public class Batch_ {

	// 无批处理机制
	public void CustomerWay() {
		Connection connect = null;

		String sql = "insert into `admin` values(?,?)";
		PreparedStatement preparedStatement = null;
		try {
			connect = JDBCUtils.getConnection();
			preparedStatement = connect.prepareStatement(sql);
			System.out.println("start");
			long start = System.currentTimeMillis();

			for (int i = 0; i < 5000; i++) {
				preparedStatement.setString(1, "jack" + i);
				preparedStatement.setString(2, "666");
				preparedStatement.executeUpdate();
			}
			long end = System.currentTimeMillis();
			System.out.println("常规输入方法费时：" + (end - start));
			// 常规输入方法费时：5812

		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		JDBCUtils.close(null, preparedStatement, connect);

	}

	@Test
	// 用批处理机制
	public void BatchWay() {
		// !!!! 首先，想用批处理机制 ，必须在配置文件的url里加上声明
		// ?rewriteBatchedStatements=true

		Connection connect = null;

		String sql = "insert into `admin` values(?,?)";
		PreparedStatement preparedStatement = null;
		try {
			connect = JDBCUtils.getConnection();
			preparedStatement = connect.prepareStatement(sql);
			System.out.println("start");
			long start = System.currentTimeMillis();

			for (int i = 0; i < 5000; i++) {
				preparedStatement.setString(1, "jack" + i);
				preparedStatement.setString(2, "666");
				preparedStatement.addBatch();
				// 当池中放了1000条后执行
				if (i % 1000 == 0) {
					preparedStatement.executeBatch();
					//清除池
					preparedStatement.clearBatch();
				}
			}
			long end = System.currentTimeMillis();
			System.out.println("批处理输入方法费时：" + (end - start));
			//批处理输入方法费时：98  ，效率飞跃

		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		JDBCUtils.close(null, preparedStatement, connect);

		
	}

}
/*
 * preparedStatement 在调用 addBatch方法后 ：
 * 
 *         底层是一个 ArrayList集合，第一次添加会创建，初始化集合，然后之后每次
 *         添加都核对sql语句参数正确与否，然后把sql语句加到集合里
 *   
 */
