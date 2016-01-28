package com.bs.plugins.system.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.bs.plugins.system.dao.IDao;
import com.bs.plugins.system.dao.MySqlSessionFactory;
import com.bs.plugins.system.entity.Column;
import com.bs.plugins.system.service.CreateDatabaseService;


public class ColumnDao implements IDao<Column>{
	static Logger logger = Logger.getLogger(CreateDatabaseService.class);
	/**
	 * 获取SqlSessionFactory 对象
	 */
	private SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getInstance();
		
	public ColumnDao(){
	}
	
	@Override
	public int insert(String sqlid, Column entity){
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
	public int update(String sqlid, Column entity){
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
	public int delete(String sqlid, Column entity){
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
	public int deleteById(String sqlid, Column entity){
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
	public Long getCount(String sqlid, Column entity){
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
	public List<Column> selectList(String sqlid, Column entity){
		SqlSession sqlSession = null;
		List<Column> list = null;
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
	public List<Column> selectAll(String sqlid){
		SqlSession sqlSession = null;
		List<Column> list = null;
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
	public Column selectOne(String sqlid, Column entity){
		SqlSession sqlSession = null;
		Column column = null;
		try{
			sqlSession= sqlSessionFactory.openSession();
			column = sqlSession.selectOne(sqlid,entity);
			return column;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (sqlSession != null){
				sqlSession.close();
			}
		}
		return column;
	}
	
	/**
	 * 判断数据库表字段是否存在
	 * @param tableName
	 * @param columnName
	 * @return
	 */
	public boolean  getColumn(String tableName,String columnName){
		Connection connection = null;
		ResultSet rs = null;
		try{
			SqlSession sqlSession= sqlSessionFactory.openSession();
			connection = sqlSession.getConnection();
			rs = connection.getMetaData().getColumns(null, null, tableName, columnName);
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
