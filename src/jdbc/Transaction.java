package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

//事务在java中的使用
public class Transaction {

	public void transaction01() {
		// 1,得到链接
		Connection connect = null;
		// 这里因为getConnection也会抛出一个运行时异常，就把他放到try块里去，有异常就一起捕获了
		// 2.导入sql
		String sql_update = "update account set account=account-100 where id=1";
		String sql_update2 = "update account set account=account+100 where id=2";
		PreparedStatement preparedStatement = null;
		try {
			connect = JDBCUtils.getConnection();
			preparedStatement = connect.prepareStatement(sql_update);
			// 执行
			preparedStatement.executeUpdate();

			// 如果出现异常，第二条写入失败
			int res = 1 / 0;

			// 第二条sql
			preparedStatement = connect.prepareStatement(sql_update2);
			// 执行
			preparedStatement.executeUpdate();

			// 打开数据库发现，第一条sql语句被执行了，1的账户金额被修改，但2每增加，100消失，这是不允许的
			// 他们两必须为一个事务，
			// connection默认的提交方式为 ：执行一句sql语句就提交一个事务，我们可以关闭这个选项，手动提交事务

		} catch (Exception e) {
			// 把异常级别扩大，能侦察到运行时异常
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			// 关闭资源
			JDBCUtils.close(null, preparedStatement, connect);
		}
	}

	@Test
	public void Transaction02() {
		// 1,得到链接
		Connection connect = null;
		// 这里因为getConnection也会抛出一个运行时异常，就把他放到try块里去，有异常就一起捕获了
		// 2.导入sql
		String sql_update = "update account set account=account-100 where id=1";
		String sql_update2 = "update account set account=account+100 where id=2";
		PreparedStatement preparedStatement = null;
		try {
			connect = JDBCUtils.getConnection();
			//关闭连接事务默认提交方式
			connect.setAutoCommit(false);//也就相当于开启了一个事务
			
			preparedStatement = connect.prepareStatement(sql_update);
			// 执行
			preparedStatement.executeUpdate();

			// 如果出现异常，第二条写入失败
			int res = 1 / 0;

			// 第二条sql
			preparedStatement = connect.prepareStatement(sql_update2);
			// 执行
			preparedStatement.executeUpdate();

			//提交事务放到所有sql语句执行结束的位置
			connect.commit();
			
			
		} catch (Exception e) {
			//把事务回滚放到这来，当出现异常，就回滚事务、
			try {
				connect.rollback();
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			//这样就不会写入第一条语句了
			
			// 把异常级别扩大，能侦察到运行时异常
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			// 关闭资源
			JDBCUtils.close(null, preparedStatement, connect);
		}
	}
}
