package threadTest;
//相较自己写的，封装性更好
//下次在用静态变量之前应该先考虑一下能不能用参数传递的方法来替换把
import java.util.Scanner;

public class Practice2Teacher {

	public static void main(String[] args) {
		Task3 tmp=new Task3();
		new Thread(tmp).start();
		new Thread(new Task4(tmp)).start();
	}
}

class Task3 implements Runnable {
	private boolean loop = true;

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while (loop) {
			System.out.print("线程1输出数据  ");
			System.out.println((int) (Math.random() * 100 + 1));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		System.out.println("Task1退出");
	}
	//

	public void setLoop(boolean loop) {
		this.loop = loop;
	}
	
}

class Task4 implements Runnable{
    //想要Task4线程能通知task3线程，要想封装性高，不添加静态变量，最好的办法就是让Task4拥有一个
	 //Task3对象
	private Task3 task3=null;
	Scanner scanner=new Scanner(System.in);
	public Task4(Task3 task3) {
		super();
		this.task3 = task3;//构造Task4时传入一个Task3，这样就可以把Task3和Task4连通起来
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while(true) {
			System.out.println("请输入指令：");
			char input=scanner.next().toUpperCase().charAt(0);
			if(input=='Q') {
				task3.setLoop(false);
				System.out.println("Task2退出");
				break;
			}
		}
	}
	
}