//package com.codegen.prototype;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.SessionAttribute;
//
///**
// * @author Generate By zenglw
// * @date 2018/6/12
// */
//@Api(tags = "Generate Code")
//@RestController
//@RequestMapping("/demo")
//public class DemoController {
//
//    @Autowired
//    private DemoServiceApi demoServiceApi;
//
//    @ApiOperation(
//        value = "desc - author - version",
//        notes = "新增",
//        tags = "Generate Code"
//    )
//    @PostMapping()
//    public Result<Demo> add(@RequestBody Demo demo, @SessionAttribute UserSessionAttr userSessionAttr) {
//
//        return Result.success(demoServiceApi.add(demo));
//    }
//
//    @ApiOperation(
//        value = "desc - author - version",
//        notes = "删除",
//        tags = "Generate Code"
//    )
//    @DeleteMapping("/{id}")
//    public Result delete(@PathVariable("id") Integer id, @SessionAttribute UserSessionAttr userSessionAttr) {
//        demoServiceApi.delete(id);
//        return Result.success();
//    }
//
//    @ApiOperation(
//        value = "desc - author - version",
//        notes = "修改",
//        tags = "Generate Code"
//    )
//    @PutMapping()
//    public Result<Demo> update(@RequestBody Demo demo, @SessionAttribute UserSessionAttr userSessionAttr) {
//        return Result.success(demoServiceApi.update(demo));
//    }
//
//    @ApiOperation(
//        value = "desc - author - version",
//        notes = "通过ID查找",
//        tags = "Generate Code"
//    )
//    @GetMapping("/{id}")
//    public Result<Demo> findById(@PathVariable("id") Integer id,@SessionAttribute UserSessionAttr userSessionAttr) {
//        return Result.success(demoServiceApi.findById(id));
//    }
//
//    @ApiOperation(
//        value = "desc - author - version",
//        notes = "通过Domain查找",
//        tags = "Generate Code"
//    )
//    @GetMapping("/findOne")
//    public Result<Demo> findOne(Demo demo, @SessionAttribute UserSessionAttr userSessionAttr) {
//        return Result.success(demoServiceApi.findOne(demo));
//    }
//
//    @ApiOperation(
//        value = "desc - author - version",
//        notes = "分页查找",
//        tags = "Generate Code"
//    )
//    @PostMapping("/page")
//    public Result<Page<Demo>> findPage(@SessionAttribute UserSessionAttr userSessionAttr) {
//        return Result.success(demoServiceApi.findPage());
//    }
//
//    @ApiOperation(
//        value = "desc - author - version",
//        notes = "列表查找",
//        tags = "Generate Code"
//    )
//    @GetMapping("/list")
//    public Result<List<Demo>> findList(Demo demo,@SessionAttribute UserSessionAttr userSessionAttr) {
//        return Result.success(demoServiceApi.findList(demo));
//    }
//
//}