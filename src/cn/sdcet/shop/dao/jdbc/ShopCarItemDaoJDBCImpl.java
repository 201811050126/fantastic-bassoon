package cn.sdcet.shop.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import cn.sdcet.shop.dao.ShopCarItemDao;
import cn.sdcet.shop.domain.Item;
import cn.sdcet.shop.domain.ShopCarItem;

public class ShopCarItemDaoJDBCImpl implements ShopCarItemDao {
	private DataSource dataSource;
	
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	public ShopCarItemDaoJDBCImpl() throws NamingException {
		Context context = new InitialContext();
		dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/SHOPPING");	
		}

	@Override
	public List<ShopCarItem> findAll(int adminsId) {
		List<ShopCarItem> shopCarItems = new ArrayList<ShopCarItem>();
		
		String sql = "select distinct i.id,name,price,pref,quantity from ShopCarItem s,item i where adminid=? and i.id = s.itemid order by i.id";
		
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, adminsId);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				Item item = new Item();
				
				item.setId(rs.getInt(1));
				item.setName(rs.getString(2));
				item.setPrice(rs.getInt(3));
				item.setPref(rs.getString(4));
				int quantity = rs.getInt(5);
				
				ShopCarItem shopCarItem = new ShopCarItem(item, quantity);
				
				shopCarItems.add(shopCarItem);
			}
			
		} catch (Exception e) {
    		e.printStackTrace();
    		throw new RuntimeException("≤È—Øπ∫ŒÔ≥µ ß∞‹£∫" + e.getMessage());
    	} finally {
    		try {
    			if (rs != null)
    				rs.close();
    		} catch (Exception e) {
    			e.printStackTrace();
    			throw new RuntimeException("πÿ±’ResultSet ß∞‹£∫" + e.getMessage());
    		} finally {
    			try {
        			if (stmt != null)
        				stmt.close();
        		} catch (Exception e) {
        			e.printStackTrace();
        			throw new RuntimeException("πÿ±’Statement ß∞‹£∫" + e.getMessage());
        		} finally {
        			try {
        				if (conn != null)
        					conn.close();
        			} catch (Exception e) {
        				e.printStackTrace();
        				throw new RuntimeException("πÿ±’Connection ß∞‹£∫" + e.getMessage());
        			}
        		}
    		}
    	}
		return shopCarItems;
	}

}
