package com.bs.plugins.system.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.bs.plugins.system.dao.IDao;
import com.bs.plugins.system.dao.MySqlSessionFactory;
import com.bs.plugins.system.entity.Table;
import com.bs.plugins.system.service.CreateDatabaseService;


public class TableDao implements IDao<Table>{
	
	static Logger logger = Logger.getLogger(CreateDatabaseService.class);
	/**
	 * 获取SqlSessionFactory 对象
	 */
	private SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getInstance();
	
	@Override
	public int insert(String sqlid, Table entity){
		SqlSession sqlSession = null;
		int ravl = 0;
		try{
			sqlSession= sqlSessionFactory.openSession();
			ravl = sqlSession.insert(sqlid, entity);
			return ravl;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (sqlSession != null){
				sqlSession.commit();
			}
			if (sqlSession != null){
				sqlSession.close();
			}
		}
		return ravl;
	}

	@Override
	public int update(String sqlid, Table entity){
		SqlSession sqlSession = null;
		int ravl = 0;
		try{
			sqlSession= sqlSessionFactory.openSession();
			ravl = sqlSession.update(sqlid, entity);
			return ravl;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (sqlSession != null){
				sqlSession.commit();
			}
			if (sqlSession != null){
				sqlSession.close();
			}
		}
		return ravl;
	}

	@Override
	public int delete(String sqlid, Table entity){
		SqlSession sqlSession = null;
		int ravl = 0;
		try{
			sqlSession= sqlSessionFactory.openSession();
			ravl = sqlSession.delete(sqlid, entity);
			return ravl;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (sqlSession != null){
				sqlSession.commit();
			}
			if (sqlSession != null){
				sqlSession.close();
			}
		}
		return ravl;
	}

	@Override
	public int deleteById(String sqlid, Table entity){
		SqlSession sqlSession = null;
		int ravl = 0;
		try{
			sqlSession= sqlSessionFactory.openSession();
			ravl = sqlSession.delete(sqlid, entity);
			return ravl;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (sqlSession != null){
				sqlSession.commit();
			}
			if (sqlSession != null){
				sqlSession.close();
			}
		}
		return ravl;
	}

	@Override
	public int deleteAll(String sqlid){
		SqlSession sqlSession = null;
		int ravl = 0;
		try{
			sqlSession= sqlSessionFactory.openSession();
			ravl = sqlSession.delete(sqlid);
			return ravl;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (sqlSession != null){
				sqlSession.commit();
			}
			if (sqlSession != null){
				sqlSession.close();
			}
		}
		return ravl;
	}

	@Override
	public Long getCount(String sqlid, Table entity){
		SqlSession sqlSession = null;
		long ravl = 0;
		try{
			sqlSession= sqlSessionFactory.openSession();
			ravl = sqlSession.selectOne(sqlid,entity);
			return ravl;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (sqlSession != null){
				sqlSession.close();
			}
		}
		return ravl;
	}

	@Override
	public List<Table> selectList(String sqlid, Table entity){
		SqlSession sqlSession = null;
		List<Table> list = null;
		try{
			sqlSession= sqlSessionFactory.openSession();
			list = sqlSession.selectList(sqlid,entity);
			return list;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (sqlSession != null){
				sqlSession.close();
			}
		}
		return list;
	}

	@Override
	public List<Table> selectAll(String sqlid){
		SqlSession sqlSession = null;
		List<Table> list = null;
		try{
			sqlSession= sqlSessionFactory.openSession();
			list = sqlSession.selectList(sqlid);
			return list;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (sqlSession != null){
				sqlSession.close();
			}
		}
		return list;
	}

	@Override
	public Table selectOne(String sqlid, Table entity){
		SqlSession sqlSession = null;
		Table table = null;
		try{
			sqlSession= sqlSessionFactory.openSession();
			table = sqlSession.selectOne(sqlid,entity);
			return table;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (sqlSession != null){
				sqlSession.close();
			}
		}
		return table;
	}
	
	/**
	 * 创建数据标
	 * @param sql
	 */
	public boolean createTable(String tableName,String sql){
		Connection connection = null;
		Statement statement = null;
		try{
			logger.debug("开始创建名称为:"+tableName+"的数据库表.");
			logger.debug("建表脚本为:"+sql);
			SqlSession sqlSession= sqlSessionFactory.openSession();
			connection = sqlSession.getConnection();
			statement = connection.createStatement();
			statement.addBatch(sql);
			statement.executeBatch();
			logger.debug("名称为:"+tableName+"的数据库表创建成功.");
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			logger.debug("名称为:"+tableName+"的数据库表创建失败.");
		}
		finally{
			try {
				if (statement != null){
					statement.close();
				}
				if (connection != null){
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	/**
	 * 创建表关系
	 * @param referenceName
	 * @param sql
	 * @return
	 */
	public boolean createTableReference(String tableName,String referenceName,String sql){
		Connection connection = null;
		Statement statement = null;
		try{
			logger.debug("开始为：" + tableName + "创建名称为 "+referenceName+" 的数据库表关系.");
			logger.debug("关系脚本为:"+sql);
			SqlSession sqlSession= sqlSessionFactory.openSession();
			connection = sqlSession.getConnection();
			statement = connection.createStatement();
			statement.addBatch(sql);
			statement.executeBatch();
			logger.debug("名称为:"+referenceName+"的数据库表关系创建成功.");
			return true;
		}
		catch(Exception e){
			logger.debug("失败原因:"+e.getMessage());
			logger.debug("名称为:"+referenceName+"的数据库表关系创建失败.");
		}
		finally{
			try {
				if (statement != null){
					statement.close();
				}
				if (connection != null){
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	/**
	 * 创建索引
	 * @param indexName
	 * @param sql
	 * @return
	 */
	public boolean createTableIndex(String tableName,String indexName,String sql){
		Connection connection = null;
		Statement statement = null;
		try{
			logger.debug("开始为：" + tableName + "创建名称为 "+indexName+" 的数据库表索引.");
			logger.debug("索引创建脚本为:"+sql);
			SqlSession sqlSession= sqlSessionFactory.openSession();
			connection = sqlSession.getConnection();
			statement = connection.createStatement();
			statement.addBatch(sql);
			statement.executeBatch();
			logger.debug("名称为:"+indexName+"的数据库表索引创建成功.");
			return true;
		}
		catch(Exception e){
			logger.debug("失败原因:"+e.getMessage());
			logger.debug("名称为:"+indexName+"的数据库表索引创建失败.");
		}
		finally{
			try {
				if (statement != null){
					statement.close();
				}
				if (connection != null){
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	/**
	 * 更新表信息
	 * @param tableCode
	 * @param sql
	 * @return
	 */
	public boolean alterTable(String tableCode,String sql){
		Connection connection = null;
		Statement statement = null;
		try{
			logger.debug("更新表名称为：" + tableCode + " 的数据库表信息.");
			logger.debug("执行脚本为:"+sql);
			SqlSession sqlSession= sqlSessionFactory.openSession();
			connection = sqlSession.getConnection();
			statement = connection.createStatement();
			statement.addBatch(sql);
			statement.executeBatch();
			logger.debug("更新表名称为："+tableCode+" 的数据库表信息更新成功.");
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			logger.debug("更新表名称为："+tableCode+" 的数据库表信息更新失败.");
		}
		finally{
			try {
				if (statement != null){
					statement.close();
				}
				if (connection != null){
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	/**
	 * 判断数据库表是否存在
	 * @param tableName
	 * @return
	 */
	public boolean  getTable(String tableName){
		Connection connection = null;
		ResultSet rs = null;
		String[] types = { "TABLE" };   
		try{
			SqlSession sqlSession= sqlSessionFactory.openSession();
			connection = sqlSession.getConnection();
			rs = connection.getMetaData().getTables(null, null, tableName,types);
			while (rs.next()){
				return true;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try {
				if (rs != null){
					rs.close();
				}
				if (connection != null){
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
