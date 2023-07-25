package array;

import java.util.Arrays;

//测试Object[][]二维数组存储表格
public class arrayObject {
	
	public static void main(String[] args) {
		System.out.println("学号\t姓名\t年龄\t学校\t课室");
		
		//Object,所有类的父类，Object[],一个对象类数组，里面只存放对象
		//首先：字符串是一个对象，要new嘛，8大基本数据类型不是对象
		//但java有个自动装箱机制，会自动将数字转换为对象，所以下面的数组成立。！！！
		Object[] a1= {1,"杨玉甫",18,"西电","2003"};
		Object[] a2= {2,"王五",14,"西电","2004"};
		Object[] a3= {3,"李晓强",19,"西电","2005"};
		Object[] a4= {4,"杨玉龙",17,"西电","2006"};
		
		Object[][] emps =new Object[4][];
		emps[0]=a1;
		emps[1]=a2;
		emps[2]=a3;
		emps[3]=a4;
		//这样就将表中所有信息存储到object二维数组里了
		for(Object[] t:emps) {
			System.out.println(Arrays.toString(t));
		}
		
	}

}
