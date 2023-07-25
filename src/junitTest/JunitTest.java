package junitTest;

import org.junit.jupiter.api.Test;

//测试junit使用方法
//相比于我们之前在main方法中的测试来说，
//使用这个工具可以单独的测试每个方法，并且在一个类中可以多次使用
public class JunitTest {

	public static void main(String[] args) {
		
	}
	//1.添加一个@Test
	//2.将Junit5添加
	@Test
	public void fun() {
		System.out.println("调用fun");
	}
	
	public void m1() {
		System.out.println("调用m1");
	}
}
