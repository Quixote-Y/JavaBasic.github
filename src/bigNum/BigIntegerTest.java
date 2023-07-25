package bigNum;

import java.math.BigInteger;

//BigInteger用法
public class BigIntegerTest {

	public static void main(String[] args) {
		//当整数数据大到long也无法装载的时候我们使用BigInteger类型
		
		BigInteger bigInteger=new BigInteger("21321323299999999999999");
		BigInteger bigInteger2=new BigInteger("100");
		System.out.println(bigInteger);
		//对BigInteger的加减乘除操作必须使用相应的方法，不能直接用运算符
		
		BigInteger add=bigInteger.add(bigInteger2);
		System.out.println(add);//加
		System.out.println(bigInteger.subtract(bigInteger2));//减
		System.out.println(bigInteger.multiply(bigInteger2));//乘
		System.out.println(bigInteger.divide(bigInteger2));//除
		
	}
}
