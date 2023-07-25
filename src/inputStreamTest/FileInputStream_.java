package inputStreamTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

/**
 * ��������Java�з�Ϊ�����ࣺ
 *     �ֽ�������һ�ζ�1���ֽڣ�InputStream  OutputStream--�������࣬�޷�ʵ����
 *            ʵ������-> FileInputStream      BufferedInputStream           ObjectInputStream
 *                      �ļ�������            �����ֽ�������                 �����ֽ�������
 *                     OUtputҲ����ͬ
 *             
 *     
 *    
 *     �ַ�������ȡ�����ַ��ı����ʽ�� Reader  Writter-->���ǳ����࣬�޷�ʵ����
 *     
 *     �Զ������ļ����в������ֽ������ã����ַ��ļ��������ַ�������
 * @author 86136
 *
 */
public class FileInputStream_ {
	
	/*ʹ��read������ȡ��ȱ�㣬��ȡЧ�ʵ���һ��ֻ�ܶ�ȡһ���ֽ�
	 * �ֽ���һ�ζ�ȡһ���ֽڣ������ַ�����
	 */

    //��ϰFileInputStreamʹ��  ���ļ�--������
	public void readeFile01() {
		String filePath="E:\\javaTestFile\\hello.txt";
		int read=0;
		FileInputStream fileInputStream=null;//�ȳ�ʼ��Ϊ�գ���������򣬿��Ա�finally����
		try {
			fileInputStream=new FileInputStream(filePath);//�����쳣�����봦��
			while((read=fileInputStream.read())!=-1) {//read������һ�ζ�ȡһ���ֽ����ݣ��������ݵ�ascall�룬��ȡ������βû�����˷���-1
				System.out.print((char)read);	//�Ѷ�ȡ����������ת��Ϊchar�������
			}
		} catch (Exception e) {//����try catch��ʱ��ע�⣬readҲ���׳��쳣������ֱ�Ӱ�catch�쳣�޸�λ����쳣��һ���Բ���
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {//���е��������������ֶ��رգ�������Դ�˷�
			try {
				fileInputStream.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}//����Ҳ���׳��쳣���ڲ���һ��
			
		}
		
	}
	
	/*ʹ��read��byte����������ȡ
	 * 
	 */
	@Test
	public void readFile02() {
		String filePath="E:\\javaTestFile\\hello.txt";
		byte[] buf=new byte[8];//����һ��8����С��byte���飬�����洢��ȡ���ֽ�
		int read=0;
		FileInputStream fileInputStream=null;
		try {
			fileInputStream=new FileInputStream(filePath);
			while((read=fileInputStream.read(buf))!=-1) {
				//read(byte[])��һ�ζ�ȡ�����С���ֽ�������ȡ�ɹ����ض�ȡ���ֽ�������ȡʧ�ܷ���-1
				System.out.print(new String(buf,0,read));//��byte���͵�����ת��Ϊ�ַ�����
			//������ʱû���뵽��ķ����滻�����µ��ַ��������������Arrays.toString,����������ַ���Ascall��ֵ
			}
		} catch (Exception e) {//����try catch��ʱ��ע�⣬readҲ���׳��쳣������ֱ�Ӱ�catch�쳣�޸�λ����쳣��һ���Բ���
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {//���е��������������ֶ��رգ�������Դ�˷�
			try {
				fileInputStream.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}//����Ҳ���׳��쳣���ڲ���һ��
			
		}
	}
}
