package collection;

import java.util.Vector;

//Vector解析
public class VectorTest {

	public static void main(String[] args) {
		//Vector实现的方法都是线程安全的
		//他基本与ArrayList运行机制相同，不过无参初始化容量为10，之后每次扩容翻两倍，有参初始化，之后每次扩容翻倍
		//源码追溯
		Vector v=new Vector();
		for(int i=0;i<10;i++) {
			v.add(i);
		}
	}
}
