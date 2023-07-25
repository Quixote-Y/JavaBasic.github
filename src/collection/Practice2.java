package collection;

import java.util.HashSet;

//定义一个Employee类，private name，age。当name和age的值相同时，认为员工相同，不能添加到HashSet中
public class Practice2 {

	public static void main(String[] args) {
		HashSet hs=new HashSet();
		hs.add(new Employee("yyf",21));
		hs.add(new Employee("zyx",22));
		hs.add(new Employee("dmy",20));
		System.out.println(hs.add(new Employee("yyf",21)));
		//先计算hashcode，发现相同，索引与第一个元素一样，但之后比较发现两个元素相同，取消添加
		
		System.out.println(hs);
	}
	
}
class Employee{
	private String name;
	private int age;
	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	//如果你选择的元素相同就返回相同的hash值
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	//当勾选的参数相同时就返回true
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (age != other.age)
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
		return "Employee [name=" + name + ", age=" + age + "]";
	}
	
	
}
