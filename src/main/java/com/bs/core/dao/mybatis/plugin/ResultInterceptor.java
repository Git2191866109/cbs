package com.bs.core.dao.mybatis.plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.mapping.ResultMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import com.bs.core.utils.ReflectUtil;


@Intercepts({
	@Signature(
		type=Executor.class,
		method="query",
		args={MappedStatement.class,Object.class,RowBounds.class,ResultHandler.class}
	)
})
public class ResultInterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		String method = invocation.getMethod().getName();
		System.out.println(method);
		Object[] args = invocation.getArgs();
		MappedStatement mappedStatement = (MappedStatement)args[0];
		Configuration configuration = mappedStatement.getConfiguration();
		List<ResultMap> lrm = mappedStatement.getResultMaps();
		List<ResultMap> resultMapList = new ArrayList<ResultMap>();
		Object param = args[1];
		for (ResultMap rm:lrm){
			String id = rm.getId();
			List<ResultMapping> resultMappings = rm.getResultMappings();
			ResultMap.Builder resultMapBuilder = new ResultMap.Builder(configuration, id, param.getClass(), resultMappings);
			ResultMap rmTemp= resultMapBuilder.build();
			resultMapList.add(rmTemp);
		}
		//自定义工具类写入属性值
		ReflectUtil.setFieldValue(mappedStatement, "resultMaps", resultMapList);
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties propertie) {
	}

}
