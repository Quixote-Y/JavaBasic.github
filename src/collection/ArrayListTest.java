package collection;

import java.util.ArrayList;

//ArrayList机制解析
public class ArrayListTest {

	public static void main(String[] args) {
		//ArrayList支持所有元素，包括null
		//相较vector，arrylist更快，但vector支持多线程
		
		/*ArrayList下的add方法，：ArrayList是线程不安全的，源码没有synchronized 标志
		 * private void add(E e, Object[] elementdata, int s) { 
		 * if (s ==elementdata.length)
		 *    elementdata = grow(); 
		 *    elementdata[s] = e; 
		 *    size = s + 1; 
		 *  }
		 */
		
		
		/*底层机制：
		 * 1.ArrayList维护了一个Object类型的数组Elementdata.
		 *     transient Object[] elementdata;
		 * 2.当创建ArrayList对象时，如果使用的是无参构造器，则初始elementdata容量为0
		 *   ，第一次添加，则扩容为10，如需再次扩容，则扩容为elementdata的1.5倍
		 * 3.如果使用的是直接指定大小的构造器new ArrayList(int);，则初始位指定大小，如需
		 *   扩容，直接扩容位elementdata的1.5倍
		 */
		
		/*看源码追路径：//我的版本和视频讲的不同，但过程相似
		 * 1.因为传入add的值时int，基本数据类型，
		 * 调用装箱Integer： public static Integer valueOf(int i)
		 * 2.正式进入add（）：
		 * public boolean add(E e) {
              modCount++;//记录修改了几次，当有多线程更改时抛出异常
              add(e, elementdata, size);//到这就调用另一个add了，e是加入元素，
                                    //elementdata是ArrayList存放对象的数组，size是现在elementdata这个数组的大小，初始是0
                                    //纠正以下，size不是数组大小，他是一个索引，指向了下一个要加入elementdata的元素应该加入的位置
              return true;
           }
		 * 3.进入add
		 * private void add(E e, Object[] elementdata, int s) {
               if (s == elementdata.length)//初始时s=0，elementdata.length=0；
               elementdata = grow();        //第一次添加元素调用无参grow（）
               elementdata[s] = e;
               size = s + 1;
            }
		 * 
		 * 4.调用无参grow()
		 *  private Object[] grow() {
                    return grow(size + 1);//调用有参grow（），参数是现有的elementdata尺寸+1
                  }
	 	 * 
	 	 * 
	 	 * 5.进入有参grow（）
	 	 * private Object[] grow(int minCapacity) {//int minCapacity当前所需要的大小，
                   int oldCapacity = elementdata.length;
                   if (oldCapacity > 0 || elementdata != DEFAULTCAPACITY_EMPTY_ELEMENTdata) {
                             int newCapacity = ArraysSupport.newLength(oldCapacity,
                             minCapacity - oldCapacity,  
                             oldCapacity >> 1  );//这一段代码意思是当第一次初始化之后length会变成10嘛，然后第二次扩容会调用他，他会使elementdata增大到1.5倍
                              return elementdata = Arrays.copyOf(elementdata, newCapacity);//用Arrays的copyOf方法复制现有的到新的elementdata里
                  } else {
                            return elementdata = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
                            //第一次扩容时，new一个大小为DEFAULT_CAPACITY=10的Object数组，因为第一次的时候minCapacity=1；
                      
                  }
            }
	 	 * 
	 	 *之后就是返回了
		 */
		ArrayList arrayList=new ArrayList();
		for(int i=0;i<10;i++) {
			arrayList.add(i);
		}
		for(int i=10;i<15;i++) {
			arrayList.add(i);
		}
		
		/*3.如果使用的是直接指定大小的构造器new ArrayList(int);，则初始位指定大小，如需
		 *   扩容，直接扩容位elementdata的1.5倍
		 * 底层：
		 * 初始化的时候会创建一个大小为你指定的大小的elementdata,
		 * 就像下面的2，当第3次加入元素时，他会去调用grow，然后grow里的这个：
		 * if (oldCapacity > 0 || elementdata != DEFAULTCAPACITY_EMPTY_ELEMENTdata) {
		 *所以直接开始扩容1.5倍
		 */
		
		ArrayList arrayList2=new ArrayList(2);
		for(int i=0;i<10;i++) {
			arrayList2.add(i);
		}
	}
}
