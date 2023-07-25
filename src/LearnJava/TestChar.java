package LearnJava;

public class TestChar {
	public static void main(String[] args) {
		char c1='a';
		char c2 ='中';
		char c3 = '\u0061';// u表示uncoide编码
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		
		//java中字符串不是基本数据类型，而是一个类
		String str = "我爱中国";
		System.out.println(str);
		
		//转义字符
		char c5 = '\n';//转义字符\n表示换行，\"输出中添加双引号\'添加单引号
		System.out.println("a\n\"b\"\nc\nd");//看输出
		System.out.println("a\tb\tc\td\t");//看输出，制表符
		}

}
