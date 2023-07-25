package array;

import java.util.Arrays;
import java.util.Comparator;

//定制一个排序方式
public class ArraySortSelf {

	public static void main(String[] args) {
		int[] arr= {1,4343,12,432,21,43};
		bobbleSort(arr,new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				// TODO 自动生成的方法存根
				Integer i1=(Integer)o1;
				Integer i2=(Integer)o2;
				
				//return i1-i2;//从小到大
				return i2-i1;//从大到小
			}
		});
		System.out.println(Arrays.toString(arr));
		
	}
	public static void bobbleSort(int arr[],Comparator c) {//把Comparator接口也导入进来
		int tmp=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				     /*a[i]>a[j]*/
				if((c.compare(arr[i], arr[j]))>0) {//如果compare实现时时i-j，那就是冒泡
					tmp=arr[j];
					arr[j]=arr[i];
					arr[i]=tmp;
				}
			}
		}
	}
}
