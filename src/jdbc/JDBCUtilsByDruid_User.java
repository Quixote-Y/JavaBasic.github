package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

public class JDBCUtilsByDruid_User {

	public static void main(String[] args) {
		Connection connection = null;

		String sql = "select * from `admin` where king like ?";
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = JDBCUtilsByDruid.getConnection();
			System.out.println(connection.getClass());
			// class com.alibaba.druid.pool.DruidPooledConnection
			// 这里connection的运行类型是这个Druid数据库连接池的Connection
			// 而 之前直接连接Mysql的Connection 运行时类型是 com.mysql.jdbc.JDBC4Connection
			// 他们都实现了java的Connection接口，但实现方式不同，close这个函数的效果也就不同
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "jack_101");

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2));
			}

		} catch (Exception e) {
			// TODO: handle exception

		} finally {
			JDBCUtilsByDruid.close(resultSet, preparedStatement, connection);
		}
	}
	
	//上面的方式还存在一些瑕疵
	//1.因为ResultSet结果集和Connection关联，当我们关闭Connection之后，ResultSet就不能继续使用，
	//  这使得当我们想利用返回值来进行长时间的操作，就不能关闭连接，造成浪费
	//2.通过ResultSet获取返回值的结果的操作显得不是很人性化
	//3.灵活性不高
	//  考虑采用一个集合ArrayList《admin》这样的一个集合，创建一个类 admin，他的属性是数据库里的admin表
	//   的结构映射，这样就可以把我们ResultSet的值转换为具体的java对象，存储进行操作
	//@Test
	//Junit框架不能有返回值，有返回值会没输出
	public List testSelectToArrayList() {
		System.out.println("使用Druid方式完成");
		 Connection connection=null;
		 
		 String sql="select * from `admin` where king like ?";
		 PreparedStatement preparedStatement=null;
		 ResultSet resultSet=null;
		 //创建一个ArrayList《Admin》
		 ArrayList<Admin> list = new ArrayList<>();
		 try {
			connection = JDBCUtilsByDruid.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "jack_010");
		    resultSet = preparedStatement.executeQuery();
		    while(resultSet.next()) {
		    	String king =resultSet.getString(1);
		    	String password = resultSet.getString(2);
		    	//创建一个Admin对象，把他加到List里
		    	list.add(new Admin(king,password));
		    }
		    //这样所有的查询返回值都被转存到List中，然后我们就可以对List进行操作，灵活性就更高了
		    System.out.println(list);
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			JDBCUtilsByDruid.close(resultSet, preparedStatement, connection);
		}
		 return list;
	}
	
	//上面的方法依旧存在可改进的地方， 我们把从数据库的出来的ResultSet转存到ArrayList这个过程，无论在什么样
	//的执行程序中都不会发生变化，那为什么不把它封装到一个函数里，这样之后就不用每次都去写这一大串代码了
	//      Apache的工具类 DBUtils 就帮我们实现了这个功能
	//@Test
	public void testQuerMany() throws SQLException {//返回值是多行的情况
		//1.得到链接
		Connection connection =JDBCUtilsByDruid.getConnection();
		//2.使用DBUtils 类和接口 ，先引入相应的jar包
		//3.创建一个QuerRunner
		QueryRunner queryRunner = new QueryRunner();
		//执行相应操作，返回ArrayList结果集
		String sql="select * from `admin` where king like ?";
		
		// (1) queryRunner.query() 执行sql语句 ，得到 ResultSet结果集 ---》分装到 ArrayList集合里
		// (2) 返回的是一个集合
		// (3) connection 连接
		// (4) sql  :执行的sql语句
		// (5) new BeanListhandler<>(Admin.class) : 将ResultSet中的结果取出 转换为--》Admin对象
		//       ————》封装到ArrayList里去 ，底层使用的是反射机制 ，获取Admin类的属性，然后封装
		// (6) 在后面的参数就是sql语句中占位符的值 ，可变参数
		// (7) 底层创建的ResultSet ，会在 query里面关闭 ，
		
		/*
		* 分析 queryRunner.query 方法:
		* public <T> T query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params) throws
		SQLException {
		* PreparedStatement stmt = null;//定义 PreparedStatement
		* ResultSet rs = null;//接收返回的 ResultSet
		* Object result = null;//返回 ArrayList
		*
		* try {
		* stmt = this.prepareStatement(conn, sql);//创建 PreparedStatement
		* this.fillStatement(stmt, params);//对 sql 进行 ? 赋值
		* rs = this.wrap(stmt.executeQuery());//执行 sql,返回 resultset
		* result = rsh.handle(rs);//返回的 resultset --> arrayList[result] [使用到反射，对传入 class 对象
		处理]
		* } catch (SQLException var33) {
		* this.rethrow(var33, sql, params);
		* } finally {
		* try {
		* this.close(rs);//关闭 resultset
		* } finally {
		* this.close((Statement)stmt);//关闭 preparedstatement 对象
		* }
		* }
		*
		* return result;
		* }
		*/
		

		//BeanHandler<T>() 把结果集中的第一行数据封装到对应的javaBean实例中
		//BeanListHandler<T>() 将结果集中的每一行数据都封装到对应的javaBean实列中
		List<Admin> list=queryRunner.query(connection, sql,new BeanListHandler<>(Admin.class), "jack_010");
		System.out.println("输出集合信息");
		for (Admin admin : list) {
			System.out.println(admin);
		}
		//释放资源
		JDBCUtilsByDruid.close(null, null, connection);	
	}
	
	//apache - dbutils -druid 完成 返回结果是单行的情况
	//@Test
	public void tsetQuerySingle() throws SQLException {
		Connection connection = JDBCUtilsByDruid.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		String sql = "select * from `admin` where king like ?";
		//BeanHandler<T>() 把结果集中的第一行数据封装到对应的javaBean实例中
		//返回的就是一个Admin对象，而不是BeanListHandler的一个List数组
		Admin admin = queryRunner.query(connection, sql, new BeanHandler<>(Admin.class), "jack0");
		System.out.println(admin);
		JDBCUtilsByDruid.close(null, null, connection);
	}
	
	//apache dbutils druid 完成 查询结果是单行单列 - 返回的就是一个Object
	//@Test
	public void testScalar() throws SQLException {
		Connection connection = JDBCUtilsByDruid.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		//返回的就是一个Object对象
		String sql = "select password from `admin` where king = ?";
		//ScalarHandler() 返回的是单行单列
		Object obj = queryRunner.query(connection, sql, new ScalarHandler(), "jack0");
		System.out.println(obj);
		
		JDBCUtilsByDruid.close(null, null, connection);
		
	}
	//apache - dbutils - druid 完成 增删改 dml 操作
	//@Test
	public void testDml() throws SQLException {
		Connection connection = JDBCUtilsByDruid.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		String sql_update = "update `admin` set `password`='9999' where king = 'jack0'";
		//queryRunner 执行dml的 操作是 queryRunner.update()
		//返回值依旧是受影响的行数
		int affectedRow = queryRunner.update(connection, sql_update, null);
		System.out.println(affectedRow>0?"更新执行成功":"没有影响到表");
		String sql_delete = "delete from `admin` where king = 'jack0'";
		
		String sql_select = "select * from `admin` where king = 'jack0'";
		Object admin = queryRunner.query(connection, sql_select, new BeanHandler<Admin>(Admin.class));
		System.out.println("更改后表中jack0的密码是："+admin);
		
		int affectedRow2 = queryRunner.update(connection, sql_delete, null);
		System.out.println(affectedRow2>0?"删除执行成功":"没有影响到表");
		
//		String sql_insert = "insert into `admin` values('杰克范马','213')";
//		int affectedRow3  = queryRunner.update(connection, sql_insert, null);
//		System.out.println(affectedRow3>0?"添加成功":"添加失败");
		
		String sql_select2 = "select * from `admin` where king = ?";
		Admin admin2 = queryRunner.query(connection, sql_select2, new BeanHandler<>(Admin.class),"杰克范马");
		System.out.println("杰克范马："+admin2);
		
		
		
		JDBCUtilsByDruid.close(null, null, connection);
		
	}
	
	
}
