package cn.sdcet.shop.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import cn.sdcet.shop.dao.rootDao;

public class rootDaoJDBCImpl implements rootDao {
	private DataSource dataSource;
	public rootDaoJDBCImpl() throws NamingException {
		Context context = new InitialContext();
		try {
			Context context1 = new InitialContext();
			dataSource = (DataSource) context1.lookup("java:/comp/env/jdbc/SHOPPING");	
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException("≤È’“ ˝æ›‘¥ ß∞‹£∫" + e.getMessage());
		}
	}
	@Override
	public boolean rootlogincheck(String rootname, String rootpsword) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		if(rootname==null){
			rootname="";
		}else if(rootpsword==null){
			rootpsword="";
		}
		try {
			conn = dataSource.getConnection();
			String sql = "select rootname,rootpsword from root";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				String n = rs.getString(1);
				String p = rs.getString(2);
				if(rootname.equals(n)&&rootpsword.equals(p)){
					return true;
				}
			}
			}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("≤È—Ø ß∞‹£∫" + e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("πÿ±’ResultSet ß∞‹£∫" + e.getMessage());
			} finally {
				try {
					if (stmt != null) {
						stmt.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException("πÿ±’PreparedStatement ß∞‹£∫"
							+ e.getMessage());
				} finally {
					try {
						if (conn != null) {
							conn.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
						throw new RuntimeException("πÿ±’Connection ß∞‹£∫"
								+ e.getMessage());
					}
				}
			}
		}
		return false;
	}
public void updateroot(String rootpasswrd){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		
		try {
			conn = dataSource.getConnection();
			String sql = "update root set rootpsword=? where rootname='admin'";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, rootpasswrd);
			//stmt.setInt(2, id);
			stmt.executeUpdate();
			}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("–ﬁ∏ƒ ß∞‹£∫" + e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("πÿ±’ResultSet ß∞‹£∫" + e.getMessage());
			} finally {
				try {
					if (stmt != null) {
						stmt.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException("πÿ±’PreparedStatement ß∞‹£∫"
							+ e.getMessage());
				} finally {
					try {
						if (conn != null) {
							conn.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
						throw new RuntimeException("πÿ±’Connection ß∞‹£∫"
								+ e.getMessage());
					}
				}
			}
		}

}

}

