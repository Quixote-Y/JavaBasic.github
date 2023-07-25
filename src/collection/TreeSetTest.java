package collection;

import java.util.Comparator;
import java.util.Objects;
import java.util.TreeMap;
import java.util.TreeSet;


//TreeSet解析
public class TreeSetTest {

	@SuppressWarnings("all")
	public static void main(String[] args) {
		//1.TreeSet有无参构造器，当调用无参构造器时，添加数据对象任然是无序的
		//2.TreeSet还有一个构造器，可以传入一个比较器（匿名类）并指定排序规则顺序
		
		//TreeSet set=new TreeSet();//无参构造函数，添加数据是无序的
		TreeSet set=new TreeSet(new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				// TODO 自动生成的方法存根
				//1.按字符串大小进行比较
				//先把Object转为String，然后调用默认compareto方法
				//return ((String)o1).compareTo((String)o2);//-----------------》像这里，当返回值是0时，也就是两个字符串相同时，那么这个字符串就不会加入到树里
				//再来试试别的比较方法
				//比较两个字符串长度，长倒短排序
				return ((String)o1).length()-((String)o2).length();//这样返回的就是两个字符串的长度的差值，大于0，放到右子树，小于0左子树，等于0，不添加，那就意味着这一整个树中
				                                                  //不会出现两个字符串长度相等，相等长度字符串会添加失败
			}
			
		});
		set.add("a");
		set.add("a");
		set.add("asada");
		set.add("das");
		set.add("rawa");
		set.add("daa");
		System.out.println(set);
		
		//一些细节，1.首先先创建一个空的类Num
		//2.然后尝试去向TreeSet里添加一个NUm对象试试
		TreeSet tree=new TreeSet();
		tree.add(new Num());///------>一定会抛出一个类型转换异常，因为创建TreeSet的时候没有传入比较器，那么添加元素的时候tree就会去调用你传入参数的Comparable接口实现的comparaTo方法，但明显
		                   //NUmber就没有实现这个接口
		
		//------------------》怎么解决呢：也很简单，让Num实现ComparaTo方法就好了，注意，这时候在无比较器的TreeSet里，他的Comparable里的compareTo方法也就是比较器的作用了

		//TreeMap里的compare方法的源码：
		/*
		   final int compare(Object k1, Object k2) {
                  return comparator==null ? ((Comparable<? super K>)k1).compareTo((K)k2)
                           : comparator.compare((K)k1, (K)k2);-----------------------------》当构造器为null的时候，返回k实现了的Comaparable接口的ComparaTo方法
            }
		 */
		System.out.println(tree);
	}
}
class Num /*implements Comparable*/{

	/*@Override
	public int compareTo(Object o) {
		// TODO 自动生成的方法存根
		return 0;
	}*/
	
}
//源码：
  /*1.进入带比较器的TreeSet构造函数，他会带着比较器参数调用TreeSMap的构造函数
          public TreeSet(Comparator<? super E> comparator) {
               this(new TreeMap<>(comparator));
           }
    2.调用TreeMap的带比较器的构造函数，函数执行把自己的构造器换成我们自行编写的构造器
     public TreeMap(Comparator<? super K> comparator) {
        this.comparator = comparator;
    }
    //初始化结束
     * 
    3.执行add（“a”），调用TreeSet的add
     public boolean add(E e) {
        return m.put(e, PRESENT)==null;
      }
   4 .调用m.put，也就是TreeMap的put函数，在这里又调用三个参数的put
      public V put(K key, V value) {
          return put(key, value, true);
      }
    5.第一次在put中执行：
     Entry<K,V> t = root;
        if (t == null) {
            addEntryToEmptyMap(key, value);
            return null;
        }
        
     6.第二次add前面都一样，但到了三参数put中：
          会调用我们初始化时写入的比较器：
           Comparator<? super K> cpr = comparator;  
           cmp = cpr.compare(key, t.key);        //调用比较器里重写的comapre方法，比较要添加的节点和树上的节点，取得返回值
     
     7.根据返回值的不同采取不同的处理方法，但当返回值是0时，那就会返回一个默认值PRESENT，也就预示着添加失败，这个元素不会添加到tree里，因此比较器的构造对整个树的构建又很大影响
     
     
     
     
     
   */
       /*TreeMap中三参数put全部源码
        private V put(K key, V value, boolean replaceOld) {
        Entry<K,V> t = root;  //第一次调用时为空，之后就根节点
        if (t == null) {                      //第一次调用的时候，检查一下根节点是否为null啥的
            addEntryToEmptyMap(key, value);    
            return null;
        }                     
        int cmp;                    //这里开始就都是第一次以后调用会执行的了
        Entry<K,V> parent;                       //双亲Entry节点
        // split comparator and comparable paths
        Comparator<? super K> cpr = comparator;          //调用比较器，按比较器中的内容，看返回值
        if (cpr != null) {                              //比较器不为null，也就是你自己写了比较器
            do {
                parent = t;                           //节点赋给parent
                cmp = cpr.compare(key, t.key);        //调用比较器里重写的comapre方法，比较要添加的节点和树上的节点，取得返回值
                if (cmp < 0)                          //返回值小于0
                    t = t.left;                        //往左
                else if (cmp > 0)                      //大于0
                    t = t.right;                        //往右
                else {                                    //等于0
                    V oldValue = t.value;                //把他的值给oldValue，，，这是Set，调用的HashMap，map是双值存储，所以最开始调用map时就给了一个默认值给value：：：PRESENT
                    if (replaceOld || oldValue == null) {  //判断是否要替换或节点的value是否为null，，，，，replaceOld永远是 true，调用时输入的
                        t.value = value;                    //为空或要替换，那就把值赋给t（树上的节点）值
                    }
                    return oldValue;                    //返回oldvalue，也就是返回默认值：PRESENT
                }
            } while (t != null);            //持续到叶子节点的最后
        } else {            //无比较器的情况
            Objects.requireNonNull(key);
            @SuppressWarnings("unchecked")
            Comparable<? super K> k = (Comparable<? super K>) key;//如果没有传入Comparator比较器，那就会把传入key值转换为Comparable类型
                                                                 //---》为什么能转：因为你必须实现Comparable接口，这个接口里有个方法：comparaTo，会调用这个，如果你输入的键值
                                                                  * 没有实现Comparable接口，没有comparaTO方法，那这个地方就会报类型转换异常
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
        addEntry(key, value, parent, cmp < 0);//添加Entry节点
        return null;
    }

        */
 
 
 
