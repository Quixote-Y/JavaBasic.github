package LearnJava;
/**
 * ��дtoString
 * @author 86136
 *
 */
public class TestToString {

	int number;
	String name;
	
	TestToString(int a,String b){
		number=a;
		name=b;
	}
	//���Ա�����ֱ�����ɣ��Ҽ������ҵ�Դ�룬�������tostring����
	@Override
	public String toString() {
		return "TestToString [number=" + number + ", name=" + name + "]";
	}

	public static void main(String[] args) {
		TestToString s1=new TestToString(1,"yang");
		System.out.println(s1.toString());
		
		//toStringΪobject��ĳ�Ա���������е��඼���Ե�����������ĸ���
		//û��д��tostring
		//public String toString() {
        //return getClass().getName() + "@" + 
		//Integer.toHexString(hashCode());
        //}
		
		
		
		
	}
}
