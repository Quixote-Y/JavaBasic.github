package array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
public class arraySort {

	//数组排序算法
	/*
	 * 1.自己写排序算法或者Arrays提供的sort算法
	 * 2.因为数组是引用类型，通过sort排序后会直接影响到实参arr
	 * 3.sort是重载的，也可以通过传入一个接口Comparator实现定制排序
	 * 
	 */
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		//默认排序

		Integer[] arr= {1,434,21,212,35312,2,3,5,6,21};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));//默认由大到小的顺序
        
        //定制排序
        /*
         * 1.调用定制排序时，需传入两个参数：
	     * 
	     *    （1）排序的数组arr
	     *    （2）实现comparator接口的匿名内部类，要求实现compare方法
	     *2.运行路线：
	     *    （1）Arrays.sort(arr, new Comparator(
	     *    （2）最终运行到 binarySort(a, lo, hi, lo + initRunLen, c);方法
	     *    （3）这是个二叉树排序，它里面有一段代码：
	     *              while (left < right) {
                            int mid = (left + right) >>> 1;
                            if (c.compare(pivot, a[mid]) < 0)
                                      right = mid;
                            else
                                      left = mid + 1;}
                  根据compare方法的不同，做出不一样的动作，根据动态绑定会回到程序
                  
                 （4）@Override
			           public int compare(Object o1, Object o2) {
				          // TODO 自动生成的方法存根
				           Integer i1=(Integer) o1;
				           Integer i2=(Integer) o2;
				           return i2-i1;
				        返回值>0还是<0会影响排序结果
         */
        Arrays.sort(arr, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				// TODO 自动生成的方法存根
				Integer i1=(Integer) o1;
				Integer i2=(Integer) o2;
				return i2-i1;
			}  	
        });//好像不能排int数组	
        
        System.out.println(Arrays.toString(arr));
        //二叉查找binarySearch
        /*
         * 1.要求目标数组必须是有序的
         * 2.若不存在，返回return -(low+1);
         */
        int index=Arrays.binarySearch(arr,21);
        System.out.println(index);
        
        //copyOf 数组元素复制
        //从arr数组中拷贝arr.length个元素
        Integer[] newArr =Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(newArr));
        //equals：数组所有元素相等
        //asList：将数据转换为List集合
        //asList 编译类型是 List（接口）
        //        运行类型是 java.util.Arrays$ArrayList，
        //         是Arrays里面的一个静态内部类
        List<Integer> asList=Arrays.asList(arr);
        System.out.println("asList: "+asList);
        System.out.println("asList的运行类型是： "+asList.getClass());
	}
}
