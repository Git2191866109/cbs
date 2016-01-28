<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.bs.plugins.custom.${daoImportPackage}">

	<parameterMap id="${entity?uncap_first}Param" type="com.bs.plugins.custom.${entityImportPackage}" />
	<resultMap id="${entity?uncap_first}Result" type="com.bs.plugins.custom.${entityImportPackage}">
	<#assign idIsExist="false"/>
	<#list columns as column>
	<#assign property="result"/>
	<#if column.code?lower_case=='id' >
		<#assign property="id"/>
		<#assign idIsExist="true"/>
	</#if>
	<#if column.dataType?contains('bigint')>
		<${property} property="${column.code?uncap_first}" column="${entity?uncap_first}_${column.code?uncap_first}" javaType="java.lang.Long" />
	<#elseif column.dataType?contains('smallint')>
		<${property} property="${column.code?uncap_first}" column="${entity?uncap_first}_${column.code?uncap_first}" javaType="java.lang.Integer" />
	<#elseif column.dataType?contains('double')>
		<${property} property="${column.code?uncap_first}" column="${entity?uncap_first}_${column.code?uncap_first}" javaType="java.lang.Double" />
	<#elseif column.dataType?contains('decimal')>
		<${property} property="${column.code?uncap_first}" column="${entity?uncap_first}_${column.code?uncap_first}" javaType="java.math.BigDecimal" />
	<#elseif column.dataType?contains('int')>
		<${property} property="${column.code?uncap_first}" column="${entity?uncap_first}_${column.code?uncap_first}" javaType="java.lang.Integer" />
	<#else>
		<${property} property="${column.code?uncap_first}" column="${entity?uncap_first}_${column.code?uncap_first}" javaType="java.lang.String" />
	</#if>
	</#list>
	<#assign isChildReference="false"/>
	<#assign isParentReference="false"/>
	<#list references as reference>
	<#if table.code == reference.childTable.code>
	<#assign isChildReference="true"/>
	<#list reference.joins as join>
	<#assign pcode="${join.parentTableColumn.table.code}"/>
	<#assign idx="${pcode?index_of('_')}"/>
	<#assign len="${pcode?length}"/>
		<association property="${pcode?substring(idx?number+1,len?number)?uncap_first}" javaType="com.bs.plugins.custom.${pcode?substring(0,idx?number)?lower_case}.${pcode?substring(idx?number + 1,len?number)?lower_case}.entity.${pcode?substring(idx?number+1,len?number)}">
		<#list join.parentTableColumn.table.columns as column>
		<#assign property="result"/>
		<#if column.code?lower_case=='id' >
			<#assign property="id"/>
		</#if>
		<#if column.dataType?contains('bigint')>
			<${property} property="${column.code?uncap_first}" column="${pcode?substring(idx?number+1,len?number)?uncap_first}_${column.code?uncap_first}" javaType="java.lang.Long" />
		<#elseif column.dataType?contains('smallint')>
			<${property} property="${column.code?uncap_first}" column="${pcode?substring(idx?number+1,len?number)?uncap_first}_${column.code?uncap_first}" javaType="java.lang.Integer" />
		<#elseif column.dataType?contains('double')>
			<${property} property="${column.code?uncap_first}" column="${pcode?substring(idx?number+1,len?number)?uncap_first}_${column.code?uncap_first}" javaType="java.lang.Double" />
		<#elseif column.dataType?contains('decimal')>
			<${property} property="${column.code?uncap_first}" column="${pcode?substring(idx?number+1,len?number)?uncap_first}_${column.code?uncap_first}" javaType="java.math.BigDecimal" />
		<#elseif column.dataType?contains('int')>
			<${property} property="${column.code?uncap_first}" column="${pcode?substring(idx?number+1,len?number)?uncap_first}_${column.code?uncap_first}" javaType="java.lang.Integer" />
		<#else>
			<${property} property="${column.code?uncap_first}" column="${pcode?substring(idx?number+1,len?number)?uncap_first}_${column.code?uncap_first}" javaType="java.lang.String" />
		</#if>
		</#list>
		</association>
	</#list>
	</#if>
	</#list>
	<#list references as reference>
	<#if table.code == reference.parentTable.code>
	<#assign isParentReference="true"/>
	<#list reference.joins as join>
	<#assign pcode="${join.childTableColumn.table.code}"/>
	<#assign idx="${pcode?index_of('_')}"/>
	<#assign len="${pcode?length}"/>
		<collection property="${pcode?substring(idx?number+1,len?number)?uncap_first}s" ofType="com.bs.plugins.custom.${pcode?substring(0,idx?number)?lower_case}.${pcode?substring(idx?number + 1,len?number)?lower_case}.entity.${pcode?substring(idx?number+1,len?number)}">
		<#list join.childTableColumn.table.columns as column>
		<#assign property="result"/>
		<#if column.code?lower_case=='id' >
			<#assign property="id"/>
		</#if>
		<#if column.dataType?contains('bigint')>
			<${property} property="${column.code?uncap_first}" column="${pcode?substring(idx?number+1,len?number)?uncap_first}_${column.code?uncap_first}" javaType="java.lang.Long" />
		<#elseif column.dataType?contains('smallint')>
			<${property} property="${column.code?uncap_first}" column="${pcode?substring(idx?number+1,len?number)?uncap_first}_${column.code?uncap_first}" javaType="java.lang.Integer" />
		<#elseif column.dataType?contains('double')>
			<${property} property="${column.code?uncap_first}" column="${pcode?substring(idx?number+1,len?number)?uncap_first}_${column.code?uncap_first}" javaType="java.lang.Double" />
		<#elseif column.dataType?contains('decimal')>
			<${property} property="${column.code?uncap_first}" column="${pcode?substring(idx?number+1,len?number)?uncap_first}_${column.code?uncap_first}" javaType="java.math.BigDecimal" />
		<#elseif column.dataType?contains('int')>
			<${property} property="${column.code?uncap_first}" column="${pcode?substring(idx?number+1,len?number)?uncap_first}_${column.code?uncap_first}" javaType="java.lang.Integer" />
		<#else>
			<${property} property="${column.code?uncap_first}" column="${pcode?substring(idx?number+1,len?number)?uncap_first}_${column.code?uncap_first}" javaType="java.lang.String" />
		</#if>
		</#list>
		</collection>
	</#list>
	</#if>
	</#list>
	</resultMap>
	
	<#if isChildReference == "true">
	<select id="selectAssociations" resultMap="${entity?uncap_first}Result" parameterMap="${entity?uncap_first}Param">
		select
		<#assign tableCode="${table.code}"/>
		<#assign tableIndex="${tableCode?index_of('_')}"/>
		<#assign tableLength="${tableCode?length}"/>		 
		<#list columns as column>
		<#if column_has_next>
			${tableCode?substring(tableIndex?number+1,tableLength?number)?uncap_first}.${column.code} ${entity?uncap_first}_${column.code?uncap_first},
		</#if>
		<#if !column_has_next>
		<#if isChildReference == "true">
			${tableCode?substring(tableIndex?number+1,tableLength?number)?uncap_first}.${column.code} ${entity?uncap_first}_${column.code?uncap_first},	
		<#else>
			${tableCode?substring(tableIndex?number+1,tableLength?number)?uncap_first}.${column.code} ${entity?uncap_first}_${column.code?uncap_first}
		</#if>
		</#if>
		</#list>
		<#assign index=0/>
		<#list references as reference>
			<#if table.code == reference.childTable.code>
			<#assign index=reference_index/>
			</#if>
		</#list>
		<#list references as reference>
			<#if table.code == reference.childTable.code>
				<#assign ptCode="${reference.parentTable.code}"/>
				<#assign ptIndex="${ptCode?index_of('_')}"/>
				<#assign ptLength="${ptCode?length}"/>
				<#if index != reference_index>
					<#list reference.joins as join>
						<#list join.parentTableColumn.table.columns as column>
			${ptCode?substring(ptIndex?number+1,ptLength?number)?uncap_first}.${column.code} ${ptCode?substring(ptIndex?number+1,ptLength?number)?uncap_first}_${column.code?uncap_first},
						</#list>
					</#list>
				</#if>
				<#if index == reference_index>
					<#list reference.joins as join>
						<#if join_has_next>
							<#list join.parentTableColumn.table.columns as column>
			${ptCode?substring(ptIndex?number+1,ptLength?number)?uncap_first}.${column.code} ${ptCode?substring(ptIndex?number+1,ptLength?number)?uncap_first}_${column.code?uncap_first},
							</#list>
						</#if>
						<#if !join_has_next>
							<#list join.parentTableColumn.table.columns as column>
								<#if column_has_next>
			${ptCode?substring(ptIndex?number+1,ptLength?number)?uncap_first}.${column.code} ${ptCode?substring(ptIndex?number+1,ptLength?number)?uncap_first}_${column.code?uncap_first},
								</#if>
								<#if !column_has_next>
			${ptCode?substring(ptIndex?number+1,ptLength?number)?uncap_first}.${column.code} ${ptCode?substring(ptIndex?number+1,ptLength?number)?uncap_first}_${column.code?uncap_first}
								</#if>
							</#list>		
						</#if>
					</#list>
				</#if>
			</#if>
		</#list>
		from ${table.code} ${tableCode?substring(tableIndex?number+1,tableLength?number)?uncap_first}
		<#list references as reference>
		<#if table.code == reference.childTable.code>
		<#assign ptCode="${reference.parentTable.code}"/>
		<#assign ptIndex="${ptCode?index_of('_')}"/>
		<#assign pttLength="${ptCode?length}"/>
		<#list reference.joins as join>
		inner join ${ptCode} ${ptCode?substring(ptIndex?number+1,pttLength?number)?uncap_first} on ${ptCode?substring(ptIndex?number+1,pttLength?number)?uncap_first}.${join.parentTableColumn.code}=${tableCode?substring(tableIndex?number+1,tableLength?number)?uncap_first}.${join.childTableColumn.code}
		</#list>
		</#if>
		</#list>
		<where>
			<trim prefixOverrides="and">
			<#list columns as column >
			<#if column.dataType?contains('bigint')>
				<if test="${column.code?uncap_first} != null">and ${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('smallint')>
				<if test="${column.code?uncap_first} != null">and ${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('double')>
				<if test="${column.code?uncap_first} != null">and ${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('decimal')>
				<if test="${column.code?uncap_first} != null">and ${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('int')>
				<if test="${column.code?uncap_first} != null">and ${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#else>
				<if test="${column.code?uncap_first} != null and ${column.code?uncap_first} != ''">and ${column.code}=<#noparse>#{</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			</#if>
			</#list>
			</trim>
		</where>
	</select>
	</#if>
	
	<#list references as reference>
	<#if table.code == reference.childTable.code>
	<#assign isChildReference="true"/>
	<#list reference.joins as join>
	<#assign pcode="${join.parentTableColumn.table.code}"/>
	<#assign idx="${pcode?index_of('_')}"/>
	<#assign len="${pcode?length}"/>
	<#assign ccode="${join.childTableColumn.table.code}"/>
	<#assign cidx="${ccode?index_of('_')}"/>
	<#assign clen="${ccode?length}"/>
	
	<select id="select${ccode?substring(cidx?number+1,clen?number)}${pcode?substring(idx?number+1,len?number)}" resultMap="${entity?uncap_first}Result" parameterMap="${entity?uncap_first}Param">
		select
		<#assign tableCode="${table.code}"/>
		<#assign tableIndex="${tableCode?index_of('_')}"/>
		<#assign tableLength="${tableCode?length}"/>	
		<#list columns as column>
			<#if column_has_next>
			${tableCode?substring(tableIndex?number+1,tableLength?number)?uncap_first}.${column.code} ${entity?uncap_first}_${column.code?uncap_first},
			</#if>
		</#list>
		<#list join.parentTableColumn.table.columns as column>
			<#if column_has_next>
			${pcode?substring(idx?number+1,len?number)?uncap_first}.${column.code} ${ptCode?substring(ptIndex?number+1,ptLength?number)?uncap_first}_${column.code?uncap_first},
			</#if>
			<#if !column_has_next>
			${pcode?substring(idx?number+1,len?number)?uncap_first}.${column.code} ${ptCode?substring(ptIndex?number+1,ptLength?number)?uncap_first}_${column.code?uncap_first}
			</#if>
		</#list>
		from ${table.code} ${tableCode?substring(tableIndex?number+1,tableLength?number)?uncap_first}
		inner join ${pcode} ${pcode?substring(idx?number+1,len?number)?uncap_first} on ${pcode?substring(idx?number+1,len?number)?uncap_first}.${join.parentTableColumn.code}=${tableCode?substring(tableIndex?number+1,tableLength?number)?uncap_first}.${join.childTableColumn.code}
		<where>
			<trim prefixOverrides="and">
			<#list columns as column >
			<#if column.dataType?contains('bigint')>
				<if test="${column.code?uncap_first} != null">and ${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('smallint')>
				<if test="${column.code?uncap_first} != null">and ${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('double')>
				<if test="${column.code?uncap_first} != null">and ${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('decimal')>
				<if test="${column.code?uncap_first} != null">and ${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('int')>
				<if test="${column.code?uncap_first} != null">and ${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#else>
				<if test="${column.code?uncap_first} != null and ${column.code?uncap_first} != ''">and ${column.code}=<#noparse>#{</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			</#if>
			</#list>
			</trim>
		</where>
	</select>
	</#list>
	</#if>
	</#list>
	
	
	<#if isParentReference == "true">
	<select id="selectCollections" resultMap="${entity?uncap_first}Result" parameterMap="${entity?uncap_first}Param">
		select
		<#assign tableCode="${table.code}"/>
		<#assign tableIndex="${tableCode?index_of('_')}"/>
		<#assign tableLength="${tableCode?length}"/>		 
		<#list columns as column>
		<#if column_has_next>
			${tableCode?substring(tableIndex?number+1,tableLength?number)?uncap_first}.${column.code} ${entity?uncap_first}_${column.code?uncap_first},
		</#if>
		<#if !column_has_next>
		<#if isParentReference == "true">
			${tableCode?substring(tableIndex?number+1,tableLength?number)?uncap_first}.${column.code} ${entity?uncap_first}_${column.code?uncap_first},	
		<#else>
			${tableCode?substring(tableIndex?number+1,tableLength?number)?uncap_first}.${column.code} ${entity?uncap_first}_${column.code?uncap_first}
		</#if>
		</#if>
		</#list>
		<#list references as reference>
		<#if table.code == reference.parentTable.code>
		<#assign ctCode="${reference.childTable.code}"/>
		<#assign ctIndex="${ctCode?index_of('_')}"/>
		<#assign ctLength="${ctCode?length}"/>
		<#list reference.joins as join>
		<#if join_has_next>
		<#list join.childTableColumn.table.columns as column>
			${ctCode?substring(ctIndex?number+1,ctLength?number)?uncap_first}.${column.code} ${ctCode?substring(ctIndex?number+1,ctLength?number)?uncap_first}_${column.code?uncap_first},
		</#list>
		</#if>
		<#if !join_has_next>
		<#list join.childTableColumn.table.columns as column>
			<#if column_has_next>
			${ctCode?substring(ctIndex?number+1,ctLength?number)?uncap_first}.${column.code} ${ctCode?substring(ctIndex?number+1,ctLength?number)?uncap_first}_${column.code?uncap_first},
			</#if>
			<#if !column_has_next>
			${ctCode?substring(ctIndex?number+1,ctLength?number)?uncap_first}.${column.code} ${ctCode?substring(ctIndex?number+1,ctLength?number)?uncap_first}_${column.code?uncap_first}
			</#if>
		</#list>		
		</#if>
		</#list>
		</#if>
		</#list>
		from ${table.code} ${tableCode?substring(tableIndex?number+1,tableLength?number)?uncap_first}
		<#list references as reference>
		<#if table.code == reference.parentTable.code>
		<#assign ctCode="${reference.childTable.code}"/>
		<#assign ctIndex="${ctCode?index_of('_')}"/>
		<#assign ctLength="${ctCode?length}"/>
		<#list reference.joins as join>
		inner join ${ctCode} ${ctCode?substring(ctIndex?number+1,ctLength?number)?uncap_first} on ${ctCode?substring(ctIndex?number+1,ctLength?number)?uncap_first}.${join.childTableColumn.code}=${tableCode?substring(tableIndex?number+1,tableLength?number)?uncap_first}.${join.parentTableColumn.code}
		</#list>
		</#if>
		</#list>
		<where>
			<trim prefixOverrides="and">
			<#list columns as column >
			<#if column.dataType?contains('bigint')>
				<if test="${column.code?uncap_first} != null">and ${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('smallint')>
				<if test="${column.code?uncap_first} != null">and ${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('double')>
				<if test="${column.code?uncap_first} != null">and ${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('decimal')>
				<if test="${column.code?uncap_first} != null">and ${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('int')>
				<if test="${column.code?uncap_first} != null">and ${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#else>
				<if test="${column.code?uncap_first} != null and ${column.code?uncap_first} != ''">and ${column.code}=<#noparse>#{</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			</#if>
			</#list>
			</trim>
		</where>
	</select>
	</#if>
	
	
	<#list references as reference>
	<#if table.code == reference.parentTable.code>
	<#assign isParentReference="true"/>
	<#list reference.joins as join>
	<#assign ccode="${join.childTableColumn.table.code}"/>
	<#assign cidx="${ccode?index_of('_')}"/>
	<#assign clen="${ccode?length}"/>
	<#assign pcode="${join.parentTableColumn.table.code}"/>
	<#assign pidx="${pcode?index_of('_')}"/>
	<#assign plen="${pcode?length}"/>
	<select id="select${pcode?substring(pidx?number+1,plen?number)}${ccode?substring(cidx?number+1,clen?number)}" resultMap="${entity?uncap_first}Result" parameterMap="${entity?uncap_first}Param">
		select
		<#assign tableCode="${table.code}"/>
		<#assign tableIndex="${tableCode?index_of('_')}"/>
		<#assign tableLength="${tableCode?length}"/>		 
		<#list columns as column>
			${tableCode?substring(tableIndex?number+1,tableLength?number)?uncap_first}.${column.code} ${entity?uncap_first}_${column.code?uncap_first},
		</#list>
		<#list join.childTableColumn.table.columns as column>
			<#if column_has_next>
				${ccode?substring(cidx?number+1,clen?number)?uncap_first}.${column.code} ${ccode?substring(cidx?number+1,clen?number)?uncap_first}_${column.code?uncap_first},
			</#if>
			<#if !column_has_next>
				${ccode?substring(cidx?number+1,clen?number)?uncap_first}.${column.code} ${ccode?substring(cidx?number+1,clen?number)?uncap_first}_${column.code?uncap_first}
			</#if>
	
		</#list>
		from ${table.code} ${tableCode?substring(tableIndex?number+1,tableLength?number)?uncap_first}
		inner join ${ccode} ${ccode?substring(cidx?number+1,clen?number)?uncap_first} on ${ccode?substring(cidx?number+1,clen?number)?uncap_first}.${join.childTableColumn.code}=${tableCode?substring(tableIndex?number+1,tableLength?number)?uncap_first}.${join.parentTableColumn.code}
		<where>
			<trim prefixOverrides="and">
			<#list columns as column >
			<#if column.dataType?contains('bigint')>
				<if test="${column.code?uncap_first} != null">and ${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('smallint')>
				<if test="${column.code?uncap_first} != null">and ${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('double')>
				<if test="${column.code?uncap_first} != null">and ${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('decimal')>
				<if test="${column.code?uncap_first} != null">and ${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('int')>
				<if test="${column.code?uncap_first} != null">and ${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#else>
				<if test="${column.code?uncap_first} != null and ${column.code?uncap_first} != ''">and ${column.code}=<#noparse>#{</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			</#if>
			</#list>
			</trim>
		</where>
	</select>
	</#list>
	</#if>
	</#list>
	
	<select id="selectList" resultMap="${entity?uncap_first}Result" parameterMap="${entity?uncap_first}Param">
		select 
		<#list columns as column>
		<#if column_has_next>
			${column.code} ${entity?uncap_first}_${column.code?uncap_first},
		</#if>
		<#if !column_has_next>
			${column.code} ${entity?uncap_first}_${column.code?uncap_first}
		</#if>
		</#list>
		from ${table.code}
		<where>
			<trim prefixOverrides="and">
			<#list columns as column >
			<#if column.dataType?contains('bigint')>
				<if test="${column.code?uncap_first} != null">and ${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('smallint')>
				<if test="${column.code?uncap_first} != null">and ${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('double')>
				<if test="${column.code?uncap_first} != null">and ${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('decimal')>
				<if test="${column.code?uncap_first} != null">and ${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('int')>
				<if test="${column.code?uncap_first} != null">and ${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#else>
				<if test="${column.code?uncap_first} != null and ${column.code?uncap_first} != ''">and ${column.code}=<#noparse>#{</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			</#if>
			</#list>
			</trim>
		</where>
	</select>
	
	<select id="selectAll" resultMap="${entity?uncap_first}Result">
		select 
		<#list columns as column>
		<#if column_has_next>
			${column.code} ${entity?uncap_first}_${column.code?uncap_first},
		</#if>
		<#if !column_has_next>
			${column.code} ${entity?uncap_first}_${column.code?uncap_first}
		</#if>
		</#list>
		from ${table.code}
	</select>
	
	<#if idIsExist == 'true' >
	<select id="selectOneById"  resultMap="${entity?uncap_first}Result" parameterMap="${entity?uncap_first}Param">
		select 
		<#list columns as column>
		<#if column_has_next>
			${column.code} ${entity?uncap_first}_${column.code?uncap_first},
		</#if>
		<#if !column_has_next>
			${column.code} ${entity?uncap_first}_${column.code?uncap_first}
		</#if>
		</#list>
		from ${table.code} where Id=<#noparse>${</#noparse>id<#noparse>}</#noparse>
	</select>		
	</#if>
	
	<select id="selectPaginatedList"  resultMap="${entity?uncap_first}Result" parameterMap="${entity?uncap_first}Param">
		select 
		<#list columns as column>
		<#if column_has_next>
			${column.code} ${entity?uncap_first}_${column.code?uncap_first},
		</#if>
		<#if !column_has_next>
			${column.code} ${entity?uncap_first}_${column.code?uncap_first}
		</#if>
		</#list>
		from ${table.code}
		<#list columns as column>
		<#if column.code?lower_case == 'id'>
		order by Id asc
		</#if>
		</#list>
		limit <#noparse>${</#noparse>start<#noparse>}</#noparse>,<#noparse>${</#noparse>offset<#noparse>}</#noparse>
	</select>
	
	<select id="getCount"  resultType="long" parameterMap="${entity?uncap_first}Param">
		select count(*) from ${table.code}
		<where>
			<trim prefixOverrides="and">
			<#list columns as column >
			<#if column.dataType?contains('bigint')>
				<if test="${column.code?uncap_first} != null">and ${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('smallint')>
				<if test="${column.code?uncap_first} != null">and ${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('double')>
				<if test="${column.code?uncap_first} != null">and ${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('decimal')>
				<if test="${column.code?uncap_first} != null">and ${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('int')>
				<if test="${column.code?uncap_first} != null">and ${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#else>
				<if test="${column.code?uncap_first} != null and ${column.code?uncap_first} != ''">and ${column.code}=<#noparse>#{</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			</#if>
			</#list>
			</trim>
		</where>	
	</select>
	
	<#if idIsExist=='true' >
	<update id="updateById" parameterMap="${entity?uncap_first}Param">
		update ${table.code}
		<set>
			<trim prefixOverrides=",">
			<#list columns as column >
			<#if column.dataType?contains('bigint')>
				<if test="${column.code?uncap_first} != null">,${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('smallint')>
				<if test="${column.code?uncap_first} != null">,${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('double')>
				<if test="${column.code?uncap_first} != null">,${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('decimal')>
				<if test="${column.code?uncap_first} != null">,${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('int')>
				<if test="${column.code?uncap_first} != null">,${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('datetime')>
				<#if column.code == 'ModifyTime' || column.code == 'ModifyDate'>
                    ,${column.code}=now()
				<#else>
               		 <if test="${column.code?uncap_first} != null  and ${column.code?uncap_first} != ''">,${column.code}=<#noparse>#{</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
				</#if>
			<#else>
				<if test="${column.code?uncap_first} != null and ${column.code?uncap_first} != ''">,${column.code}=<#noparse>#{</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			</#if>
			</#list>
			</trim>
		</set>
		where Id=<#noparse>${</#noparse>id<#noparse>}</#noparse>
	</update>
	<update id="updateCompleteById" parameterMap="${entity?uncap_first}Param">
		update ${table.code}
		<set>
			<trim prefixOverrides=",">
				<#list columns as column >
					<#if column.dataType?contains('bigint')>
						<#if column.code == 'ModifierId'>
                            ,${column.code}=<#noparse>${</#noparse>opId<#noparse>}</#noparse>
						<#elseif column.code == 'CreatorId'>
						<#else>
                            ,${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse>
						</#if>
					<#elseif column.dataType?contains('smallint')>
                    	<if test="${column.code?uncap_first} != null">,${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
                        <if test="${column.code?uncap_first} == null">,${column.code}= 0</if>
					<#elseif column.dataType?contains('double')>
						,${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse>
					<#elseif column.dataType?contains('decimal')>
						,${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse>
					<#elseif column.dataType?contains('int')>
                        <if test="${column.code?uncap_first} != null">,${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
                        <if test="${column.code?uncap_first} == null">,${column.code}= 0</if>
					<#elseif column.dataType?contains('datetime')>
						<#if column.code == 'ModifyTime' || column.code == 'ModifyDate'>
                            ,${column.code}=now()
						<#elseif column.code == 'CreateTime' || column.code == 'CreateDate'>
						<#else>
                        <if test="${column.code?uncap_first} != null  and ${column.code?uncap_first} != ''">,${column.code}=<#noparse>#{</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
						</#if>
					<#else>
						,${column.code}=<#noparse>#{</#noparse>${column.code?uncap_first}<#noparse>}</#noparse>
					</#if>
				</#list>
			</trim>
		</set>
		where Id=<#noparse>${</#noparse>id<#noparse>}</#noparse>
	</update>
	</#if>
	
	<insert id="insert" parameterMap="${entity?uncap_first}Param">
		insert into ${table.code}
		<trim prefix="(" prefixOverrides="," suffix=")">
		<#list columns as column >
		<#if column.dataType?contains('bigint')>
			<if test="${column.code?uncap_first} != null">,${column.code}</if>
		<#elseif column.dataType?contains('smallint')>
			<if test="${column.code?uncap_first} != null">,${column.code}</if>
		<#elseif column.dataType?contains('double')>
			<if test="${column.code?uncap_first} != null">,${column.code}</if>
		<#elseif column.dataType?contains('decimal')>
			<if test="${column.code?uncap_first} != null">,${column.code}</if>
		<#elseif column.dataType?contains('int')>
			<if test="${column.code?uncap_first} != null">,${column.code}</if>
		<#elseif column.dataType?contains('datetime')>
			<#if column.code == 'CreateTime' || column.code == 'CreateDate'>
                ,${column.code}
			<#else>
                <if test="${column.code?uncap_first} != null and ${column.code?uncap_first} != ''">,${column.code}</if>
			</#if>
		<#else>
			<if test="${column.code?uncap_first} != null and ${column.code?uncap_first} != ''">,${column.code}</if>
		</#if>
		</#list>		
		</trim>
		values
		<trim prefix="(" prefixOverrides="," suffix=")">
		<#list columns as column >
		<#if column.dataType?contains('bigint')>
			<if test="${column.code?uncap_first} != null">,<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
		<#elseif column.dataType?contains('smallint')>
			<if test="${column.code?uncap_first} != null">,<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
		<#elseif column.dataType?contains('double')>
			<if test="${column.code?uncap_first} != null">,<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
		<#elseif column.dataType?contains('decimal')>
			<if test="${column.code?uncap_first} != null">,<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
		<#elseif column.dataType?contains('int')>
			<if test="${column.code?uncap_first} != null">,<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
		<#elseif column.dataType?contains('datetime')>
			<#if column.code == 'CreateTime' || column.code == 'CreateDate'>
                ,now()
			<#else>
            	<if test="${column.code?uncap_first} != null and ${column.code?uncap_first} != ''">,<#noparse>#{</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			</#if>
		<#else>
			<if test="${column.code?uncap_first} != null and ${column.code?uncap_first} != ''">,<#noparse>#{</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
		</#if>
		</#list>			
		</trim>
		<selectKey keyProperty="generatedKey" resultType="Long">
			  select LAST_INSERT_ID() as generatedKey   
		</selectKey>	
	</insert>
	
	<#if idIsExist=='true' >
	<delete id="deleteById" parameterMap="${entity?uncap_first}Param">
		delete from ${table.code} where Id=<#noparse>${</#noparse>id<#noparse>}</#noparse>
	</delete>
	</#if>
	
	<delete id="deleteAll" parameterMap="${entity?uncap_first}Param">
		delete from ${table.code}
	</delete>
	
	<delete id="delete" parameterMap="${entity?uncap_first}Param">
		delete from ${table.code}
		<where>
			<trim prefixOverrides="and">
			<#list columns as column >
			<#if column.dataType?contains('bigint')>
				<if test="${column.code?uncap_first} != null">and ${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('smallint')>
				<if test="${column.code?uncap_first} != null">and ${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('double')>
				<if test="${column.code?uncap_first} != null">and ${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('decimal')>
				<if test="${column.code?uncap_first} != null">and ${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('int')>
				<if test="${column.code?uncap_first} != null">and ${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#else>
				<if test="${column.code?uncap_first} != null and ${column.code?uncap_first} != ''">and ${column.code}=<#noparse>#{</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			</#if>
			</#list>
			</trim>
		</where>	
	</delete>
</mapper>