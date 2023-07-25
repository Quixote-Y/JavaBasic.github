package reflectionTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class Practice2 {

	public static void main(String[] args) throws Exception {
		
		Class fileClass=Class.forName("java.io.File");
		
		Constructor[] allConstructors=fileClass.getDeclaredConstructors();
		
		for(Constructor t:allConstructors) {
			System.out.println(t.getName());
			Type[] formal=t.getGenericParameterTypes();
			for(int i=0;i<formal.length;i++) {
				System.out.println("���������ǣ�"+formal[i].getTypeName());
			}
			System.out.println("����������\t"+t.toGenericString());
		}
		//��ȡ���ι�����
		Constructor constructor=fileClass.getDeclaredConstructor(String.class);//��һ��String�����Ĺ�����
		//�����ļ�����
		Object file=constructor.newInstance("E:\\javaTestFile\\���䴴��.txt");
	    //�����ļ�
		Method createNewFile=fileClass.getDeclaredMethod("createNewFile");
		createNewFile.invoke(file);
	}
}
