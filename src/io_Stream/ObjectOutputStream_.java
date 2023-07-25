package io_Stream;
//���л���������ݵ��ļ���ʱ�򣬲����������ֵ��������������ͣ������ܹ����ڶ���ʱ�ָ���������
//�����л��������ݴ��ļ��������ʱ�򣬻ظ���������
//������1.ʵ��Serializable�ӿ�  //���ƣ���ǽӿڣ�û�з�����Ҫʵ��
       //2.Externalizable�ӿ� 

//���л�ʱ��static   transient�������л��������棩 ���������εĲ������л��������л������ǵ�ֵ�ᱻ��ΪĬ��ֵ
//���л�����ʱ���ö������е����Զ�Ҫʵ��Serializable�ӿڣ���Ҫ�����л�
//���л��߱��ɼ̳��ԣ��������л�������ҲĬ�Ͽ����л�

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.sun.source.doctree.SerialDataTree;

//ObjectOutputStream  ObjectInputStream Ҳ��ʵ����OutputStream InputStream�ӿڣ����ڴ���������װ����
//���Դ���ڵ���ΪOutputStream InputStream�ӿڵ�ʵ����
public class ObjectOutputStream_ {

	public static void main(String[] args) {
		
		//д���ļ���ʲô���͵�����ν��д�벻�ǰ��ı�д��
		String path="E:\\javaTestFile\\ObjectOutput.txt";
		ObjectOutputStream oos=null;
		
		try {
			//�ڲ��ļ���д��ʱ����û��true�������������д�������Ƿ񸲸��ı�֮ǰ������
			oos =new ObjectOutputStream(new FileOutputStream(path));
			//write
			oos.writeInt(100);//int-->Integer
			oos.writeBoolean(true);//boolean-->Boolean
			oos.writeUTF("�ڵ����ʹ�����");//String�õ�ʱWriteUTF
			oos.writeObject(new Dog(10,"С��"));//дһ��������ȥ
			System.out.println("����д�����");
			
		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		
	}
	
}
//��Ҫ�����л�������ʵ��Serializable�ӿ�
class Dog implements Serializable{
	private int age;
	private String name;
	//private int wife;//�������л�UID֮����ı���Ľṹ�����ı�UID����ô�������ͻ���Ϊ���޸ĵ��ǲ�Ӱ��Ķ�����
	//                 ���������л��Ͳ���ʧ��,
	//        ���������Ե�����������ķ�����Ӧ��������ת�͵�ʱ�򣬱������������������ṹΪ���渳ֵĬ��ֵ��
	//serialVersionUID  ���л��汾�ţ�������߼�����
	/*
	 * ��ִ�����л�ʱ������д����󵽴����У�����ݵ�ǰ��Ľṹ����һ���汾ID��
	 * �������л���ʱ�򣬳����Ƚϴ����е����л��汾ID�͵�ǰ����ṹ�İ汾ID�Ƿ�һ�£�
	 *             ���һ�£������л��ɹ�����һ����ʧ��
	 * ������ǲ���ʽ����һ��serialVersionUID����ô��������Ĭ������һ��UID�����UID����Ľṹʮ������
	 * �����л����ܻᵼ��InvalidClassExpection�쳣
	 */
	private static final long serialVersionUID=1L;
	
	public Dog(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Dog [age=" + age + ", name=" + name + "]";
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public int getWife() {
//		return wife;
//	}
//	public void setWife(int wife) {
//		this.wife = wife;
//	}
	
	
	
}
