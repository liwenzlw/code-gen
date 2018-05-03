package com.codegen.dbtool;

import com.codegen.util.DbUtil;
import com.codegen.util.GenerateFile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbConnectionTests {

    @Autowired
    private DbUtil dbTool;

    @Autowired
    private GenerateFile generateFile;

    @Test
    public void contextLoads() throws Exception{
        generateFile.start();
    }
}
