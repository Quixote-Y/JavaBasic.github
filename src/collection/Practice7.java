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
		//更改值直接put就好了
		map.put("jack",2600 );
		//不能遍历Hashmap实例！！！！！，map的机制，key值的Set，value值的Collection，Map.Entry的entryset
//		改工资，那获取collection就好了
//	Collection value=map.values();
//		for(Object t:value) {
//			t=(Integer)t+100;
//		}
		//不行不行，改不了值应该是因为值传递，增强for改不了值
	//改值不会！！！！！
		
		Set keySet=map.keySet();
		for(Object key:keySet) {
			map.put(key,(Integer)map.get(key)+100);
		}
		//改值只能用put，，，put
		Set entrySet=map.entrySet();
		for(Object t:entrySet) {
			Map.Entry eml=(Map.Entry)t;
			System.out.println(eml.getKey()+"-"+eml.getValue());
		}
	}
}