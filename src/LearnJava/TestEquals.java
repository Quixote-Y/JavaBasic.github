package LearnJava;
/**
 * ��дequals����
 * @author 86136
 *
 */
public class TestEquals {

	int id;
	String name;
	public TestEquals(int id, String name) {
		
		this.id = id;
		this.name = name;
	}
	//��дequals��������ֱ������
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;//����ַ��ͬ��ֱ�ӷ���true
		if (obj == null)
			return false;//Ŀ��Ϊ�գ�����false
		if (getClass() != obj.getClass())
			return false;//���������಻ͬ������false
		TestEquals other = (TestEquals) obj;
		if (id != other.id)//�������������㣬�Ƚ϶���id
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		TestEquals e1=new TestEquals(1,"yang");
		TestEquals e2=new TestEquals(1,"yang");
		//e1��e2����һ��������ַ��ͬ��object.quals�������ԱȽ϶���������ȣ�����д
		//Ĭ�ϱȽ϶��ߵ�hashcode
		System.out.println(e1.equals(e2));//δ��дδfalse����д��δtrue
	}

	
}
