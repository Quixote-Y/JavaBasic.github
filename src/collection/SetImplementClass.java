package collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//Set�ӿ����
public class SetImplementClass {

	@SuppressWarnings("all")
	public static void main(String[] args) {
		//1.set�ӿڵ�ʵ����Ķ��󣬲��ܴ���ظ�Ԫ�أ��������һ��null
		//2.set�ӿڶ����ŵ������������
		//3.set�ӿ���Ȼ���������ģ���Ȼȡ��ʱ��˳��������˳��һ�£����ǹ̶���
		//��set��ʵ����HashSet����֤һ��
		Set set =new HashSet();
		set.add("john");
		set.add("lucy");
		set.add(null);
		set.add("spe");
		System.out.println(set);
		set.add("dad");
		System.out.println(set);
		
		//����
		//������
		Iterator it=set.iterator();
		while(it.hasNext()) {
			Object obj=it.next();
			System.out.print(obj+"\t");
		}
		//��ǿfor
		System.out.println("\n=========for===========");
		for(Object obj:set) {
			System.out.print(obj+"\t");
		}
		//setû��get���������Բ�������ͨforѭ��ʵ�ֱ���
		
		/*HashSet��
		 * 1.��������
		 * public HashSet() {
                map = new HashMap<>();
           }
           ���ĵײ���HashMap
           2.�����Դ�null����ֻ����һ��
           3.����֤��ŵ������������
           4.HashSet���������ͬ��Ԫ�ض���
		 */
		//����set
		set=new HashSet();
		System.out.println(set);
		//4.HashSet���������ͬ��Ԫ�ض���
		set.add("Lucy");//T
		set.add("Lucy");//F
		set.add(new Dog("tom"));//T
		set.add(new Dog("tom"));//T,��Ϊ�ǲ�ͬ������������
		
		//------
		set.add(new String("sda"));//T
		set.add(new String("sda"));//F,������ܼ��룿������������������
		System.out.println(set);
		//������ת��SetImplementClass2��SetԴ�룡��������
	}
}
class Dog{
	String name;

	public Dog(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + "]";
	}
	
}