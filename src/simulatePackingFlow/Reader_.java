package simulatePackingFlow;
//模拟包装流（处理流）的底层机制
//数据处理流分为：
/*
               节点流                                 包装流（处理流）
         底层流，直接和一个数据源相接，            对节点流进行包装，提供更加强大的数据处理功能
         提供基本的数据源数据处理方式                   装饰器模式
         
    次包的代码尾模拟简单的装饰器模式
 */

//抽象类/接口
public abstract class Reader_ {

	//这是一般的方法，需要写多个来实现多态
	public void fileRead() {};
	public void stringRead() {};
	
	
	//你也可以直接写一个抽象的Read方法，不区分类型，这样就可以一个接口统一管理
	//public abstract void Read();//然后子类再去一一实现他就可以了
}
