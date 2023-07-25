package mathtest;

import java.math.*;
public class MathTest {

	public static void main(String[] args) {
		int abs=-21;
		System.out.println(Math.abs(abs));//����ֵ 21
		
		
		double pow =Math.pow(2, 4);//2��4�η�������
		System.out.println(pow);//16
		
		double ceil=Math.ceil(3.9);//����ȡ��
		System.out.println(ceil);//4
		
		double floor=Math.floor(2.323);//����ȡ��
		System.out.println(floor);//2
		
		long round=Math.round(-3.221);//����5��
		System.out.println(round);//-3
		
		double sqrt =Math.sqrt(9.0);//����
		System.out.println(sqrt);//3
		
		//Math.random(),����һ�����С��������01��0<=x<1
		//��ȡһ��2--7֮��������
		//x=2+(7-2)*Math.random();
		for(int i=0;i<10;i++) {
			System.out.print(2+5*Math.random()+" ");//10��2-7֮��������
		}
		System.out.println();//3
		//��ȡһ��2<=x<=7֮����������
		for(int i=0;i<10;i++) {//ע�⿴��Χ��û����7���������Ҫû����7����7-2������7����
			                      //8-2
			System.out.print((int)(2+6*Math.random())+" ");//10��2-7֮����������
		}
	}
}
