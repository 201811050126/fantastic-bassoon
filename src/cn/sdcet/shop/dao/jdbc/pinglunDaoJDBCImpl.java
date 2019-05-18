package cn.sdcet.shop.dao.jdbc;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import cn.sdcet.shop.dao.PinglunDao;
import cn.sdcet.shop.domain.Admins;
import cn.sdcet.shop.domain.Pinglun;

public class pinglunDaoJDBCImpl implements PinglunDao {
	private DataSource dataSource;
	public pinglunDaoJDBCImpl() throws NamingException {
		Context context = new InitialContext();
		try {
			Context context1 = new InitialContext();
			dataSource = (DataSource) context1.lookup("java:/comp/env/jdbc/SHOPPING");	
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException("查找数据源失败：" + e.getMessage());
		}
	}
	
	//查询所有评论
	public List<Pinglun> findAllPinglun() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Pinglun> pingluns = new ArrayList<Pinglun>();
		try {
			conn = dataSource.getConnection();
			String sql = "select id,adminId,itemId,content,time from Pinglun";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				int id=rs.getInt("id");
				int adminId = rs.getInt("adminId");
				int itemId=rs.getInt("itemId");
				String content = rs.getString("content");
				String time = rs.getString("time");


				Pinglun pinglun = new Pinglun();
				pinglun.setId(id);
				pinglun.setAdminId(adminId);
				pinglun.setItemId(itemId);
				pinglun.setContent(content);
				pinglun.setTime(time);


				pingluns.add(pinglun);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return pingluns;
	}

	//根据商品id查询所有评论
	public List<Pinglun> findPinglunByItemId(int itemId){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Pinglun> pingluns = new ArrayList<Pinglun>();
		try {
			conn = dataSource.getConnection();
			String sql = "select id,adminID,content,time from Pinglun where itemId= ? ";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,itemId);
			rs = stmt.executeQuery();
			while(rs.next()){
				int adminId = rs.getInt("adminId");
				String content = rs.getString("content");
				String time = rs.getString("time");


				Pinglun pinglun = new Pinglun();
				pinglun.setAdminId(adminId);
				pinglun.setContent(content);
				pinglun.setTime(time);


				pingluns.add(pinglun);

			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败：" + e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭ResultSet失败：" + e.getMessage());
			} finally {
				try {
					if (stmt != null) {
						stmt.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException("关闭PreparedStatement失败："
							+ e.getMessage());
				} finally {
					try {
						if (conn != null) {
							conn.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
						throw new RuntimeException("关闭Connection失败："
								+ e.getMessage());
					}
				}
			}
		}
		return pingluns;
	}
	
	//发表评论
	public void addPinglun(Pinglun pinglun) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		int itemId = pinglun.getItemId();
		int adminId = pinglun.getAdminId();
		String content = pinglun.getContent();
		String time =pinglun.getTime();
		try {
			conn = dataSource.getConnection();
			String sql = "insert into Pinglun(itemId,adminId,content,time) values(?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, itemId);
			stmt.setInt(2, adminId);
			stmt.setString(3, content);
			stmt.setString(4, time);
			stmt.executeUpdate();
			}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败：" + e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭ResultSet失败：" + e.getMessage());
			} finally {
				try {
					if (stmt != null) {
						stmt.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException("关闭PreparedStatement失败："
							+ e.getMessage());
				} finally {
					try {
						if (conn != null) {
							conn.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
						throw new RuntimeException("关闭Connection失败："
								+ e.getMessage());
					}
				}
			}
		}
		
	}
	
	//删除评论
	public void deletePinglun(int id) {
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			connection = dataSource.getConnection();
			String sql = "DELETE FROM Pinglun WHERE id=?";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("删除评论失败：" + e.getMessage());
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭PreparedStatement失败："
						+ e.getMessage());
			} finally {
				try {
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException("关闭Connection失败："
							+ e.getMessage());
				}
			}
		}

	}



}


