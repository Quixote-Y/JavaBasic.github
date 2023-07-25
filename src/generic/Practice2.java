package generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//559����ϰ
public class Practice2 {

	public static void main(String[] args) {
		ArrayList<Employee> list=new ArrayList<>();
		
		list.add(new Employee("dmy",1000,2003,01,19));
		list.add(new Employee("yyf",10000,2001,02,06));
		list.add(new Employee("zyx",4000,2001,10,23));
		list.add(new Employee("zyx",4000,2001,11,23));
		//����һ���ҵ���Collections���� sort��������дcomparable�ӿڵ�compare�����������ޱȽ�����sort
		Collections.sort(list);
		System.out.println("-----------Collections.sort--------------");

		System.out.println(list);
		//����˳��
		Collections.shuffle(list);
		System.out.println(list);
		System.out.println("-----------ArrayList.sort(List��Comparator)--------------");
		list.sort(new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				// TODO �Զ����ɵķ������
				
				return o1.compareTo(o2);//ע�⣬sort������TreeMap�Ĺ��첻һ��������˵�ǡ�0����0��=0�������
				             //���������0��һ�飬<=0��һ�飬�ʼ������Ϊ����ֵȫΪ1��0�����޷�����
			}
		});
		System.out.println(list);
	}
}

class Employee implements Comparable<Employee>{
	private String name;
	private int sal;
	private Mydata birthday;
	
	
	
	public Employee(String name, int sal, int year,int month,int day) {
		super();
		this.name = name;
		this.sal = sal;
		this.birthday = new Mydata(year,month,day);
	}
	



	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public int getSal() {
		return sal;
	}




	public void setSal(int sal) {
		this.sal = sal;
	}




	public Mydata getBirthday() {
		return birthday;
	}




	public void setBirthday(Mydata birthday) {
		this.birthday = birthday;
	}




	@Override
	public String toString() {
		return "\nEmployee [name=" + name + ", sal=" + sal + ", birthday=" + birthday + "]";
	}

	@Override
	public int compareTo(Employee o) {
		// TODO �Զ����ɵķ������
		int res=this.name.compareTo(o.name);
		if(res>0) return res;
	
		if(res==0) {
			  res=this.birthday.compareTo(o.birthday);
		}
		return res;
	}

	class Mydata implements Comparable<Mydata>{
		private int month;
		private int day;
		private int year;
		public Mydata(int year,int month, int day ) {
			super();
			this.month = month;
			this.day = day;
			this.year = year;
		}
		public int getMonth() {
			return month;
		}
		public void setMonth(int month) {
			this.month = month;
		}
		public int getDay() {
			return day;
		}
		public void setDay(int day) {
			this.day = day;
		}
		public int getYear() {
			return year;
		}
		public void setYear(int year) {
			this.year = year;
		}
		@Override
		public String toString() {
			return "Mydata ["+"year=" + year+","+"month=" + month + ", day=" + day  + "]";
		}
		@Override
		public int compareTo(Mydata o) {
			// TODO �Զ����ɵķ������
			if(this.year>o.year)return 1;
			if(this.year==o.year) {
				if(this.month>o.month) return 1;
				if(this.month==o.month) {
					if(this.day>o.day) return 1;
				}
			}
			return -1;
		}
		
	}



}
