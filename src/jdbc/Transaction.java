package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

//������java�е�ʹ��
public class Transaction {

	public void transaction01() {
		// 1,�õ�����
		Connection connect = null;
		// ������ΪgetConnectionҲ���׳�һ������ʱ�쳣���Ͱ����ŵ�try����ȥ�����쳣��һ�𲶻���
		// 2.����sql
		String sql_update = "update account set account=account-100 where id=1";
		String sql_update2 = "update account set account=account+100 where id=2";
		PreparedStatement preparedStatement = null;
		try {
			connect = JDBCUtils.getConnection();
			preparedStatement = connect.prepareStatement(sql_update);
			// ִ��
			preparedStatement.executeUpdate();

			// ��������쳣���ڶ���д��ʧ��
			int res = 1 / 0;

			// �ڶ���sql
			preparedStatement = connect.prepareStatement(sql_update2);
			// ִ��
			preparedStatement.executeUpdate();

			// �����ݿⷢ�֣���һ��sql��䱻ִ���ˣ�1���˻����޸ģ���2ÿ���ӣ�100��ʧ�����ǲ������
			// ����������Ϊһ������
			// connectionĬ�ϵ��ύ��ʽΪ ��ִ��һ��sql�����ύһ���������ǿ��Թر����ѡ��ֶ��ύ����

		} catch (Exception e) {
			// ���쳣������������쵽����ʱ�쳣
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} finally {
			// �ر���Դ
			JDBCUtils.close(null, preparedStatement, connect);
		}
	}

	@Test
	public void Transaction02() {
		// 1,�õ�����
		Connection connect = null;
		// ������ΪgetConnectionҲ���׳�һ������ʱ�쳣���Ͱ����ŵ�try����ȥ�����쳣��һ�𲶻���
		// 2.����sql
		String sql_update = "update account set account=account-100 where id=1";
		String sql_update2 = "update account set account=account+100 where id=2";
		PreparedStatement preparedStatement = null;
		try {
			connect = JDBCUtils.getConnection();
			//�ر���������Ĭ���ύ��ʽ
			connect.setAutoCommit(false);//Ҳ���൱�ڿ�����һ������
			
			preparedStatement = connect.prepareStatement(sql_update);
			// ִ��
			preparedStatement.executeUpdate();

			// ��������쳣���ڶ���д��ʧ��
			int res = 1 / 0;

			// �ڶ���sql
			preparedStatement = connect.prepareStatement(sql_update2);
			// ִ��
			preparedStatement.executeUpdate();

			//�ύ����ŵ�����sql���ִ�н�����λ��
			connect.commit();
			
			
		} catch (Exception e) {
			//������ع��ŵ��������������쳣���ͻع�����
			try {
				connect.rollback();
			} catch (SQLException e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
			//�����Ͳ���д���һ�������
			
			// ���쳣������������쵽����ʱ�쳣
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} finally {
			// �ر���Դ
			JDBCUtils.close(null, preparedStatement, connect);
		}
	}
}
