package enumTest;
//Enum常用方法
public class EnumMethod {

	public static void main(String[] args) {
		//使用Season2枚举类
		Season2 autum=Season2.AUTUM;//取出Autum
		//输出枚举对象的名字
		System.out.println(autum.name());
		//ordinal()输出的是该枚举对象初始化时的编号，从0开始
		//Autum是第三个初始化的，因此输出2
		System.out.println(autum.ordinal());
		//反编译：javap：将.class文件反编译为java文件，可以看到一些详细信息
		//values方法是被隐藏的，正常找不到
		//从反编译可以看出values方法，返回Season2[]
		//即返回所有已经定义的Season2枚举
		Season2[] values =Season2.values();
		for(Season2 t:values) {
			System.out.println(t.toString());
		}
		//compareTo:比较两个枚举对象，比较的是编号
//		 public final int compareTo(E o) {
//		        Enum<?> other = (Enum<?>)o;
//		        Enum<E> self = this;
//		        if (self.getClass() != other.getClass() && // optimization
//		            self.getDeclaringClass() != other.getDeclaringClass())
//		            throw new ClassCastException();
//		        return self.ordinal - other.ordinal;
//		    }
		 //return self.ordinal - other.ordinal;这一句是关键
		//返回自己的编号-对象的编号
		//WINTER[3]-SPRING[0]=3
		System.out.println(Season2.WINTER.compareTo(Season2.SPRING));
		
	}
}
