package collection;

import java.util.HashSet;

//一点细节关于TreeSet
public class TreeSetPractice {

	@SuppressWarnings("all")
	public static void main(String[] args) {
		HashSet set=new HashSet();
		Person person1=new Person(100,"yyf");
		Person person2=new Person(50,"dmy");
		set.add(person1);
		set.add(person2);
		
		//首先，关键点来了，改变了person1的name，会发生什么
		//它会改变挂到table上的Node的值，因为挂上去的就是他，
		//然后最关键的，这个操作因为是在加到table表里之后的操作，也就是说添加节点时计算的
		//hash值已经生成，这个操作不会改变它的hash值，
		//---》这个操作改变了内容，但没有改变已经生成的hash值
		
		person1.name="zyx";///               
		
		//remove的时候就会发现，按照new Person（100,"zyx"）返回的hash值去找table表
		//里面没有一个这样的对象，因为person1挂载到了new Person(100,"yyf")
		// 这个对象的hash值返回的索引的位置，remove自然就会失败
		
		set.remove(new Person(100,"zyx"));
		System.out.println(set);
		
		//添加节点也是一样，他去找new Person(100,"zyx")这个对象返回的hash值算出来的索引位置
		//会发现内个地方就没有和他一样的，然后添加进去
		set.add(new Person(100,"zyx"));
		System.out.println(set);
		
		//这个添加就可以找到person1所在的位置，因为person1的位置就是拿这个算的嘛，进去之后
		//他发现里面有元素，那就会调用equals方法，但equals方法已经重写了，他比较的是里面的
		//id和name，person1的name早被改了，那么他就会把这个节点也加入到table里
		set.add(new Person(100,"yyf"));
		System.out.println(set);
		
		
		
		
		//很细节，也说明了set并不是完全无法存入相同的数据，如果对挂载元素进行修改，那就要很谨慎
		
	}
}
class Person{
	public int id;
	public String name;
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	
}