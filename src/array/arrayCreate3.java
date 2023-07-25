package array;
/*
 * 测试数组的三种初始化方式
 */
public class arrayCreate3 {
	public static void main(String[] args) {
		//静态初始化
		int[] a= {10,20,30,40};//直接给值
		Apple[] apple= {new Apple(1,2),new Apple(2,3),new Apple(3,4)};//直接花括号赋值
		
		//动态初始化
		int[] b;//声明
		b=new int[10];//创建
		b[0]=0;
		//赋值
		
		//默认初始化
		int[] c=new int[10];//默认值是0
		boolean[] d=new boolean[2];//默认值是false
		String[] s=new String[2];//默认值是NULL
	}

}
