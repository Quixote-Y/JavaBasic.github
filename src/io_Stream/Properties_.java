package io_Stream;
//Properties  专门用于读写配置文件的集合类    配置文件格式：  键=值，不需要空格，不需要引号

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


public class Properties_ {

	public static void main(String[] args) throws IOException {
		//使用Properties 类来读取mysql.properties文件
		
		//1.创建Properties 对象
		Properties properties =new Properties();
		//2.加载指定配置文件   ；流对象
		properties.load(new FileInputStream("E:\\javaTestFile\\mysql.properties"));
		//3.把k-v显示到控制台
		properties.list(System.out);//目标都是流对象
		//4.根据key，获取相应的值
		String user=properties.getProperty("user");//返回值默认是String
		System.out.println(user);
		
		//使用Properties类添加key-val到新的文件mysql2.properties文件中
		
		//1.创建Properties对象
		Properties properties2=new Properties();
		//2.创建key-val到properties中，如果该文件里有这个key，那就更新value，没有就创建
		properties2.setProperty("charSet", "utf-8");
		properties2.setProperty("user", "汤姆");//当存储中文的时候，在文件里会自动转换为unicode编码
		properties2.setProperty("pwd", "2132414");
		//3.将k-v存储到文件中
		properties2.store(new FileOutputStream("E:\\javaTestFile\\mysql2.properties"), null);
		//store方法参数：OutputStream流对象 ，评注（加一个标签）
		System.out.println("创建成功");
	}
}
/*
 *Properties类继承了HashMap，，，，，，
 *setProperty方法最底层就是熟悉的  三参数putval（），检测到k存在就替换value，不存在就创建 
 * 
 * 
 *
   final V putVal(K key, V value, boolean onlyIfAbsent) {
        if (key == null || value == null) throw new NullPointerException();
        int hash = spread(key.hashCode());
        int binCount = 0;
        for (Node<K,V>[] tab = table;;) {
            Node<K,V> f; int n, i, fh; K fk; V fv;
            if (tab == null || (n = tab.length) == 0)
                tab = initTable();
            else if ((f = tabAt(tab, i = (n - 1) & hash)) == null) {
                if (casTabAt(tab, i, null, new Node<K,V>(hash, key, value)))
                    break;                   // no lock when adding to empty bin
            }
            else if ((fh = f.hash) == MOVED)
                tab = helpTransfer(tab, f);
            else if (onlyIfAbsent // check first node without acquiring lock
                     && fh == hash
                     && ((fk = f.key) == key || (fk != null && key.equals(fk)))
                     && (fv = f.val) != null)
                return fv;
            else {
                V oldVal = null;
                synchronized (f) {
                    if (tabAt(tab, i) == f) {
                        if (fh >= 0) {
                            binCount = 1;
                            for (Node<K,V> e = f;; ++binCount) {
                                K ek;
                                if (e.hash == hash &&
                                    ((ek = e.key) == key ||
                                     (ek != null && key.equals(ek)))) {
                                    oldVal = e.val;
                                    if (!onlyIfAbsent)
                                        e.val = value;
                                    break;
                                }
                                Node<K,V> pred = e;
                                if ((e = e.next) == null) {
                                    pred.next = new Node<K,V>(hash, key, value);
                                    break;
                                }
                            }
                        }
                        else if (f instanceof TreeBin) {
                            Node<K,V> p;
                            binCount = 2;
                            if ((p = ((TreeBin<K,V>)f).putTreeVal(hash, key,
                                                           value)) != null) {
                                oldVal = p.val;
                                if (!onlyIfAbsent)
                                    p.val = value;
                            }
                        }
                        else if (f instanceof ReservationNode)
                            throw new IllegalStateException("Recursive updata");
                    }
                }
                if (binCount != 0) {
                    if (binCount >= TREEIFY_THRESHOLD)
                        treeifyBin(tab, i);
                    if (oldVal != null)
                        return oldVal;
                    break;
                }
            }
        }
        addCount(1L, binCount);
        return null;
    }
*/