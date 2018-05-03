package com.codegen.util;

import com.codegen.config.CodeGenConfig;
import com.codegen.domain.FileMetaData;
import com.codegen.domain.TableMetaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;

import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author zenglw
 * @date 2018/5/3
 */
@Component
public class GenerateFile {

    @Autowired
    private CodeGenConfig codeGenConfig;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private DbUtil dbTool;

    TemplateEngine templateEngine = null;

    private Stream<TableMetaData> tableMetaDatas;

    /**
     * 解析文件路径
     * @param codeGenConfig
     */
    public void resolveFilePath(CodeGenConfig codeGenConfig) {

        List<FileMetaData> javaFiles = codeGenConfig.getJavaFiles();
        if(null != javaFiles) {
            for (FileMetaData javaFile: javaFiles) {
                javaFile.assembleFilePath(codeGenConfig.getProjectPath(),codeGenConfig.getJavaPath(),codeGenConfig.getTemplatePath());
            }
        }

        List<FileMetaData> resourcesFiles = codeGenConfig.getResourcesFiles();
        if(null != resourcesFiles) {
            for (FileMetaData resourcesFile: resourcesFiles) {
                resourcesFile.assembleFilePath(codeGenConfig.getProjectPath(),codeGenConfig.getResourcesPath(),codeGenConfig.getTemplatePath());
            }
        }
    }

    public void start() {
        init();
        buildTableMetaDate();
        tableMetaDatas.forEach(tableMetaData -> resolveTemplate(tableMetaData));
    }


    public void init() {
        this.templateEngine = buildTemplateEngine();
        resolveFilePath(codeGenConfig);
    }

    public TemplateEngine buildTemplateEngine() {
        SpringResourceTemplateResolver templateResolver =
                new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        TemplateEngine templateEngine = new TemplateEngine();
        templateResolver.setTemplateMode(TemplateMode.TEXT);
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }

    private void buildTableMetaDate() {
        this.tableMetaDatas = codeGenConfig.getGenerateTable().stream().map(tableName -> dbTool.buildTableMetaData(tableName));
    }

    public void resolveTemplate(TableMetaData tableMetaData) {
       try {
           Context ctx = new Context();
           ctx.setVariable("tableMateData",tableMetaData);
           ctx.setVariable("config",codeGenConfig);
           ctx.setVariable("currentDate",LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE));
           FileWriter fw = null;
           if(null != codeGenConfig.getJavaFiles()) {
               for (FileMetaData javaFile: codeGenConfig.getJavaFiles()) {
                   ctx.setVariable("fileMeta",javaFile);
                   fw = new FileWriter(javaFile.getFilePath() + "/" + tableMetaData.getClassName() + javaFile.getFileSuffix() + ".java");
                   templateEngine.process(javaFile.getTemplatePath() + "/"  + javaFile.getTemplateName(),ctx,fw);
               }
           }
           if(null != codeGenConfig.getResourcesFiles()) {
               for (FileMetaData resourceFile: codeGenConfig.getResourcesFiles()) {
                   ctx.setVariable("fileMeta",resourceFile);
                   fw = new FileWriter(resourceFile.getFilePath() + "/" + tableMetaData.getClassName() + resourceFile.getFileSuffix() + ".xml");
                   templateEngine.process(resourceFile.getTemplatePath() + "/"  + resourceFile.getTemplateName(),ctx,fw);
               }
           }
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }
}
