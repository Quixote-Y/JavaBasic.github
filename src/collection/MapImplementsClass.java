package collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//Map����
public class MapImplementsClass {

	public static void main(String[] args) {
		//1.Map��Collection���д��ڣ����ڱ������ӳ���ϵ������key--value
		//2.Map�е�key��value�������κ��������ͣ����װ��HashMap$Node������
		//3.Map��key�������ظ����ظ�ʱ�����value
		//4.Map��value�����ظ�
		//����洢
		//5.Map��key����Ϊ�գ�valueҲ����Ϊnull����keyֻ����1��null����value���ж��null
		//6.key��valueһһ��Ӧ����ͨ��key��value
		 Map map=new HashMap();
		 map.put("no1", "yyf");
		 map.put("no2", "dmy");
		 map.put("no3", "zyx");
		 map.put("no1", "lisi");//��ͬkey���滻calue
		 map.put("no4", "dmy");//value�����ظ�
		 map.put(null, null);//nullҲ����
		 map.put(null, "12");//�滻
		 //key  get�� value
		 System.out.println(map.get("no4"));//dmy
		 
		 System.out.println(map);
		 
		 
		 
		 //Map����HashMap$Node Entry Set Collection
		 //1.put����k -vʱ��Map�ĵײ�ʵ�־���HashMap��һ����table���ʼ����putValue������
		 //   ����󴴽��Ľڵ�����Ϊ��HashMap$Ndoe=newNode(hash, key, value, null);
		 //2.Map Ϊ�˷������Ա�ı��������ᴴ��һ��EntrySet���ϣ��ü��ϴ�ŵ�Ԫ������ΪEntry
		 //   ��һ��Entry�������k��v��EntrySet<Entry<K,V>> ����transient Set<Map.Entry<K,v>> entrySet
		 //
		 //�����е�key����ֵ����ɵļ�����Set��������Value��ɵļ�����Collection�����е�k��val�������ϳɵļ�����EntrySet
		 //׼ȷ��˵Ӧ����һ������Setָ����������Key��һ������Collectionָ���value��Ȼ��EntrySetָ�������ļ���
		 //

		 //3.������EntrySet�У������������   Map.Entry   ,��ʵ�ʴ洢�Ļ���    HashMap$Node  Ҳ������ǰ�洴�����ڸ�Node�ڵ�
		 //   ������Ϊ��̬��HashMap�е�Nodeʵ����Map>Entry<K,V>,  Ҳ���Ǹ���������������������Ҳ����ζ����ͨ��
		  //      entrySet��ȡ��EntrySet֮��ǿ������ת��Ӧ��ת��ΪMap.Entry,��Ϊ�ڶ�����EntrySet�У������������   Map.Entry 
		 
		 //4.����HashMap$Node �����ŵ�entrySet�к󣬾ͷ��������ǵı�������ΪMap.Entry�ṩ����Ҫ�ķ���
		 //      V get value();K getKey();
		 Set set =map.entrySet();//����EntrySet��EntrySet��ŵĶ�����������Entry������������Map.Entry
		 System.out.println(set.getClass());//����set������ʱ������ʲô������class java.util.HashMap$EntrySet������ֵ������EntrySet
		 for(Object t:set) {     //����t������Object�࣬��Ϊset��Object���࣬����Map.Entry,����ֱ��ЩMap.Entry
			 //����ת�͵�value
			 Map.Entry obj=(Map.Entry)t;
			 System.out.println(obj.getKey()+" "+obj.getValue());//��������Map.Entry����������
		 }
		 Set set2=map.keySet();//��ȡ�����У�set��Ϊ�����ظ�����ȡSet
		 Collection col=map.values();//��ȡֵ����,collection��Ϊ�����ظ�����ȡCollection
		 
		 System.out.println(set2);
		 System.out.println(col);
		//��������һ��
		 /*
		  * ������Mapʱ���ᴴ��HashMap$Node�ڵ����洢key��value��������table������MapΪ�˷������Ա��������ά����һ��EntrySet���ϣ�
		  *  ������ϵ�Ԫ�ض���Entry����Node�ĸ��࣬��Ϊ���������Ϊ�����������ã�����ÿ��Entry��ָ����һ��Node�ڵ�
		  */
		 
		 
		 //���÷���
		 //�����put
		 //remove ���ݼ�ɾ��
		 //get ���ݼ���ȡֵ������ֵ��Object
		 //size ��ȡԪ�ظ���
		 //isEmpty �ж�Ԫ�ظ����Ƿ�Ϊ0
		 //contains �Ƿ�����ü�ֵ
		 //clear �������
	}
}
