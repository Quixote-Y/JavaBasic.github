package collection;

import java.util.Comparator;
import java.util.Objects;
import java.util.TreeMap;

//TreeMap����
public class TreeMapTest {

	@SuppressWarnings("all")
	public static void main(String[] args) {
		//1.��������TreeSetһ�£�����һЩЩϸ�ڷ��棬��ΪTreeSet�ײ����TreeMap
		//2.�޲ι�������������������
		//   ���Ƚ����Ĺ����������Ƚ�������ֵ�Ĳ�ͬ���в�ͬ��Ч��
		
		//TreeMap map=new TreeMap();//���Կ���������˳��ͼ���˳�����޹ص�
		//�������ô��Ƚ����Ĺ��캯��
		TreeMap map=new TreeMap(new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				// TODO �Զ����ɵķ������
				//����k��String���Ĵ�С˳������
				//return ((String)o1).compareTo((String)o2);
				//����K�ĳ���������
				return ((String)o1).length()-((String)o2).length();
				//��һ�������Ļ��������ʲô{����=Wangba }���ܼ򵥣���Դ��
			}
			
		});
		map.put("����","Lisi ");
		map.put("����","Wangwu ");
		map.put("����","Zhaoliu ");
		map.put("����","Sanqi ");
		map.put("����","Wangba ");
		
		System.out.println(map);
		
	}
}

    //Դ�������
    /* 
      1.TreeSet��ʼ����ֱ�ӵ��ô��Ƚ����Ĺ��캯�����ѱȽ��������Լ���compatator����
           public TreeMap(Comparator<? super K> comparator) {
                  this.comparator = comparator;
            }
            
       2.ִ��put���
            map.put("����","Lisi ");
       3.����put����������������put����TreeSet��ͬ������ĵڶ�������value������Ĭ��ֵ
         PRESENT�������û������value������������������true
            public V put(K key, V value) {
                  return put(key, value, true);
            }
       4.ִ������������put��
  
          private V put(K key, V value, boolean replaceOld) {
        Entry<K,V> t = root;  //��һ�ε���ʱEntryΪ�գ�֮��͸��ڵ�
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
                    V oldValue = t.value;                   //�Ƚ�������ֵ����0���ǾͰ�������Ϣ�е�value����oldValue
                    if (replaceOld || oldValue == null) {  //�ж��Ƿ�Ҫ�滻��ڵ��value�Ƿ�Ϊnull����������replaceOld��Զ�� true������ʱ����ģ������Ļ���ʵ��仰�϶�ִ��
                        t.value = value;                    //Ϊ�ջ�Ҫ�滻���ǾͰ�ֵ����t�����ϵĽڵ㣩ֵ���������ζ�ŵ�����ֵΪ0��ʱ��
                                                             //�������Ͱ�������key������ͬһ���ˣ�ֻ�滻�˾ɵ�ֵ�����ı����ļ�ֵ����Ҳ��Ϊʲô��������{����=Wangba}��ԭ�� 
                    }
                    return oldValue;                    //����oldvalue��
                }
            } while (t != null);            //������Ҷ�ӽڵ�����
        } else {            //�ޱȽ��������
            Objects.requireNonNull(key);
            @SuppressWarnings("unchecked")
            Comparable<? super K> k = (Comparable<? super K>) key;
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
 
