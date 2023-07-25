package collection;

import java.util.Properties;

//properites解析
public class PropertiesTest {

	public static void main(String[] args) {
		//properties类继承自Hashtable并实现了Map接口，也是k-v形式存储数据
		//特点与hashtable相同
		//Properties常用于从xxxx.properties文件中加载数据到Properties对象，xxxx.properties文件
		//通常用作配置文件
		Properties properties=new Properties();
		properties.put("john", 1);
		properties.put("namei", 2);//同样，键值对都不可以为空
		properties.put("namei2", 3);
		properties.put("namei3", 4);
		System.out.println(properties);
		properties.put("namei", 100);//替换
		System.out.println(properties);
		properties.remove("namei3");//删除
		System.out.println(properties);
		System.out.println(properties.get("john"));//获取值

	}
}
