package collection;

import java.util.Arrays;

//HashSet�ĵײ�ʵ��HashMap��ʵ�ַ�ʽ --���ڵ��
public class HashMapStract {

	public static void main(String[] args) {
		//ģ��һ��HashSet�ĵײ㣬HashMap
		//����һ�����飬Node[],�����Ϊ��ÿһ���ڵ��ŵ���һ������
		
		Node[] table=new Node[10];//һ����СΪ10�ı�
		Node node1=new Node("john",null);//��ʼ����ʱ����һ���ڵ�Ϊnull
		table[2]=node1;
		Node node2=new Node("jack",null);
		//��node1�ڵ���һ��ָ����
		node1.next=node2;//�����͹ҵ�table[2]������//�����Լ���ϵ㿴һ�����ݽṹ
		System.out.println(Arrays.toString(table));
	}
	
}

class Node{
	String name;
	Node next;
	public Node(String name, Node next) {
		super();
		this.name = name;
		this.next = next;
	}
	@Override
	public String toString() {
		return "Node [name=" + name + ", next=" + next + "]";
	}
	
	
}
