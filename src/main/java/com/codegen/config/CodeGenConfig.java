package com.codegen.config;

import com.codegen.domain.FileMetaData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zenglw
 * @date 2018/5/1
 */
@Component
@ConfigurationProperties(prefix = "codegen")
public class CodeGenConfig {

    @Value("${spring.profiles.active}")
    private String profile;
    private String db;
    private String driver;
    private String url;
    private String username;
    private String password;
    private String author;
    private String tablePrefix;
    private String tableSuffix;

    private String templatePath;
    private String projectPath;
    private String javaPath;
    private String resourcesPath;
    //key为模板文件名，value为包名，如果value中带有>符合，则前半部分为生成文件路径，后半部分为包名
    private List<FileMetaData> javaFiles;

    //key为模板文件名，value为生成文件路径
    private List<FileMetaData> resourcesFiles;

    private List<String> generateTable;

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getGenerateTable() {
        return generateTable;
    }

    public void setGenerateTable(List<String> generateTable) {
        this.generateTable = generateTable;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTablePrefix() {
        return tablePrefix;
    }

    public void setTablePrefix(String tablePrefix) {
        this.tablePrefix = tablePrefix;
    }

    public String getTableSuffix() {
        return tableSuffix;
    }

    public void setTableSuffix(String tableSuffix) {
        this.tableSuffix = tableSuffix;
    }

    public String getTemplatePath() {
        return templatePath;
    }

    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    public String getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }

    public String getJavaPath() {
        return javaPath;
    }

    public void setJavaPath(String javaPath) {
        this.javaPath = javaPath;
    }

    public String getResourcesPath() {
        return resourcesPath;
    }

    public void setResourcesPath(String resourcesPath) {
        this.resourcesPath = resourcesPath;
    }

    public List<FileMetaData> getJavaFiles() {
        return javaFiles;
    }

    public void setJavaFiles(List<FileMetaData> javaFiles) {
        this.javaFiles = javaFiles;
    }

    public List<FileMetaData> getResourcesFiles() {
        return resourcesFiles;
    }

    public void setResourcesFiles(List<FileMetaData> resourcesFiles) {
        this.resourcesFiles = resourcesFiles;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
