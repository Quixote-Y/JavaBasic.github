package io_Stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//BufferedInputStream   BufferedOutputStreamʹ��
//BufferedInputStream��ֱ�Ӹ�����FilterInputStream
//BufferedOutputStream��ֱ�Ӹ�����FilterOutputStream
//Filter��InputStream��OutputStream��ʵ����
public class BufferedCopy02 {
	//�ֽ�����������Ƶ��ƵͼƬ��Ҳ���Դ����ı��ļ�
	public static void main(String[] args) {
		
		String srcPath="E:\\javaTestFile\\1.png";
		String desPath="E:\\javaTestFile\\1Copyy2.png";
		
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		
		byte[] data=new byte[1024];
		int dataLen=0;
		
		//ע�⣬�ֽڰ�װ����װ�Ķ���һ��Ҫ��InputStream OutputStream��ʵ�����಻Ҫ�����ַ����ڱ�
		try {
			bis =new BufferedInputStream(new FileInputStream(srcPath));
			bos =new BufferedOutputStream(new FileOutputStream(desPath,true));
			
			//copy
			while((dataLen=bis.read(data))!=-1) {
				bos.write(data, 0, dataLen);
			}
			System.out.println("�ļ������ɹ�");
			
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			try {
				bis.close();
				bos.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}

}
