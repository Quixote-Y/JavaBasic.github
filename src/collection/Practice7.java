package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//HashMap Practie
public class Practice7 {

	@SuppressWarnings("all")
	public static void main(String[] args) {
		Map map=new HashMap();
		map.put("jack", 650);
		map.put("tom", 1200);
		map.put("smith", 2900);
		//����ֱֵ��put�ͺ���
		map.put("jack",2600 );
		//���ܱ���Hashmapʵ��������������map�Ļ��ƣ�keyֵ��Set��valueֵ��Collection��Map.Entry��entryset
//		�Ĺ��ʣ��ǻ�ȡcollection�ͺ���
//	Collection value=map.values();
//		for(Object t:value) {
//			t=(Integer)t+100;
//		}
		//���в��У��Ĳ���ֵӦ������Ϊֵ���ݣ���ǿfor�Ĳ���ֵ
	//��ֵ���ᣡ��������
		
		Set keySet=map.keySet();
		for(Object key:keySet) {
			map.put(key,(Integer)map.get(key)+100);
		}
		//��ֵֻ����put������put
		Set entrySet=map.entrySet();
		for(Object t:entrySet) {
			Map.Entry eml=(Map.Entry)t;
			System.out.println(eml.getKey()+"-"+eml.getValue());
		}
	}
}