package com.bs.plugins.custom.${entityPackage};

import com.bs.core.entity.Entity;
<#list columns as cols>
<#if cols.dataType?contains('decimal')>
import java.math.BigDecimal;
<#break>
</#if>
</#list>

<#list references as reference>
<#if table.code == reference.childTable.code>
<#list reference.joins as join>
<#assign pcode="${join.parentTableColumn.table.code}"/>
<#assign idx="${pcode?index_of('_')}"/>
<#assign len="${pcode?length}"/>
import com.bs.plugins.custom.${pcode?substring(0,idx?number)?lower_case}.${pcode?substring(idx?number + 1,len?number)?lower_case}.entity.${pcode?substring(idx?number+1,len?number)};
</#list>
</#if>
</#list>
<#global isArrayList="false"/>
<#list references as reference>
<#if table.code == reference.parentTable.code>
<#list reference.joins as join>
<#assign pcode="${join.childTableColumn.table.code}"/>
<#assign idx="${pcode?index_of('_')}"/>
<#assign len="${pcode?length}"/>
<#global isArrayList="true"/>
import com.bs.plugins.custom.${pcode?substring(0,idx?number)?lower_case}.${pcode?substring(idx?number + 1,len?number)?lower_case}.entity.${pcode?substring(idx?number+1,len?number)};	
</#list>
</#if>
</#list>
<#if isArrayList == 'true'>
import java.util.ArrayList;
</#if>

public class Base${entity} extends Entity {

	private static final long serialVersionUID = 1L;
	
	<#list columns as cols>
	<#assign dataType="String" />
	<#if cols.dataType?contains('bigint')>
	<#assign dataType="Long" />
	<#elseif cols.dataType?contains('smallint')>
	<#assign dataType="Integer" />
	<#elseif cols.dataType?contains('double')>
	<#assign dataType="Double" />
	<#elseif cols.dataType?contains('decimal')>
	<#assign dataType="BigDecimal" />
	<#elseif cols.dataType?contains('int')>
	<#assign dataType="Integer" />
	<#else>
	<#assign dataType="String" />
	</#if>
	/**${cols.name}-<@compress single_line=true>${cols.comment}</@compress>**/
	private ${dataType} ${cols.code?uncap_first};
	</#list>
<#list references as reference>
<#if table.code == reference.childTable.code>
<#list reference.joins as join>
<#assign pcode="${join.parentTableColumn.table.code}"/>
<#assign idx="${pcode?index_of('_')}"/>
<#assign len="${pcode?length}"/>
	/**<@compress single_line=true>${join.parentTableColumn.table.comment}</@compress>**/
	private ${pcode?substring(idx?number+1,len?number)} ${pcode?substring(idx?number+1,len?number)?uncap_first};
</#list>
</#if>
</#list>
<#list references as reference>
	<#if table.code == reference.parentTable.code>
	<#list reference.joins as join>
	<#assign pcode="${join.childTableColumn.table.code}"/>
	<#assign idx="${pcode?index_of('_')}"/>
	<#assign len="${pcode?length}"/>
	/**<@compress single_line=true>${join.childTableColumn.table.comment}</@compress>**/
	private ArrayList<${pcode?substring(idx?number+1,len?number)}> ${pcode?substring(idx?number+1,len?number)?uncap_first}s;
	</#list>
	</#if>
</#list>

	public Base${entity}() {
	}

<#list columns as cols>
<#assign dataType="String" />
<#if cols.dataType?contains('bigint')>
<#assign dataType="Long" />
<#elseif cols.dataType?contains('smallint')>
<#assign dataType="Integer" />
<#elseif cols.dataType?contains('double')>
<#assign dataType="Double" />
<#elseif cols.dataType?contains('decimal')>
<#assign dataType="BigDecimal" />
<#elseif cols.dataType?contains('int')>
<#assign dataType="Integer" />
<#else>
<#assign dataType="String" />
</#if>
	public ${dataType} get${cols.code}() {
		return ${cols.code?uncap_first};
	}

	public void set${cols.code}(${dataType} ${cols.code?uncap_first}) {
		this.${cols.code?uncap_first} = ${cols.code?uncap_first};
	}
</#list>
	
<#list references as reference>
<#if table.code == reference.childTable.code>
<#list reference.joins as join>
<#assign pcode="${join.parentTableColumn.table.code}"/>
<#assign idx="${pcode?index_of('_')}"/>
<#assign len="${pcode?length}"/>
	public ${pcode?substring(idx?number+1,len?number)} get${pcode?substring(idx?number+1,len?number)} () {
		return ${pcode?substring(idx?number+1,len?number)?uncap_first};
	}

	public void set${pcode?substring(idx?number+1,len?number)}(${pcode?substring(idx?number+1,len?number)} ${pcode?substring(idx?number+1,len?number)?uncap_first}) {
		this.${pcode?substring(idx?number+1,len?number)?uncap_first} = ${pcode?substring(idx?number+1,len?number)?uncap_first};
	}
</#list>
</#if>
</#list>
<#list references as reference>
	<#if table.code == reference.parentTable.code>
	<#list reference.joins as join>
	<#assign pcode="${join.childTableColumn.table.code}"/>
	<#assign idx="${pcode?index_of('_')}"/>
	<#assign len="${pcode?length}"/>
	public ArrayList<${pcode?substring(idx?number+1,len?number)}> get${pcode?substring(idx?number+1,len?number)} () {
		return ${pcode?substring(idx?number+1,len?number)?uncap_first}s;
	}

	public void set${pcode?substring(idx?number+1,len?number)}(ArrayList<${pcode?substring(idx?number+1,len?number)}> ${pcode?substring(idx?number+1,len?number)?uncap_first}s) {
		this.${pcode?substring(idx?number+1,len?number)?uncap_first}s = ${pcode?substring(idx?number+1,len?number)?uncap_first}s;
	}	
	</#list>
	</#if>
</#list>
}
