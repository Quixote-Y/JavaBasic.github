package collection;

import java.util.Comparator;
import java.util.Objects;
import java.util.TreeMap;

//TreeMap解析
public class TreeMapTest {

	@SuppressWarnings("all")
	public static void main(String[] args) {
		//1.他基本与TreeSet一致，除了一些些细节方面，因为TreeSet底层就是TreeMap
		//2.无参构造器，加入序列无序
		//   含比较器的构造器，按比较器返回值的不同会有不同的效果
		
		//TreeMap map=new TreeMap();//可以看输出，输出顺序和加入顺序是无关的
		//下面是用带比较器的构造函数
		TreeMap map=new TreeMap(new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				// TODO 自动生成的方法存根
				//按照k（String）的大小顺序排序
				//return ((String)o1).compareTo((String)o2);
				//按照K的长度来排序
				return ((String)o1).length()-((String)o2).length();
				//想一下这样的话输出会是什么{李四=Wangba }，很简单，看源码
			}
			
		});
		map.put("李四","Lisi ");
		map.put("王五","Wangwu ");
		map.put("赵六","Zhaoliu ");
		map.put("三七","Sanqi ");
		map.put("王八","Wangba ");
		
		System.out.println(map);
		
	}
}

    //源码分析：
    /* 
      1.TreeSet初始化，直接调用带比较器的构造函数，把比较器赋给自己的compatator参数
           public TreeMap(Comparator<? super K> comparator) {
                  this.comparator = comparator;
            }
            
       2.执行put语句
            map.put("李四","Lisi ");
       3.进入put，调用三个参数的put，与TreeSet不同，这里的第二个参数value不再是默认值
         PRESENT，而是用户输入的value，第三个参数依旧是true
            public V put(K key, V value) {
                  return put(key, value, true);
            }
       4.执行三个参数的put，
  
          private V put(K key, V value, boolean replaceOld) {
        Entry<K,V> t = root;  //第一次调用时Entry为空，之后就根节点
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
                    V oldValue = t.value;                   //比较器返回值等于0，那就把输入信息中的value赋给oldValue
                    if (replaceOld || oldValue == null) {  //判断是否要替换或节点的value是否为null，，，，，replaceOld永远是 true，调用时输入的，这样的话其实这句话肯定执行
                        t.value = value;                    //为空或要替换，那就把值赋给t（树上的节点）值，，这就意味着当返回值为0的时候，
                                                             //编译器就把这两个key当作是同一个了，只替换了旧的值，不改变他的键值，这也是为什么上面会输出{李四=Wangba}的原因 
                    }
                    return oldValue;                    //返回oldvalue，
                }
            } while (t != null);            //持续到叶子节点的最后
        } else {            //无比较器的情况
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
        addEntry(key, value, parent, cmp < 0);//添加Entry节点
        return null;
    }
     */
 
