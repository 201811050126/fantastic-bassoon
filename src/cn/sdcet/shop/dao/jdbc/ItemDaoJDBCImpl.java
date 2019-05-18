package cn.sdcet.shop.dao.jdbc;
import java.sql.*;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import cn.sdcet.shop.dao.ItemDao;
import cn.sdcet.shop.domain.Item;

public class ItemDaoJDBCImpl implements ItemDao{

	private DataSource dataSource;
	public ItemDaoJDBCImpl() throws NamingException {
		Context context = new InitialContext();
		try {
			Context context1 = new InitialContext();
			dataSource = (DataSource) context1.lookup("java:/comp/env/jdbc/SHOPPING");	
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException("查找数据源失败：" + e.getMessage());
		}
	}
	
	
	public List<Item> findAll() {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Item> items = new ArrayList<Item>();
		try {
			conn = dataSource.getConnection();
			String sql = "select id,name,pref,price,catalogId from item";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				String pref = rs.getString("pref");
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				int catalogid=rs.getInt("catalogId");
				
				Item item = new Item();
				item.setId(id);
				item.setName(name);
				item.setPref(pref);
				item.setPrice(price);
				item.setCatalogid(catalogid);
				
				items.add(item);
				
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
		return items;
	}
	@Override
	//通过分类id 查询
	public Item findById(int id) {
		return null;
	}

	@Override
	public List<Item> getItemList(int catalogId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Item> items = new ArrayList<Item>();
		try {
			conn = dataSource.getConnection();
			String sql = "select id,name,pref,price from item where CATALOGID = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, catalogId);
			rs = stmt.executeQuery();
			while(rs.next()){
				String pref = rs.getString("pref");
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				
				Item item = new Item();
				item.setId(id);
				item.setName(name);
				item.setPref(pref);
				item.setPrice(price);
				
				items.add(item);
				
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
		return items;
	}
//主页查询商品
	@Override
	public List<Item> findItemByName(String name) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Item> items = new ArrayList<Item>();
		try {
			conn = dataSource.getConnection();
			String sql = "select id,name,pref,price from item where name like ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%"+name+"%");
			rs = stmt.executeQuery();
			while(rs.next()){
				String pref = rs.getString("pref");
				int id = rs.getInt("id");
				String n = rs.getString("name");
				int price = rs.getInt("price");
				
				Item item = new Item();
				item.setId(id);
				item.setName(n);
				item.setPref(pref);
				item.setPrice(price);
				
				items.add(item);
				
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
		return items;
	}
	
	//删除商品管理里面的商品
		public void deleteItem(int id) {
			Connection connection = null;
			PreparedStatement ps = null;

			try {
				connection = dataSource.getConnection();
				String sql = "DELETE FROM Item WHERE id=?";
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
		
		//后台添加商品
		public void rootAddDao(Item item) {

			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;

			String name=item.getName();
			int price = item.getPrice();
			String pref = item.getPref();
			int catalogid=item.getCatalogid();
							
			try {
				
				conn = dataSource.getConnection();
				String sql = "insert into Item(name,price,pref,catalogid) values(?,?,?,?)";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, name);
				stmt.setInt(2 ,price);
				stmt.setString(3, pref);
				stmt.setInt(4, catalogid);
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
		@Override
		//判断用户名是否重负
		public boolean addcheck(String name) {
			// TODO Auto-generated method stub
			
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			if(name==null){
				name="";
			}
			try {
				conn = dataSource.getConnection();
				String sql = "select name from item";
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
			return true;
		}
		
		
		//后台修改商品信息
				public void updateItemInfo(Item item) {

					Connection conn = null;
					PreparedStatement stmt = null;
					ResultSet rs = null;
					
					int id=item.getId();
					String name=item.getName();
					int price = item.getPrice();
					String pref = item.getPref();
					int catalogid=item.getCatalogid();
									
					try {
						
						conn = dataSource.getConnection();
						String sql = "update Item set name=?,price=?,pref=?,catalogid=? where id=?";
						stmt = conn.prepareStatement(sql);
						stmt.setString(1, name);
						stmt.setInt(2 ,price);
						stmt.setString(3, pref);
						stmt.setInt(4, catalogid);
						stmt.setInt(5, id);
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




	}



