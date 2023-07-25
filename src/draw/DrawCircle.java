package draw;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

//画图入门--如何画圆
       //3.使主类继承JFrame，JFrame对应着窗口，可以理解是一个画框
public class DrawCircle extends JFrame {
	   //4.定义一个画板（Panel）
	private MyPanel mp= null;
	
	public static void main(String[] args) {
		//6.实例化调用
		new DrawCircle();
		System.out.println("退出程序");
	}
	
	  //5.写一个构造器
	public DrawCircle() {//构造器
		//初始化面板
		mp=new MyPanel();
		//把面板放到画框里
		this.add(mp);
		//设置窗口大小
		this.setSize(400,300);//单位是像素
		//设置参数使你点击生成框的X的时候程序就退出，不然不会自动结束
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//框可见
		this.setVisible(true);
	}

}
      //1.定义一个MyPanel，继承JPanel类
class MyPanel extends JPanel{
	
	/*（1）.Panel就是画板，你可以在上面画图
	 *（2）.Graphics g就是画笔，这个类型提供了众多的绘图方法 
	 */
	
	//2.重写paint方法-->覆盖 javax.swing.JComponent.paint，里面的参数Graphics g
     //--快捷方法，右键，选择源码，然后选择覆盖/实现方法，进去之后选择JComponent.paint
	@Override
	public void paint(Graphics g) {
		// TODO 自动生成的方法存根
		super.paint(g);//着个必须保留，使用父类带参数的构造方法初始化
		//System.out.println("paint被调用");
		
		//Graphics 类常用绘图方法
		//演示绘制不同的图形..
		
		//画直线 drawLine(int x1,int y1,int x2,int y2)
		//g.drawLine(0, 0, 100, 100);//分别是起点和终点坐标
		
		//画矩形边框 drawRect(int x, int y, int width, int height)
		//g.drawRect(10,10,100,200);//矩形边框的右上角坐标和长和宽
		
		//画椭圆边框 drawOval(int x, int y, int width, int height)
		//g.drawOval(10, 10, 100, 100);//四个参数分别是椭圆形贴合矩形的左上角坐标x，y，矩形长和宽
		
		//填充矩形 fillRect(int x, int y, int width, int height)
		//必须得先设置画笔的颜色
//		g.setColor(Color.blue);  //setColor,里面的颜色参数得调用Color类用里面的参数
//		g.fillRect(10, 10, 200, 200);//左上角坐标，长宽
		
		//填充椭圆 fillOval(int x, int y, int width, int height)
		//1.先设置画笔颜色
//		g.setColor(Color.black);
//		g.fillOval(10,10,200,200);//同键椭圆边框
		
		//画图片 drawImage(Image img, int x, int y, ..)
		//1.先要获取图片
//		Image imag=Toolkit.getDefaultToolkit().getImage("E:\\javacode\\LearnJava\\src\\draw\\test.jpg");//读取照片
//		g.drawImage(imag, 10, 10, 295,413,this);
		
		//画字符串 drawString(String str, int x, int y)//写字
		//给画笔设置颜色和字体
        g.setColor(Color.red);//颜色
        g.setFont(new Font("楷体",Font.BOLD,50));//字体，new一个Font，用楷书，加粗，大小50
        g.drawString("杨玉甫", 100, 100);//写字，坐标是字左下角的坐标
		
		//设置画笔的字体 setFont(Font font)
		//设置画笔的颜色 setColor(Color c)
		
	}
	
}

/*注意：1.paint不是print真的！！，搞错了一次
 *      2.paint方法会被自动调用，在以下这些情况：
 *            （1）。当组件第一次在屏幕上显示的时候，程序会自动调用paint（）方法来绘制组件
 *            （2）.窗口最小化又最大化
 *            （3）.窗口大小发生变化时
 *            （4）.repaint方法被调用
 * 
 */



