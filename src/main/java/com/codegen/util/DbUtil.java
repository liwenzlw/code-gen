package com.codegen.util;

import com.codegen.config.CodeGenConfig;
import com.codegen.domain.ColumnMetaData;
import com.codegen.domain.TableMetaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;
import java.util.Properties;

/**
 * @author zenglw
 * @date 2018/5/1
 */
@Component
public class DbUtil {

    @Autowired
    private CodeGenConfig codeGenConfig;
    @Autowired
    private ApplicationContext applicationContext;

    private Connection connection;

    private DatabaseMetaData dbMetaData;

    @PostConstruct
    public void init() throws Exception {
        Class.forName(codeGenConfig.getDriver());
        this.connection = getConnection();
        dbMetaData = connection.getMetaData();
    }

    @PreDestroy
    public void destory() throws Exception{
        this.connection.close();
    }

    public Connection getConnection() throws Exception {
        Properties props =new Properties();
        props.put("user", codeGenConfig.getUsername());
        props.put("password", codeGenConfig.getPassword());
        props.put("remarksReporting","true");
        return DriverManager.getConnection(codeGenConfig.getUrl(),props);
    }

    public TableMetaData buildTableMetaData (String tableName) {

        TableMetaData tableMetaData = new TableMetaData();
        try {
            String schema = dbMetaData.getUserName().toUpperCase();
            ResultSet tables = dbMetaData.getTables(null, schema, tableName, null);
            tableMetaData.setTableName(tableName);
            tables.next();
            ResultSetMetaData metaData = tables.getMetaData();

            tableMetaData.setTableComment(tables.getString("Remarks"));

            ResultSet columns = dbMetaData.getColumns(null, schema, tableName, null);

            while (columns.next()) {
                ColumnMetaData columnMetaData = new ColumnMetaData();
                columnMetaData.setDbColumnName(columns.getString("COLUMN_NAME"));
                columnMetaData.setDbColumnType(columns.getString("TYPE_NAME"));
                columnMetaData.setDbColumnComments(columns.getString("REMARKS"));
                //小数点位数
                columnMetaData.setDecimalDigits(columns.getInt("DECIMAL_DIGITS"));
                tableMetaData.getColumns().add(columnMetaData);
            }

            tableMetaData.build(codeGenConfig);
//            SpringResourceTemplateResolver templateResolver =
//                    new SpringResourceTemplateResolver();
//            templateResolver.setApplicationContext(applicationContext);
//            TemplateEngine templateEngine = new TemplateEngine();
//            templateResolver.setTemplateMode(TemplateMode.TEXT);
//
//            templateEngine.setTemplateResolver(templateResolver);
//            Context ctx = new Context();
//            ctx.setVariable("tableMateData",tableMetaData);
//            ctx.setVariable("config",codeGenConfig);
//            ctx.setVariable("currentDate",LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE));
//            FileWriter fw = new FileWriter("/templates/t.java");
//            templateEngine.process("classpath:templates/t.template",ctx,fw);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }





        return tableMetaData;
    }

 //   public ResultSetMetaData getResultSet(String tableName) throws Exception {

//        String schema =dbMetaData.getUserName().toUpperCase();
//        ResultSet tables = dbMetaData.getTables(null, schema, "%", null);
//        ResultSet columns = dbMetaData.getColumns(null, schema, "T_ACCOUNT", null);
//        ResultSetMetaData metaData = columns.getMetaData();
//
//        while (columns.next()) {
//            ResultSetMetaData metaData1 = columns.getMetaData();
//            for(int i=0;i<metaData1.getColumnCount();i++) {
//                String colName = metaData1.getColumnName(i + 1);
//                String colVal = columns.getString(colName);
//                System.out.println(colName + ": " +colVal);
//            }

//            String column_name = columns.getString("COLUMN_NAME");
//            System.out.println(column_name);
//            String remarks = columns.getString("REMARKS");
//            System.out.println(remarks);
//            String type_name = columns.getString("TYPE_NAME");
//            System.out.println(type_name);

 //       }
        //ResultSet rs =getConnection.getMetaData().getColumns(null, getXMLConfig.getSchema(),tableName.toUpperCase(), "%")
//        while (tables.next()) {
//            String tableNameInDb = tables.getString("TABLE_NAME");
//            System.out.println(tableNameInDb);
//            ResultSet columns = dbMetaData.getColumns(null, schema, "TAB_EMPLOYEE_INFO", null);
//            while (columns.next()) {
//                String column_name = columns.getString("COLUMN_NAME");
//                System.out.println(column_name);
//                String remarks = columns.getString("REMARKS");
//                System.out.println(remarks);
//                String data_type = columns.getString("DATA_TYPE");
//                System.out.println(data_type);
//                String type_name = columns.getString("TYPE_NAME");
//                System.out.println(type_name);
//
//            }
//
//        }
//
//
//        return null;
//    }



}
