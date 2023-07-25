package array;
//测试java对数组常用包Arrays常用函数用法

import java.util.Arrays;
public class arrayArrays {

	public static void main(String[] args) {
		//先看怎么数组拷贝
		String[] s = {"nihao","hellow","hi","good moring","afternoon","evening"};
		String[] sC=new String[10];//声明创建要复制到的目标地址
		
		//数组拷贝函数，参数依次为：原数组，原起始位置，目标数组，目标起始位置，复制长度
		System.arraycopy(s, 0, sC, 0, s.length);

		//输出sC
		System.out.println(Arrays.toString(sC));
		
		
	
		
		int[] a= {10,20,40,1,594,60,2319};
		//Arrays.toString(),于object里的toString不同，是将对象指向的内容转换为字符串输出粗来
		System.out.println(Arrays.toString(a));
		//对数组进行排序
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		
		//返回元素所在的索引位置，若未找到则返回负数
		//二分查找
		System.out.println("159的位置:"+Arrays.binarySearch(a, 159));
		System.out.println("594的位置:"+Arrays.binarySearch(a, 594));
		
		System.out.println("以下为字符替换部分-------");
		//填充字符，把起始位置到结束位置之前的元素都替换为指定元素
		int[] b = {1,2,3,4,5,6,7,8,9,0,};
		Arrays.fill(b,2,7,100);//把数组b的第二个位置起始到第七个位置之前的数都替换为100
		System.out.println(Arrays.toString(b));
	}
}
