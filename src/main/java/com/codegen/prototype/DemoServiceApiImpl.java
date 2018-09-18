//package com.codegen.prototype;
//
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author Generate By zenglw
// * @date 2018/6/12
// */
//@Api(tags = "Generate Code")
//@RestController
//public class DemoServiceApiImpl implements DemoServiceApi {
//
//    @Autowired
//    private DemoService demoService;
//
//    @ApiOperation(
//        value = "desc - author - version",
//        notes = "新增",
//        tags = "Generate Code"
//    )
//    @Override
//    public Demo add(@RequestBody Demo demo) {
//        return demoService.add(demo);
//    }
//
//    @ApiOperation(
//        value = "desc - author - version",
//        notes = "删除",
//        tags = "Generate Code"
//    )
//    @Override
//    public void delete(Integer id) {
//        demoService.delete(id);
//    }
//
//    @ApiOperation(
//        value = "desc - author - version",
//        notes = "修改",
//        tags = "Generate Code"
//    )
//    @Override
//    public Demo update(@RequestBody Demo demo) {
//        return demoService.update(demo);
//    }
//
//    @ApiOperation(
//        value = "desc - author - version",
//        notes = "通过ID查找",
//        tags = "Generate Code"
//    )
//    @Override
//    public Demo findById(Integer id) {
//        return demoService.findById(id);
//    }
//
//    @ApiOperation(
//        value = "desc - author - version",
//        notes = "通过Domain查找",
//        tags = "Generate Code"
//    )
//    @Override
//    public Demo findOne(@RequestBody Demo demo) {
//        return demoService.findOne(demo);
//    }
//
//    @ApiOperation(
//        value = "desc - author - version",
//        notes = "分页查找",
//        tags = "Generate Code"
//    )
//    @Override
//    public Page<Demo> findPage() {
//        return demoService.findPage();
//    }
//
//    @ApiOperation(
//        value = "desc - author - version",
//        notes = "列表查找",
//        tags = "Generate Code"
//    )
//    @Override
//    public List<Demo> findList(@RequestBody Demo demo) {
//        return demoService.findList(demo);
//    }
//}
