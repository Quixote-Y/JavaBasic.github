package dao_.dao;

import java.sql.Connection;
import java.sql.SQLException;

import dao_.javaBean.Goods;
import jdbc.JDBCUtilsByDruid;

public class GoodsDao extends BasicDao<Goods> {

	//这样就可以有BasicDao里面的基本方法了
	//下面可以自己为GoodsDao添加一些专门的方法
}
