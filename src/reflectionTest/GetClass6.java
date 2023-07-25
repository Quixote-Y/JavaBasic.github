package reflectionTest;
//6�ֻ�ȡClass�ķ����ͳ���
public class GetClass6 {

	public static void main(String[] args) throws ClassNotFoundException {
		
		//1.����֪һ�����ȫ�������Ҹ�������·���£���ͨ��Class��ľ�̬����forName��ȡ
		//         Class.forName(str)         ������׶Σ�
		
		String classAllPath="reflectionTest.Cat";
		Class<?> cls1 =Class.forName(classAllPath);
		System.out.println(cls1);
		
		//2.����.class ,�����ڲ������ݣ���ͨ�������ȡ��Ĺ���������Ĳ���   �����ؽ׶Σ�
		Class cls2=Cat.class;
		System.out.println(cls2);
		
		//3.����.getClass()   ,���Ѿ��ж���ʵ����ʱ��      �������н׶�
		Cat cat=new Cat();
		Class cls3=cat.getClass();          
		// ���������ʱ���ͣ���ͽ����˶�̬��Ϊʲôת��Ϊ�������ú���ú��������������������д��������Ϊ����Class
		// �Ծ��������Class
		System.out.println(cls3);
		
		//4.ͨ���������ClassLoader
		//(1)�ȵõ���ļ�����
		ClassLoader classLoader=cat.getClass().getClassLoader();
		//(2)ͨ����ļ������õ�Class����
		Class cls4=classLoader.loadClass(classAllPath);
		System.out.println(cls4);
		
		//5.�����������Ϳ���.class
		//6.�����������Ͷ�Ӧ�İ�װ�࣬����ͨ��.TYPE �õ�Class�����
	}
}
