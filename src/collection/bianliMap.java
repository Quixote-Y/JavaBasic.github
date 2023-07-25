package collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//Map中遍历方法
public class bianliMap {

	public static void main(String[] args) {
		HashMap hashMap=new HashMap();
		hashMap.put(1, new Staff("王海洋",2132,1));
		hashMap.put(2,new Staff("李四",1000,2));
		hashMap.put(3, new Staff("王五",4000,3));
		hashMap.put(4, new Staff("赵三",4000,4));
		//遍历方式
		//1.获取Key对应的Set集合
		Set set=hashMap.keySet();
		     //然后就遍历操作Set就好了
		//（1）for
		System.out.println("----keySet增强for————");
		for(Object t:set) {
			//拿到了key值,t
			System.out.println(t+"-"+hashMap.get(t));
		}
		System.out.println("----keySet迭代器————");
		//(2)迭代器操作Set
		Iterator iterator=set.iterator();
		while(iterator.hasNext()) {
			//取到的就是key
			Object key=iterator.next();
			System.out.println(key+"-"+hashMap.get(key));
		}
		//2.直接取values
		Collection collection=hashMap.values();
		 //然后就遍历collection就好
		 //（1）
		for(Object t:collection) {
			//取到的就是value
			System.out.println(t);
		}
		//(2)
		Iterator iterator2=collection.iterator();
		while(iterator2.hasNext()) {
			Object val=iterator2.next();//取到值
			System.out.print(val+"\n");
		}
		//3.用EntrySet取k-v
		Set entrySet=hashMap.entrySet();
		  //(1)增强for
		System.out.println("\n=====EntrySet增强for=======");
		for(Object t:entrySet) {
			//取到的是整个HashMap$Node,Node实现了Map.ENtry，可以转型，利用他的方法
			Map.Entry entry=(Map.Entry)t;//向上转型
			System.out.println(entry.getKey()+"-"+entry.getValue());
		}
		System.out.println("\n=====EntrySet迭代器=======");
		Iterator iterator3=entrySet.iterator();
		while(iterator3.hasNext()) {
			Object entry2=iterator3.next();//获取的是节点
			//想使用getKEy和value还得向上转型为Map.Entry
			Map.Entry en2=(Map.Entry)entry2;
			System.out.println(en2.getKey()+"-"+en2.getValue());
		}
		
		System.out.println("\n=====根据薪水进行排序输出=======");
		//根据薪水进行排序然后输出
		//取出Set key，然后按照sal排序
		Set sal2=hashMap.keySet();
		Object[] sal3=sal2.toArray();
		//不能强制类型转换为Integer[],虽然是Object类数组，但里面的数据全是Integer，也可以直接操作，需要和Integer比较时再转也可以
		for(int i=0;i<sal3.length;i++) {
			for(int j=i+1;j<sal3.length;j++) {
				Staff value1=(Staff)hashMap.get(sal3[i]);
				Staff value2=(Staff)hashMap.get(sal3[j]);//这几个强制类型转换，都是从Object类型转
				if(value1.getSal()<value2.getSal()) {
					Integer tmp=(Integer) sal3[i];
					sal3[i]=sal3[j];
					sal3[j]=tmp;
				}//按薪水对键值在sal3中排序
			}
		}
		for(int i=0;i<sal3.length;i++) {
			System.out.println(sal3[i]+"-"+hashMap.get(sal3[i]));
		}
		
		//用迭代器输出薪水高于2000的人
		System.out.println("\n=====用迭代器输出薪水高于2000的人=======");
		Set tmp=hashMap.entrySet();
		Iterator iterator4 =tmp.iterator();
		while(iterator4.hasNext()) {
			Map.Entry obj=(Map.Entry)iterator4.next();//强制类型转换
			Object value6=obj.getValue();
			Staff staff=(Staff)value6;//强制类型转换
			if(staff.getSal()>=2000) {
				System.out.println(obj.getKey()+"-"+obj.getValue());
			}
		}
		/*
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 总结一下：这一部分的难点就在与去理解Map的存储方式HashMap，然后清楚每个方法返回来的是什么
		 *         像keySet返回来的应该是一个key的对象的集合，values返回的是value对象的集合，
		 *         entrySet返回的是HashMap里的Node节点，但Node节点并没有相应的方法去操作他，
		 *         所以Node实现了Map里的Entry，Map.Entry,使用里面的getKey，和getValue方法可以很快捷的
		 *         对map进行操作。
		 *         然后就是还有一个点，hashmap貌似是没有迭代器的,想遍历map只能用到上面说的集合Set，Collection
		 *          EntrySet这三个，然后去在他们中迭代
		 *          
		 *          然后就是EntrySet结构：：：里面存储的对象，定义上是Entry，但运行类型是Map.Entry
		 *                                   实际存放的其实是HashMap$Node，NOde节点
		 *                          然后上面三个集合都不是直接存放的新的数据，只是指向了Node节点罢了
		 *                          
		 *                          HashMap的扩容机制和HashSet一样
		 *          当添加元素时，只通过Key的哈希值获取Table的索引，然后判断该位置是否有元素
		 *          有元素，看要加入的元素和已有的元素是否相同：
		 *                                   相同，无操作，返回
		 *                                   不相同，检查节点是树还是链表，
		 *                                         树就用树的方法判断
		 *                                         链表就循环检查，--添加元素/有相同元素，不添加，只是替换
		 */
	}
}
class Staff{
	String name;
	int sal;
	int number;
	public Staff(String name, int sal, int number) {
		super();
		this.name = name;
		this.sal = sal;
		this.number = number;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + number;
		result = prime * result + sal;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Staff other = (Staff) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number != other.number)
			return false;
		if (sal != other.sal)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Staff [name=" + name + ", sal=" + sal + ", number=" + number + "]";
	}
	public String getName() {
		return name;
	}
	public int getSal() {
		return sal;
	}
	public int getNumber() {
		return number;
	}
	
}