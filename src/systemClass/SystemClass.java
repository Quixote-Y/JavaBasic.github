package systemClass;

import java.util.Arrays;

//System�ೣ�÷���
public class SystemClass {

	
	public static void main(String[] args) {
		//exit(0)�˳�����
		//0��ʾһ��״̬��������״̬
		
//	     System.out.println("OK!");
//       System.exit(0);
//	     System.out.println("OK2");
		
		//arraycopy:��������Ԫ�أ��Ƚ��ʺϵײ���ã�
		//һ��ʹ��Arrays.copy����ɸ������飬�����ĵײ���õ�Ҳ��arraycopy����
		int[] src= {1,2,3};
		int[] des=new int[3];
		//����Ϊ��Դ���飬Դ��㣬Ŀ�����飬Ŀ����㣬������Ŀ
		System.arraycopy(src, 0, des, 0, src.length);
		System.out.println(Arrays.toString(src));
		System.out.println(Arrays.toString(des));
		//currentTimeMillis():���ص�ǰʱ�䵽1970��1��1�յĺ�����
		long time=System.currentTimeMillis();
		System.out.println(time);
		//��������gc��������
		System.gc();
	}
}
