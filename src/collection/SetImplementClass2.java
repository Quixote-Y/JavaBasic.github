package collection;

import java.util.HashMap;
import java.util.HashSet;



//HashSet底层实现源码
public class SetImplementClass2 {

	@SuppressWarnings("all")
	public static void main(String[] args) {
		//结论：
		/*
		 * 1.HashSet底层是HashMap
		 * 2.添加一个元素时，先得到hash值，然后根据算法转换为table表的索引值
		 * 3.找到存储数据table表，看这个索引位置是否已经存放元素
		 * 4.如果没有直接添加
		 * 5.如果有，就调用equals比较，如果相同，就放弃添加，如果不同，则添加在链表尾
		 * 6.JAva8中，如果一条链表元素个数超过或等于TREEIFY_THRESHOLD（默认是8），并且
		 *   table表的大小>=MIN_TREEIFY_CAPACITY（m默认64），就会对该条链表进行红黑树树化
		 *   以提高存储效率
		 */
		
		//源码追溯：
		HashSet hashSet=new HashSet();
		hashSet.add("java");//T
		hashSet.add("john");//T
		hashSet.add("java");//F
		//在HashSet hashSet=new HashSet();处打下断点
		/*
		  1.执行HashSet，创建的HashMap
		  
		   public HashSet() {
                  map = new HashMap<>();
                  }
		  2.执行add（）
		  
		  public boolean add(E e) {            //e=“java”
	        return map.put(e, PRESENT)==null; }//（static）PRESENT = new Object();
	                                          //PRESRENT一个空的静态object，占空
	                          //从第6步可以看到加入成功返回null返回T否则为false
	      3.执行put（）
	      
	      public V put(K key, V value) {
                return putVal(hash(key), key, value, false, true);
           }
          4.执行hash(key)，得到key=“java”的hashCode的值 
            算法是：(h = key.hashCode()) ^ (h >>> 16)
            所以也不是简单的hashCode，hahshCode按位异或后右移16位，避免碰撞
            
          static final int hash(Object key) {
                   int h;
                   return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
           }
           5.拿到hash值，返回put方法
           
         public V put(K key, V value) {
             return putVal(hash(key), key, value, false, true);
         }
    
          6.进入putVal（）------>关键点来了
            关键传入参数依次为：hash值，key是数据，value是PRESNENT
            
        final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
                   
        Node<K,V>[] tab; Node<K,V> p; int n, i;//进行临时变量初始化，一个Node数组tab，一个节点p
        
               //table是HashMap的一个数组，数据类型是Node[]：：：：hashmap里的声明：transient Node<K,V>[] table;
              //这个语句意思是，当table=null或者table长度为0的时候，执行tab = resize()；n=tab.length;
               //即进行初始化，resize初始化第一次初始化为大小  16
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
            
                 //这里用长度-1与上hash值得到这个key（数据元素）在table表里的索引位置，然后把这个位置赋给临时节点p，并判断是否为空----》在这里p=tab【i】
                //是空，就创建节点，存储数据
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
            
                //不是空，
        else {
            Node<K,V> e; K k;     //创建临时节点e，数据k
            
                 //这里就是为什么new String却不能add成功的原因所在
                  
                 //判断节点p所指向的节点的hash值，也就是这个位置不是有数据节点嘛，p点指向的就是已经存在着的这个节点，看一下他的hash值和
                 // 要加入这个节点的hash值一不一样，
                  * 如果一样，并且（他的数据和要加入的数据一样==或者.equals相同），那就把p赋给e，也就是e指向了已经存入的节点，而不是要存的节点--》
                  *              这里用到了.equals方法，那就意味着因为动态绑定机制的存在我们完全可以重写类的。equals方法来实现两个类的某个信息相等就不能添加
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
                *如果节点p的类型是树节点调用这个
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                
                *如果都不是，hash值不一样，也不是树节点，
            else {
                for (int binCount = 0; ; ++binCount) {   //一个无限循环
                    if ((e = p.next) == null) {         //判断节点下一个是否为空，主要是判断是否是尾节点
                    
                        p.next = newNode(hash, key, value, null);       // 如果是尾节点，那就把要加入的节点加到他后面
                                                                       //--->这一个代码段看完就可以明白到最后一个节点还没跳出，那就意味着没有相同的元素
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                           //TREEIFY_THRESHOLD是一个值，判断是否应该把这一条链表树化，默认值是8，当这一条链被加了8个节点之后就会进来
                        
                            treeifyBin(tab, hash);
                            //这里是树化的方法，里面还有一个判断，源码是这样的：
                             * if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
                                       resize();
                               //这里面说，如果这个表是空的或者：：：(n = tab.length) < MIN_TREEIFY_CAPACITY)
                                * 也就是表的长度<MIN_TREEIFY_CAPACITY（64）,这个时候还使用resize（）来扩容table表，并不直接转为红黑树，MIN_TREEIFY_CAPACITY默认值是64
                           //总的来说：当一条链的节点数到达8个或以上，并且表的长度达到了64，那么这条链就会被树化
                        break;     
                    }
                    
                    //如果hash值相等，其实这是一个遍历，每一个节点都要判断是否和要加入节点的hash值相同并且数据或.equals相同
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;       //如果相同，直接返回
                    p = e;      //这里就是遍历的原因，在开头把e=p.next;在结尾把p=e;两个指针交替实现遍历
                }
            }
            
             //上面给e赋值时e=p.next;当p是最后一个节点时，p.next也就是null，那不为null意味着没到最后一个节点就跳出来了，有相同的节点
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                    
                afterNodeAccess(e);
                
                return oldValue;//返回
            }
        }
        //如果执行到这，说明上面没有执行，说明节点添加到最后一个位置了
        ++modCount;                 //记录修改次数
        if (++size > threshold)    //threshold是阈值，当table表里的节点数，所有节点，链表里的也算，多于阈值的时候，扩容翻倍
            resize();
        afterNodeInsertion(evict);//这个方法没有实现，是空的方法，主要用来给子类实现以添加功能
        return null;           //加入成功返回null
    }


     8.这是resize（）的一部分，主要看一下threshold---》阈 值
       final Node<K,V>[] resize() {
        Node<K,V>[] oldTab = table;               //oldTab指向现有的表table
        int oldCap = (oldTab == null) ? 0 : oldTab.length; //这是记录旧表的长度
        int oldThr = threshold;                  //旧的阈值
        int newCap, newThr = 0;                   //新值初始化
        
        //如果有旧的表
        if (oldCap > 0) {
            if (oldCap >= MAXIMUM_CAPACITY) {//已经到达最大容量，无法扩容
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&//否则更新参数，后面创建更新
                     oldCap >= DEFAULT_INITIAL_CAPACITY)
                newThr = oldThr << 1;                  // 阈值翻倍
        }
        else if (oldThr > 0) // initial capacity was placed in threshold
            newCap = oldThr;
            
            //如果是第一次初始化，table为null
        else {               // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY;         //初始默认容量为DEFAULT_INITIAL_CAPACITY（16）
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY); 
            //初始默认阈值thrshold为DEFAULT_LOAD_FACTOR（装载因子0.75） * （16）DEFAULT_INITIAL_CAPACITY，也就是12
        }
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                      (int)ft : Integer.MAX_VALUE);
        }
        threshold = newThr;
		 */
		
		//就上面的一些结论的一些尝试
		//3.建一个HashSet来看一下数据结构
		HashSet hs=new HashSet();
		for(int i=0;i<10;i++) {
			hs.add(new Dog1("i",i));
		}
		System.out.println(hs);//打断点方便看结构，eclipse不知到咋设置能显示HashSet的整个结构包括空
	}
}
//1.先写一个class
class Dog1{
	String name;
	int num;
	public Dog1(String name, int num) {
		super();
		this.name = name;
		this.num = num;
	}
	//2.
	//生成hashcode方法--》HashSet同过hash值来判断这个元素应该存放的索引位置，那么我们可以通过重写类的hashCode方法来手动控制他存放的链
	@Override
	public int hashCode() {
		//final int prime = 31;
		//int result = 1;
		//result = prime * result + ((name == null) ? 0 : name.hashCode());
		//result = prime * result + num;
		//return result;
		//直接返回个定值
		return 100;
	}
	//那么按理说就会所有的Dog类都在一条链上了
	//如果我在重写.equals方法，那又可以做到指定元素相等不能存入
	
	

	
}