package array;

import java.util.Arrays;

/*
 * ʹ��javabean��������ʵ�ִ洢���ݱ�
 * 
 * ����̽������ʲô�ǣ�Javabean
 * �����javabean��ָ��ͨ��java��
 * �����javabean��ָ���ϸ�javabean��д�淶��д��java��
 * �淶�ǣ�
 *   �ǹ�������
 *   ���ٺ���һ���޲εĹ��캯��
 *   ���Գ�Ա����Ϊprivate������������public
 *   ���е����Ծ���set��get����
 */
public class arrayJavaBean {
	public static void main(String[] args) {
		emps[] a= {
				new emps(1,"����",18,"����","2003"),
				new emps(2,"����",14,"����","2004"),
				new emps(3,"����ǿ",19,"����","2005"),
				new emps(4,"������",17,"����","2006")
		};
		for(emps t:a) {
			System.out.println(t.toString());
		}
		System.out.println(Arrays.toString(a));//���������
		//����ǣ�num=1, name=����, age=18, school=����, clas=2003
		//Arrays.toString�������ǣ�[emps [num=1, name=����, age=18, school=����, clas=2003], emps [num=2, name=����, age=14, school=����, clas=2004], emps [num=3, name=����ǿ, age=19, school=����, clas=2005], emps [num=4, name=������, age=17, school=����, clas=2006]]
        //emps [num=1, name=����, age=18, school=����, clas=2003]�������д��Object.toString����
		//Array.toString������lang�����toString
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
