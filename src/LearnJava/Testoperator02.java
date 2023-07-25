package LearnJava;
/**
 * *测试条件（三元）运算符
 * @author 86136
 *
 */

public class Testoperator02 {
	
	public static void main(String[] args) {
		int score = 80;
		//当前式满足时结果为：前值，否则为后值
		String a = score<60 ? "不及格" : "及格";//!!!震惊，赋值操作都可以使用
		
		System.out.println(a);
		
		
		int x =-100;
		int flag = x>0 ? 1 : (x==0 ? 1 : -1);
		System.out.println(flag);
	}

}
