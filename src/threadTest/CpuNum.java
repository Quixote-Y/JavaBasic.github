package threadTest;
//��ȡcpu����
public class CpuNum {

	public static void main(String[] args) {
		Runtime runtime=Runtime.getRuntime();
		//��ȡ��ǰ����cpu����
		int cpuNum=runtime.availableProcessors();
		System.out.println("��ǰ����cpu�����ǣ�" +cpuNum);
	}
}
