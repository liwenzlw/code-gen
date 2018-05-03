package com.codegen.domain;

import com.codegen.util.CamelConvertUtil;
import org.springframework.lang.Nullable;

/**
 * @author zenglw
 * @date 2018/5/3
 */
public class FileMetaData {

    private String filePath;
    private String templateName;
    private String packageName;
    private String templatePath;
    private String fileSuffix;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getTemplatePath() {
        return templatePath;
    }

    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    public String getFileSuffix() {
        return fileSuffix;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }

    /**
     * 组装文件路径
     *
     * @return
     */
    public void assembleFilePath(String projectPath,String resourcePath,String templatePath) {
        if(null == filePath) {
            filePath = projectPath + "/" + resourcePath;
        }
        filePath = filePath + "/" + packageName.replaceAll("\\.","/" );
        this.templatePath = templatePath;
        this.fileSuffix = CamelConvertUtil.underline2Camel(null == this.fileSuffix ?"":this.fileSuffix,false);
    }
}
