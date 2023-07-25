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
			// ����connection���������������Druid���ݿ����ӳص�Connection
			// �� ֮ǰֱ������Mysql��Connection ����ʱ������ com.mysql.jdbc.JDBC4Connection
			// ���Ƕ�ʵ����java��Connection�ӿڣ���ʵ�ַ�ʽ��ͬ��close���������Ч��Ҳ�Ͳ�ͬ
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
	
	//����ķ�ʽ������һЩ覴�
	//1.��ΪResultSet�������Connection�����������ǹر�Connection֮��ResultSet�Ͳ��ܼ���ʹ�ã�
	//  ��ʹ�õ����������÷���ֵ�����г�ʱ��Ĳ������Ͳ��ܹر����ӣ�����˷�
	//2.ͨ��ResultSet��ȡ����ֵ�Ľ���Ĳ����Եò��Ǻ����Ի�
	//3.����Բ���
	//  ���ǲ���һ������ArrayList��admin��������һ�����ϣ�����һ���� admin���������������ݿ����admin��
	//   �Ľṹӳ�䣬�����Ϳ��԰�����ResultSet��ֵת��Ϊ�����java���󣬴洢���в���
	//@Test
	//Junit��ܲ����з���ֵ���з���ֵ��û���
	public List testSelectToArrayList() {
		System.out.println("ʹ��Druid��ʽ���");
		 Connection connection=null;
		 
		 String sql="select * from `admin` where king like ?";
		 PreparedStatement preparedStatement=null;
		 ResultSet resultSet=null;
		 //����һ��ArrayList��Admin��
		 ArrayList<Admin> list = new ArrayList<>();
		 try {
			connection = JDBCUtilsByDruid.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "jack_010");
		    resultSet = preparedStatement.executeQuery();
		    while(resultSet.next()) {
		    	String king =resultSet.getString(1);
		    	String password = resultSet.getString(2);
		    	//����һ��Admin���󣬰����ӵ�List��
		    	list.add(new Admin(king,password));
		    }
		    //�������еĲ�ѯ����ֵ����ת�浽List�У�Ȼ�����ǾͿ��Զ�List���в���������Ծ͸�����
		    System.out.println(list);
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			JDBCUtilsByDruid.close(resultSet, preparedStatement, connection);
		}
		 return list;
	}
	
	//����ķ������ɴ��ڿɸĽ��ĵط��� ���ǰѴ����ݿ�ĳ�����ResultSetת�浽ArrayList������̣�������ʲô��
	//��ִ�г����ж����ᷢ���仯����Ϊʲô��������װ��һ�����������֮��Ͳ���ÿ�ζ�ȥд��һ�󴮴�����
	//      Apache�Ĺ����� DBUtils �Ͱ�����ʵ�����������
	//@Test
	public void testQuerMany() throws SQLException {//����ֵ�Ƕ��е����
		//1.�õ�����
		Connection connection =JDBCUtilsByDruid.getConnection();
		//2.ʹ��DBUtils ��ͽӿ� ����������Ӧ��jar��
		//3.����һ��QuerRunner
		QueryRunner queryRunner = new QueryRunner();
		//ִ����Ӧ����������ArrayList�����
		String sql="select * from `admin` where king like ?";
		
		// (1) queryRunner.query() ִ��sql��� ���õ� ResultSet����� ---����װ�� ArrayList������
		// (2) ���ص���һ������
		// (3) connection ����
		// (4) sql  :ִ�е�sql���
		// (5) new BeanListhandler<>(Admin.class) : ��ResultSet�еĽ��ȡ�� ת��Ϊ--��Admin����
		//       ������������װ��ArrayList��ȥ ���ײ�ʹ�õ��Ƿ������ ����ȡAdmin������ԣ�Ȼ���װ
		// (6) �ں���Ĳ�������sql�����ռλ����ֵ ���ɱ����
		// (7) �ײ㴴����ResultSet ������ query����ر� ��
		
		/*
		* ���� queryRunner.query ����:
		* public <T> T query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params) throws
		SQLException {
		* PreparedStatement stmt = null;//���� PreparedStatement
		* ResultSet rs = null;//���շ��ص� ResultSet
		* Object result = null;//���� ArrayList
		*
		* try {
		* stmt = this.prepareStatement(conn, sql);//���� PreparedStatement
		* this.fillStatement(stmt, params);//�� sql ���� ? ��ֵ
		* rs = this.wrap(stmt.executeQuery());//ִ�� sql,���� resultset
		* result = rsh.handle(rs);//���ص� resultset --> arrayList[result] [ʹ�õ����䣬�Դ��� class ����
		����]
		* } catch (SQLException var33) {
		* this.rethrow(var33, sql, params);
		* } finally {
		* try {
		* this.close(rs);//�ر� resultset
		* } finally {
		* this.close((Statement)stmt);//�ر� preparedstatement ����
		* }
		* }
		*
		* return result;
		* }
		*/
		

		//BeanHandler<T>() �ѽ�����еĵ�һ�����ݷ�װ����Ӧ��javaBeanʵ����
		//BeanListHandler<T>() ��������е�ÿһ�����ݶ���װ����Ӧ��javaBeanʵ����
		List<Admin> list=queryRunner.query(connection, sql,new BeanListHandler<>(Admin.class), "jack_010");
		System.out.println("���������Ϣ");
		for (Admin admin : list) {
			System.out.println(admin);
		}
		//�ͷ���Դ
		JDBCUtilsByDruid.close(null, null, connection);	
	}
	
	//apache - dbutils -druid ��� ���ؽ���ǵ��е����
	//@Test
	public void tsetQuerySingle() throws SQLException {
		Connection connection = JDBCUtilsByDruid.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		String sql = "select * from `admin` where king like ?";
		//BeanHandler<T>() �ѽ�����еĵ�һ�����ݷ�װ����Ӧ��javaBeanʵ����
		//���صľ���һ��Admin���󣬶�����BeanListHandler��һ��List����
		Admin admin = queryRunner.query(connection, sql, new BeanHandler<>(Admin.class), "jack0");
		System.out.println(admin);
		JDBCUtilsByDruid.close(null, null, connection);
	}
	
	//apache dbutils druid ��� ��ѯ����ǵ��е��� - ���صľ���һ��Object
	//@Test
	public void testScalar() throws SQLException {
		Connection connection = JDBCUtilsByDruid.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		//���صľ���һ��Object����
		String sql = "select password from `admin` where king = ?";
		//ScalarHandler() ���ص��ǵ��е���
		Object obj = queryRunner.query(connection, sql, new ScalarHandler(), "jack0");
		System.out.println(obj);
		
		JDBCUtilsByDruid.close(null, null, connection);
		
	}
	//apache - dbutils - druid ��� ��ɾ�� dml ����
	//@Test
	public void testDml() throws SQLException {
		Connection connection = JDBCUtilsByDruid.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		String sql_update = "update `admin` set `password`='9999' where king = 'jack0'";
		//queryRunner ִ��dml�� ������ queryRunner.update()
		//����ֵ��������Ӱ�������
		int affectedRow = queryRunner.update(connection, sql_update, null);
		System.out.println(affectedRow>0?"����ִ�гɹ�":"û��Ӱ�쵽��");
		String sql_delete = "delete from `admin` where king = 'jack0'";
		
		String sql_select = "select * from `admin` where king = 'jack0'";
		Object admin = queryRunner.query(connection, sql_select, new BeanHandler<Admin>(Admin.class));
		System.out.println("���ĺ����jack0�������ǣ�"+admin);
		
		int affectedRow2 = queryRunner.update(connection, sql_delete, null);
		System.out.println(affectedRow2>0?"ɾ��ִ�гɹ�":"û��Ӱ�쵽��");
		
//		String sql_insert = "insert into `admin` values('�ܿ˷���','213')";
//		int affectedRow3  = queryRunner.update(connection, sql_insert, null);
//		System.out.println(affectedRow3>0?"��ӳɹ�":"���ʧ��");
		
		String sql_select2 = "select * from `admin` where king = ?";
		Admin admin2 = queryRunner.query(connection, sql_select2, new BeanHandler<>(Admin.class),"�ܿ˷���");
		System.out.println("�ܿ˷���"+admin2);
		
		
		
		JDBCUtilsByDruid.close(null, null, connection);
		
	}
	
	
}
