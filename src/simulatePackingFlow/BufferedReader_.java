package simulatePackingFlow;

//��װ��
public class BufferedReader_ extends Reader_{

	private Reader_ in;//����һ�������ǣ�Reader_���࣬�����Ϳ��Դ����κ�һ��Reader��ʵ���࣬�����ṩ��ǿ��Ĳ���
	
	//������
	public BufferedReader_(Reader_ in) {
		super();
		this.in = in;
	}
	
	//�ļ�������
	public void fileReaders() {
		for(int i=0;i<10;i++) {
			in.fileRead();
		}
	}
	

	//�ַ���������
	public void stringReader() {
		for(int i=0;i<5;i++) {
			in.stringRead();
		}
	}
}
