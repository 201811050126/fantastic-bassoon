package cn.sdcet.shop.dao.jdbc;
import java.sql.*;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import cn.sdcet.shop.dao.GoodsDao;
import cn.sdcet.shop.domain.Goods;

public class GoodsDaoJDBCImpl implements GoodsDao{

	private DataSource dataSource;
	public GoodsDaoJDBCImpl() {
		try {
		Context context = new InitialContext();
			Context context1 = new InitialContext();
			dataSource = (DataSource) context1.lookup("java:/comp/env/jdbc/SHOPPING");	
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException("≤È’“ ˝æ›‘¥ ß∞‹£∫" + e.getMessage());
		}
	}
	
	
	public List<Goods> findAll() {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Goods> goodsList = new ArrayList<Goods>();
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT gNo,gId ,gType ,gColor ,gSize ,gNum ,gPrice_input ,gPrice ,gSale FROM Goods";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				int gNo = rs.getInt("gNo");
				String gId = rs.getString("gId");
				String gType = rs.getString("gType");
				String gColor = rs.getString("gColor");
				String gSize = rs.getString("gSize");
				int gNum = rs.getInt("gNum");
				double gPrice_input = rs.getDouble("gPrice_input");
				double gPrice = rs.getDouble("gPrice");
				double gSale = rs.getDouble("gSale");
				
				Goods goods =  new Goods(gNo, gId, gType, gColor, gSize, gNum, gPrice_input, gPrice, gSale);
				
				goodsList.add(goods);
				
				
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
		return goodsList;
	}

	public Goods getGoodsByType(int gType) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		Goods goods = new Goods();
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT gNo,gId ,gType ,gColor ,gSize ,gNum ,gPrice_input ,gPrice ,gSale FROM Goods WHERE gType like'a%' ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, gType);
			rs = stmt.executeQuery();
			while(rs.next()){
				int gNo2 = rs.getInt("gNo");
				String gId = rs.getString("gId");
				String gType1 = rs.getString("gType");
				String gColor = rs.getString("gColor");
				String gSize = rs.getString("gSize");
				int gNum = rs.getInt("gNum");
				double gPrice_input = rs.getDouble("gPrice_input");
				double gPrice = rs.getDouble("gPrice");
				double gSale = rs.getDouble("gSale");
				
				goods =  new Goods(gNo2, gId, gType1, gColor, gSize, gNum, gPrice_input, gPrice, gSale);
				
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
		return goods;
	}
	
	public Goods getGoodsByGNo(int gNo) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		Goods goods = new Goods();
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT gNo,gId ,gType ,gColor ,gSize ,gNum ,gPrice_input ,gPrice ,gSale FROM Goods WHERE gNo = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, gNo);
			rs = stmt.executeQuery();
			while(rs.next()){
				int gNo2 = rs.getInt("gNo");
				String gId = rs.getString("gId");
				String gType = rs.getString("gType");
				String gColor = rs.getString("gColor");
				String gSize = rs.getString("gSize");
				int gNum = rs.getInt("gNum");
				double gPrice_input = rs.getDouble("gPrice_input");
				double gPrice = rs.getDouble("gPrice");
				double gSale = rs.getDouble("gSale");
				
				goods =  new Goods(gNo2, gId, gType, gColor, gSize, gNum, gPrice_input, gPrice, gSale);
				
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
		return goods;
	}
//÷˜“≥≤È—Ø…Ã∆∑
	@Override
	public List<Goods> findGoodsByName(String name) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Goods> goodsList = new ArrayList<Goods>();
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT gNo,gId ,gType ,gColor ,gSize ,gNum ,gPrice_input ,gPrice ,gSale FROM Goods WHERE gId like ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			rs = stmt.executeQuery();
			while(rs.next()){
				int gNo2 = rs.getInt("gNo");
				String gId = rs.getString("gId");
				String gType = rs.getString("gType");
				String gColor = rs.getString("gColor");
				String gSize = rs.getString("gSize");
				int gNum = rs.getInt("gNum");
				double gPrice_input = rs.getDouble("gPrice_input");
				double gPrice = rs.getDouble("gPrice");
				double gSale = rs.getDouble("gSale");
				
				Goods goods =  new Goods(gNo2, gId, gType, gColor, gSize, gNum, gPrice_input, gPrice, gSale);
				
				goodsList.add(goods);
				
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
		return goodsList;
	}
	
	//…æ≥˝…Ã∆∑π‹¿Ì¿Ô√Êµƒ…Ã∆∑
		public void deleteGoods(int gNo) {
			Connection connection = null;
			PreparedStatement ps = null;

			try {
				connection = dataSource.getConnection();
				String sql = "DELETE FROM Goods WHERE gNo=?";
				ps = connection.prepareStatement(sql);
				ps.setInt(1, gNo);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("…æ≥˝∑÷¿‡ ß∞‹£∫" + e.getMessage());
			} finally {
				try {
					if (ps != null) {
						ps.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException("πÿ±’PreparedStatement ß∞‹£∫"
							+ e.getMessage());
				} finally {
					try {
						if (connection != null) {
							connection.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
						throw new RuntimeException("πÿ±’Connection ß∞‹£∫"
								+ e.getMessage());
					}
				}
			}

		}
		
		//∫ÛÃ®ÃÌº”…Ã∆∑
		public void rootAddDao(Goods goods) {

			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;

							
			try {
				
				conn = dataSource.getConnection();
				String sql = "insert into Goods(gId ,gType ,gColor ,gSize ,gNum ,gPrice_input ,gPrice ,gSale) values(?,?,?,?,?,?,?,?)";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, goods.getgId());
				stmt.setString(2 ,goods.getgType());
				stmt.setString(3, goods.getgColor());
				stmt.setString(4, goods.getgSize());
				stmt.setInt(5, goods.getgNum());
				stmt.setDouble(6, goods.getgPrice_input());
				stmt.setDouble(7 ,goods.getgPrice());
				stmt.setDouble(8, goods.getgSale());
				
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
		//≈–∂œ”√ªß√˚ «∑Ò÷ÿ∏∫
		public boolean addcheck(String gId) {
			
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			if(gId==null){
				gId="";
			}
			try {
				conn = dataSource.getConnection();
				String sql = "select gId from Goods";
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				while(rs.next()){
					String n = rs.getString(1);
					if(gId.equals(n)){
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
		
		
		//∫ÛÃ®–ﬁ∏ƒ…Ã∆∑–≈œ¢
				public void updateGoodsInfo(Goods goods) {

					Connection conn = null;
					PreparedStatement stmt = null;
					ResultSet rs = null;
					
									
					try {
						
						conn = dataSource.getConnection();
						String sql = "update Goods set gId=?,gType=?,gColor=?,gSize=?,gNum=?,gPrice_input=?,gPrice=?,gSale=? where gNo=?";
						stmt = conn.prepareStatement(sql);
						stmt.setString(1, goods.getgId());
						stmt.setString(2 ,goods.getgType());
						stmt.setString(3, goods.getgColor());
						stmt.setString(4, goods.getgSize());
						stmt.setInt(5, goods.getgNum());
						stmt.setDouble(6, goods.getgPrice_input());
						stmt.setDouble(7 ,goods.getgPrice());
						stmt.setDouble(8, goods.getgSale());
						stmt.setInt(9, goods.getgNo());
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





	}



