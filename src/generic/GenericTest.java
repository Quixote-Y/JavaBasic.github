package generic;

import java.util.ArrayList;

//���ͽ���
public class GenericTest {

	public static void main(String[] args) {
		//1.����ķ����У����ǲ��ܶԼ��뵽ArrayList�е��������ͽ���Լ����
		//Ȼ�����list��ʱ��list�෵��������Object�������ֶ�ת��Ϊָ�������ͣ���Ч����Ӱ�죬�ڼ����׷�������ת������
		// Ϊ�˶ž����Ƶ�������֣�����ʹ�÷���
		
		//2.���ͣ��ֳƲ��������ͣ�Ҳ����ָ��������ʲô�����ͣ������ʼ�������ʱ��ָ������
		//��ô�ڱ����ʱ����������ܷ�������ֵ����ָ���Ķ����ǲ���һ�����ͣ�Ȼ��Ѵ��������������
		//��������������ʱ�׳��쳣
		
		//3.���Ϳ��������ӿ�����ʱͨ��һ����ʶ����T��E�ȣ���ʾ���е�ĳ�����ԣ�����ĳ�������ķ���ֵ���ͣ������ǲ�������
		//  ������Ҳ���ԣ��ڵ�������ʼ����ʱ��ָ������������ķ���ֵ
	
		//���͵�һЩϸ�ڣ�
		//���Ͳ����滻������������ֻ������������--��Integer String Dog
		//�ٸ�����ָ���������ͺ󣬿��Դ�������ͻ���������
		//���������Զ����������ƶϣ������ֻ�����д���͵�ֵ���ұߵı��������Զ���ȫ
		//�������û��ָ������Ĭ����Object
		
		//���Ͷ�������鲻�ܳ�ʼ������Ϊ�����ڶ��󴴽�֮ǰ�ǲ�֪��������ָ��ľ������͵ģ��ײ��޷�ȷ�������������ĵ�ַ�ռ�
		//���Ͳ��ܳ����ھ�̬�������������̬���������࣬���ཨ��ʱ��ʼ������ʱ���ͻ�û��ֵ�������޷�����
		
		//���ͽӿ��о�̬��Ա�����÷��ͣ�Ȼ��ӿ��е�����Ĭ�϶���static����������Զ������÷���
		 //     ���ͽӿ��ڼ̳к�ʵ�ֵ�ʱ��ָ���������ͣ�Ȼ���滻�ӿ���ķ���
		//             û�ж��巺�ͣ�Ĭ��Object---��д��Ĭ�ϣ���Ըд����Object
		
		//���ͷ������Զ�������ͨ���У�Ҳ���Զ����ڷ�������
		//   public<T,R> void fly(T t,R r){}//���ͷ���
		//     //�����÷��ͷ���ʱ������������������ͻ�ȷ������
		//    car.fly("����",100);
		//    car.fly(100,100.2);//�����÷��ͷ���ʱ������������������ͻ�ȷ������,���ó���Ա��ȥдɶ�����
		//    public void hi(T t){}//�ⲻ�Ƿ��ͷ�������ֻ�Ƿ����������ͨ����
		//  ���ͷ������Ե����Լ������ķ��ͣ�Ҳ����ʹ�÷����������ķ���
		//  public<K> void fun(K k,T t){}//TΪ������ķ��Ͳ����ǿ��Ե�---���о��ؼ������������÷��ͷ������ùܱ�ģ�ֱ�Ӹ�����ֵ�ͺ��ˣ�������������ж���������
		
		//����û�м̳��ԣ�������
		// List<Object> list=new ArrayList<String>(),����String�̳�Object���Ǵ����
		
		//���ͺ�ͨ���
		//   <? >            :���Խ����κ���������
		//   <? extends A >  :���Խ���A�༰�����࣬��ʾ����
		//   <? super A >    :���Խ���A�༰�丸�࣬��ʾ����		
		
		
		//�Զ��巺���ࣺҲ������������ʹ���˷���
		
	    Dog<Integer> dog1=new Dog<>("dmy",21);
	    Dog<String> dog2=new Dog<>("dmy","����21");//���͵�����
	    ArrayList<Dog> list=new ArrayList<>();//��ʼ����ʱ���������͵�����
	    //�����Ļ��������Ϳ�һʶ������뵽����Ķ��������Ƿ���Dog���ͣ�Ȼ����㷴����
	    list.add(dog1);
	    list.add(dog2);
	    //�Ӹ�Cat��ȥ�ͻᱨ��
	    //list.add(new Cat("zyx" ,10));
	    //���� ArrayList<Dog> �еķ��� add��Dog�����ڲ�����Cat��������
	    //��������age��������û�в��
	    dog1.show();
	    dog2.show();
	}
}
class Dog<E>{
	String name;
	E age;
	public Dog(String name, E age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + "]";
	}
	public void show() {
		System.out.println(age.getClass());//����age������ʱ����
	}
}
class Cat<E>{
	String name;
	E age;
	public Cat(String name, E age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + "]";
	}
	public void show() {
		System.out.println(age.getClass());//����age������ʱ����
	}
}
