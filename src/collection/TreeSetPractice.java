package collection;

import java.util.HashSet;

//һ��ϸ�ڹ���TreeSet
public class TreeSetPractice {

	@SuppressWarnings("all")
	public static void main(String[] args) {
		HashSet set=new HashSet();
		Person person1=new Person(100,"yyf");
		Person person2=new Person(50,"dmy");
		set.add(person1);
		set.add(person2);
		
		//���ȣ��ؼ������ˣ��ı���person1��name���ᷢ��ʲô
		//����ı�ҵ�table�ϵ�Node��ֵ����Ϊ����ȥ�ľ�������
		//Ȼ����ؼ��ģ����������Ϊ���ڼӵ�table����֮��Ĳ�����Ҳ����˵��ӽڵ�ʱ�����
		//hashֵ�Ѿ����ɣ������������ı�����hashֵ��
		//---����������ı������ݣ���û�иı��Ѿ����ɵ�hashֵ
		
		person1.name="zyx";///               
		
		//remove��ʱ��ͻᷢ�֣�����new Person��100,"zyx"�����ص�hashֵȥ��table��
		//����û��һ�������Ķ�����Ϊperson1���ص���new Person(100,"yyf")
		// ��������hashֵ���ص�������λ�ã�remove��Ȼ�ͻ�ʧ��
		
		set.remove(new Person(100,"zyx"));
		System.out.println(set);
		
		//��ӽڵ�Ҳ��һ������ȥ��new Person(100,"zyx")������󷵻ص�hashֵ�����������λ��
		//�ᷢ���ڸ��ط���û�к���һ���ģ�Ȼ����ӽ�ȥ
		set.add(new Person(100,"zyx"));
		System.out.println(set);
		
		//�����ӾͿ����ҵ�person1���ڵ�λ�ã���Ϊperson1��λ�þ��������������ȥ֮��
		//������������Ԫ�أ��Ǿͻ����equals��������equals�����Ѿ���д�ˣ����Ƚϵ��������
		//id��name��person1��name�类���ˣ���ô���ͻ������ڵ�Ҳ���뵽table��
		set.add(new Person(100,"yyf"));
		System.out.println(set);
		
		
		
		
		//��ϸ�ڣ�Ҳ˵����set��������ȫ�޷�������ͬ�����ݣ�����Թ���Ԫ�ؽ����޸ģ��Ǿ�Ҫ�ܽ���
		
	}
}
class Person{
	public int id;
	public String name;
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	
}