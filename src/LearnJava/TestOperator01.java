package LearnJava;

public class TestOperator01 {
	
	public static void main(String[] args) {
		String a="3";
		int b=4;
		System.out.println(a+b);//���34
		
		//������String������char���ͣ�����char�����Ǽӷ�
		char c1 = 'h';
		System.out.println(Integer.toHexString(c1));
		char c2 = 'i';
		System.out.println(Integer.toHexString(c2));
		System.out.println(c1+c2);//�����ֵ
		
		//ͨ���ӿ��ַ�����������+��������ӷ�
		System.out.println(""+c1+c2);
		
		boolean x=true;
		boolean y=false;
		short z=46;
		if((z++==46)&&(y=true))z++;
		if((x=false)||(++z==49))z++;
		System.out.println("z="+z);
	}

}
