package generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;


//Junit
//566
public class Practice3 {

	public static void main(String[] args) {
		
	}
	@Test
	public void testList() {
		
		Dao<User> userDao=new Dao<>();
		userDao.save("1", new User(1,20,"yyf"));
		userDao.save("2", new User(2,22,"zyx"));
		userDao.save("3", new User(3,12,"dmy"));
		String id ="2";
		System.out.println("get ="+id+"--"+userDao.get(id));
		userDao.updata("2", new User(2,30,"lcy"));
		System.out.println(userDao.list());
		userDao.delete("2");
		System.out.println(userDao);
		
	}
}


class Dao<T>{
	private Map<String,T> map =new HashMap<String, T>();
	
	public Map<String, T> getMap() {
		return map;
	}

	public void setMap(HashMap<String, T> map) {
		this.map = map;
	}
	public void save(String id,T entity) { 
		map.put(id, entity);
		System.out.println("OK");
	}
	
	public T get(String id) {
		return map.get(id);
	}
	public void updata(String id,T entity) {
		map.put(id,entity);
		System.out.println("OK");
	}
	public List<T> list(){
		//return (List<T>)map.values();
		//不能强制转换Collection到list，运行时会报错
		//ArrayList维护了一个Object类型的数组Elementdata.
		
		//Collection转list的方法应该是
		
		//List<T> list2 =new ArrayList<T>(map.values());
		return new ArrayList<T>(map.values());
	    //我们可以看看这个构造器:传入一个Collection类或他的子类
		//原理也很简单，就是把collection转换为一个Object数组，然后用数组来和ArrayList底层的elementdata数组进行操作
		/*
		  public ArrayList(Collection<? extends E> c) {
                Object[] a = c.toArray();
                if ((size = a.length) != 0) {
                if (c.getClass() == ArrayList.class) {
                      elementdata = a;
                } else {
                      elementdata = Arrays.copyOf(a, size, Object[].class);
                }
                } else {
                 // replace with empty array.
                 elementdata = EMPTY_ELEMENTdata;
                 }
          }
		 
		 */
	
	}
	public void delete(String id) {
		map.remove(id);
		System.out.println("OK");
	}
}

class User{
	private int id;
	private int age;
	private String name;
	public User(int id, int age, String name) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", age=" + age + ", name=" + name + "]";
	}
	
}