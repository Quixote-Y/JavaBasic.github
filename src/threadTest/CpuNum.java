package threadTest;
//获取cpu数量
public class CpuNum {

	public static void main(String[] args) {
		Runtime runtime=Runtime.getRuntime();
		//获取当前电脑cpu数量
		int cpuNum=runtime.availableProcessors();
		System.out.println("当前电脑cpu数量是：" +cpuNum);
	}
}
