package jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

//PreparedStatement �ӿ��÷�
public class PreparedStatement_ {

	public static void main(String[] args) throws Exception {
		//Statement��Ϊ���������ʱ����Ҫ�ֶ����' ,����sqlע�����⣬�Ҵ�������鷳���׳���
		//��������PreparedStatement�ӿڣ�����Statement���ӽӿڣ��ṩ����ķ�������ؼ�����ռλ��
		
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

		//sql���
		//������ռ�շ�
		//������ܿ���ռ�շ�����Խ���ˣ�ʹ��ռ�շ���������statementһ����Ϊ���������������Ƿ���Ҹ��ӣ����׳���
		String sql="select * from `admin` where `user`=? and `password`=?";

		PreparedStatement preparedStatement=connect.prepareStatement(sql);
				//��ȡPreparedStatement,ͨ�����ӻ�ȡPreparedStatement����Ҫ����һ��sql���

		//����PreparedStatement�ɹ���Ҫ��ռ�շ�����ֵ
		//��set����
		preparedStatement.setString(1, user);//��һ���ʺŴ���ֵΪ user
		preparedStatement.setString(2, password);//�ڶ����ʺ�
		
		
		//ִ��
		//ִ��ʱ�� ��ѯ����� executeQuery() ,����ֵΪ ResultSet 
		//         ��ɾ����� �� executeUpdate() ������ֵΪ int ����ʾ���Ӱ���˼��У�����0��ʾʧ��
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet.next()) {
			System.out.println(resultSet.getString(1)+"\t"+resultSet.getString(2));
		}else {
			System.out.println("���û�������");
		}
		/*
             �������û���:1' or
             ����������:or '1'='1
              ���û�������
            sqlע�����ˣ�ԭ�������������ÿ�ռ�շ��Ĵ�ֵ�������
		 */
		//�ر�����
		resultSet.close();
		preparedStatement.close();
		connect.close();
	}
}
/*PreparedStament �Ƚ�Statement������
 * 1.PreparedStatement ��Statement ���ӽӿ�
   2.����Ŀɶ��ԺͿ�ά����
   3.PreparedStatement ��������������ܣ�
   4.DBServer���Ԥ��������ṩ�����Ż�����ΪԤ��������п��ܱ��ظ����ã���������ڱ�DBServer�ı�����������ִ�д��뱻������������ô�´ε���ʱֻҪ����ͬ��Ԥ�������Ͳ���Ҫ���룬ֻҪ������ֱ�Ӵ������������ִ�д����оͻ�õ�ִ�С�
     ��statement�����,��ʹ����ͬ��������Ϊ�������ݲ�һ��,����������䱾����ƥ��,û�л�����������.��ʵ��û�����ݿ�����ͨ��������ִ�д��뻺�档����ÿִ��һ�ζ�Ҫ�Դ����������һ�Ρ�
     (�﷨��飬�����飬����ɶ������������)
   5.PreparedStatement ���Է�ֹ SQL ע��
*/
