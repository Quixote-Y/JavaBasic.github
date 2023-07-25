package exception;

import java.util.Scanner;

//如果用户会输入的不是整数，就提示他反复输入，直到输入一个整数为止
public class Practice1 {
	
	public static void main(String[] args) {
	
		int num;
		System.out.println("请输入一个整数： ");
		for(;;) {
	        try {
	        	
		        Scanner scanner = new Scanner(System.in);//System.in
		        num = scanner.nextInt();
		        break;//try时发生异常就不再继续向下执行了，没发生异常才会进行这条
	        } catch (Exception e) {
		        // TODO: handle exception
	        	System.out.println("输入数不是整数，请从新输入：");
	    	    continue;
	        }
		}
		System.out.println(num);
	}
}
//沃焯，沃焯！！！！


//也可以
//String input=""; //字符串要初始化啊记主！！！
//input=scanner.next();//不管输入的数据类型先当字符串存储起来
//num=Inter.parseInteger(input);//使用的是运行时类转换异常，这样的话就更加明确