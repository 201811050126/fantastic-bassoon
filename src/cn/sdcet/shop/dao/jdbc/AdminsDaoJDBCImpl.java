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

import cn.sdcet.shop.dao.AdminsDao;
import cn.sdcet.shop.domain.Admins;
import cn.sdcet.shop.domain.Item;

public class AdminsDaoJDBCImpl implements AdminsDao {
	private DataSource dataSource;
	public AdminsDaoJDBCImpl() throws NamingException {
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
	//≈–∂œ◊¢≤·√˚ «∑Ò÷ÿ∏¥
	public boolean registerCheckAdmins(String name) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		if(name==null){
			name="";
		}
		try {
			conn = dataSource.getConnection();
			String sql = "select name from admins";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				String n = rs.getString(1);
				if(name.equals(n)){
					return false;
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
		return true;
	}

	@Override
	//µ«¬º≈–∂œ
	public boolean hasMatchAdmins(String name, String password) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		if(name==null){
			name="";
		}else if(password==null){
			password="";
		}
		try {
			conn = dataSource.getConnection();
			String sql = "select name,password from admins";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				String n = rs.getString(1);
				String p = rs.getString(2);
				if(name.equals(n)&&password.equals(p)){
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

	@Override
	//◊¢≤·”√ªß
	public void addAdmins(Admins admins) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		int id = admins.getId();
		String name = admins.getName();
		String password = admins.getPassword();
		String email = admins.getEmail();
		try {
			conn = dataSource.getConnection();
			String sql = "insert into Admins(name,password,email) values(?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, password);
			stmt.setString(3, email);
			stmt.executeUpdate();
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
		
	}

	@Override
	//Õ®π˝name≤È—Øid
	public int getAdminsIdByName(String name) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int id = 0;
		try {
			conn = dataSource.getConnection();
			String sql = "select id from admins where name = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,name);
			rs = stmt.executeQuery();
			if(rs.next()){
				id = rs.getInt(1);
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
		return id;
	}
	
	//Õ®π˝id≤È—Ø√˚◊÷
	public String getAdminsIdById(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String name=null;
		try {
			conn = dataSource.getConnection();
			String sql = "select name from admins where id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,id);
			rs = stmt.executeQuery();
			if(rs.next()){
				name = rs.getString(1);
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
		return name;
	}
	
	//Õ®π˝id≤È—Ø√˚◊÷
		public String getAdminsemailById(int id) {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			String email=null;
			try {
				conn = dataSource.getConnection();
				String sql = "select email from admins where id = ?";
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1,id);
				rs = stmt.executeQuery();
				if(rs.next()){
					email = rs.getString(1);
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
			return email;
		}
}
