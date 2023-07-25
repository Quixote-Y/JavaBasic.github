package bigNum;
//当我们要保存一个精度很高的数据，double不能装的时候，使用BigDecimal

import java.math.*;
public class BigDecimalTest {
	public static void main(String[] args) {
		BigDecimal bigDecimal=new BigDecimal("1321.213231231239999999999099999");
		BigDecimal bigDecimal2=new BigDecimal("3");
		
		//t同BigInteger，都要用指定的方法来运算
		System.out.println(bigDecimal.add(bigDecimal2));//加
		System.out.println(bigDecimal.subtract(bigDecimal2));//减
		System.out.println(bigDecimal.multiply(bigDecimal2));//乘
		
		
		//在除这里会出现问题：
		//如果两个数相除，除不尽怎么办，结果是一个无限不循环小数，那就会一直执行除操作
		//程序会抛出算术异常，这就需要我们在每次除运算时进行精度控制
		//bigDecimal.divide(bigDecimal2,BigDecimal.ROUND_CEILING)---
		//---->意思是，除法操作，结果精确到被除数
		//System.out.println(bigDecimal.divide(bigDecimal2));//除
		
		System.out.println(bigDecimal.divide(bigDecimal2,BigDecimal.ROUND_CEILING));
	}

}
