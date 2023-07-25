package systemClass;

import java.util.Arrays;

//System类常用方法
public class SystemClass {

	
	public static void main(String[] args) {
		//exit(0)退出程序
		//0表示一个状态，正常的状态
		
//	     System.out.println("OK!");
//       System.exit(0);
//	     System.out.println("OK2");
		
		//arraycopy:复制数组元素，比较适合底层调用，
		//一般使用Arrays.copy来完成复制数组，但他的底层调用的也是arraycopy函数
		int[] src= {1,2,3};
		int[] des=new int[3];
		//参数为：源数组，源起点，目标数组，目标起点，复制数目
		System.arraycopy(src, 0, des, 0, src.length);
		System.out.println(Arrays.toString(src));
		System.out.println(Arrays.toString(des));
		//currentTimeMillis():返回当前时间到1970年1月1日的毫秒数
		long time=System.currentTimeMillis();
		System.out.println(time);
		//建议启动gc回收垃圾
		System.gc();
	}
}
