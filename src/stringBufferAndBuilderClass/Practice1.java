package stringBufferAndBuilderClass;
//StringBUfferӦ��
import java.util.Scanner;

/*
 * ������Ʒ���ƺͼ۸�Ҫ���ӡЧ�����У�
 * ��Ʒ�� ��Ʒ�۸�
 * �ֻ� 123��564.59
 * Ҫ�󣺼۸��С����ǰ��ÿ��λ��С�������
 */
public class Practice1 {

	public static void main(String[] args) {
		System.out.println("��������Ʒ������Ʒ�۸�");
		StringBuffer stringBuffer=new StringBuffer();
		stringBuffer.append("��Ʒ��\t��Ʒ�۸�\n");
	
		Scanner scanner=new Scanner(System.in);
		String name=scanner.nextLine();
		String price=scanner.next();
		//����Ʒ���ӵ�buffer��
		stringBuffer.append(name+"\t");
		
		//����۸�ĸ�ʽ
		StringBuffer priceBuffer=new StringBuffer(price);
		int index=priceBuffer.lastIndexOf(".");
		for(;;) {
			if(index-3<=0)break;
			priceBuffer.insert(index-3, ",");//���룬
			index-=3;
		}
		stringBuffer.append(priceBuffer+"\n");
		System.out.println(stringBuffer);
	}
}
//����һ��forѭ�������ʵ���ظ�����