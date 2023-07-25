package LearnJava;

public class Testoperator {
	
	public static void main(String[] args) {
		//位运算符
		int a=7;
		int b=8;
		System.out.println(a&b);
		System.out.println(a|b);
		System.out.println(a^b); //异或
		System.out.println(~b); //取反
		
		
		//移位，最快乘除2操作
		int c =5<<2;//相当于：5*2*2
		System.out.println(c);
		System.out.println(40>>3);//40除以8
	}

}
