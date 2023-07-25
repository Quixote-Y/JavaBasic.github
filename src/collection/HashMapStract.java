package collection;

import java.util.Arrays;

//HashSet的底层实现HashMap的实现方式 --》节点表
public class HashMapStract {

	public static void main(String[] args) {
		//模拟一个HashSet的底层，HashMap
		//创建一个数组，Node[],数组称为表，每一个节点存放的是一个链表
		
		Node[] table=new Node[10];//一个大小为10的表
		Node node1=new Node("john",null);//初始化的时候下一个节点为null
		table[2]=node1;
		Node node2=new Node("jack",null);
		//把node1节点下一个指向他
		node1.next=node2;//这样就挂到table[2]后面了//可以自己打断点看一下数据结构
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
