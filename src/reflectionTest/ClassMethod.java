package reflectionTest;

import java.lang.reflect.Field;

//Class�ೣ�÷���
public class ClassMethod {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
		String str="reflectionTest.Cat";
		//��ȡ��Class��Ķ��� ����ʾ��ȷ����java���ͣ���д�ɲ�д
		Class<?> cls=Class.forName(str);
		
		//��ʾClass�������ĸ����Class����
		System.out.println(cls);//����������Class��Ķ��������ĸ���   Cat
		
		//��ʾ����ʱ����
		System.out.println(cls.getClass());
		//�����������ʱ���ͣ�����Class��������Բ���ֱ�Ӱ�Class����ǿתΪCat����
		
		//��ȡ���·���������ļ�λ��
		System.out.println(cls.getPackageName());
		
		//��ȡ���ȫ����������
		System.out.println(cls.getName());
		
		//��������ʵ��-->�������o���������;���Cat����ˣ������ǿתΪCat
		Object o=cls.newInstance();
		System.out.println("o������ʱ����Ϊ��"+o.getClass());
		//ͨ�������ȡ����
		Field field=cls.getField("age");
		System.out.println("age �ǣ�"+field.get(o));//��Ա������get��������invoke
		//��������ֵ
		field.set(o, 100);//��һ������Ϊ����ʵ�����ڶ���Ϊ�ı����Ե�ֵ
		System.out.println("age���˺��ǣ�"+field.get(o));
		//��ȡ��������
		Field[] fields=cls.getFields();
		for(Field f:fields) {
			System.out.print(f.getName()+"\t\t");//���������
		}
		//Class����� Constructor�����  Field����� Method����� ���ǰ�����API���������õ����������Ϣ�����в��������������ڲ�Api�ĵ�
		//�����ǵ�Api�� get ... һ�������֣���getMethod("A")��ֻ���õ����еķ���A��һ�㻹����һ��getdeclaredMethod("A")�����Ϳ����õ�˽�еķ���A��
		//���õ�˽�еķ���������ֱ�ӽ��в������ᱨ���� ���� .setAccessible(true);
		//˽�����ԣ��������������������
		//ֱ�ӵ���Class.newInstance();ʵ���ϵ��õ����޲ι��캯�������������вι��캯�����ȵ��õ��вι��캯������Ȼ����вι��캯������.newInstance(����)����
		//����ֵ�� �����йصķ���ֵ������Object���󷵻أ�  һ����������String���ͣ�����������������صı������;���Object������������String
		
		
	}
}
