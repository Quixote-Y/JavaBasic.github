package junitTest;

import org.junit.jupiter.api.Test;

//����junitʹ�÷���
//���������֮ǰ��main�����еĲ�����˵��
//ʹ��������߿��Ե����Ĳ���ÿ��������������һ�����п��Զ��ʹ��
public class JunitTest {

	public static void main(String[] args) {
		
	}
	//1.���һ��@Test
	//2.��Junit5���
	@Test
	public void fun() {
		System.out.println("����fun");
	}
	
	public void m1() {
		System.out.println("����m1");
	}
}
