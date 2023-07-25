package collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//Set接口相关
public class SetImplementClass {

	@SuppressWarnings("all")
	public static void main(String[] args) {
		//1.set接口的实现类的对象，不能存放重复元素，可以添加一个null
		//2.set接口对象存放的数据是无序的
		//3.set接口虽然存放是无序的，虽然取出时的顺序和输入的顺序不一致，但是固定的
		//用set的实现类HashSet来验证一下
		Set set =new HashSet();
		set.add("john");
		set.add("lucy");
		set.add(null);
		set.add("spe");
		System.out.println(set);
		set.add("dad");
		System.out.println(set);
		
		//遍历
		//迭代器
		Iterator it=set.iterator();
		while(it.hasNext()) {
			Object obj=it.next();
			System.out.print(obj+"\t");
		}
		//增强for
		System.out.println("\n=========for===========");
		for(Object obj:set) {
			System.out.print(obj+"\t");
		}
		//set没有get方法，所以不能用普通for循环实现遍历
		
		/*HashSet：
		 * 1.构造器：
		 * public HashSet() {
                map = new HashMap<>();
           }
           他的底层是HashMap
           2.他可以存null，但只会有一个
           3.不保证存放的数据是有序的
           4.HashSet不能添加相同的元素对象
		 */
		//重置set
		set=new HashSet();
		System.out.println(set);
		//4.HashSet不能添加相同的元素对象
		set.add("Lucy");//T
		set.add("Lucy");//F
		set.add(new Dog("tom"));//T
		set.add(new Dog("tom"));//T,因为是不同对象嘛可以理解
		
		//------
		set.add(new String("sda"));//T
		set.add(new String("sda"));//F,这个不能加入？？？？？？？？？？
		System.out.println(set);
		//下面是转到SetImplementClass2看Set源码！！！！！
	}
}
class Dog{
	String name;

	public Dog(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + "]";
	}
	
}