package collection;

import java.util.HashSet;

//����һ��Employee�࣬���������private name�� sal�� birthday
//birthdayΪMydata���ͣ�������year month��day
//��name ��birthday��ֵ��ͬʱ����Ϊ����ͬ��Ա����������ӵ�HashSet��
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
//ע��һ���㣬�ϸ�죬hashֵ������ȷ�������ģ����������Ա�Ԫ���Ƿ���ȵ�
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
