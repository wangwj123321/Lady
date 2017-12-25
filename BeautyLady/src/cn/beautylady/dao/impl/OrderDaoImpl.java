package cn.beautylady.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import cn.beautylady.dao.BaseDao;
import cn.beautylady.dao.OrderDao;
import cn.beautylady.entity.BuyCar;
import cn.beautylady.entity.Order;
import cn.beautylady.entity.OrderDetail;

public class OrderDaoImpl extends BaseDao implements OrderDao{

	@Override
	public int[] addOrder(Order order,List<OrderDetail> Details,List<BuyCar> cars) {
		String orderNo="";
		while (true) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
			Date date = new Date();
			String nn = sdf.format(date);
			Random random = new Random();
			int ran = random.nextInt(1000);
			orderNo = nn + ran;
			Order sure=getOrderByOrderNo(orderNo);
			if (sure==null) {
				break;
			}
		}
		List<String> sqls=new ArrayList<>();
		String addOrder=String.format("INSERT INTO `order` VALUES(NULL,'%s','%s','%s',%d,NOW(),%f,0)", orderNo,order.getUserAccount(),order.getUserName(),order.getAddressID(),order.getCostPrice());
		sqls.add(addOrder);
		for (BuyCar buyCar : cars) {
			String sql=String.format("UPDATE `buycar` SET `status`=2 WHERE id=%d", buyCar.getId());
			sqls.add(sql);
		}
		for (OrderDetail detail : Details) {
			String sql=String.format("INSERT INTO `orderdetail` VALUES(NULL,'%s','%s','%s','%s',%f,%d,%f,%f)",orderNo,detail.getColorNo(),detail.getSizeNo(),detail.getProductNo(),detail.getTagPrice(),detail.getCount(),detail.getAmount(),detail.getZk() );
			sqls.add(sql);
		}
		int[] counts=transactionExcute(sqls);
		return counts;
	}

	@Override
	public Order getOrderByOrderNo(String orderNo) {
		String sql="SELECT * FROM `order` WHERE orderNo=?";
		return getOne(sql, Order.class, orderNo);
	}

	@Override
	public Order getUserAccountLastOrder(String userAccount) {
		String sql="SELECT * FROM `order` WHERE userAccount=? ORDER BY createDate DESC";
		return getOne(sql, Order.class, userAccount);
	}

	@Override
	public int addOrderDetail(OrderDetail orderDetail) {
		String sql="INSERT INTO `orderdetail` VALUES(NULL,?,?,?,?,?,?,?,?)";
		Object[] objs= {orderDetail.getOrderNo(),orderDetail.getColorNo(),orderDetail.getSizeNo(),orderDetail.getProductNo(),orderDetail.getTagPrice(),orderDetail.getCount(),orderDetail.getAmount(),orderDetail.getZk()};
		int count=0;
		try {
			count=executeUpdate(sql, objs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Order> getOrderByUserAccount(String userAccount) {
		String sql = "select * from `order` where userAccount = ? order by createDate desc";
		return getArrayList(sql, Order.class, userAccount);
	}

	@Override
	public List<OrderDetail> getOrderDetailByOrderNo(String orderNo) {
		String sql = "select * from `orderdetail` where orderNo = ?";
		return getArrayList(sql, OrderDetail.class, orderNo);
	}

	@Override
	public OrderDetail getOrderDetailById(Integer id) throws NoSuchFieldException, NoSuchMethodException,
			IllegalAccessException, InstantiationException, InvocationTargetException, SQLException {
		String sql = "select * from `orderdetail` where id = ?";
		return selectOne(OrderDetail.class, sql, id);
	}

	@Override
	public int updateOrderStatus(int orderId, int status) {
		String sql="UPDATE `order` SET `status`=? WHERE id=?";
		int count=0;
		try {
			count=executeUpdate(sql, status,orderId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Order> getListOrder(int pageNo,int pageSize) {
		String sql="SELECT `order`.*,`address`.`address`,`address`.`name`,`address`.`phone` \r\n" + 
				"FROM `order`,`address`\r\n" + 
				"WHERE `order`.`addressID`=`address`.`id` LIMIT ?,?";
		return getArrayList(sql, Order.class,pageNo,pageSize);
	}

	@Override
	public int getOrderCount() {
		int count=getCountByClass(Order.class);
		return count;
	}
	
}
