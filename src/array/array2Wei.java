package array;
//测试多维数组
import java.util.Arrays;
public class array2Wei {

	public static void main(String[] args) {
		//静态初始化
		int[][] a= {
				{1,2,3},
				{2,4},
				{3,4,5,6,7,8,9},
				{1}
		};//创建了一个二维数组
		//System.out.println(Arrays.toString(a));
		//Arrays.toString只能转换一维数组；
		for(int[] t:a) {
			System.out.println(Arrays.toString(t));
		}
		//动态初始化
		//java中多维数组的声明和初始化应该从低维到高位的顺序进行
		int[][] b=new int[4][];//先确定一维的大小
		b[0]=new int[2];
		b[1]=new int[2];
		b[3]=new int[3];
		b[2]=new int[10];//特点在于不像c的二维数组是一个工整的矩阵，而是二维可以不一样长
		//声明完成
		b[0][0]=100;
		b[0][1]=200;//....以此类推逐个赋值
		
		
		//动态时二维的初始化还可以这样
		int[][] c=new int[3][];
		
		c[0]=new int[] {1,2};
		c[1]=new int[] {2,3,4,4};
		//c[2]=new int[] {3,4,5,6,7,8,3};
		//易错点必须要new一个新的数组赋给一维，数组常量必须初始化才能使用
		//System.out.println(Arrays.toString(b));
		//System.out.println(Arrays.toString(c));
		for(int[] t:b) {
			System.out.println(Arrays.toString(t));
		}
		for(int[] t:c) {
			System.out.println(Arrays.toString(t));
		}
	}
}
