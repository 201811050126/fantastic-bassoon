package cn.sdcet.shop.dao.jdbc;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import cn.sdcet.shop.dao.CatalogDao;
import cn.sdcet.shop.domain.Admins;
import cn.sdcet.shop.domain.Catalog;
import cn.sdcet.shop.domain.Item;

public class CatalogDaoJDBCImpl implements CatalogDao {
	private DataSource dataSource;
	public CatalogDaoJDBCImpl() throws NamingException {
		Context context = new InitialContext();
		try {
			Context context1 = new InitialContext();
			dataSource = (DataSource) context1.lookup("java:/comp/env/jdbc/SHOPPING");	
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException("查找数据源失败：" + e.getMessage());
		}
	}
	@Override
	//查询所与分离
	public List<Catalog> findAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Catalog> catalogs = new ArrayList<Catalog>();
		try {
			conn = dataSource.getConnection();
			String sql = "select id,name from catalog";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				
				Catalog catalog = new Catalog();
				catalog.setId(id);
				catalog.setName(name);
				
				catalogs.add(catalog);
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
		return catalogs;
	}
	//通过分类id查询 分类名称
	public String findnameBycatalogId(int catalogId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String name=null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "select name from catalog where id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, catalogId);
			rs = stmt.executeQuery();
			if(rs.next()){
				name = rs.getString(1);
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
		return name;
	}
	
	//添加分类
	public void addCatalog(String name) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		
		try {
			conn = dataSource.getConnection();
			String sql = "insert into Catalog(name) values(?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.executeUpdate();
			}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加失败：" + e.getMessage());
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
	
	
	//删除分类
	public void deleteCatalog(int id) {
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			connection = dataSource.getConnection();
			String sql = "DELETE FROM Catalog WHERE id=?";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("删除分类失败：" + e.getMessage());
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
	//修改分类名称

		public void updateCatalog(int id,String name) {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			
			try {
				conn = dataSource.getConnection();
				String sql = "update Catalog set name=? where id=?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, name);
				stmt.setInt(2, id);
				stmt.executeUpdate();
				}catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("修改失败：" + e.getMessage());
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
	


}
