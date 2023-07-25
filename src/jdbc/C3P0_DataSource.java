package jdbc;
//数据库连接池：C3P0 应用

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/* 1. 直接进行java连接数据库存在很大的隐患，首先，数据库可以承载的连接数有限，当连接数超过一定
 *     数量时，就会发生异常 COnnection too much ，除此之外 直接连接数据库 速度慢 ，效率低
 * 2. 采用数据库连接池对 java与数据库的Connection连接对象 进行管理 ，在连接池中放入一定数量的Connnection
 *     对象，当有 程序需要 获取连接时 ，直接从已有的数据库连接池里拿 ，不用时 释放引用，把链接放回池里
 * 3. 数据库连接池负责 分配 管理 释放 数据库连接 它允许应用程序重复使用一个现有的数据库连接 ，而不是新创建一个
 *     当 应用程序像数据库连接池请求的链接数量超过最大值时，这些请求被放入等待队列 
 * 
 * 
 */
/*  1.数据库连接池 ：java提供了一个接口 javax.sql.DateSource  ,数据库厂商需要实现这个接口 ，来使数据库支持 数据库连接池 功能
 * 
 *  2.数据库连接池的种类：
 *       C3P0: 稳定性
 *       Druid :德鲁伊 阿里提供的数据库连接池 ，现在最常用
 *       
 *  3. 因此就像JDBC一样的，想要使用数据库连接池功能必须 下载 相应的 jar包 导入来添加功能
 *  
 */
/*在这解决一下无法打开引用jar包的源码问题：
 *      出现这个错误的原因是，你虽然导入了.jar包，但
 *      没有配置对应的Javadoc或源码路径，
 *      所以在编辑器中无法查看源 码和对应API。
 * 
 *考虑使用jad反汇编插件来实现把class文件转换为java文件查看，初步遇到一些麻烦，安装配置完成jad插件不生效，依旧无法查看class
 *
 */
public class C3P0_DataSource {

	@Test
	public void C3P0Test() throws SQLException {
		// C3P0的使用
		// 1.必须要导入 C3P0.jar包 ，方法和JDBC一样
		// 2.就使用C3P0配套的配置文件来 实现 数据库连接池创建就好了,
		// 将对应文件导入src目录下，修改里面的参数
		// 创建---必须要传入 c3p0配置文档里你写的配置名
		ComboPooledDataSource yyf_DataSource = new ComboPooledDataSource("yyf");
		//这条语句就 数据库连接池 和数据库已经建立好了连接
		
		System.out.println("start");
		long start=System.currentTimeMillis();
		for (int i = 0; i < 5000; i++) {
			Connection connection = yyf_DataSource.getConnection();
			//
			connection.close();
		}
		long end = System.currentTimeMillis();
		System.out.println("数据库连接池C3P05000次连接耗时："+(end-start));
		//数据库连接池C3P05000次连接耗时：896  ms
	}
}
