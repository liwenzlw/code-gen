//package com.codegen.prototype;
//
//
//import java.util.List;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//
///**
// * @author Generate By zenglw
// * @date 2018/6/12
// */
//@FeignClient("")
//public interface DemoServiceApi {
//
//
//    @PostMapping("/demo/add")
//    Demo add(@RequestBody Demo demo);
//
//    @PostMapping("/demo/delete")
//    void delete(@RequestParam("id") Integer id);
//
//    @PostMapping("/demo/update")
//    Demo update(@RequestBody Demo demo);
//
//    @PostMapping("/demo/findById")
//    Demo findById(@RequestParam Integer id);
//
//    @PostMapping("/demo/findOne")
//    Demo findOne(@RequestBody Demo demo);
//
//    @PostMapping("/demo/findPage")
//    Page<Demo> findPage();
//
//    @PostMapping("/demo/findList")
//    List<Demo> findList(@RequestBody Demo demo);
//
//}
