//package com.codegen.prototype;
//
//
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
///**
// * @author Generate By zenglw
// * @date 2018/6/12
// */
//@Repository
//public class DemoRepository {
//
//    @Autowired
//    private DemoMapper demoMapper;
//
//    public Demo add(Demo demo) {
//        demoMapper.insert(demo);
//        return demo;
//    }
//
//    public Demo findOne(Demo demo) {
//        return demoMapper.findOne(demo);
//    }
//
//    public Demo findById(Integer id) {
//        return demoMapper.findById(id);
//    }
//
//    public List<Demo> findList(Demo demo) {
//        return demoMapper.findList(demo);
//    }
//
//
//    public Page<Demo> findPage() {
//        return demoMapper.findPage(null,null);
//    }
//
//    public Demo update(Demo demo) {
//        demoMapper.updateByPrimaryKeySelective(demo);
//        return demoMapper.findById(demo.getId());
//    }
//
//    public void delete(Integer id) {
//        demoMapper.deleteById(id);
//    }
//}
