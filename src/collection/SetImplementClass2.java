package collection;

import java.util.HashMap;
import java.util.HashSet;



//HashSet�ײ�ʵ��Դ��
public class SetImplementClass2 {

	@SuppressWarnings("all")
	public static void main(String[] args) {
		//���ۣ�
		/*
		 * 1.HashSet�ײ���HashMap
		 * 2.���һ��Ԫ��ʱ���ȵõ�hashֵ��Ȼ������㷨ת��Ϊtable�������ֵ
		 * 3.�ҵ��洢����table�����������λ���Ƿ��Ѿ����Ԫ��
		 * 4.���û��ֱ�����
		 * 5.����У��͵���equals�Ƚϣ������ͬ���ͷ�����ӣ������ͬ�������������β
		 * 6.JAva8�У����һ������Ԫ�ظ������������TREEIFY_THRESHOLD��Ĭ����8��������
		 *   table��Ĵ�С>=MIN_TREEIFY_CAPACITY��mĬ��64�����ͻ�Ը���������к��������
		 *   ����ߴ洢Ч��
		 */
		
		//Դ��׷�ݣ�
		HashSet hashSet=new HashSet();
		hashSet.add("java");//T
		hashSet.add("john");//T
		hashSet.add("java");//F
		//��HashSet hashSet=new HashSet();�����¶ϵ�
		/*
		  1.ִ��HashSet��������HashMap
		  
		   public HashSet() {
                  map = new HashMap<>();
                  }
		  2.ִ��add����
		  
		  public boolean add(E e) {            //e=��java��
	        return map.put(e, PRESENT)==null; }//��static��PRESENT = new Object();
	                                          //PRESRENTһ���յľ�̬object��ռ��
	                          //�ӵ�6�����Կ�������ɹ�����null����T����Ϊfalse
	      3.ִ��put����
	      
	      public V put(K key, V value) {
                return putVal(hash(key), key, value, false, true);
           }
          4.ִ��hash(key)���õ�key=��java����hashCode��ֵ 
            �㷨�ǣ�(h = key.hashCode()) ^ (h >>> 16)
            ����Ҳ���Ǽ򵥵�hashCode��hahshCode��λ��������16λ��������ײ
            
          static final int hash(Object key) {
                   int h;
                   return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
           }
           5.�õ�hashֵ������put����
           
         public V put(K key, V value) {
             return putVal(hash(key), key, value, false, true);
         }
    
          6.����putVal����------>�ؼ�������
            �ؼ������������Ϊ��hashֵ��key�����ݣ�value��PRESNENT
            
        final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
                   
        Node<K,V>[] tab; Node<K,V> p; int n, i;//������ʱ������ʼ����һ��Node����tab��һ���ڵ�p
        
               //table��HashMap��һ�����飬����������Node[]��������hashmap���������transient Node<K,V>[] table;
              //��������˼�ǣ���table=null����table����Ϊ0��ʱ��ִ��tab = resize()��n=tab.length;
               //�����г�ʼ����resize��ʼ����һ�γ�ʼ��Ϊ��С  16
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
            
                 //�����ó���-1����hashֵ�õ����key������Ԫ�أ���table���������λ�ã�Ȼ������λ�ø�����ʱ�ڵ�p�����ж��Ƿ�Ϊ��----��������p=tab��i��
                //�ǿգ��ʹ����ڵ㣬�洢����
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
            
                //���ǿգ�
        else {
            Node<K,V> e; K k;     //������ʱ�ڵ�e������k
            
                 //�������Ϊʲônew Stringȴ����add�ɹ���ԭ������
                  
                 //�жϽڵ�p��ָ��Ľڵ��hashֵ��Ҳ�������λ�ò��������ݽڵ��p��ָ��ľ����Ѿ������ŵ�����ڵ㣬��һ������hashֵ��
                 // Ҫ��������ڵ��hashֵһ��һ����
                  * ���һ�������ң��������ݺ�Ҫ���������һ��==����.equals��ͬ�����ǾͰ�p����e��Ҳ����eָ�����Ѿ�����Ľڵ㣬������Ҫ��Ľڵ�--��
                  *              �����õ���.equals�������Ǿ���ζ����Ϊ��̬�󶨻��ƵĴ���������ȫ������д��ġ�equals������ʵ���������ĳ����Ϣ��ȾͲ������
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
                *����ڵ�p�����������ڵ�������
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                
                *��������ǣ�hashֵ��һ����Ҳ�������ڵ㣬
            else {
                for (int binCount = 0; ; ++binCount) {   //һ������ѭ��
                    if ((e = p.next) == null) {         //�жϽڵ���һ���Ƿ�Ϊ�գ���Ҫ���ж��Ƿ���β�ڵ�
                    
                        p.next = newNode(hash, key, value, null);       // �����β�ڵ㣬�ǾͰ�Ҫ����Ľڵ�ӵ�������
                                                                       //--->��һ������ο���Ϳ������׵����һ���ڵ㻹û�������Ǿ���ζ��û����ͬ��Ԫ��
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                           //TREEIFY_THRESHOLD��һ��ֵ���ж��Ƿ�Ӧ�ð���һ������������Ĭ��ֵ��8������һ����������8���ڵ�֮��ͻ����
                        
                            treeifyBin(tab, hash);
                            //�����������ķ��������滹��һ���жϣ�Դ���������ģ�
                             * if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
                                       resize();
                               //������˵�����������ǿյĻ��ߣ�����(n = tab.length) < MIN_TREEIFY_CAPACITY)
                                * Ҳ���Ǳ�ĳ���<MIN_TREEIFY_CAPACITY��64��,���ʱ��ʹ��resize����������table������ֱ��תΪ�������MIN_TREEIFY_CAPACITYĬ��ֵ��64
                           //�ܵ���˵����һ�����Ľڵ�������8�������ϣ����ұ�ĳ��ȴﵽ��64����ô�������ͻᱻ����
                        break;     
                    }
                    
                    //���hashֵ��ȣ���ʵ����һ��������ÿһ���ڵ㶼Ҫ�ж��Ƿ��Ҫ����ڵ��hashֵ��ͬ�������ݻ�.equals��ͬ
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;       //�����ͬ��ֱ�ӷ���
                    p = e;      //������Ǳ�����ԭ���ڿ�ͷ��e=p.next;�ڽ�β��p=e;����ָ�뽻��ʵ�ֱ���
                }
            }
            
             //�����e��ֵʱe=p.next;��p�����һ���ڵ�ʱ��p.nextҲ����null���ǲ�Ϊnull��ζ��û�����һ���ڵ���������ˣ�����ͬ�Ľڵ�
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                    
                afterNodeAccess(e);
                
                return oldValue;//����
            }
        }
        //���ִ�е��⣬˵������û��ִ�У�˵���ڵ���ӵ����һ��λ����
        ++modCount;                 //��¼�޸Ĵ���
        if (++size > threshold)    //threshold����ֵ����table����Ľڵ��������нڵ㣬�������Ҳ�㣬������ֵ��ʱ�����ݷ���
            resize();
        afterNodeInsertion(evict);//�������û��ʵ�֣��ǿյķ�������Ҫ����������ʵ������ӹ���
        return null;           //����ɹ�����null
    }


     8.����resize������һ���֣���Ҫ��һ��threshold---���� ֵ
       final Node<K,V>[] resize() {
        Node<K,V>[] oldTab = table;               //oldTabָ�����еı�table
        int oldCap = (oldTab == null) ? 0 : oldTab.length; //���Ǽ�¼�ɱ�ĳ���
        int oldThr = threshold;                  //�ɵ���ֵ
        int newCap, newThr = 0;                   //��ֵ��ʼ��
        
        //����оɵı�
        if (oldCap > 0) {
            if (oldCap >= MAXIMUM_CAPACITY) {//�Ѿ���������������޷�����
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&//������²��������洴������
                     oldCap >= DEFAULT_INITIAL_CAPACITY)
                newThr = oldThr << 1;                  // ��ֵ����
        }
        else if (oldThr > 0) // initial capacity was placed in threshold
            newCap = oldThr;
            
            //����ǵ�һ�γ�ʼ����tableΪnull
        else {               // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY;         //��ʼĬ������ΪDEFAULT_INITIAL_CAPACITY��16��
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY); 
            //��ʼĬ����ֵthrsholdΪDEFAULT_LOAD_FACTOR��װ������0.75�� * ��16��DEFAULT_INITIAL_CAPACITY��Ҳ����12
        }
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                      (int)ft : Integer.MAX_VALUE);
        }
        threshold = newThr;
		 */
		
		//�������һЩ���۵�һЩ����
		//3.��һ��HashSet����һ�����ݽṹ
		HashSet hs=new HashSet();
		for(int i=0;i<10;i++) {
			hs.add(new Dog1("i",i));
		}
		System.out.println(hs);//��ϵ㷽�㿴�ṹ��eclipse��֪��զ��������ʾHashSet�������ṹ������
	}
}
//1.��дһ��class
class Dog1{
	String name;
	int num;
	public Dog1(String name, int num) {
		super();
		this.name = name;
		this.num = num;
	}
	//2.
	//����hashcode����--��HashSetͬ��hashֵ���ж����Ԫ��Ӧ�ô�ŵ�����λ�ã���ô���ǿ���ͨ����д���hashCode�������ֶ���������ŵ���
	@Override
	public int hashCode() {
		//final int prime = 31;
		//int result = 1;
		//result = prime * result + ((name == null) ? 0 : name.hashCode());
		//result = prime * result + num;
		//return result;
		//ֱ�ӷ��ظ���ֵ
		return 100;
	}
	//��ô����˵�ͻ����е�Dog�඼��һ��������
	//���������д.equals���������ֿ�������ָ��Ԫ����Ȳ��ܴ���
	
	

	
}