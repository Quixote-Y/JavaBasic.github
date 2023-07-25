package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;



//������ϵ���
public class CollectionInterface {
  
	/*
	 * 1.������Ҫ�����飨���м��ϣ�˫�м��ϣ�
	 *        Collection�ӿ���Iterable�ӿڵ�����--�����е�Collectionʵ����������Ե���һ��iterator����
	 * 2.Collection�ӿ���������Ҫ���ӽӿ�List Set�����ǵ�ʵ�����඼�ǵ��м���
	 *   List-->arryList LinkedList  Vector
	 *   Set -->TreeSet HashSet
	 * 3.Map�ӿڵ�ʵ��������˫�м��ϣ���ŵ��Ǽ�ֵ��
	 *   Map-->HashMap TreeMap Hashtable
	 */
	@SuppressWarnings("all")
	public static void main(String[] args) { 
	//Collection���÷���
	//Collection�Ǹ��ӿڣ��޷�ʵ����������ʹ������ʵ������Arraylist����
		
		Collection col=new ArrayList();//�ӿڲ��ܴ���ʵ�����������������ñ�������
		                               //��ʱcolֻ��ʹ��Collection�ӿ���ķ���������ʹ��
		                               //List������ӵķ�����ArrayList��List��ʵ������
		//���Ԫ�� add����
		col.add("jack");
		col.add(100);
		col.add("mot");
		col.add(true);//add�Ķ�����Object��˵���κεĶ��󶼿�����ӽ���
		System.out.println("col: "+col);
		//ɾ������Ԫ�� remove
		//col.remove(0);//ɾ����һ��Ԫ��"jack"---->���ԣ�Collection��û�ж���Ӧ����List�ﶨ����
		col.remove(100);//ָ��ɾ��col���100
		System.out.println("col: "+col);
		//�鿴Ԫ���Ƿ���� contains
		
		System.out.println(col.contains("mot"));
		
		//��ȡԪ�ظ���
		System.out.println(col.size());
		//�ж��Ƿ�Ϊ�� isEmpty
		System.out.println(col.isEmpty());
		//��� clear
		col.clear();
		System.out.println("col: "+col);
		//��Ӷ��Ԫ�� addAll
		//����ֱ�����һcollection�ӿڵ�ʵ���࣬һ����ȫ�����
		ArrayList al=new ArrayList();
		al.add("HK");
		al.add("UK");
		al.add("DK");
		col.addAll(al);
		System.out.println("col: "+col);
		//ɾ�����Ԫ�� removeAll
		col.add("WK");
		col.removeAll(al);
		System.out.println("col: "+col);//wk
		
		 //Collection�ӿڱ�����������ַ�ʽ
		//������---
		// Collection�ӿ���Iterable�ӿڵ�����
		//--�����е�Collectionʵ����������Ե���һ��iterator����������������Է���
		//һ��Iterator������������Ҫʹ�����е�����������hasNext���ж�ָ����ָλ����һ��λ���Ƿ���
		//Ԫ�أ�next��������ָ�����ƣ���ȡ��ָ���Ԫ�أ�
		//��������ʼ���ɹ�ʱ��ָ��ָ��ͷ����ûָ���һ��Ԫ��
		//���������ص�Ԫ��������Object�����ݶ�̬�󶨣�����ʱ���ͻ��Զ�ת��Ϊ��ʵ����������ʵ���
		
		//����ʹ�õ�����������һ��col
		col.addAll(al);
		//1.�õ�col��Ӧ�ĵ�����
		Iterator iterator =col.iterator();
		//2.ʹ��whileѭ��
		 while(iterator.hasNext()) {
			 //������һ��Ԫ��
			 Object obj=iterator.next();//��������ΪObject������ʱ����
			 System.out.println(obj);
		 }
		 
		 //������ָ������֮����ô��λ�أ����³�ʼ��
		 iterator =col.iterator();
		 System.out.println("_________________");
		 while(iterator.hasNext()) {
			 //������һ��Ԫ��
			 Object obj=iterator.next();//��������ΪObject������ʱ����
			 System.out.println(obj);
		 }
		 
		 System.out.println("_____��������ǿfor______");
		  //��ǿfor
		 //��ǿfor��ʵ�ַ�ʽ���ǵ����������˵������Ĳ���
		 for(Object t:col) {
			 System.out.println(t);
		 }
		 
	}
}
