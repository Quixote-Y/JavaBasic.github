package LearnJava;
/**
 * this参数使用
 * @author 86136
 *
 */
public class TestThis {

	int a,b,c;
	//无参构造函数
	TestThis(){
		System.out.println("调用无参构造函数！");
	}
	//两个参数
	TestThis(int a,int b){
		this.a=a;
		this.b=b;
		System.out.println("调用有2参构造函数！"+a+b);
	}
	//构造函数调用构造函数
	TestThis(int a,int b,int c){
		this();//调用无参构造函数,必须是函数的第一个句子
		this.a=a;
		this.b=b;
		this.c=c;
		System.out.println("调用3参构造函数"+a+b+c);
	}
	
	//主函数
	public static void main(String[] args) {
		new TestThis();
		new TestThis(2,3);
		new TestThis(1,2,3);
	}
}
