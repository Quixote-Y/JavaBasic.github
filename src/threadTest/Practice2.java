package threadTest;

import java.util.Scanner;

public class Practice2 {

	public static void main(String[] args) {
		new Thread(new Task1()).start();
		new Thread(new Task2()).start();
	}
}
class Task1 implements Runnable{

	
	public static char loop=' ';
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while(true) {
			System.out.print("线程1输出数据  ");
			System.out.println((int)(Math.random()*100+1));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			if(loop=='Q')break;
		}
	}
	
}class Task2 implements Runnable{

	Scanner scanner=new Scanner(System.in);
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while(true) {
			
			String input=scanner.next();
			if(input.equals("Q")) {
				Task1.loop='Q';
				System.out.println("程序结束");
				break;
			}
		}
	}
	
}