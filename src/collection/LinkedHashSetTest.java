package collection;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;



//LinkedHashSet解析
public class LinkedHashSetTest {
 
	public static void main(String[] args) {
		//1.插入顺序和遍历的顺序一致
		//  他的hahs表机制与HashSet一致，但节点属性不同，多了两个结点指针，一个指向上一个添加的元素
		//   一个指向下一个添加的元素，即一个正常的HashSet建立过程中，求完hash值确定索引位置，检查
		//   是否添加，添加的话 求上一个添加的节点，把他的after指向新节点，新节点的befor指向上一个
		//  添加的节点。----------》在hash表外通过befor和after建立了一个基于插入顺序的双向链表
		
		LinkedHashSet lhs=new LinkedHashSet();
	    lhs.add(new String("AAA"));	
	    lhs.add(456);
	    lhs.add(456);
	    lhs.add("hsp");
	    System.out.println(lhs);
	}
	/*
	 //自己打断点走一下就明白了，LinkedhashSet所添加的节点不是之前的Node，而是Entry,他的两个属性before, after，上面提到，LinkedhashSet还维护了两个属性head，tail用来记录
	 //双向链表的头和尾，这样每次加入新元素时就可以直接替换tail指向的元素，其他的基本都与HashSet一致 
    // HashMap.Node subclass for normal LinkedHashMap entries.
     * Node是HashMap的静态内部类
     * Entry是LinkedHashMap的静态内部类
     * --------因为Entry继承了Node，所以调用相同的putVal里的new Node可以转到Entry节点建立
            static class Entry<K,V> extends HashMap.Node<K,V> {
                    Entry<K,V> before, after;
                    Entry(int hash, K key, V value, Node<K,V> next) {
                    super(hash, key, value, next);
                    }
          }

      
    }
	 
	 */
}
