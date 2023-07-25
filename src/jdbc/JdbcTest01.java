package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;


//jdbc��һ������
public class JdbcTest01 {

	public static void main(String[] args) {
		//���ȣ�jdbc��java�涨�����ݿ��ͳһ�ӿڣ����ݿ⳧��ʵ�ֽӿڣ�java����Ա
		//���ýӿ�ʵ������ɶ����ݿ�Ĳ�����Ϊ���ܲ���mysql���ݿ⣬�����ȵ���mysql
		//��jdbcʵ�������������ʹ�õ��ǣ�mysql-connector-j-8.0.31.jar��
		//���õķ����ǣ�����ĿĿ¼�´���һ���ļ��У�Ȼ������ص�mysqlʵ������������
		//Ȼ���� ������·��-��������·��  ������������
		//���ʵ���� Ҳ���� mysql�� ����
		
		try {
			//1.ע������
			  //��һ�����󣺵���İ�һ���ǣ�import com.mysql.cj.jdbc.Driver;��Ȼ����
			Driver driver =new Driver();
            
			
			//2.�õ�����
			/*������⣺
			 *       jdbc.mysql:// �涨�ű�ʾ��Э�飬ͨ��jdbc�ķ�ʽ����mysql
			 *       localhost   ������Ҳ������ip��ַ
			 *       3306        mysql�ļ����˿�
			 *       yyf_db01    ���ӵ�mysql ���ݹ���ϵͳ���Ǹ����ݿ�
			 *  ���ʾ���socket����
			 * 
			 */
			//������ĸ
			String url="jdbc:mysql://localhost:3306/yyf_db01";
			//���û��� ����ŵ�Properties������
			Properties properties =new Properties();
			
			//������������ݿ���û�������
			properties.put("user", "root");
			properties.put("password", "1234");
			//��������
			Connection connect =driver.connect(url, properties);
			
			//3.ִ��sql
			String sql="insert into jdbcTest_db values (null,'����','��','30')";
			//ʹ��statement����ִ�о�̬sql��䲢���������ɵĽ������
			Statement statement =connect.createStatement();
			//�����dml����ɾ�ģ���䣬���صľ���Ӱ������
			int rows =statement.executeUpdate(sql);
			
			System.out.println(rows>0?"�ɹ�":"ʧ��");
			
			//4.�ر���Դ
			statement.close();
			connect.close();
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			System.out.println("��¼mysqlʧ��");
		}
		
	}
}
