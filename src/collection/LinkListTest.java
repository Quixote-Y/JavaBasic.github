package collection;

import java.util.LinkedList;

//LinkList���ƽ���
public class LinkListTest {

	public static void main(String[] args) {
		//LinkedListʵ����˫�������˫����е��ص�
		//��������κ�Ԫ�أ�����null
		//�̲߳���ȫ���޷�ʵ��ͬ��
		//CRUD--����ɾ�Ĳ�
		LinkedList linkedList =new LinkedList();
		linkedList.add(1);
		linkedList.add(2);
		//Դ�������
		/*
		 *   ���ȣ�����֪������LinkList��������У�  first��ָ�������ͷ
		 *                                         last ��ָ�������β
		 *                                         size�� ����ĳ���
		 *                                         modCount�� �޸Ĵ���
		 *                                        item  ���洢������
		 *    1.
		 *       public boolean add(E e) {
                    linkLast(e);
                    return true;
                    }
                    
              2. void linkLast(E e) {
                     final Node<E> l = last;
                     final Node<E> newNode = new Node<>(l, e, null);
                     last = newNode;
                     if (l == null)
                         first = newNode;
                     else
                          l.next = newNode;
                     size++;
                     modCount++;
                      }      
                      //��һ���򵥵�˫�����������ָ�봦��ͺã�
                       * ɾ������޸Ľڵ��ʱ��ע���ָ�뽻��
		 */
		
		//�Ĳ��ArrayList����
		//��ɾ��LinkedList����
		
	}
}
