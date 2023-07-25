package jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

//statement ����sqlע������
public class Statement_ {

	/*��Ϊsqlע��:
	 *    ͨ�����������ʱ�����' '���ţ���sql������巢���仯��ʹ���Ϸ���������úϷ�
	 *    
	 *    ���裺һ����ѯ��
	 *      Select * from admin
	 *      where name= ? and pwd = ? 
	 *      ������һ����ѯ������ͨ���㴫��Ĳ����Ĳ�ͬ�����ر�����û��������¼�������ں˶��û��Ƿ�Ϸ�
	 *      
	 *      ���������������������
	 *       ?  : 1' or
	 *       ?  : or '1' ='1
	 *       ��ô���ɵĲ�ѯ���ͱ���ˣ�
	 *       select * from admin
	 *       where name = '1'  or ' and pwd = 'or '1'='1';
	 *       ��Ϊ�������ʱ���ַ���������Ҫ�����߼���һ��''������ϴ���������'��ʹ���巢���˱仯
	 *       where �� name ='1'  ���� ' and pwd =' ���� '1'='1'����Ȼ�������������������ʽ�������ѯ���һ���᷵��ֵ  
	 * 
	 *       ����һ�£���mysql�����У�select * from jdbctest_db where true �����᷵�����еļ�¼
	 *        �Ǵ���������ﾳ�����ע��Ϳ��Է������е��û��������룬���ݿ�ͱ�������
	 *        
	 */
	
	public static void main(String[] args) throws Exception {
		//��ʾsqlע�룬������һ�����������һ��tom ���� 123
		Scanner scanner =new Scanner(System.in);
		
		System.out.print("�������û���:");
		String user=scanner.nextLine();
		System.out.print("����������:");
		String password =scanner.nextLine();
		
		//��ʼ��������
		Properties properties=new Properties();
		properties.load(new FileInputStream("src\\mysql.properties"));
		String user2=properties.getProperty("user");
		String password2=properties.getProperty("password");
		String driver=properties.getProperty("driver");
		String url=properties.getProperty("url");
		
		Class.forName(driver);
		Connection connect =DriverManager.getConnection(url,user2,password2);

		//��ȡstatement
		Statement statement=connect.createStatement();
		//дsql���
		//sql���Ӳ�����''�����ű�©�ˣ���©�˳����⣬Ȼ����Ƿ�����``�´�����navicate��дһ���ڳ�����
		String sql="select * from `admin` where `user`= '"
		                     +user+"' and `password`= '"+password+"'";
		//ִ��
		ResultSet resultSet=statement.executeQuery(sql);
		if(resultSet.next()) {
			System.out.println(resultSet.getString(1)+"\t"+resultSet.getString(2));
		}else {
			System.out.println("���û�������");
		}
		/*
		 * �������û���:1' or
           ����������: or '1'='1---���ͳ�����������
            tom	123
            sqlע�뷢����
            Statement�ǲ���ȫ��

		 */
		//�ر�����
		resultSet.close();
		statement.close();
		connect.close();
	}
	
	
}
