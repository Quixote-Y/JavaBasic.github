package collection;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;



//LinkedHashSet����
public class LinkedHashSetTest {
 
	public static void main(String[] args) {
		//1.����˳��ͱ�����˳��һ��
		//  ����hahs�������HashSetһ�£����ڵ����Բ�ͬ�������������ָ�룬һ��ָ����һ����ӵ�Ԫ��
		//   һ��ָ����һ����ӵ�Ԫ�أ���һ��������HashSet���������У�����hashֵȷ������λ�ã����
		//   �Ƿ���ӣ���ӵĻ� ����һ����ӵĽڵ㣬������afterָ���½ڵ㣬�½ڵ��beforָ����һ��
		//  ��ӵĽڵ㡣----------����hash����ͨ��befor��after������һ�����ڲ���˳���˫������
		
		LinkedHashSet lhs=new LinkedHashSet();
	    lhs.add(new String("AAA"));	
	    lhs.add(456);
	    lhs.add(456);
	    lhs.add("hsp");
	    System.out.println(lhs);
	}
	/*
	 //�Լ���ϵ���һ�¾������ˣ�LinkedhashSet����ӵĽڵ㲻��֮ǰ��Node������Entry,������������before, after�������ᵽ��LinkedhashSet��ά������������head��tail������¼
	 //˫�������ͷ��β������ÿ�μ�����Ԫ��ʱ�Ϳ���ֱ���滻tailָ���Ԫ�أ������Ļ�������HashSetһ�� 
    // HashMap.Node subclass for normal LinkedHashMap entries.
     * Node��HashMap�ľ�̬�ڲ���
     * Entry��LinkedHashMap�ľ�̬�ڲ���
     * --------��ΪEntry�̳���Node�����Ե�����ͬ��putVal���new Node����ת��Entry�ڵ㽨��
            static class Entry<K,V> extends HashMap.Node<K,V> {
                    Entry<K,V> before, after;
                    Entry(int hash, K key, V value, Node<K,V> next) {
                    super(hash, key, value, next);
                    }
          }

      
    }
	 
	 */
}
