package annotationTest;



/*
 * 注解用法解析：
 * @Override：方法重写（从编译层面）
 * @Deprecated：过时了，不推荐使用，但仍能用
 * @SuppressWarning ：抑制警告信息
 */
public class Annotation {
	B a=new B();//可以看到B被划了一条横线，这就是@Deprecated的作用

}


//@override解读
/*
 * 1.@Override放在fly上面，表示子类在写fly方法时重写了父类的fly
 * 2.这里有没有override其实没有影响
 * 3. 最重要的作用：但写了@Override之后，编译器就会去检查该方法是否真的重写了
 *   父类的方法，如果有则编译通过，否则编译错误
 * 4.打开@Override的定义：
 * 
 *  @Target(ElementType.METHOD)//修饰注解的注解：元注解   ；这里表示Override的目标是方法
    @Retention(RetentionPolicy.SOURCE)
    public @interface Override {
    }
    其中@intrface并不是接口的意思，而是表明这是一个 注解类
 */
class Father{
	void fly(){};
}

class Son extends Father{
	@Override
	void fly() {};
}

//@Deprecated解读
/*
 * 1.修饰某个元素，表示该元素已经过时了
 * 2.不推荐使用，但仍然i能够使用
 * 3.可以修饰方法，类，字段，包，参数等等
 * 4.多用于系统升级有更好的替代品时过渡提醒操作
 * 5.查看一下源码：
 *   @Documented
     @Retention(RetentionPolicy.RUNTIME)
     @Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, MODULE, PARAMETER, TYPE})
     public @interface Deprecated {
 */
//可以看到B被划了一条横线，这就是@Deprecated的作用
@Deprecated
class B{
	
}

//@DepressWarnings解读
/*1.当我们不希望看到某些警告信息时，可以使用DepressWarnings来抑制警告信息
 * 2.DepressWarnings{" 参数 "}根据参数的不同抑制不同的警告信息，all是所有类型
 * 3.放置的位置不同生效域也会发生变化
 * 
*/


//元注解：解释注解的注解
/*
 * Retention:指定该注解保留多长时间，
 * 三个类型：SOURCE：在源码层面.java；CLASS:直到被编译为class文件；RUNTINE：到运行
 * 
 * Target：用于指定修饰的注解生效于那些位置
 * 
 * @Documented：
 * @Inherited:
*/