package mathtest;

import java.math.*;
public class MathTest {

	public static void main(String[] args) {
		int abs=-21;
		System.out.println(Math.abs(abs));//绝对值 21
		
		
		double pow =Math.pow(2, 4);//2的4次方，求幂
		System.out.println(pow);//16
		
		double ceil=Math.ceil(3.9);//向上取整
		System.out.println(ceil);//4
		
		double floor=Math.floor(2.323);//向下取整
		System.out.println(floor);//2
		
		long round=Math.round(-3.221);//四舍5入
		System.out.println(round);//-3
		
		double sqrt =Math.sqrt(9.0);//开方
		System.out.println(sqrt);//3
		
		//Math.random(),返回一个随机小数，介于01，0<=x<1
		//获取一个2--7之间的随机数
		//x=2+(7-2)*Math.random();
		for(int i=0;i<10;i++) {
			System.out.print(2+5*Math.random()+" ");//10个2-7之间的随机数
		}
		System.out.println();//3
		//获取一个2<=x<=7之间的随机整数
		for(int i=0;i<10;i++) {//注意看范围包没包括7啊，这很重要没包括7就是7-2，包括7就是
			                      //8-2
			System.out.print((int)(2+6*Math.random())+" ");//10个2-7之间的随机整数
		}
	}
}
