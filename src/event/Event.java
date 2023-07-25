package event;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

//java事件处理机制--监听器，事件对象，事件源，处理---委派事件模型
//控制小球移动
public class Event extends JFrame {
	MyPanel mp=null;
	public static void main(String[] args) {
		Event en=new Event();
	}
	public Event() {
		mp=new MyPanel();
		this.add(mp);
		//必须把这个监听器放到框架里
		this.addKeyListener(mp);
		this.setSize(1000,750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	
}
//初步画了一个原但还不能移动，怎么移动呢
//1.事件监听，让Panel实现一个监听接口KeyListener，KeyListener是一个监听器，可以监听键盘事件
//机制就是：当事件源发生一个事件，产生一个事件对象像键盘就是KeyEvent对象，监听器监听到后，通过接口里具体的方法借由实现监听器接口的类来处理事件

class MyPanel extends JPanel implements KeyListener{

	int x=10;
	int y=10;//通过这两个参数来控制圆生成的位置
	@Override
	public void paint(Graphics g) {
		// TODO 自动生成的方法存根
		super.paint(g);
		//draw circle
		g.fillOval(x, y, 100, 100);//default black
	}

	//一下是KeyListener接口的方法
	//又字符输出时，这个方法触发
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自动生成的方法存根
		
	}
//有按键被按下时，触发
//想要控制小球移动，这个就够了
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 自动生成的方法存根
		//根据按键上下左右来改变xy的值，然后重绘图像
		if(e.getKeyCode()==KeyEvent.VK_DOWN) {//向下箭头
			y+=10;
		}else if(e.getKeyCode()==KeyEvent.VK_UP) {
			y-=10;
		}else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			x+=10;
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			x-=10;
		}
		
		//重绘
		this.repaint();
		
	}
//按键被释放时触发
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自动生成的方法存根
		
	}
	
	
}
