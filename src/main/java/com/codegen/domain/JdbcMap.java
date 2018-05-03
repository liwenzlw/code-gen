package com.codegen.domain;

/**
 * @author zenglw
 * @date 2018/5/2
 */
public interface JdbcMap {
    default String getJavaType(String oracleType){
        return "";
    };
}
