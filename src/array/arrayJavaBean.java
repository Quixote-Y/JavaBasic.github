package array;

import java.util.Arrays;

/*
 * 使用javabean和数组来实现存储数据表
 * 
 * 首先探讨以下什么是：Javabean
 * 广义的javabean是指普通的java类
 * 狭义的javabean是指按严格javabean编写规范编写的java类
 * 规范是：
 *   是公共的类
 *   至少含有一个无参的构造函数
 *   属性成员必须为private，方法必须是public
 *   所有的属性均有set和get方法
 */
public class arrayJavaBean {
	public static void main(String[] args) {
		emps[] a= {
				new emps(1,"杨玉甫",18,"西电","2003"),
				new emps(2,"王五",14,"西电","2004"),
				new emps(3,"李晓强",19,"西电","2005"),
				new emps(4,"杨玉龙",17,"西电","2006")
		};
		for(emps t:a) {
			System.out.println(t.toString());
		}
		System.out.println(Arrays.toString(a));//这个方法是
		//存的是：num=1, name=杨玉甫, age=18, school=西电, clas=2003
		//Arrays.toString出来的是：[emps [num=1, name=杨玉甫, age=18, school=西电, clas=2003], emps [num=2, name=王五, age=14, school=西电, clas=2004], emps [num=3, name=李晓强, age=19, school=西电, clas=2005], emps [num=4, name=杨玉龙, age=17, school=西电, clas=2006]]
        //emps [num=1, name=杨玉甫, age=18, school=西电, clas=2003]这个是重写的Object.toString内容
		//Array.toString调用了lang包里的toString
	}

}

class emps{
	private int num;
	private String name;
	private int age;
	private String school;
	private String clas;
	public emps(int num, String name, int age, String school, String clas) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
		this.school = school;
		this.clas = clas;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getClas() {
		return clas;
	}
	public void setClas(String clas) {
		this.clas = clas;
	}
	@Override
	public String toString() {
		return "emps [num=" + num + ", name=" + name + ", age=" + age + ", school=" + school + ", clas=" + clas + "]";
	}
	
}
