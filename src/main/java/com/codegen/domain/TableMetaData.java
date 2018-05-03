package com.codegen.domain;



import com.codegen.config.CodeGenConfig;
import com.codegen.util.CamelConvertUtil;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zenglw
 * @date 2018/5/2
 */
public class TableMetaData {

    private String tableName;
    private String className;
    private String tableComment;
    private String fieldName;

    public List<ColumnMetaData> columns = new ArrayList<>();

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public List<ColumnMetaData> getColumns() {
        return columns;
    }

    public void setColumns(List<ColumnMetaData> columns) {
        this.columns = columns;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public void build(CodeGenConfig codeGenConfig) {
        String tableName = this.tableName;
        if(null != codeGenConfig && !StringUtils.isEmpty(codeGenConfig.getTablePrefix()) && tableName.startsWith(codeGenConfig.getTablePrefix())) {
            tableName = tableName.replaceFirst(codeGenConfig.getTablePrefix(),"");
        }
        if(null != codeGenConfig && !StringUtils.isEmpty(codeGenConfig.getTableSuffix()) && tableName.endsWith(codeGenConfig.getTableSuffix())) {
            int i = tableName.lastIndexOf(codeGenConfig.getTableSuffix());
            tableName = tableName.substring(0,i);
        }
        String className = CamelConvertUtil.underline2Camel(tableName,false);
        this.setClassName(className);
        this.setFieldName(CamelConvertUtil.underline2Camel(className));
        for (ColumnMetaData c: columns) {
            c.build();
        }
    }

}
