package collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//Map解析
public class MapImplementsClass {

	public static void main(String[] args) {
		//1.Map与Collection并列存在，用于保存具有映射关系的数据key--value
		//2.Map中的key和value可以是任何引用类型，会封装到HashMap$Node对象中
		//3.Map的key不允许重复，重复时会更新value
		//4.Map中value可以重复
		//无序存储
		//5.Map的key可以为空，value也可以为null，但key只能有1个null，但value可有多个null
		//6.key和value一一对应，可通过key找value
		 Map map=new HashMap();
		 map.put("no1", "yyf");
		 map.put("no2", "dmy");
		 map.put("no3", "zyx");
		 map.put("no1", "lisi");//相同key就替换calue
		 map.put("no4", "dmy");//value可以重复
		 map.put(null, null);//null也可以
		 map.put(null, "12");//替换
		 //key  get找 value
		 System.out.println(map.get("no4"));//dmy
		 
		 System.out.println(map);
		 
		 
		 
		 //Map解析HashMap$Node Entry Set Collection
		 //1.put数据k -v时，Map的底层实现就是HashMap，一样的table表初始化，putValue方法，
		 //   他最后创建的节点类型为：HashMap$Ndoe=newNode(hash, key, value, null);
		 //2.Map 为了方便程序员的遍历，还会创建一个EntrySet集合，该集合存放的元素类型为Entry
		 //   而一个Entry对象就有k，v，EntrySet<Entry<K,V>> 即：transient Set<Map.Entry<K,v>> entrySet
		 //
		 //由所有的key（键值）组成的集合是Set，由所有Value组成的集合是Collection，所有的k和val的组合组合成的集合是EntrySet
		 //准确地说应该是一个集合Set指向了有所的Key，一个集合Collection指向可value，然后EntrySet指向两个的集合
		 //

		 //3.对象在EntrySet中，定义的类型是   Map.Entry   ,但实际存储的还是    HashMap$Node  也就是你前面创建的内个Node节点
		 //   这是因为多态，HashMap中的Node实现了Map>Entry<K,V>,  也就是父类引用子类对象嘛，但这样也就意味这你通过
		  //      entrySet获取到EntrySet之后，强制类型转换应该转换为Map.Entry,因为在对象在EntrySet中，定义的类型是   Map.Entry 
		 
		 //4.当把HashMap$Node 对象存放到entrySet中后，就方便了我们的遍历，因为Map.Entry提供了重要的方法
		 //      V get value();K getKey();
		 Set set =map.entrySet();//返回EntrySet，EntrySet里放的对象定义类型是Entry，运行类型是Map.Entry
		 System.out.println(set.getClass());//看看set的运行时类型是什么：：：class java.util.HashMap$EntrySet，返回值类型是EntrySet
		 for(Object t:set) {     //这里t必须是Object类，因为set是Object子类，不是Map.Entry,不能直接些Map.Entry
			 //向下转型到value
			 Map.Entry obj=(Map.Entry)t;
			 System.out.println(obj.getKey()+" "+obj.getValue());//这是两个Map.Entry的两个方法
		 }
		 Set set2=map.keySet();//获取键序列，set因为不能重复，获取Set
		 Collection col=map.values();//获取值序列,collection因为可以重复，获取Collection
		 
		 System.out.println(set2);
		 System.out.println(col);
		//大致梳理一下
		 /*
		  * 当创建Map时，会创建HashMap$Node节点来存储key和value，并建立table，但是Map为了方便程序员操作，又维护了一个EntrySet集合，
		  *  这个集合的元素都是Entry，是Node的父类，因为父类可以作为子类对象的引用，所以每个Entry都指向了一个Node节点
		  */
		 
		 
		 //常用方法
		 //添加是put
		 //remove 根据键删除
		 //get 根据键获取值，返回值是Object
		 //size 获取元素个数
		 //isEmpty 判断元素个数是否为0
		 //contains 是否包含该键值
		 //clear 清楚所有
	}
}
