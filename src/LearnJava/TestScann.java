package LearnJava;

import java.util.Scanner;//导入scanner包

public class TestScann {
	
	public static void main(String[] args) 
	{
		
		
		//此处有个问题，如果先输入数字，那么第二个scann.nextline就会失效，考虑可能和缓冲区机制有关。-->
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入姓名： ");
		String name = scan.nextLine();
		System.out.println("姓名是： "+name);
		System.out.println("\n\n");
		System.out.println("请输入数据： ");
		int data = scan.nextInt();
		System.out.println("数据： "+data);
		
		
		//关闭scan流
		scan.close();
		
		
		
	}

}
