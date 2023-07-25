package LearnJava;

public class TestOperator01 {
	
	public static void main(String[] args) {
		String a="3";
		int b=4;
		System.out.println(a+b);//输出34
		
		//条件是String，不是char类型，若是char，仍是加法
		char c1 = 'h';
		System.out.println(Integer.toHexString(c1));
		char c2 = 'i';
		System.out.println(Integer.toHexString(c2));
		System.out.println(c1+c2);//输出数值
		
		//通过加空字符串，让整个+都变成连接符
		System.out.println(""+c1+c2);
		
		boolean x=true;
		boolean y=false;
		short z=46;
		if((z++==46)&&(y=true))z++;
		if((x=false)||(++z==49))z++;
		System.out.println("z="+z);
	}

}
