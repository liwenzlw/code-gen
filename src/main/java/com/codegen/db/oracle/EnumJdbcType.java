package com.codegen.db.oracle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zenglw
 * @date 2018/5/1
 */
public enum  EnumJdbcType {
    STRING("varchar", String.class),
    LONGTEXT("longtext", String.class),
    CHAR("char", char.class),
    CHAR_OBj("char", Character.class),
    INT("int", int.class),
    INTEGER("int", Integer.class),
    SHORT("tinyint", short.class),
    SHORT_OBJ("tinyint", Short.class),
    BYTE("tinyint", byte.class),
    BYTE_Obj("tinyint", Byte.class),
    BIGDECIMAL("decimal", BigDecimal.class),
    DATETIME("datetime", Date.class),
    FLOAT("float", float.class),
    FLOAT_OBJ("float", Float.class),
    DOUBLE("double", double.class),
    DOUBLE_OBJ("double", Double.class),
    NUMBER_DOUBLE("NUMBER", Double.class),
    NUMBER_LONG("NUMBER", Long.class);

    private String jdbcType;
    private Class javaType;

    EnumJdbcType(String jdbcType, Class javaType) {
        this.jdbcType = jdbcType;
        this.javaType = javaType;
    }

    public String getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
    }

    public Class getJavaType() {
        return javaType;
    }

    public void setJavaType(Class javaType) {
        this.javaType = javaType;
    }
}
