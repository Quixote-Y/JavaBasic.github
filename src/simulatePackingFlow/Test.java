package simulatePackingFlow;

public class Test {

	
	public static void main(String[] args) {
	
		FileReader_ fileReader_=new FileReader_();
		BufferedReader_ bufferedReader_=new BufferedReader_(fileReader_);//����һ���ļ�����Ϊ����������װ��
		                                         //����ͨ����̬���ܵ������ķ���,
		//�������ģ��㴫��BufferedReader����һ��Reader��Ȼ��BufferedReader����ķ���д��ʱ�����õ�Reader
		//�����ṩ�ķ�����������BufferedReader������Ĳ�����һ��Reader��ʵ���࣬������Ҳ��һ����Reader��ͬ���Ƶ�
		//�����������Ļ�����̬���������̳У�������д����������ָ�������������������ʹ��������д���ķ���ʱ�ͻ��̬��������ķ���
		//�����BufferedReader�е�������FileReader��fileRead��������˲Ż�������
		
		bufferedReader_.fileReaders();
	}
}
