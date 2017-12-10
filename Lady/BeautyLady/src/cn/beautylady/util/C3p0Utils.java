package cn.beautylady.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Utils {
	private static C3p0Utils c3p0Utils;//连接池对象
	private ComboPooledDataSource dataSource;//通过标识创建相应连接池;
	static {
		c3p0Utils = new C3p0Utils();
	}
	public C3p0Utils() {
		dataSource = new ComboPooledDataSource("mysql");
	}
	
	/**
	 * 新生成C3p0Utils对象
	 * @return C3p0Utils对象
	 */
	public static C3p0Utils getInstance() {
		return c3p0Utils;
	}
	
	/**
	 * 获取数据库连接
	 * @return
	 */
	public DataSource getDataSource(){
		return dataSource;
	}
	/**
	 * 从连接池中取出连接
	 * @return 数据库连接对象
	 */
	public Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("数据库链接出错",e);
		}
		
	}
	/**
	 * 获取PreparedStatement 对象
	 * @param conn 数据库连接
	 * @param sql SQL语句
	 * @return PreparedStatement 对象
	 */
	public static PreparedStatement setStatement(Connection conn,String sql) {
		PreparedStatement pstmt = null;
		 try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}
	/**
	 * 向PreparedStatement 对象传递参数
	 * @param pstmt PreparedStatement 对象
	 * @param params 参数对象数组
	 * @return 传参后的PreparedStatement 对象
	 */
	public static PreparedStatement setSQLParameters(PreparedStatement pstmt,Object ... params) {
		try {
			if(params != null && params.length >0) {
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i+1, params[i]);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}
	/**
	 * 释放连接回连接池
	 * @param conn 数据库对象
	 * @param stmt Statement 对象
	 * @param rs 结果集
	 */
	public static void releaseSources(Connection conn,Statement stmt,ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
