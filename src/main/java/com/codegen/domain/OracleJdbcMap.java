package com.codegen.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zenglw
 * @date 2018/5/2
 */
public class OracleJdbcMap implements JdbcMap {

    public static Map<String, String> oracleJdbcMap = new HashMap<String, String>();

    static {
        oracleJdbcMap.put("CHAR","String");
        oracleJdbcMap.put("NCHAR","String");
        oracleJdbcMap.put("VARCHAR","String");
        oracleJdbcMap.put("VARCHAR2","String");
        oracleJdbcMap.put("NVARCHAR2","String");
        oracleJdbcMap.put("NUMBER","Integer");
        oracleJdbcMap.put("NUMBER2","Double");
        oracleJdbcMap.put("INTEGER","Integer");
        oracleJdbcMap.put("BINARY_FLOAT","Float");
        oracleJdbcMap.put("BINARY_DOUBLE","Double");
        oracleJdbcMap.put("FLOAT","Float");
        oracleJdbcMap.put("DATE","Date");
        oracleJdbcMap.put("TIMESTAMP","Date");
        oracleJdbcMap.put("CLOB","String");
        oracleJdbcMap.put("BLOB","Byte[]");
        oracleJdbcMap.put("BFILE","Byte[]");
    }

    @Override
    public String getJavaType(String oracleType) {
        return oracleJdbcMap.get(oracleType);
    }
}
