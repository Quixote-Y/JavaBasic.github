package generic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Practice1 {

	public static void main(String[] args) {
		Student student1=new Student("yyf");
		Student student2=new Student("dmy");
		Student student3=new Student("zyx");
		HashMap<String,Student> map=new HashMap<String,Student>();//
		map.put(student1.getName(), student1);
		map.put(student2.getName(), student2);
		map.put(student3.getName(), student3);
		System.out.println(map);
		//
		System.out.println("\n---------Foreach---------");
		Set<String> keySet=map.keySet();
		for(String t:keySet) {
			System.out.println(t+"-"+map.get(t));
		}
		//
		System.out.println("\n---------Iterator---------");
//		Set entrySet=map.entrySet();
//		Iterator iterator=entrySet.iterator();
		//
		Iterator<String> iterator=keySet.iterator();
		while(iterator.hasNext()) {
			String i=iterator.next();
			System.out.println(i+"-"+map.get(i ));
		}
		
		System.out.println("\n---------Iterator2---------");
		
		Set<Map.Entry<String, Student>> entrySet=map.entrySet();
		Iterator<Map.Entry<String, Student>> iterator2=entrySet.iterator();
		while(iterator2.hasNext()) {
			Map.Entry<String,Student> next=iterator2.next();
			System.out.println(next.getKey()+"-"+next.getValue());
		}
		
		
	}
}
class Student{
	private String name;

	public Student(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	};
	
	
}