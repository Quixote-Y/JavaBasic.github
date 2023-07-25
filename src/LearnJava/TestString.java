package LearnJava;
/**
 * ����String
 * @author 86136
 *
 */
public class TestString {
	/*
	 * 1. String��ʵ����Serializable, Comparable�����ӿ�
	 *     Serializable���ɴ��л��������������ϴ���
	 *     Comparable��String������ԱȽϴ�С
	 * 2. String��final�࣬���ܱ�������̳�
	 * 3. String������private final char value[];���ڴ���ַ�������
	 * 4. һ��ע��value��final���ͣ��������޸�-->value��ָ��ĵ�ַ�����޸ģ���value�ĵ�ַ���ܱ�
	 * �������������ڶ��п����µĵ�ַ�ռ䣬���ڴ��ָ���������ַ����ĵ�ַ
	 *    �������ַ������޸ģ���value������ָ���µ����ݿռ䣬������ָ��ĵ�ַ�ɱ�
	 */

	public static void main(String[] args) {
		
		//����String
		String s1=null;
		String s2 ="";
		String s3="java";
		String s4=new String("java");
		String s5=new String();
		/*
		 *            String s ="hsp"
		 *  �����ȼ�鳣������û��"hsp",�о�ֱ��ָ��ó������������
		 *  û�оʹ���Ȼ��ָ������  sָ����ǳ����صĵ�ַ
		 *            String s =new String("hsp");
		 *   �����ڶ��н���һ����ַ���������String���value���飬Ȼ��value
		 *   ��ȥ���������ҡ�hsp����û�оʹ������ַ������õ���ַ��Ȼ��
		 *   �ؼ����ˣ�  valueָ���˳����صĵ�ַ  ��Ȼ�󷵻�����һ�����и�
		 *              value���ڵĵ�ַ��String s
		 */
		
		
		
		//System.out.println(s1.length()); //�˴��ᱨ����ָ���쳣
		System.out.println(s2.length());
		System.out.println(s3.length());
		System.out.println(s4.length());
		System.out.println(s5.length());//newһ�����ַ���������Ctrl�鿴һ��Stringԭ�ĵ��Ĺ��캯�������ͺܶ�
	
	
		
		System.out.println("---------------------------");
		String g1="GOOD";
		String g2="GOOD";
		String g3=new String("GOOD");
		System.out.println(g1==g2);//true
		System.out.println(g1==g3);//false
		System.out.println(g1.equals(g3));//true
		
		//Ϊʲô�����������״����
		/*
		 * java�ڴ���ջ���ѣ������������֣�
		 * ���������������Ϣ�����������и���̬����������
		 * ���������������
		 * g1��g2ֱ�ӵ���GOOD�����ڰ�����ָ��ֱ��ָ�������е�GOOD��
		 * ���Զ�������ַ�����
		 * ��new String��"GOOD")����newʱ���ڶ����½�һ��ָ��ָ���ַ�������
		 * ������������ָ����е�ָ�룬���Զ��ߵ�Ȼ�Ͳ�ͬ��
		 */
		
		//������
		Person p1 =new Person();
		p1.name="hspde";
		Person p2= new Person();
		p2.name="hspde";
		
		System.out.println(p1.name.equals(p2.name));//true
		System.out.println(p1.name==p2.name);//true
		System.out.println(p1.name=="hspde");//true
		
		//����һ�£�����p1��p2���ڶ��ｨ�����������������Լ��ĳ�Ա��ϢString
		//          ��Ϊp1.name="hspde",����ֱ��ָ���˳������еĵ�ַ
		//          ��p2.nameҲ����ˣ����Զ������洢�����ݶ�Ϊͬһ����ַ
		//           ������
		//    ���ڵ�������"hspde"�������ľ������ڳ������еĵ�ַ
		
		
		//�ַ������ԣ�
		/*
		 * ������䴴���˼��������ڴ�ֲ�ͼ
		 * String s1="hello";
		 * s1="haha";
		 * 
		 * ������û��newֱ�Ӹ����ַ��������Ի�ֱ��ָ��������������û��hello��haha��
		 *      ��ᴴ���µ��ַ�����������
		 *      
		 *  �����⣺
		 *  
		 *  String a ="hello"+"abc";�����˼�������
		 *  
		 *  ����������������ɵ�ӣ������Զ��Ż�Ϊ��
		 *  String a="helloabc";
		 *  ���������û����ǰ������helloabc���Ǿʹ�����һ������
		 *  
		 *  String a="hello";
		 *  String b="abc";
		 *  String c=a+b;   �����˼�������
		 *  
		 *  ������String a��b������Ȼ����Ҫ��c��������String c����һ���ϵ㣬
		 *       ���������з�ʽ
		 *  ���ݶϵ�˳��
		 *      1.���ж�a�Ƿ�Ϊ�գ�toString
		 *      2.�������ڽ�ȥ����һ��StringBuilder sb =StringBuilder����
		 *      3.ִ��sb.append("hello")
		 *      4.ִ��sb.append("abc")
		 *      5.String c =sb.toString
		 *      ���Կ���toStringԴ�룺
		 *      public String toString() {
                   // Create a copy, don't share the array
                   return isLatin1() ? StringLatin1.newString(value, 0, count)
                   : StringUTF16.newString(value, 0, count);
                     }
		 *�����new��һ��String����ָ�������еĽ����
		 *����cָ����Ƕ��еģ�String��    value[]-->���е�"helloabc"
		 */
		//���������һ��
		String a ="hello";//����a
		String b="abc";//����b
		String c=a+b;
		
			
		
		System.out.println("----------------------");
		//�ַ������ò���
		String m1 = "core Java";
		String m2 = "Core Java";
		System.out.println(m1.charAt(3));//.charAt(num)��ȡ��numλ���ַ�
		System.out.println(m1.length());//.length()�����ַ����ĳ���
		System.out.println(m1.equals(m2));//�Ƚ������ַ����Ƿ����
		System.out.println(m1.equalsIgnoreCase(m2));//�Ƚ������ַ��������Ƿ���ͬ�����Դ�Сд
		System.out.println(m1.indexOf("Java"));//�����ַ�����Java�������ֵĵ�һ��λ��
		System.out.println(m1.indexOf("apple"));//���ַ���δ���ֹ��򷵻�-1
		
		String s =m1.replace(' ', '&');//��m1�еĿո��滻Ϊ&
		/*
		 * 1.ע�⿴replace��Ĳ���������char���ͣ����ʹ��" ",���ʾ�����ַ�����
		 * �����ᱨ��
		 * 2.ע�� ' '�м����һ���ո񣬲�ȻҲ�ᱨ��
		 * 3.��replaceԴ�룬���Կ���ʵ��ԭ�����Ǽ򵥵��滻������ֱ��������һ���µ��ַ���
		 */
		System.out.println("�滻���λ��"+s);
		
		
		System.out.println("\n-------------");
		String f ="";
		String f1="How old are you?";
		
		System.out.println(f1.startsWith("How"));//����ַ���f1�Ƿ���how��ͷ
		System.out.println(f1.endsWith("you"));//����ַ���f1�Ƿ����н�β
		f=f1.substring(4);//��ȡ���ַ�������f1�±�4λ�ÿ�ʼ
		System.out.println(f);
		f=f1.substring(4, 7);//��ȡ���ַ�������f1�±�4���±�7,������7
		System.out.println(f);
		f=f1.toUpperCase();//f1��ת��д
		System.out.println(f);
		f=f1.toLowerCase();//f1��תСд
		System.out.println(f);
		String f2="  How old are you ? ";
		f=f2.trim();//ȥ���ַ�����β�Ŀո񣬲�ȥ���ռ�Ŀո�
		System.out.println(f);
		System.out.println(f2);//ע���������µ��ַ�����Դ�ַ���û�иı�
		
		String f3="I ove Java,Java is best,Good Java!";
		String f4="JAVA";
		System.out.println(f3.lastIndexOf("Java"));//�����ҵ�һ������Java�ַ�����λ�ã�λ��������������
		System.out.println(f3.toLowerCase().indexOf(f4.toLowerCase()));//�Ƚ��ַ�������ΪСд�����ַ���һ�£����ܴ�Сд
		                                                               //Ȼ���ҵ�f3���е�һ�γ���f4��λ��
		//concat:�ַ������ӣ�replace���ַ����滻��
		//split("����")�����ݲ������ַ������зָ����һ�����飬����������ַ�����Ҫ��
		//��ת���ַ�\
		//toCharArray:תΪ�ַ�����
		//a.compareTo(b):����2���ַ�����һ������ȵĵ�iλ����Ľ����
		           //�������ַ������Ȳ�ͬ��Ȼ�����ݶ�һ�����ͷ���len��a��-len��b��
	    //.format(),������cһ����ռλ�����������
		String name="yyf";
		int age=21;
		double score=90.2130;
		char gender='M';
		String formatStr="�ҵ�����%s,����%d���ɼ�%.2f,�Ա���%c";
		String info=String.format(formatStr, name,age,score,gender);
		System.out.println(info);
		//����÷��ܺ�---��ռλ����ʽ���
	}
}
class Person{
	String name;
}
