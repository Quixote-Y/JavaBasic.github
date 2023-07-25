package LearnJava;
/**
 * 测试类型自动转换和强制类型转换
 * @author 86136
 *
 */
public class TestOperator04 {
	
	public static void main(String[] args) {
		
		//容量小的类型可以自动转换为容量大的类型
		int a =2345;
		long b =a;
		//int c = b;//错误，long不能自动转换为int
		double d = b;
		float f =b ;
		
		//特列：整型常量是int类型，但可以自动转换为：byte/short/char
		//但值不能超过对应类型数值范围，byte：-128--127
		//int h0 =123;
		//byte h1 =h0;错误
		byte h0 =123;
		//byte h1 =1234;错误
		
		char h2 =97;//a的ascall码
		System.out.println(h2);
		
		
		//强制类型转换
		double cast1 = 3.123321;
		int cast2= (int) cast1;//舍弃小数部分
		System.out.println(cast2);
		
		//当强制转换数值溢出时会给一个无关值
		//编译器识别报错byte cast3 =(int)300;
		
		//溢出问题
		int money = 1000000000;//10亿
		int years =20;
		
		int total = money*years;//数据已经溢出，total是负数
		System.out.println("total   "+total);
		//一个错误解决方法
		long total2 = money*years;
		System.out.println("total2  "+total2);
		//因为右侧计算已经溢出，在赋值操作
		
		//正确解法
		long total3 = 1L*money*years;//1L把右侧数据计算转换为long数据
		System.out.println("total3  "+total3);
		//或者把右侧随机一个数据强制数据类型转换为long
		
	}

}