package com.bdata.cap.web.dao;

//import com.cupid.model.admin.web.test.service.BaseTest;
//import com.jd.jr.cupid.model.admin.core.dao.model.SocratesModelFeat;
//import com.jd.jr.cupid.model.admin.core.dao.model.SocratesModelFeatGroup;

import com.bdata.cap.web.base.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestTableDaoTests extends BaseTest {

    @Autowired
    TastTableDao dao;

    @Test
    public void testgetByModelIdNotExist() {
        dao.get();
//        Integer id = 10000;
//        String version = "FV201911170000";
//        List<SocratesModelFeatGroup> result = dao.getByModelId(id, version);
//        System.out.println("SocratesModelFeatMapperTests.testInsert--->:" + result.size());
    }

}
