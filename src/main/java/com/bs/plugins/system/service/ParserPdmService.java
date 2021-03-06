package com.bs.plugins.system.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.bs.plugins.system.entity.Column;
import com.bs.plugins.system.entity.Index;
import com.bs.plugins.system.entity.Key;
import com.bs.plugins.system.entity.Pdm;
import com.bs.plugins.system.entity.PhysicalDiagram;
import com.bs.plugins.system.entity.Reference;
import com.bs.plugins.system.entity.ReferenceJoin;
import com.bs.plugins.system.entity.Table;
import com.bs.plugins.system.entity.User;


/**
 * 
 * 解析PDM文件
 *
 */
public class ParserPdmService  extends BaseCreaterService{
	
//	private ResourcePatternResolver  resolver = new PathMatchingResourcePatternResolver();
	private Pdm pdm = new Pdm();
	
	static Logger logger = Logger.getLogger(ParserPdmService.class);
	
	public ParserPdmService(){
		pdm = new Pdm();
	}

	public Pdm pdmParser(String pdmFileName) throws Exception {
		//pdm文件存放的相对路径
//		String resource = pdmFilePath + pdmFileName;
		logger.debug("开始查找数据库设计文件:" + pdmFileName);
//		String  pdmFilePath = null;
//		try{
//			//spring 解析工具进行文件查找
//			Resource resources = resolver.getResource(resource);
//			if (resources != null){
//				//读取文件绝对路径
//				pdmFilePath = resources.getFile().getAbsolutePath();
//				logger.debug("名称为 "+pdmFileName +" 的文件找到.");
//			}
//		}
//		catch(Exception e){
//			logger.debug("名称为 "+pdmFileName +" 未找到.");
//		}
//		logger.debug("判断数据库设计文件 "+pdmFileName +" 是否被修改.");
//		boolean isModify = this.fileIsModify(pdmFilePath);
//		if (!isModify){
//			logger.debug("数据库设计文件 "+pdmFileName +" 的未被修改.");
//			return null;
//		}
//		logger.debug("数据库设计文件 "+pdmFileName +" 的有修改.");
		logger.debug("开始解析数据库设计文件:" + pdmFileName);
		SAXReader reader = new SAXReader();
		Document doc = reader.read(pdmFileName);
		Node model = doc.selectSingleNode("//c:Children/o:Model");
		pdm.setAttributeId(((Element) model).attributeValue("Id"));
		pdm.setName(selectSingleNodeStringText(model, "a:Name"));
		pdm.setCode(selectSingleNodeStringText(model, "a:Code"));
		pdm.setCreationDate(selectSingleNodeStringText(model, "a:CreationDate"));
		pdm.setCreator(selectSingleNodeStringText(model, "a:Creator"));
		pdm.setModificationDate(selectSingleNodeStringText(model, "a:ModificationDate"));
		
		Node dbms = model.selectSingleNode("//o:Shortcut");
		pdm.setDBMSCode(selectSingleNodeStringText(dbms, "a:Code"));
		pdm.setDBMSName(selectSingleNodeStringText(dbms, "a:Name"));
		pdm.setCreationDate(selectSingleNodeStringText(dbms, "a:CreationDate"));
		pdm.setCreator(selectSingleNodeStringText(dbms, "a:Creator"));
		pdm.setModificationDate(selectSingleNodeStringText(dbms, "a:ModificationDate"));

		logger.debug("数据库库设计文件数据模型名称为:" + pdm.getCode() + "(" + pdm.getName() + ")  数据库类型为:" + pdm.getDBMSCode() + "(" + pdm.getDBMSName() + ")");

		pdm.setUsers(userParser(model));
		pdm.setTables(tableParser(model));
		pdm.setPhysicalDiagrams(physicalDiagramParser(model));
		pdm.setReferences(referenceParser(model));

		return pdm;
	}

	public ArrayList<PhysicalDiagram> physicalDiagramParser(Node node)
			throws Exception {
		ArrayList<PhysicalDiagram> physicalList = new ArrayList<PhysicalDiagram>();
		for (Object o : node
				.selectNodes("c:PhysicalDiagrams/o:PhysicalDiagram")) {
			Node physicalNode = (Node) o;
			PhysicalDiagram physicalDiagram = new PhysicalDiagram();
			physicalDiagram.setAttributeId(((Element) physicalNode).attributeValue("Id"));
			physicalDiagram.setName(selectSingleNodeStringText(physicalNode, "a:Name"));
			physicalDiagram.setCode(selectSingleNodeStringText(physicalNode, "a:Code"));
			physicalDiagram.setCreationDate(selectSingleNodeStringText(physicalNode, "a:CreationDate"));
			physicalDiagram.setCreator(selectSingleNodeStringText(physicalNode, "a:Creator"));
			physicalDiagram.setModificationDate(selectSingleNodeStringText(physicalNode, "a:ModificationDate"));
			// 添加Table
			for (Object table : physicalNode.selectNodes("c:Symbols/o:TableSymbol/c:Object/o:Table")) {
				String id = ((Element) table).attributeValue("Ref");
				physicalDiagram.addTable(pdm.getTable(id));
			}
			physicalList.add(physicalDiagram);
		}
		return physicalList;
	}

	/**
	 * 遍历表
	 * @param node
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Table> tableParser(Node node) throws Exception {
		ArrayList<Table> tableList = new ArrayList<Table>();
		for (Object tableNodeObj : node.selectNodes("c:Tables/o:Table")) {
			Node tableNode = (Node) tableNodeObj;
			Table table = new Table();
			table.setAttributeId(((Element) tableNode).attributeValue("Id"));
			table.setObjectId(selectSingleNodeStringText(tableNode, "a:ObjectID"));
			table.setName(selectSingleNodeStringText(tableNode, "a:Name"));
			table.setCode(selectSingleNodeStringText(tableNode, "a:Code"));
			table.setCreationDate(selectSingleNodeStringText(tableNode, "a:CreationDate"));
			table.setCreator(selectSingleNodeStringText(tableNode, "a:Creator"));
			table.setModificationDate(selectSingleNodeStringText(tableNode, "a:ModificationDate"));
			table.setComment(selectSingleNodeStringText(tableNode, "a:Comment"));
			logger.debug("/*********************************************************/");
			logger.debug("数据库表名为：" + table.getName() + "--代码为:" + table.getCode());
			// 添加Columns
			table.setColumns(columnParser(tableNode));
			// 添加key
			for (Object keyNodeObj : tableNode.selectNodes("c:Keys/o:Key")) {
				Node keyNode = (Node) keyNodeObj;
				Key key = new Key();
				key.setAttributeId(((Element) keyNode).attributeValue("Id"));
				key.setObjectId(selectSingleNodeStringText(keyNode, "a:ObjectID"));
				key.setName(selectSingleNodeStringText(keyNode, "a:Name"));
				key.setCode(selectSingleNodeStringText(keyNode, "a:Code"));
				key.setConstraintName(selectSingleNodeStringText(keyNode, "a:ConstraintName"));
				key.setExtendedAttributesText(selectSingleNodeStringText(keyNode, "a:ExtendedAttributesText"));
				key.setCreationDate(selectSingleNodeStringText(keyNode, "a:CreationDate"));
				key.setCreator(selectSingleNodeStringText(keyNode, "a:Creator"));
				key.setModificationDate(selectSingleNodeStringText(keyNode, "a:ModificationDate"));
				for (Object column : keyNode.selectNodes("c:Key.Columns/o:Column")) {
					String id = ((Element) column).attributeValue("Ref");
					key.addColumn(table.getColumn(id));
				}
				table.addKey(key);
			}
			// 添加PrimaryKey
			String keyId = ((Element) tableNode.selectSingleNode("c:PrimaryKey/o:Key")).attributeValue("Ref");
			table.setPrimaryKey(table.getKey(keyId));
			// 添加Indexes
			for (Object indexNodeObj : tableNode.selectNodes("c:Indexes/o:Index")) {
				Node indexNode = (Node) indexNodeObj;
				Index index = new Index();
				index.setAttributeId(((Element) indexNode).attributeValue("Id"));
				index.setName(selectSingleNodeStringText(indexNode, "a:Name"));
				index.setCode(selectSingleNodeStringText(indexNode, "a:Code"));
				index.setCreationDate(selectSingleNodeStringText(indexNode, "a:CreationDate"));
				index.setCreator(selectSingleNodeStringText(indexNode, "a:Creator"));
				index.setModificationDate(selectSingleNodeStringText(indexNode, "a:ModificationDate"));
				index.setTable(table);
				for (Object column : indexNode.selectNodes("//c:Column/o:Column")) {
					String id = ((Element) column).attributeValue("Ref");
					index.addColumn(table.getColumn(id));
				}
				table.addIndex(index);
			}
			// 添加User
			Element userElement = (Element) tableNode.selectSingleNode("c:Owner/o:User");
			if (userElement != null) {
				String userId = userElement.attributeValue("Ref");
				table.setUser(pdm.getUser(userId));
			}
			tableList.add(table);
		}
		return tableList;
	}

	/**
	 * 遍历字段
	 * @param node
	 * @return
	 */
	public ArrayList<Column> columnParser(Node node) {
		ArrayList<Column> columnList = new ArrayList<Column>();
		for (Object o : node.selectNodes("c:Columns/o:Column")) {
			Node columnNode = (Node) o;
			Column column = new Column();
			column.setAttributeId(((Element) columnNode).attributeValue("Id"));
			column.setObjectId(selectSingleNodeStringText(columnNode, "a:ObjectID"));
			column.setName(selectSingleNodeStringText(columnNode, "a:Name"));
			column.setShowName(selectSingleNodeStringText(columnNode, "a:ShowName"));
			column.setCode(selectSingleNodeStringText(columnNode, "a:Code"));
			column.setDataType(selectSingleNodeStringText(columnNode, "a:DataType"));
			column.setIdentity(selectSingleNodeIntText(columnNode, "a:Identity"));
			column.setLength(selectSingleNodeIntText(columnNode, "a:Length"));
			column.setPrecision(selectSingleNodeIntText(columnNode, "a:Precision"));
			column.setMandatory(selectSingleNodeIntText(columnNode, "a:Column.Mandatory"));
			column.setDefaultValue(selectSingleNodeStringText(columnNode, "a:DefaultValue"));
			column.setLowValue(selectSingleNodeStringText(columnNode, "a:LowValue"));
			column.setHighValue(selectSingleNodeStringText(columnNode, "a:HighValue"));
			column.setComment(selectSingleNodeStringText(columnNode, "a:Comment"));
			column.setCreationDate(selectSingleNodeStringText(columnNode, "a:CreationDate"));
			column.setCreator(selectSingleNodeStringText(columnNode, "a:Creator"));
			column.setModificationDate(selectSingleNodeStringText(columnNode, "a:ModificationDate"));
			columnList.add(column);
			logger.debug("数据库字段名为 ：" + column.getName() + "--字段代码：" + column.getCode() + "--字段类型为:"+column.getDataType() ) ;
		}
		logger.debug("/*********************************************************/");
		return columnList;
	}

	/**
	 * 遍历用户
	 * 
	 * @param node
	 * @return
	 */
	public ArrayList<User> userParser(Node node) {
		ArrayList<User> userList = new ArrayList<User>();
		for (Object o : node.selectNodes("c:Users/o:User")) {
			Node userNode = (Node) o;
			User user = new User();
			user.setAttributeId(((Element) userNode).attributeValue("Id"));
			user.setName(selectSingleNodeStringText(userNode, "a:Name"));
			user.setCode(selectSingleNodeStringText(userNode, "a:Code"));
			user.setCreationDate(selectSingleNodeStringText(userNode, "a:CreationDate"));
			user.setCreator(selectSingleNodeStringText(userNode, "a:Creator"));
			user.setModificationDate(selectSingleNodeStringText(userNode, "a:ModificationDate"));
			userList.add(user);
		}
		return userList;
	}

	/**
	 * 遍历外键
	 * @param node
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Reference> referenceParser(Node node)
			throws Exception {
		ArrayList<Reference> referenceList = new ArrayList<Reference>();
		for (Object referenceNodeObj : node.selectNodes("c:References/o:Reference")) {
			Node referenceNode = (Node) referenceNodeObj;
			Reference reference = new Reference();
			reference.setAttributeId(((Element) referenceNode).attributeValue("Id"));
			reference.setObjectId(selectSingleNodeStringText(referenceNode, "a:ObjectID"));
			reference.setName(selectSingleNodeStringText(referenceNode, "a:Name"));
			reference.setCode(selectSingleNodeStringText(referenceNode, "a:Code"));
			reference.setConstraintName(selectSingleNodeStringText(referenceNode, "a:ForeignKeyConstraintName"));
			reference.setUpdateConstraint(selectSingleNodeIntText(referenceNode, "a:UpdateConstraint"));
			reference.setDeleteConstraint(selectSingleNodeIntText(referenceNode, "a:DeleteConstraint"));
			reference.setImplementationType(selectSingleNodeStringText(referenceNode, "a:ImplementationType"));
			reference.setCreationDate(selectSingleNodeStringText(referenceNode, "a:CreationDate"));
			reference.setCreator(selectSingleNodeStringText(referenceNode, "a:Creator"));
			reference.setModificationDate(selectSingleNodeStringText(referenceNode, "a:ModificationDate"));
			// 添加ParentTable
			String parentTableId = ((Element) referenceNode.selectSingleNode("c:ParentTable/o:Table")).attributeValue("Ref");
			reference.setParentTable(pdm.getTable(parentTableId));
			// 添加ChildTable
			String childTableId = ((Element) referenceNode.selectSingleNode("c:ChildTable/o:Table")).attributeValue("Ref");
			reference.setChildTable(pdm.getTable(childTableId));
			// 添加Joins
			for (Object referenceJoinNodeObj : referenceNode.selectNodes("c:Joins/o:ReferenceJoin")) {
				Node referenceJoinNode = (Node) referenceJoinNodeObj;
				ReferenceJoin referenceJoin = new ReferenceJoin();
				referenceJoin.setAttributeId(((Element) referenceJoinNode).attributeValue("Id"));
				referenceJoin.setObjectId(selectSingleNodeStringText(referenceJoinNode, "a:ObjectID"));
				referenceJoin.setCreationDate(selectSingleNodeStringText(referenceJoinNode, "a:CreationDate"));
				referenceJoin.setCreator(selectSingleNodeStringText(referenceJoinNode, "a:Creator"));
				referenceJoin.setModificationDate(selectSingleNodeStringText(referenceJoinNode, "a:ModificationDate"));
				
				String id = ((Element) referenceJoinNode.selectSingleNode("c:Object1/o:Column")).attributeValue("Ref");
				referenceJoin.setParentTableColumn(reference.getParentTable().getColumn(id));

				id = ((Element) referenceJoinNode.selectSingleNode("c:Object2/o:Column")).attributeValue("Ref");
				referenceJoin.setChildTableColumn(reference.getChildTable().getColumn(id));
				reference.addReferenceJoin(referenceJoin);
			}
			referenceList.add(reference);
		}
		return referenceList;
	}

	private String selectSingleNodeStringText(Node parentNode, String childNodeName) {
		Node childNode = parentNode.selectSingleNode(childNodeName);
		if (childNode != null) {
			return childNode.getText();
		} else {
			return "";
		}
	}

	private Integer selectSingleNodeIntText(Node parentNode, String childNodeName) {
		Node childNode = parentNode.selectSingleNode(childNodeName);
		if (childNode != null) {
			return Integer.parseInt(childNode.getText());
		} else {
			return null;
		}
	}
}
