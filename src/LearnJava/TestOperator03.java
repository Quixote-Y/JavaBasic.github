package LearnJava;
/**
 * 测试非>与>或
 * @author 86136
 *
 */
public class TestOperator03 {
	
	public static void main(String[] args) {
		
		//优先级问题用法
		boolean s1 = true,s2= true, s3=false;
		System.out.println(s1||s2&&s3);//非》与》或，先做后面的运算
		
		//复杂时应该使用小括号
		boolean s4= (3>1||4>3)&&(3<5);
		System.out.println(s4);
	}

}
