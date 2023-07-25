package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

//ð��ʵ��List����
public class Practice1 {

	@SuppressWarnings("all")
	public static void main(String[] args) {
		Book book1=new Book("��¥��",100);
		Book book2=new Book("���μ�",2);
		Book book3=new Book("С����",200);
		Book book4=new Book("��ʥ��",2323);
		Book book5=new Book("������",43);
		//��ӵ�List��
		//List��ʵ���������õķ�������һ�µ�
		//�������������԰�����ʵ���඼����һ��
		//List list =new LinkedList();
		//List list =new Vector();
		List list =new ArrayList();
		list.add(book1);
		list.add(book2);
		list.add(book3);
		list.add(book4);
		list.add(book5);
		//�������
		System.out.println(list.toString());
		System.out.println("______________________\n");
		sort(list);
		System.out.println(list);
		//һ�������¼��
		/*����������ģ�
		 * [collection.Book@4232c52b, collection.Book@1877ab81, collection.Book@305fd85d, collection.Book@458c1321, collection.Book@11438d26]
		 *������ǵ�ַ��Ϊʲô�أ����˸�����дtoString������
		 *
		 */
		//ֱ�Ӵ�ӡ
		//[���ƺ�¥��	�۸�100	, �������μ�	�۸�2	, ����С����	�۸�200	, ���ƴ�ʥ��	�۸�2323	, ����������	�۸�43	]
		//�����λ���ӡ�������Ҳ�����ӡ������ʲô�ط������
		//��������ʵʵ��ѭ����ӡ������������������ʽ
		for(Object t:list) {
			System.out.println(t+"\n");
		}
		//������iterator����
		System.out.println("______________________\n");
		Iterator iterator=list.iterator();
		while(iterator.hasNext()) {
			Object obj=iterator.next();
			System.out.println(obj+"\n");
		}
		
	}
	
	//ð��ʵ��List��Book�ļ۸�Ӹߵ�������
	public static void sort(List list){
		int listSize=list.size();
		for(int i=0;i<listSize;i++) {
			for(int j=i+1;j<listSize;j++) {
				//ȡ��List���Ӧλ�õ�Ԫ��
				Book book1=(Book)list.get(i);//����ת�ͣ���Ϊgetȡ������Ĭ����Object����
				Book book2=(Book)list.get(j);
				if(book1.price>book2.price) {
					//��С����
					list.set(i, book2);
					list.set(j,book1);//�ܼ򵥵�Ԫ�ػ���
				}
			}
		}
		
	}
	
}

class Book{
	String name;
	int price;
	public Book(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "����: "+name+"\t"+"�۸�: "+price+"\t";
	}
	
	
	
}
