package io_Stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

//�����л�
public class ObjectInputStream_ {

	public static void main(String[] args) {
		//ָ�������л��ļ�
		String path="E:\\javaTestFile\\ObjectOutput.txt";
		
		ObjectInputStream ois=null;
		//
		
		try {
			ois=new ObjectInputStream(new FileInputStream(path));
			//�����л�����˳���д��˳��һ��Ҫһ��
			System.out.println(ois.readInt());
			System.out.println(ois.readBoolean());
			System.out.println(ois.readUTF());
			Object dog=null;
			//��������ʱ����Ҫ�׳��쳣
			try {
				dog=ois.readObject();//����ֵ��Object����

			} catch (ClassNotFoundException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}		
			//dog�ı���������Object
			System.out.println("dog�����������ǣ�"+dog.getClass());
			System.out.println(dog);
			
			//ʹ��dog�ķ�������dog
			//��Ϊdog�ı���������Object�����������dog�ķ�������Ҫ����ת��
			Dog dog2=(Dog)dog;
			System.out.println(dog2.getName());
			//System.out.println(dog2.getWife());
			//����֮�⻹��һЩϸ����Ҫע�⣺
			//�Ƿ������ObjectInputStream������ļ����õ�����ȡ����Object������ඨ�壬Ҫ�����ò����ඨ�壬��ô��Ͳ�������ת�ͣ����ܶ������в���
			//�������Dog���ڱ�İ������Default�࣬������ļ����޷�ת��ΪDOg�࣬�޷�������һ�����ǻ�ѡ������������Ϊһ��public�࣬����������Ϳ��Է�����
			//default Ȩ��ֻ�б��������ܷ������еķ���������
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
}
