package collection;

import java.util.HashSet;

//创建一个Employee类，该类包含：private name， sal， birthday
//birthday为Mydata类型，属性有year month，day
//当name 和birthday的值相同时，认为是相同的员工，不能添加到HashSet中
public class Practice3 {
	

	public static void main(String[] args) {
		HashSet hs=new HashSet();
		hs.add(new Employee2("yyf",100,2001,02,06));
		hs.add(new Employee2("dmy",200,2001,02,31));
		boolean a=hs.add(new Employee2("dmy",200,2001,02,31));
		System.out.println(a);
		System.out.println(hs);
	}
}
class Employee2{
	private String name;
	private int sal;
	private Mydata birthday;
	
	public Employee2(String name, int sal, int year,int month,int day) {
		super();
		this.name = name;
		this.sal = sal;
		this.birthday =new  Mydata(year,month,day);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
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
		Employee2 other = (Employee2) obj;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
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
		return "Employee2 [name=" + name + ", sal=" + sal + ", birthday=" + birthday + "]";
	}
	class Mydata{
		int year;
		int month;
		int day;
		public Mydata(int year, int month, int day) {
			super();
			this.year = year;
			this.month = month;
			this.day = day;
		}

		@Override
		public String toString() {
			return "Mydata [year=" + year + ", month=" + month + ", day=" + day + "]";
		}
//注意一个点，老搞混，hash值是用来确定索引的，不是用来对比元素是否相等的
		@Override
		public int hashCode() {
			return 10;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Mydata other = (Mydata) obj;
			if (day != other.day)
				return false;
			if (month != other.month)
				return false;
			if (year != other.year)
				return false;
			return true;
		}
		
		
	}
	

	
	
}
