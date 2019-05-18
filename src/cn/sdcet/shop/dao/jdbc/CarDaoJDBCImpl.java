package cn.sdcet.shop.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import cn.sdcet.shop.dao.CarDao;
import cn.sdcet.shop.domain.Item;
import cn.sdcet.shop.domain.ShopCarItem;

public class CarDaoJDBCImpl implements CarDao {
	private DataSource dataSource;
	
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	public CarDaoJDBCImpl() throws NamingException {
		Context context = new InitialContext();
		dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/SHOPPING");	
		} 

	@Override
	public void delete(int itemId, int adminsId) {
		String sql = "delete from shopcaritem where adminid=? and itemid =?";
		
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, adminsId);
			stmt.setInt(2, itemId);
			stmt.executeUpdate();
			conn.commit();
		} catch (Exception e) {
    		e.printStackTrace();
    		throw new RuntimeException("删除图书条目失败：" + e.getMessage());
    	} finally {
			try {
    			if (stmt != null)
    				stmt.close();
    		} catch (Exception e) {
    			e.printStackTrace();
    			throw new RuntimeException("关闭Statement失败：" + e.getMessage());
    		} finally {
    			try {
    				if (conn != null)
    					conn.close();
    			} catch (Exception e) {
    				e.printStackTrace();
    				throw new RuntimeException("关闭Connection失败：" + e.getMessage());
    			}
    		}
		
    	}
	}

	@Override
	public void update(int itemId, int adminsId, int quantity) {

		String sql = "update ShopCarItem set quantity=? where itemId=? and adminid=?";
		
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,quantity);
			stmt.setInt(2,itemId);
			stmt.setInt(3,adminsId);
			stmt.executeUpdate();
			conn.commit();
		} catch (Exception e) {
    		e.printStackTrace();
    		throw new RuntimeException("修改购物车条目失败：" + e.getMessage());
    	} finally {
			try {
    			if (stmt != null)
    				stmt.close();
    		} catch (Exception e) {
    			e.printStackTrace();
    			throw new RuntimeException("关闭Statement失败：" + e.getMessage());
    		} finally {
    			try {
    				if (conn != null)
    					conn.close();
    			} catch (Exception e) {
    				e.printStackTrace();
    				throw new RuntimeException("关闭Connection失败：" + e.getMessage());
    			}
    		}
		
    	}
	
	}

	@Override
	public void add(int itemId, int adminsId) {

		String sql = "insert into ShopCarItem(quantity,itemId,adminID) values(1,?,?)";
		
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,itemId);
			stmt.setInt(2,adminsId);
			stmt.executeUpdate();
			conn.commit();
		} catch (Exception e) {
    		e.printStackTrace();
    		throw new RuntimeException("添加购物车条目失败：" + e.getMessage());
    	} finally {
			try {
    			if (stmt != null)
    				stmt.close();
    		} catch (Exception e) {
    			e.printStackTrace();
    			throw new RuntimeException("关闭Statement失败：" + e.getMessage());
    		} finally {
    			try {
    				if (conn != null)
    					conn.close();
    			} catch (Exception e) {
    				e.printStackTrace();
    				throw new RuntimeException("关闭Connection失败：" + e.getMessage());
    			}
    		}
		
    	}
	}

	@Override
	public void clear(int adminId) {
		String sql = "delete from shopcaritem where adminid=?";
		
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, adminId);
			stmt.executeUpdate();
			conn.commit();
		} catch (Exception e) {
    		e.printStackTrace();
    		throw new RuntimeException("清空购物车失败：" + e.getMessage());
    	} finally {
			try {
    			if (stmt != null)
    				stmt.close();
    		} catch (Exception e) {
    			e.printStackTrace();
    			throw new RuntimeException("关闭Statement失败：" + e.getMessage());
    		} finally {
    			try {
    				if (conn != null)
    					conn.close();
    			} catch (Exception e) {
    				e.printStackTrace();
    				throw new RuntimeException("关闭Connection失败：" + e.getMessage());
    			}
    		}
		
    	}
	}

	@Override
	public float getPayment(int adminsId) {
		int sum = 0;
		String sql = "select distinct price,quantity from ShopCarItem s,item i where adminid=? and i.id = s.itemid";
		
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, adminsId);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				sum += rs.getInt(1)*rs.getInt(2);
			}
			
		} catch (Exception e) {
    		e.printStackTrace();
    		throw new RuntimeException("查询商品合计总价失败：" + e.getMessage());
    	} finally {
    		try {
    			if (rs != null)
    				rs.close();
    		} catch (Exception e) {
    			e.printStackTrace();
    			throw new RuntimeException("关闭ResultSet失败：" + e.getMessage());
    		} finally {
    			try {
        			if (stmt != null)
        				stmt.close();
        		} catch (Exception e) {
        			e.printStackTrace();
        			throw new RuntimeException("关闭Statement失败：" + e.getMessage());
        		} finally {
        			try {
        				if (conn != null)
        					conn.close();
        			} catch (Exception e) {
        				e.printStackTrace();
        				throw new RuntimeException("关闭Connection失败：" + e.getMessage());
        			}
        		}
    		}
    	}
		return sum;
	}

}
