package collection;

import java.util.Comparator;
import java.util.Objects;
import java.util.TreeMap;
import java.util.TreeSet;


//TreeSet����
public class TreeSetTest {

	@SuppressWarnings("all")
	public static void main(String[] args) {
		//1.TreeSet���޲ι��������������޲ι�����ʱ��������ݶ�����Ȼ�������
		//2.TreeSet����һ�������������Դ���һ���Ƚ����������ࣩ��ָ���������˳��
		
		//TreeSet set=new TreeSet();//�޲ι��캯������������������
		TreeSet set=new TreeSet(new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				// TODO �Զ����ɵķ������
				//1.���ַ�����С���бȽ�
				//�Ȱ�ObjectתΪString��Ȼ�����Ĭ��compareto����
				//return ((String)o1).compareTo((String)o2);//-----------------�������������ֵ��0ʱ��Ҳ���������ַ�����ͬʱ����ô����ַ����Ͳ�����뵽����
				//�������Ա�ıȽϷ���
				//�Ƚ������ַ������ȣ�����������
				return ((String)o1).length()-((String)o2).length();//�������صľ��������ַ����ĳ��ȵĲ�ֵ������0���ŵ���������С��0������������0������ӣ��Ǿ���ζ����һ��������
				                                                  //������������ַ���������ȣ���ȳ����ַ��������ʧ��
			}
			
		});
		set.add("a");
		set.add("a");
		set.add("asada");
		set.add("das");
		set.add("rawa");
		set.add("daa");
		System.out.println(set);
		
		//һЩϸ�ڣ�1.�����ȴ���һ���յ���Num
		//2.Ȼ����ȥ��TreeSet�����һ��NUm��������
		TreeSet tree=new TreeSet();
		tree.add(new Num());///------>һ�����׳�һ������ת���쳣����Ϊ����TreeSet��ʱ��û�д���Ƚ�������ô���Ԫ�ص�ʱ��tree�ͻ�ȥ�����㴫�������Comparable�ӿ�ʵ�ֵ�comparaTo������������
		                   //NUmber��û��ʵ������ӿ�
		
		//------------------����ô����أ�Ҳ�ܼ򵥣���Numʵ��ComparaTo�����ͺ��ˣ�ע�⣬��ʱ�����ޱȽ�����TreeSet�����Comparable���compareTo����Ҳ���ǱȽ�����������

		//TreeMap���compare������Դ�룺
		/*
		   final int compare(Object k1, Object k2) {
                  return comparator==null ? ((Comparable<? super K>)k1).compareTo((K)k2)
                           : comparator.compare((K)k1, (K)k2);-----------------------------����������Ϊnull��ʱ�򣬷���kʵ���˵�Comaparable�ӿڵ�ComparaTo����
            }
		 */
		System.out.println(tree);
	}
}
class Num /*implements Comparable*/{

	/*@Override
	public int compareTo(Object o) {
		// TODO �Զ����ɵķ������
		return 0;
	}*/
	
}
//Դ�룺
  /*1.������Ƚ�����TreeSet���캯����������űȽ�����������TreeSMap�Ĺ��캯��
          public TreeSet(Comparator<? super E> comparator) {
               this(new TreeMap<>(comparator));
           }
    2.����TreeMap�Ĵ��Ƚ����Ĺ��캯��������ִ�а��Լ��Ĺ����������������б�д�Ĺ�����
     public TreeMap(Comparator<? super K> comparator) {
        this.comparator = comparator;
    }
    //��ʼ������
     * 
    3.ִ��add����a����������TreeSet��add
     public boolean add(E e) {
        return m.put(e, PRESENT)==null;
      }
   4 .����m.put��Ҳ����TreeMap��put�������������ֵ�������������put
      public V put(K key, V value) {
          return put(key, value, true);
      }
    5.��һ����put��ִ�У�
     Entry<K,V> t = root;
        if (t == null) {
            addEntryToEmptyMap(key, value);
            return null;
        }
        
     6.�ڶ���addǰ�涼һ����������������put�У�
          ��������ǳ�ʼ��ʱд��ıȽ�����
           Comparator<? super K> cpr = comparator;  
           cmp = cpr.compare(key, t.key);        //���ñȽ�������д��comapre�������Ƚ�Ҫ��ӵĽڵ�����ϵĽڵ㣬ȡ�÷���ֵ
     
     7.���ݷ���ֵ�Ĳ�ͬ��ȡ��ͬ�Ĵ���������������ֵ��0ʱ���Ǿͻ᷵��һ��Ĭ��ֵPRESENT��Ҳ��Ԥʾ�����ʧ�ܣ����Ԫ�ز�����ӵ�tree���˱Ƚ����Ĺ�����������Ĺ����ֺܴ�Ӱ��
     
     
     
     
     
   */
       /*TreeMap��������putȫ��Դ��
        private V put(K key, V value, boolean replaceOld) {
        Entry<K,V> t = root;  //��һ�ε���ʱΪ�գ�֮��͸��ڵ�
        if (t == null) {                      //��һ�ε��õ�ʱ�򣬼��һ�¸��ڵ��Ƿ�Ϊnullɶ��
            addEntryToEmptyMap(key, value);    
            return null;
        }                     
        int cmp;                    //���￪ʼ�Ͷ��ǵ�һ���Ժ���û�ִ�е���
        Entry<K,V> parent;                       //˫��Entry�ڵ�
        // split comparator and comparable paths
        Comparator<? super K> cpr = comparator;          //���ñȽ��������Ƚ����е����ݣ�������ֵ
        if (cpr != null) {                              //�Ƚ�����Ϊnull��Ҳ�������Լ�д�˱Ƚ���
            do {
                parent = t;                           //�ڵ㸳��parent
                cmp = cpr.compare(key, t.key);        //���ñȽ�������д��comapre�������Ƚ�Ҫ��ӵĽڵ�����ϵĽڵ㣬ȡ�÷���ֵ
                if (cmp < 0)                          //����ֵС��0
                    t = t.left;                        //����
                else if (cmp > 0)                      //����0
                    t = t.right;                        //����
                else {                                    //����0
                    V oldValue = t.value;                //������ֵ��oldValue����������Set�����õ�HashMap��map��˫ֵ�洢�������ʼ����mapʱ�͸���һ��Ĭ��ֵ��value������PRESENT
                    if (replaceOld || oldValue == null) {  //�ж��Ƿ�Ҫ�滻��ڵ��value�Ƿ�Ϊnull����������replaceOld��Զ�� true������ʱ�����
                        t.value = value;                    //Ϊ�ջ�Ҫ�滻���ǾͰ�ֵ����t�����ϵĽڵ㣩ֵ
                    }
                    return oldValue;                    //����oldvalue��Ҳ���Ƿ���Ĭ��ֵ��PRESENT
                }
            } while (t != null);            //������Ҷ�ӽڵ�����
        } else {            //�ޱȽ��������
            Objects.requireNonNull(key);
            @SuppressWarnings("unchecked")
            Comparable<? super K> k = (Comparable<? super K>) key;//���û�д���Comparator�Ƚ������Ǿͻ�Ѵ���keyֵת��ΪComparable����
                                                                 //---��Ϊʲô��ת����Ϊ�����ʵ��Comparable�ӿڣ�����ӿ����и�������comparaTo���������������������ļ�ֵ
                                                                  * û��ʵ��Comparable�ӿڣ�û��comparaTO������������ط��ͻᱨ����ת���쳣
            do {
                parent = t;
                cmp = k.compareTo(t.key);
                if (cmp < 0)
                    t = t.left;
                else if (cmp > 0)
                    t = t.right;
                else {
                    V oldValue = t.value;
                    if (replaceOld || oldValue == null) {
                        t.value = value;
                    }
                    return oldValue;
                }
            } while (t != null);
        }
        addEntry(key, value, parent, cmp < 0);//���Entry�ڵ�
        return null;
    }

        */
 
 
 
