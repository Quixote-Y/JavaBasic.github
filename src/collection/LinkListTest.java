package collection;

import java.util.LinkedList;

//LinkList机制解析
public class LinkListTest {

	public static void main(String[] args) {
		//LinkedList实现了双向链表和双向队列的特点
		//可以添加任何元素，包括null
		//线程不安全，无法实现同步
		//CRUD--》增删改查
		LinkedList linkedList =new LinkedList();
		linkedList.add(1);
		linkedList.add(2);
		//源码解析：
		/*
		 *   首先：必须知道的是LinkList里的属性有：  first：指向链表的头
		 *                                         last ：指向链表的尾
		 *                                         size： 链表的长度
		 *                                         modCount： 修改次数
		 *                                        item  ：存储的数据
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
                      //就一个简单的双向链表，留意点指针处理就好，
                       * 删除添加修改节点的时候注意点指针交换
		 */
		
		//改查多ArrayList好用
		//增删多LinkedList好用
		
	}
}
