package dao_.test;

import java.util.List;

import dao_.dao.GoodsDao;
import dao_.javaBean.Goods;

public class GoodsDaoTest {

	public static void main(String[] args) {
//		String sql_insert = "insert into goods values(1,'�����ֻ�',10000,null,null)";
		GoodsDao goodsDao = new GoodsDao();
//		goodsDao.update(sql_insert, null);
		List<Goods> list=goodsDao.queryMultiply("Select * from goods where unitprice >?", Goods.class, 1000);
		System.out.println(list);
		
		int affectedRow = goodsDao.update("update goods set unitprice =5000 where goods_name = '�����ֻ�' ", null);
		System.out.println(affectedRow>0?"�޸ĳɹ�":"û��Ӱ�쵽��");
		
		List<Goods> list2=goodsDao.queryMultiply("Select * from goods where unitprice >?", Goods.class, 1000);
		System.out.println(list2);
		
		
		
	}
}
