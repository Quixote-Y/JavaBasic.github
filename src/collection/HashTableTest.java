package collection;

import java.util.Hashtable;

//Hashtable解析
public class HashTableTest {

	public static void main(String[] args) {
		Hashtable table=new Hashtable();//小心点，Hashtable，table，t小写
		for(int i=0;i<10;i++) {
			table.put("hello"+i, i);
		}
		table.put("hello2", 100);//key值相同替换
		
		//存放的是键值对
		//Hashtable的键和值都不能为null，否则会抛出NullPointerException
		//使用方法与hashMap基本一致
		//hashtable是线程安全的，hashMap是线程不安全的
		
		//1.底层有数组 Hashtable$Entry[] ,初始化大小为 11
		//2.临界值 threshold =8
		//3.扩容机制：
		/*源码：
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
    
    //扩容语句是int newCapacity = (oldCapacity << 1) + 1;//*2+1
		 */
	}
}
