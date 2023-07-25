package collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//Map�б�������
public class bianliMap {

	public static void main(String[] args) {
		HashMap hashMap=new HashMap();
		hashMap.put(1, new Staff("������",2132,1));
		hashMap.put(2,new Staff("����",1000,2));
		hashMap.put(3, new Staff("����",4000,3));
		hashMap.put(4, new Staff("����",4000,4));
		//������ʽ
		//1.��ȡKey��Ӧ��Set����
		Set set=hashMap.keySet();
		     //Ȼ��ͱ�������Set�ͺ���
		//��1��for
		System.out.println("----keySet��ǿfor��������");
		for(Object t:set) {
			//�õ���keyֵ,t
			System.out.println(t+"-"+hashMap.get(t));
		}
		System.out.println("----keySet��������������");
		//(2)����������Set
		Iterator iterator=set.iterator();
		while(iterator.hasNext()) {
			//ȡ���ľ���key
			Object key=iterator.next();
			System.out.println(key+"-"+hashMap.get(key));
		}
		//2.ֱ��ȡvalues
		Collection collection=hashMap.values();
		 //Ȼ��ͱ���collection�ͺ�
		 //��1��
		for(Object t:collection) {
			//ȡ���ľ���value
			System.out.println(t);
		}
		//(2)
		Iterator iterator2=collection.iterator();
		while(iterator2.hasNext()) {
			Object val=iterator2.next();//ȡ��ֵ
			System.out.print(val+"\n");
		}
		//3.��EntrySetȡk-v
		Set entrySet=hashMap.entrySet();
		  //(1)��ǿfor
		System.out.println("\n=====EntrySet��ǿfor=======");
		for(Object t:entrySet) {
			//ȡ����������HashMap$Node,Nodeʵ����Map.ENtry������ת�ͣ��������ķ���
			Map.Entry entry=(Map.Entry)t;//����ת��
			System.out.println(entry.getKey()+"-"+entry.getValue());
		}
		System.out.println("\n=====EntrySet������=======");
		Iterator iterator3=entrySet.iterator();
		while(iterator3.hasNext()) {
			Object entry2=iterator3.next();//��ȡ���ǽڵ�
			//��ʹ��getKEy��value��������ת��ΪMap.Entry
			Map.Entry en2=(Map.Entry)entry2;
			System.out.println(en2.getKey()+"-"+en2.getValue());
		}
		
		System.out.println("\n=====����нˮ�����������=======");
		//����нˮ��������Ȼ�����
		//ȡ��Set key��Ȼ����sal����
		Set sal2=hashMap.keySet();
		Object[] sal3=sal2.toArray();
		//����ǿ������ת��ΪInteger[],��Ȼ��Object�����飬�����������ȫ��Integer��Ҳ����ֱ�Ӳ�������Ҫ��Integer�Ƚ�ʱ��תҲ����
		for(int i=0;i<sal3.length;i++) {
			for(int j=i+1;j<sal3.length;j++) {
				Staff value1=(Staff)hashMap.get(sal3[i]);
				Staff value2=(Staff)hashMap.get(sal3[j]);//�⼸��ǿ������ת�������Ǵ�Object����ת
				if(value1.getSal()<value2.getSal()) {
					Integer tmp=(Integer) sal3[i];
					sal3[i]=sal3[j];
					sal3[j]=tmp;
				}//��нˮ�Լ�ֵ��sal3������
			}
		}
		for(int i=0;i<sal3.length;i++) {
			System.out.println(sal3[i]+"-"+hashMap.get(sal3[i]));
		}
		
		//�õ��������нˮ����2000����
		System.out.println("\n=====�õ��������нˮ����2000����=======");
		Set tmp=hashMap.entrySet();
		Iterator iterator4 =tmp.iterator();
		while(iterator4.hasNext()) {
			Map.Entry obj=(Map.Entry)iterator4.next();//ǿ������ת��
			Object value6=obj.getValue();
			Staff staff=(Staff)value6;//ǿ������ת��
			if(staff.getSal()>=2000) {
				System.out.println(obj.getKey()+"-"+obj.getValue());
			}
		}
		/*
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * �ܽ�һ�£���һ���ֵ��ѵ������ȥ���Map�Ĵ洢��ʽHashMap��Ȼ�����ÿ����������������ʲô
		 *         ��keySet��������Ӧ����һ��key�Ķ���ļ��ϣ�values���ص���value����ļ��ϣ�
		 *         entrySet���ص���HashMap���Node�ڵ㣬��Node�ڵ㲢û����Ӧ�ķ���ȥ��������
		 *         ����Nodeʵ����Map���Entry��Map.Entry,ʹ�������getKey����getValue�������Ժܿ�ݵ�
		 *         ��map���в�����
		 *         Ȼ����ǻ���һ���㣬hashmapò����û�е�������,�����mapֻ���õ�����˵�ļ���Set��Collection
		 *          EntrySet��������Ȼ��ȥ�������е���
		 *          
		 *          Ȼ�����EntrySet�ṹ����������洢�Ķ��󣬶�������Entry��������������Map.Entry
		 *                                   ʵ�ʴ�ŵ���ʵ��HashMap$Node��NOde�ڵ�
		 *                          Ȼ�������������϶�����ֱ�Ӵ�ŵ��µ����ݣ�ֻ��ָ����Node�ڵ����
		 *                          
		 *                          HashMap�����ݻ��ƺ�HashSetһ��
		 *          �����Ԫ��ʱ��ֻͨ��Key�Ĺ�ϣֵ��ȡTable��������Ȼ���жϸ�λ���Ƿ���Ԫ��
		 *          ��Ԫ�أ���Ҫ�����Ԫ�غ����е�Ԫ���Ƿ���ͬ��
		 *                                   ��ͬ���޲���������
		 *                                   ����ͬ�����ڵ�������������
		 *                                         ���������ķ����ж�
		 *                                         �����ѭ����飬--���Ԫ��/����ͬԪ�أ�����ӣ�ֻ���滻
		 */
	}
}
class Staff{
	String name;
	int sal;
	int number;
	public Staff(String name, int sal, int number) {
		super();
		this.name = name;
		this.sal = sal;
		this.number = number;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + number;
		result = prime * result + sal;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Staff other = (Staff) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number != other.number)
			return false;
		if (sal != other.sal)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Staff [name=" + name + ", sal=" + sal + ", number=" + number + "]";
	}
	public String getName() {
		return name;
	}
	public int getSal() {
		return sal;
	}
	public int getNumber() {
		return number;
	}
	
}