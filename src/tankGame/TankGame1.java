package tankGame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

import javax.swing.JFrame;

public class TankGame1 extends JFrame {

	MyPanel mp=null;
	public static void main(String[] args) {
		TankGame1 tankgame=new TankGame1();
	}
	public TankGame1(){
		System.out.println("请选择：1.开始新游戏  2.继续上次游戏");
		Scanner scanner=new Scanner(System.in);
		int input=scanner.nextInt();
		mp=new MyPanel(input-1);//new一个MyPanel
		this.add(mp);//把panel加到Frame里
		
		//建立重绘线程，把mp加到Thread里
		new Thread(mp).start();
		//把监听器加到框架中
		this.addKeyListener(mp);
		this.setSize(1150,750);//设置Frame框架
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点×退出
		this.setVisible(true);//可见
		//在JFrame里加一个监听器，监听是否点了X
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO 自动生成的方法存根
				Recoder.storeRecode();
			}
			
		
		});
	}
}
