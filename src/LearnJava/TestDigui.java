package LearnJava;
/**
 * 递归阶乘
 * @author 86136
 *
 */
public class TestDigui {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();//获取当前时间
		long result =factorial(20);
		long endTime = System.currentTimeMillis();
		System.out.println("递归结果： "+result);
		System.out.println("递归耗时： "+(endTime-startTime));
		
	}
	
	private static long factorial(int a) {
		if(a==1) {
			return 1;
		}
		else {
			return a*factorial(a-1);
		}
	}
}
