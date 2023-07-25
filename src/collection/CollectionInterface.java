package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;



//集合体系框架
public class CollectionInterface {
  
	/*
	 * 1.集合主要是两组（单列集合，双列集合）
	 *        Collection接口是Iterable接口的子类--》所有的Collection实现子类均可以调用一个iterator方法
	 * 2.Collection接口有两个重要的子接口List Set，他们的实现子类都是单列集合
	 *   List-->arryList LinkedList  Vector
	 *   Set -->TreeSet HashSet
	 * 3.Map接口的实现子类是双列集合，存放的是键值对
	 *   Map-->HashMap TreeMap Hashtable
	 */
	@SuppressWarnings("all")
	public static void main(String[] args) { 
	//Collection常用方法
	//Collection是个接口，无法实例化，我们使用他的实现子类Arraylist来看
		
		Collection col=new ArrayList();//接口不能创建实例，但可以声明引用变量类型
		                               //此时col只能使用Collection接口里的方法，不能使用
		                               //List里新添加的方法，ArrayList是List的实现子类
		//添加元素 add（）
		col.add("jack");
		col.add(100);
		col.add("mot");
		col.add(true);//add的对象是Object，说明任何的对象都可以添加进来
		System.out.println("col: "+col);
		//删除单个元素 remove
		//col.remove(0);//删除第一个元素"jack"---->不对，Collection里没有定义应该是List里定义了
		col.remove(100);//指定删除col里的100
		System.out.println("col: "+col);
		//查看元素是否存在 contains
		
		System.out.println(col.contains("mot"));
		
		//获取元素个数
		System.out.println(col.size());
		//判断是否为空 isEmpty
		System.out.println(col.isEmpty());
		//清空 clear
		col.clear();
		System.out.println("col: "+col);
		//添加多个元素 addAll
		//可以直接添加一collection接口的实现类，一次性全部添加
		ArrayList al=new ArrayList();
		al.add("HK");
		al.add("UK");
		al.add("DK");
		col.addAll(al);
		System.out.println("col: "+col);
		//删除多个元素 removeAll
		col.add("WK");
		col.removeAll(al);
		System.out.println("col: "+col);//wk
		
		 //Collection接口遍历对象的两种方式
		//迭代器---
		// Collection接口是Iterable接口的子类
		//--》所有的Collection实现子类均可以调用一个iterator方法，这个方法可以返回
		//一个Iterator迭代器对象，主要使用其中的两个函数：hasNext：判断指针所指位置下一个位置是否还有
		//元素，next，迭代器指针下移，并取出指向的元素，
		//迭代器初始化成功时，指针指向头部，没指向第一个元素
		//迭代器返回的元素类型是Object，根据动态绑定，运行时类型会自动转换为与实际类型最合适的类
		
		//现在使用迭代器来遍历一下col
		col.addAll(al);
		//1.得到col对应的迭代器
		Iterator iterator =col.iterator();
		//2.使用while循环
		 while(iterator.hasNext()) {
			 //返回下一个元素
			 Object obj=iterator.next();//返回类型为Object，编译时类型
			 System.out.println(obj);
		 }
		 
		 //迭代器指针下移之后怎么复位呢？重新初始化
		 iterator =col.iterator();
		 System.out.println("_________________");
		 while(iterator.hasNext()) {
			 //返回下一个元素
			 Object obj=iterator.next();//返回类型为Object，编译时类型
			 System.out.println(obj);
		 }
		 
		 System.out.println("_____以下是增强for______");
		  //增强for
		 //增强for的实现方式就是迭代器，简化了迭代器的操作
		 for(Object t:col) {
			 System.out.println(t);
		 }
		 
	}
}
