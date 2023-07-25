package io_Stream;
//Properties  ר�����ڶ�д�����ļ��ļ�����    �����ļ���ʽ��  ��=ֵ������Ҫ�ո񣬲���Ҫ����

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


public class Properties_ {

	public static void main(String[] args) throws IOException {
		//ʹ��Properties ������ȡmysql.properties�ļ�
		
		//1.����Properties ����
		Properties properties =new Properties();
		//2.����ָ�������ļ�   ��������
		properties.load(new FileInputStream("E:\\javaTestFile\\mysql.properties"));
		//3.��k-v��ʾ������̨
		properties.list(System.out);//Ŀ�궼��������
		//4.����key����ȡ��Ӧ��ֵ
		String user=properties.getProperty("user");//����ֵĬ����String
		System.out.println(user);
		
		//ʹ��Properties�����key-val���µ��ļ�mysql2.properties�ļ���
		
		//1.����Properties����
		Properties properties2=new Properties();
		//2.����key-val��properties�У�������ļ��������key���Ǿ͸���value��û�оʹ���
		properties2.setProperty("charSet", "utf-8");
		properties2.setProperty("user", "��ķ");//���洢���ĵ�ʱ�����ļ�����Զ�ת��Ϊunicode����
		properties2.setProperty("pwd", "2132414");
		//3.��k-v�洢���ļ���
		properties2.store(new FileOutputStream("E:\\javaTestFile\\mysql2.properties"), null);
		//store����������OutputStream������ ����ע����һ����ǩ��
		System.out.println("�����ɹ�");
	}
}
/*
 *Properties��̳���HashMap������������
 *setProperty������ײ������Ϥ��  ������putval��������⵽k���ھ��滻value�������ھʹ��� 
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