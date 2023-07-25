package LearnJava;

public class TestConstant {
	public static void main(String[] args) {
		final double pi=3.14;//常量声明
		//无法再次为常量赋值
		
		int r=4;
		double area=pi*r*r;
		double circle=2*pi*r;
		System.out.println("面积是： "+area);
		System.out.println("周长是： "+circle);
	}


}
