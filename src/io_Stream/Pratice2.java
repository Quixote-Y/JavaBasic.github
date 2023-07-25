package io_Stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Properties;

public class Pratice2 {

	public static void main(String[] args ) {
		//
		
		Properties properties =new Properties();
		ObjectOutputStream oos=null;
		ObjectInputStream ois=null;
		
		try {
			properties.load(new FileInputStream("E:\\javaTestFile\\dog.properties"));
			String name=properties.getProperty("name");
			String color=properties.getProperty("color");
			int age=Integer.parseInt(properties.getProperty("age"));
			//�ַ���תint
			//ObjectתString   object+""
			Dog2 dog=new Dog2(name,age,color);
			System.out.println(dog);
			
			oos =new ObjectOutputStream(new FileOutputStream("E:\\javaTestFile\\dog.dat"));
			oos.writeObject(dog);
			System.out.println("dog���л����");
			
			ois =new ObjectInputStream(new FileInputStream("E:\\javaTestFile\\dog.dat"));
			try {
				Dog2 dogReturn=(Dog2)ois.readObject();
				System.out.println(dogReturn);
			} catch (ClassNotFoundException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			try {
				oos.close();
				ois.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
}

class Dog2 implements Serializable {
	private String name;
	private int age;
	private String color;
	public Dog2(String name, int age, String color) {
		super();
		this.name = name;
		this.age = age;
		this.color = color;
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Dog2 [name=" + name + ", age=" + age + ", color=" + color + "]";
	}
	
	
}
