package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

//冒泡实现List排序
public class Practice1 {

	@SuppressWarnings("all")
	public static void main(String[] args) {
		Book book1=new Book("红楼梦",100);
		Book book2=new Book("西游记",2);
		Book book3=new Book("小王子",200);
		Book book4=new Book("大圣游",2323);
		Book book5=new Book("骆驼王",43);
		//添加到List里
		//List的实现子类所用的方法都是一致的
		//因此我们这里可以把三种实现类都尝试一下
		//List list =new LinkedList();
		//List list =new Vector();
		List list =new ArrayList();
		list.add(book1);
		list.add(book2);
		list.add(book3);
		list.add(book4);
		list.add(book5);
		//输出看看
		System.out.println(list.toString());
		System.out.println("______________________\n");
		sort(list);
		System.out.println(list);
		//一个错误记录：
		/*输出是这样的：
		 * [collection.Book@4232c52b, collection.Book@1877ab81, collection.Book@305fd85d, collection.Book@458c1321, collection.Book@11438d26]
		 *输出的是地址，为什么呢？忘了给类重写toString方法了
		 *
		 */
		//直接打印
		//[名称红楼梦	价格100	, 名称西游记	价格2	, 名称小王子	价格200	, 名称大圣游	价格2323	, 名称骆驼王	价格43	]
		//他间隔位会打印，但我找不到打印，是在什么地方定义的
		//还是老老实实用循环打印，这样方便控制输出格式
		for(Object t:list) {
			System.out.println(t+"\n");
		}
		//再试试iterator遍历
		System.out.println("______________________\n");
		Iterator iterator=list.iterator();
		while(iterator.hasNext()) {
			Object obj=iterator.next();
			System.out.println(obj+"\n");
		}
		
	}
	
	//冒泡实现List里Book的价格从高到低排序
	public static void sort(List list){
		int listSize=list.size();
		for(int i=0;i<listSize;i++) {
			for(int j=i+1;j<listSize;j++) {
				//取出List里对应位置的元素
				Book book1=(Book)list.get(i);//向下转型，因为get取出来的默认是Object对象
				Book book2=(Book)list.get(j);
				if(book1.price>book2.price) {
					//从小到大
					list.set(i, book2);
					list.set(j,book1);//很简单的元素互换
				}
			}
		}
		
	}
	
}

class Book{
	String name;
	int price;
	public Book(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "名称: "+name+"\t"+"价格: "+price+"\t";
	}
	
	
	
}
