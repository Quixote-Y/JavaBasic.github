package collection;

import java.util.Hashtable;

//Hashtable����
public class HashTableTest {

	public static void main(String[] args) {
		Hashtable table=new Hashtable();//С�ĵ㣬Hashtable��table��tСд
		for(int i=0;i<10;i++) {
			table.put("hello"+i, i);
		}
		table.put("hello2", 100);//keyֵ��ͬ�滻
		
		//��ŵ��Ǽ�ֵ��
		//Hashtable�ļ���ֵ������Ϊnull��������׳�NullPointerException
		//ʹ�÷�����hashMap����һ��
		//hashtable���̰߳�ȫ�ģ�hashMap���̲߳���ȫ��
		
		//1.�ײ������� Hashtable$Entry[] ,��ʼ����СΪ 11
		//2.�ٽ�ֵ threshold =8
		//3.���ݻ��ƣ�
		/*Դ�룺
		protected void rehash() {
        int oldCapacity = table.length;
        Entry<?,?>[] oldMap = table;

        // overflow-conscious code
        int newCapacity = (oldCapacity << 1) + 1;
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            if (oldCapacity == MAX_ARRAY_SIZE)
                // Keep running with MAX_ARRAY_SIZE buckets
                return;
            newCapacity = MAX_ARRAY_SIZE;
        }
        Entry<?,?>[] newMap = new Entry<?,?>[newCapacity];

        modCount++;
        threshold = (int)Math.min(newCapacity * loadFactor, MAX_ARRAY_SIZE + 1);
        table = newMap;

        for (int i = oldCapacity ; i-- > 0 ;) {
            for (Entry<K,V> old = (Entry<K,V>)oldMap[i] ; old != null ; ) {
                Entry<K,V> e = old;
                old = old.next;

                int index = (e.hash & 0x7FFFFFFF) % newCapacity;
                e.next = (Entry<K,V>)newMap[index];
                newMap[index] = e;
            }
        }
    }
    
    //���������int newCapacity = (oldCapacity << 1) + 1;//*2+1
		 */
	}
}
