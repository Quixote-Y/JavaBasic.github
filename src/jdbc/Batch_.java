package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

//������һ���Դ������sql��䣬������Ч��
public class Batch_ {

	// �����������
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
			System.out.println("�������뷽����ʱ��" + (end - start));
			// �������뷽����ʱ��5812

		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

		JDBCUtils.close(null, preparedStatement, connect);

	}

	@Test
	// �����������
	public void BatchWay() {
		// !!!! ���ȣ�������������� �������������ļ���url���������
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
				// �����з���1000����ִ��
				if (i % 1000 == 0) {
					preparedStatement.executeBatch();
					//�����
					preparedStatement.clearBatch();
				}
			}
			long end = System.currentTimeMillis();
			System.out.println("���������뷽����ʱ��" + (end - start));
			//���������뷽����ʱ��98  ��Ч�ʷ�Ծ

		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

		JDBCUtils.close(null, preparedStatement, connect);

		
	}

}
/*
 * preparedStatement �ڵ��� addBatch������ ��
 * 
 *         �ײ���һ�� ArrayList���ϣ���һ����ӻᴴ������ʼ�����ϣ�Ȼ��֮��ÿ��
 *         ��Ӷ��˶�sql��������ȷ���Ȼ���sql���ӵ�������
 *   
 */
