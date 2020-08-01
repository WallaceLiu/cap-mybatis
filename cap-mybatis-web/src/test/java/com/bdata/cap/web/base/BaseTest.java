package com.bdata.cap.web.base;

//import com.jd.fastjson.JSON;
//import com.jd.jr.ComputerApplication;

import com.CapApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

//import com.jd.jr.cupid.model.admin.web.ComputerApplication;

/**
 * ${DESCRIPTION}
 *
 * @author liangfawen
 * @create 2019-01-16 19:24
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CapApplication.class)
public class BaseTest {
    public void print(Object o) {
//        System.out.println("_________________________________________________________");
//        System.out.println("--->:" + JSON.toJSONString(o));
    }

    public void print(Collection o) {
//        System.out.println("_________________________________________________________");
//        System.out.println("--->:" + JSON.toJSONString(o));
    }

}
