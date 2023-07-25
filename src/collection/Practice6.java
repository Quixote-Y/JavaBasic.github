package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//使用ArrayList完成对对象的各种操作
public class Practice6 {

	@SuppressWarnings("all")
	public static void main(String[] args) {
		List list =new ArrayList();
		Car2 Car21=new Car2("宝马",4000000);
		Car2 Car22=new Car2("宾利",50000000);
		Car2 Car23=new Car2("小鹏",50000);
		list.add(Car21);
		list.add(Car22);
		list.add(Car23);
		list.remove(Car23);
		System.out.println(list);
		System.out.println(list.contains(Car23));
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		list.clear();
		System.out.println(list.isEmpty());
		List list2=new ArrayList();
		list2.add(Car21);
		list.add(Car22);
		list.addAll(list2);
		System.out.println(list);
		System.out.println(list.containsAll(list2));
		list.removeAll(list2);
		System.out.println(list);
		list.addAll(list2);
		for(Object t:list) {
			System.out.println(((Car2)t).getName()+"-"+((Car2)t).getPrice());
		}
		System.out.println("----------diedaiqi-----------------");
		Iterator iterator=list.iterator();
		while(iterator.hasNext()) {
			Object obj=iterator.next();
			System.out.println(((Car2)obj).getName()+"-"+((Car2)obj).getPrice());
		}
	}
}
class Car2{
	private String name;
	private int price;
	public Car2(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Car2 [name=" + name + ", price=" + price + "]";
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
	
}
