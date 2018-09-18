package com.codegen.domain;

import com.codegen.util.CamelConvertUtil;

/**
 * @author zenglw
 * @date 2018/5/2
 */
public class ColumnMetaData {

    private String dbColumnName;
    private String dbColumnType;
    /**
     * 列名小写
     */
    private String dbColumnNameLower;
    private String dbColumnComments;
    private String javaFieldName;
    private String javaFieldType;
    //小数点位数
    private Integer decimalDigits;

    public String getDbColumnName() {
        return dbColumnName;
    }

    public void setDbColumnName(String dbColumnName) {
        this.dbColumnName = dbColumnName;
    }

    public String getDbColumnType() {
        return dbColumnType;
    }

    public void setDbColumnType(String dbColumnType) {
        this.dbColumnType = dbColumnType;
    }

    public String getDbColumnComments() {
        return dbColumnComments;
    }

    public void setDbColumnComments(String dbColumnComments) {
        this.dbColumnComments = dbColumnComments;
    }

    public String getJavaFieldName() {
        return javaFieldName;
    }

    public void setJavaFieldName(String javaFieldName) {
        this.javaFieldName = javaFieldName;
    }

    public String getJavaFieldType() {
        return javaFieldType;
    }

    public void setJavaFieldType(String javaFieldType) {
        this.javaFieldType = javaFieldType;
    }

    public Integer getDecimalDigits() {
        return decimalDigits;
    }

    public void setDecimalDigits(Integer decimalDigits) {
        this.decimalDigits = decimalDigits;
    }

    public String getDbColumnNameLower() {
        return dbColumnNameLower;
    }

    public void setDbColumnNameLower(String dbColumnNameLower) {
        this.dbColumnNameLower = dbColumnNameLower;
    }

    public void build() {
        String javaFieldName = CamelConvertUtil.underline2Camel(this.dbColumnName);
        this.setJavaFieldName(javaFieldName);
        String javaFieldType = null;
        if(null != this.decimalDigits && this.decimalDigits > 0) {
            javaFieldType = OracleJdbcMap.oracleJdbcMap.get("MONEY");
        } else {
            javaFieldType = OracleJdbcMap.oracleJdbcMap.get(this.dbColumnType);
        }
        this.setJavaFieldType(javaFieldType);
        this.dbColumnNameLower = dbColumnName.toLowerCase();
    }
}
