package com.baomidou;

import com.baomidou.po.courtyard.HouseCourtyardBase;
import com.baomidou.service.courtyard.HouseCourtyardBaseService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ServiceTest {
    @Resource
    private HouseCourtyardBaseService houseCourtyardBaseService;

    @Test
    public void save(){
        HouseCourtyardBase houseCourtyardBase = new HouseCourtyardBase();
        houseCourtyardBase.setCourtyardId(UUID.randomUUID().toString());
        houseCourtyardBase.setOrganId("3281332b9bc711e9afc21cb72cde98e2");
        houseCourtyardBase.setCourtyardName("zkSe测试");
        houseCourtyardBase.setCourtyardAddress("合肥");
        houseCourtyardBase.setLogicDelete("NO");
        houseCourtyardBase.setAreaId("011102");
        houseCourtyardBaseService.save(houseCourtyardBase);
    }

    @Test
    public void saveBatch(){

        List<HouseCourtyardBase> houseCourtyardBaseList = new ArrayList<>();

        HouseCourtyardBase houseCourtyardBase = new HouseCourtyardBase();
        houseCourtyardBase.setCourtyardId(UUID.randomUUID().toString());
        houseCourtyardBase.setOrganId("3281332b9bc711e9afc21cb72cde98e2");
        houseCourtyardBase.setCourtyardName("zkSe测试");
        houseCourtyardBase.setCourtyardAddress("合肥");
        houseCourtyardBase.setLogicDelete("NO");
        houseCourtyardBase.setAreaId("011102");

        HouseCourtyardBase houseCourtyardBase1 = new HouseCourtyardBase();
        houseCourtyardBase1.setCourtyardId(UUID.randomUUID().toString());
        houseCourtyardBase1.setOrganId("3281332b9bc711e9afc21cb72cde98e2");
        houseCourtyardBase1.setCourtyardName("zkSe测试");
        houseCourtyardBase1.setCourtyardAddress("合肥");
        houseCourtyardBase1.setLogicDelete("NO");
        houseCourtyardBase1.setAreaId("011102");

        houseCourtyardBaseList.add(houseCourtyardBase);
        houseCourtyardBaseList.add(houseCourtyardBase1);
        houseCourtyardBaseService.saveBatch(houseCourtyardBaseList);
    }

    @Test
    public void saveOrUpdateBatch(){

        List<HouseCourtyardBase> houseCourtyardBaseList = new ArrayList<>();

        HouseCourtyardBase houseCourtyardBase = new HouseCourtyardBase();
        houseCourtyardBase.setCourtyardId(UUID.randomUUID().toString());
        houseCourtyardBase.setOrganId("3281332b9bc711e9afc21cb72cde98e2");
        houseCourtyardBase.setCourtyardName("zkSe测试");
        houseCourtyardBase.setCourtyardAddress("合肥");
        houseCourtyardBase.setLogicDelete("NO");
        houseCourtyardBase.setAreaId("011102");

        HouseCourtyardBase houseCourtyardBase1 = new HouseCourtyardBase();
        houseCourtyardBase1.setCourtyardId(UUID.randomUUID().toString());
        houseCourtyardBase1.setOrganId("3281332b9bc711e9afc21cb72cde98e2");
        houseCourtyardBase1.setCourtyardName("zkSe测试");
        houseCourtyardBase1.setCourtyardAddress("合肥");
        houseCourtyardBase1.setLogicDelete("NO");
        houseCourtyardBase1.setAreaId("011102");

        houseCourtyardBaseList.add(houseCourtyardBase);
        houseCourtyardBaseList.add(houseCourtyardBase1);
        houseCourtyardBaseService.saveOrUpdateBatch(houseCourtyardBaseList);
    }

    @Test
    public void removeByIds(){
        List<String> idList = new ArrayList<>();
        idList.add("ee596e44-6a34-43cd-955a-1f838fb7d9fd");
        idList.add("fa041b05-1902-4d51-918b-47364fb38c51");
        houseCourtyardBaseService.removeByIds(idList);
    }
}
