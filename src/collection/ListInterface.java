package collection;

import java.util.ArrayList;
import java.util.List;


//Collection的子接口List
public class ListInterface {

	public static void main(String[] args) {
		/*List
		 * 1.List中的所有元素是有顺序的，且可重复
		 * 2.list中的每个元素都有对应的顺序索引，支持索引
		 * 3.List有很多实现类，常用的是ArrayList LinkedList  Vector
		 */
		
		//常用方法
		List list=new ArrayList();
		//添加元素 add
		list.add("张三");
		list.add("李四");
		list.add("王五");
		//在指定索引处加入元素
		list.add(1, "jack");
		list.add(1,"tom");
		
		System.out.println(list);
		
		List list2=new ArrayList();
		list2.add(1);
		list2.add(2);
		list2.add(3);
		//将list2添加到list里
		list.addAll(list2);
		
		System.out.println(list);
		
		//将list2移除list
		list.removeAll(list2);
		
		System.out.println(list);
		
		//将list2添加到list索引1的位置
		list.addAll(1, list2);
		System.out.println(list);
		
		//返回3所在的索引
		System.out.println(list.indexOf(3));
		//最后一个3所在的索引
		System.out.println(list.lastIndexOf(3));
		
		//remove 
		
		//替换指定位置的元素set
		list.set(3, "替换");
		System.out.println(list);
		
		//返回指定位置区间的子集合，前闭后开subList
		List list3=list.subList(4, 6);
		System.out.println(list3);
		//获取指定位置的元素
		Object get1=list.get(3);
		System.out.println(get1);

	}
}
