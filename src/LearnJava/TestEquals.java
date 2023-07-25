package LearnJava;
/**
 * 重写equals函数
 * @author 86136
 *
 */
public class TestEquals {

	int id;
	String name;
	public TestEquals(int id, String name) {
		
		this.id = id;
		this.name = name;
	}
	//重写equals，编译器直接生成
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;//若地址相同，直接返回true
		if (obj == null)
			return false;//目标为空，返回false
		if (getClass() != obj.getClass())
			return false;//两个对象类不同，返回false
		TestEquals other = (TestEquals) obj;
		if (id != other.id)//上面条件不满足，比较二者id
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		TestEquals e1=new TestEquals(1,"yang");
		TestEquals e2=new TestEquals(1,"yang");
		//e1和e2内容一样，但地址不同，object.quals函数可以比较对象内容相等，得重写
		//默认比较二者的hashcode
		System.out.println(e1.equals(e2));//未重写未false，重写后未true
	}

	
}
