package jdbc;
//���ݿ����ӳأ�C3P0 Ӧ��

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/* 1. ֱ�ӽ���java�������ݿ���ںܴ�����������ȣ����ݿ���Գ��ص����������ޣ�������������һ��
 *     ����ʱ���ͻᷢ���쳣 COnnection too much ������֮�� ֱ���������ݿ� �ٶ��� ��Ч�ʵ�
 * 2. �������ݿ����ӳض� java�����ݿ��Connection���Ӷ��� ���й��� �������ӳ��з���һ��������Connnection
 *     ���󣬵��� ������Ҫ ��ȡ����ʱ ��ֱ�Ӵ����е����ݿ����ӳ����� ������ʱ �ͷ����ã������ӷŻس���
 * 3. ���ݿ����ӳظ��� ���� ���� �ͷ� ���ݿ����� ������Ӧ�ó����ظ�ʹ��һ�����е����ݿ����� ���������´���һ��
 *     �� Ӧ�ó��������ݿ����ӳ���������������������ֵʱ����Щ���󱻷���ȴ����� 
 * 
 * 
 */
/*  1.���ݿ����ӳ� ��java�ṩ��һ���ӿ� javax.sql.DateSource  ,���ݿ⳧����Ҫʵ������ӿ� ����ʹ���ݿ�֧�� ���ݿ����ӳ� ����
 * 
 *  2.���ݿ����ӳص����ࣺ
 *       C3P0: �ȶ���
 *       Druid :��³�� �����ṩ�����ݿ����ӳ� ���������
 *       
 *  3. ��˾���JDBCһ���ģ���Ҫʹ�����ݿ����ӳع��ܱ��� ���� ��Ӧ�� jar�� ��������ӹ���
 *  
 */
/*������һ���޷�������jar����Դ�����⣺
 *      ������������ԭ���ǣ�����Ȼ������.jar������
 *      û�����ö�Ӧ��Javadoc��Դ��·����
 *      �����ڱ༭�����޷��鿴Դ ��Ͷ�ӦAPI��
 * 
 *����ʹ��jad���������ʵ�ְ�class�ļ�ת��Ϊjava�ļ��鿴����������һЩ�鷳����װ�������jad�������Ч�������޷��鿴class
 *
 */
public class C3P0_DataSource {

	@Test
	public void C3P0Test() throws SQLException {
		// C3P0��ʹ��
		// 1.����Ҫ���� C3P0.jar�� ��������JDBCһ��
		// 2.��ʹ��C3P0���׵������ļ��� ʵ�� ���ݿ����ӳش����ͺ���,
		// ����Ӧ�ļ�����srcĿ¼�£��޸�����Ĳ���
		// ����---����Ҫ���� c3p0�����ĵ�����д��������
		ComboPooledDataSource yyf_DataSource = new ComboPooledDataSource("yyf");
		//�������� ���ݿ����ӳ� �����ݿ��Ѿ�������������
		
		System.out.println("start");
		long start=System.currentTimeMillis();
		for (int i = 0; i < 5000; i++) {
			Connection connection = yyf_DataSource.getConnection();
			//
			connection.close();
		}
		long end = System.currentTimeMillis();
		System.out.println("���ݿ����ӳ�C3P05000�����Ӻ�ʱ��"+(end-start));
		//���ݿ����ӳ�C3P05000�����Ӻ�ʱ��896  ms
	}
}
