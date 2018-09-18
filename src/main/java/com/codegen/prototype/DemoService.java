//package com.codegen.prototype;
//
//
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// * @author Generate By zenglw
// * @date 2018/6/12
// */
//@Service
//public class DemoService {
//
//    @Autowired
//    private DemoRepository demoRepository;
//
//    public Demo add(Demo demo) {
//        return demoRepository.add(demo);
//    }
//
//    public void delete(Integer id) {
//        demoRepository.delete(id);
//    }
//
//    public Demo update(Demo demo) {
//       return demoRepository.update(demo);
//    }
//
//    public Page<Demo> findPage() {
//        return demoRepository.findPage();
//    }
//
//    public List<Demo> findList(Demo demo) {
//        return demoRepository.findList(demo);
//    }
//
//    public Demo findById(Integer id) {
//        return demoRepository.findById(id);
//    }
//
//    public Demo findOne(Demo demo) {
//        return demoRepository.findOne(demo);
//    }
//}
