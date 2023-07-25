package collection;

import java.util.HashSet;

//����һ��Employee�࣬private name��age����name��age��ֵ��ͬʱ����ΪԱ����ͬ��������ӵ�HashSet��
public class Practice2 {

	public static void main(String[] args) {
		HashSet hs=new HashSet();
		hs.add(new Employee("yyf",21));
		hs.add(new Employee("zyx",22));
		hs.add(new Employee("dmy",20));
		System.out.println(hs.add(new Employee("yyf",21)));
		//�ȼ���hashcode��������ͬ���������һ��Ԫ��һ������֮��ȽϷ�������Ԫ����ͬ��ȡ�����
		
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
	
	//�����ѡ���Ԫ����ͬ�ͷ�����ͬ��hashֵ
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	//����ѡ�Ĳ�����ͬʱ�ͷ���true
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
