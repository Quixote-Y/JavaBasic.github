package dao_.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import jdbc.JDBCUtilsByDruid;

/*ʹ��dao�������ںΣ�
 *    ����jdbc�����sql������ʮ�ֽ�Ӳ��ÿһ��sql��䶼����Ҫȥ�����ĵ���һ��query������
 *       ��ÿһ�ű�Ĳ�������ҵ���߼�����ʱ�Եò���� ��һ��ʹ���� Dao ������ҵ���߼�
 *       ����ÿһ�ű� �����Ƕ�������д��Ӧ�� Daoȥʵ�ֶ����ű����ɾ�Ĳ飬ͨ������������sql��䣬
 *       ��ͬ���͵�sql��һ�����������벻ͬ���ݵ�sql��䣬��󽵵��˳�����ظ�������Ҳ����������
 *          
 *     �����BasicDao ���Ϊ���� ר��Dao�ĸ��� ����ʵ������Dao�����õ��Ļ�����ɾ�Ĳ������ר�õ�
 *     ͨ���̳�����Ȼ����չ�ķ�ʽ��ʵ�ֶ����ݿ��ص����ݱ�Ĳ���
 *     ���ٴ�������
 */
public class BasicDao<T> {//����ָ���������ͣ�ָ�����ཫ������ʲô�����͵�JavaBean

	static QueryRunner qr = new QueryRunner();
	
	
	/**ͨ�õ�dml����,��������
	 * ֻҪ�ǵ���qeryRunner.update��sql�����õ�������Ǿ�����ɾ�Ĳ���
	 * @param sql     ����sql�������ݣ�dml�������
	 * @param parameters  ����sql������ռλ�����ڵĲ��� ���ɱ����
	 * @return   �����������ݱ��Ӱ������
	 */
	public int update(String sql,Object...parameters) {
		Connection connection=null;
		try {
			//1.ͨ���������Ȼ�ȡDruid���ݿ����ӳص�����
			connection = JDBCUtilsByDruid.getConnection();
            //ִ��sql������䣬���� 
			 return qr.update(connection, sql, parameters);
		} catch (SQLException e) {
			//�Ϸ������׳�����ʱ�쳣�������߿�ѡ�񲻴��������
			throw new RuntimeException(e);
		}finally {//�ر�
			JDBCUtilsByDruid.close(null, null, connection);
		}
	}
	/**
	 *  ���ض�����󣬲�ѯ����Ƕ��еĲ�ѯ������������ݱ�
	 * @param sql        sql��ѯ���
	 * @param clazz      ���ؽ����Ӧ���Class��Ҳ���ǲ���Ŀ����Ӧ��javaBean�����Class�����������������BeanListHandler���������н���ѯ������������ResultSetת��Ϊ���ж�ӦClss�����Ķ���
	 * @param parameters  �ɱ������ռλ����ֵ
	 * @return
	 */
	public List<T> queryMultiply(String sql,Class<T> clazz ,Object...parameters ){
		Connection connection = null;
		try {
			connection = JDBCUtilsByDruid.getConnection();
			return qr.query(connection, sql, new BeanListHandler<T>(clazz), parameters);
		} catch (SQLException e) {
			//ת���׳�
			throw new RuntimeException(e);
		}finally{
			JDBCUtilsByDruid.close(null, null, connection);
		}
	
	}
	//���ص��в�ѯ���
	public T querySingle(String sql,Class<T> clazz,Object...parameters) {
		Connection connection=null;
		try {
			connection = JDBCUtilsByDruid.getConnection();
			return qr.query(connection, sql, new BeanHandler<T>(clazz), parameters);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			JDBCUtilsByDruid.close(null, null, connection);
		}
		
	}
	//����һ�����󣬲�ѯ���ֻ��һ��һ��
	public Object queryScalar(String sql,Object...paramenters) {
		Connection connection = null;
		try {
			connection = JDBCUtilsByDruid.getConnection();
			return qr.query(connection, sql, new ScalarHandler(), paramenters);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			JDBCUtilsByDruid.close(null, null, connection);
		}
		
	}
	
	
}
