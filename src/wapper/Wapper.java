package wapper;

//包装类基本知识
public class Wapper {
  
	public static void main(String[] args) {
	/*
	 * boolean-->Boolean
	 * char-->Character
	 * byte-->Byte
	 * int-->Integer
	 * long-->Long
	 * short-->Short----------------------->几个数字类的都继承自Number父类
	 * double-->Double
	 * float-->Float
	 */
	/*
	 * 包装类和基本数据类型的转换   装箱：基本数据类型-->包装类型，反之，拆箱，
	 * jdk5以前，手动装箱和拆箱
	 * 
	 */
	//手动装箱
	//int-->Integer
	int n1 =100;
	Integer integer =new Integer(n1);
	Integer integer1=Integer.valueOf(n1);
	
	//手动拆箱
    //Integer-->int
	int n2=integer.intValue();
	
	
	//jdk5之后可以自动装箱拆箱
	int n3=100;
	Integer integer2=n3;//底层任然是Integer integer1=Integer.valueOf(n1);
	//自动拆箱
	int n4=integer2;//底层使用的是int n2=integer.intValue();
	
	//三元运算符是一个整体，会调整精度
	Object a =true? Integer.valueOf(1):Double.valueOf(2.0);//会输出1.0，首先啊
	//结果是ture，会选Integer.valueof(1),但三元运算符是一个整体，他会自动调整精度向大
	//的方向，调整为Doubl类型，1.0
	System.out.println(a);	
	Object b;
	if(true) {
		b=new Integer(1);
	}else {
		b=new Double(2.0);
	}
	System.out.println(b);//输出1，是分开的两段，不会出现转型
	}
}
