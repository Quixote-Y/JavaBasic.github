package draw;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

//��ͼ����--��λ�Բ
       //3.ʹ����̳�JFrame��JFrame��Ӧ�Ŵ��ڣ����������һ������
public class DrawCircle extends JFrame {
	   //4.����һ�����壨Panel��
	private MyPanel mp= null;
	
	public static void main(String[] args) {
		//6.ʵ��������
		new DrawCircle();
		System.out.println("�˳�����");
	}
	
	  //5.дһ��������
	public DrawCircle() {//������
		//��ʼ�����
		mp=new MyPanel();
		//�����ŵ�������
		this.add(mp);
		//���ô��ڴ�С
		this.setSize(400,300);//��λ������
		//���ò���ʹ�������ɿ��X��ʱ�������˳�����Ȼ�����Զ�����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//��ɼ�
		this.setVisible(true);
	}

}
      //1.����һ��MyPanel���̳�JPanel��
class MyPanel extends JPanel{
	
	/*��1��.Panel���ǻ��壬����������滭ͼ
	 *��2��.Graphics g���ǻ��ʣ���������ṩ���ڶ�Ļ�ͼ���� 
	 */
	
	//2.��дpaint����-->���� javax.swing.JComponent.paint������Ĳ���Graphics g
     //--��ݷ������Ҽ���ѡ��Դ�룬Ȼ��ѡ�񸲸�/ʵ�ַ�������ȥ֮��ѡ��JComponent.paint
	@Override
	public void paint(Graphics g) {
		// TODO �Զ����ɵķ������
		super.paint(g);//�Ÿ����뱣����ʹ�ø���������Ĺ��췽����ʼ��
		//System.out.println("paint������");
		
		//Graphics �ೣ�û�ͼ����
		//��ʾ���Ʋ�ͬ��ͼ��..
		
		//��ֱ�� drawLine(int x1,int y1,int x2,int y2)
		//g.drawLine(0, 0, 100, 100);//�ֱ��������յ�����
		
		//�����α߿� drawRect(int x, int y, int width, int height)
		//g.drawRect(10,10,100,200);//���α߿�����Ͻ�����ͳ��Ϳ�
		
		//����Բ�߿� drawOval(int x, int y, int width, int height)
		//g.drawOval(10, 10, 100, 100);//�ĸ������ֱ�����Բ�����Ͼ��ε����Ͻ�����x��y�����γ��Ϳ�
		
		//������ fillRect(int x, int y, int width, int height)
		//����������û��ʵ���ɫ
//		g.setColor(Color.blue);  //setColor,�������ɫ�����õ���Color��������Ĳ���
//		g.fillRect(10, 10, 200, 200);//���Ͻ����꣬����
		
		//�����Բ fillOval(int x, int y, int width, int height)
		//1.�����û�����ɫ
//		g.setColor(Color.black);
//		g.fillOval(10,10,200,200);//ͬ����Բ�߿�
		
		//��ͼƬ drawImage(Image img, int x, int y, ..)
		//1.��Ҫ��ȡͼƬ
//		Image imag=Toolkit.getDefaultToolkit().getImage("E:\\javacode\\LearnJava\\src\\draw\\test.jpg");//��ȡ��Ƭ
//		g.drawImage(imag, 10, 10, 295,413,this);
		
		//���ַ��� drawString(String str, int x, int y)//д��
		//������������ɫ������
        g.setColor(Color.red);//��ɫ
        g.setFont(new Font("����",Font.BOLD,50));//���壬newһ��Font���ÿ��飬�Ӵ֣���С50
        g.drawString("����", 100, 100);//д�֣������������½ǵ�����
		
		//���û��ʵ����� setFont(Font font)
		//���û��ʵ���ɫ setColor(Color c)
		
	}
	
}

/*ע�⣺1.paint����print��ģ����������һ��
 *      2.paint�����ᱻ�Զ����ã���������Щ�����
 *            ��1�����������һ������Ļ����ʾ��ʱ�򣬳�����Զ�����paint�����������������
 *            ��2��.������С�������
 *            ��3��.���ڴ�С�����仯ʱ
 *            ��4��.repaint����������
 * 
 */



