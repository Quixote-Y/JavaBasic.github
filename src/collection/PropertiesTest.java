package collection;

import java.util.Properties;

//properites����
public class PropertiesTest {

	public static void main(String[] args) {
		//properties��̳���Hashtable��ʵ����Map�ӿڣ�Ҳ��k-v��ʽ�洢����
		//�ص���hashtable��ͬ
		//Properties�����ڴ�xxxx.properties�ļ��м������ݵ�Properties����xxxx.properties�ļ�
		//ͨ�����������ļ�
		Properties properties=new Properties();
		properties.put("john", 1);
		properties.put("namei", 2);//ͬ������ֵ�Զ�������Ϊ��
		properties.put("namei2", 3);
		properties.put("namei3", 4);
		System.out.println(properties);
		properties.put("namei", 100);//�滻
		System.out.println(properties);
		properties.remove("namei3");//ɾ��
		System.out.println(properties);
		System.out.println(properties.get("john"));//��ȡֵ

	}
}
