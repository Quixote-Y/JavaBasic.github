package collection;

import java.util.ArrayList;
import java.util.List;


//Collection���ӽӿ�List
public class ListInterface {

	public static void main(String[] args) {
		/*List
		 * 1.List�е�����Ԫ������˳��ģ��ҿ��ظ�
		 * 2.list�е�ÿ��Ԫ�ض��ж�Ӧ��˳��������֧������
		 * 3.List�кܶ�ʵ���࣬���õ���ArrayList LinkedList  Vector
		 */
		
		//���÷���
		List list=new ArrayList();
		//���Ԫ�� add
		list.add("����");
		list.add("����");
		list.add("����");
		//��ָ������������Ԫ��
		list.add(1, "jack");
		list.add(1,"tom");
		
		System.out.println(list);
		
		List list2=new ArrayList();
		list2.add(1);
		list2.add(2);
		list2.add(3);
		//��list2��ӵ�list��
		list.addAll(list2);
		
		System.out.println(list);
		
		//��list2�Ƴ�list
		list.removeAll(list2);
		
		System.out.println(list);
		
		//��list2��ӵ�list����1��λ��
		list.addAll(1, list2);
		System.out.println(list);
		
		//����3���ڵ�����
		System.out.println(list.indexOf(3));
		//���һ��3���ڵ�����
		System.out.println(list.lastIndexOf(3));
		
		//remove 
		
		//�滻ָ��λ�õ�Ԫ��set
		list.set(3, "�滻");
		System.out.println(list);
		
		//����ָ��λ��������Ӽ��ϣ�ǰ�պ�subList
		List list3=list.subList(4, 6);
		System.out.println(list3);
		//��ȡָ��λ�õ�Ԫ��
		Object get1=list.get(3);
		System.out.println(get1);

	}
}
