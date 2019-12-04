package com.baomidou;

import com.baomidou.dao.courtyard.HouseCourtyardBaseMapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.po.courtyard.HouseCourtyardBase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MapperCrudTest {
    @Resource
    private HouseCourtyardBaseMapper houseCourtyardBaseMapper;

    /**
     * insert
     */
    @Test
    public void insertTest() {
        HouseCourtyardBase houseCourtyardBase = new HouseCourtyardBase();
        houseCourtyardBase.setCourtyardId(UUID.randomUUID().toString());
        houseCourtyardBase.setOrganId("3281332b9bc711e9afc21cb72cde98e2");
        houseCourtyardBase.setCourtyardName("zk测试");
        houseCourtyardBase.setCourtyardAddress("合肥");
        houseCourtyardBase.setLogicDelete("NO");
        houseCourtyardBase.setAreaId("011102");
        houseCourtyardBaseMapper.insert(houseCourtyardBase);
    }

    @Test
    public void deleteByIdTest() {
        houseCourtyardBaseMapper.deleteById("1f5d1ac0-0abe-4907-9978-7c0ad72ab4eb");
    }

    @Test
    public void deleteByMap() {
        Map<String, Object> paramsMap = new HashMap<>(16);
        paramsMap.put("courtyard_name", "zk测试1");
        houseCourtyardBaseMapper.deleteByMap(paramsMap);
    }


    @Test
    public void deleteByWrapper() {
        HouseCourtyardBase houseCourtyardBase = new HouseCourtyardBase();
        houseCourtyardBase.setCourtyardName("zk测试2");
        Wrapper<HouseCourtyardBase> houseCourtyardBaseWrapper = new Wrapper<HouseCourtyardBase>() {
            @Override
            public HouseCourtyardBase getEntity() {
                return houseCourtyardBase;
            }

            @Override
            public MergeSegments getExpression() {
                return null;
            }

            @Override
            public String getSqlSegment() {
                return null;
            }
        };
        //第一种
        /*houseCourtyardBaseMapper.delete(houseCourtyardBaseWrapper);*/
        //第二种
        houseCourtyardBaseMapper.delete(new QueryWrapper<HouseCourtyardBase>().lambda().eq(HouseCourtyardBase::getCourtyardName, "zk测试2"));
    }

    @Test
    public void deleteBatchByIds() {
        List<String> idList = new ArrayList<>();
        idList.add("22712fa0-53bc-4674-b12d-be3c6c946107");
        idList.add("4bde2bf6-1ded-4e4e-a430-67432d4c9ef9");
        houseCourtyardBaseMapper.deleteBatchIds(idList);
    }

    @Test
    public void updateById() {
        HouseCourtyardBase houseCourtyardBase = new HouseCourtyardBase();
        houseCourtyardBase.setCourtyardId("ee596e44-6a34-43cd-955a-1f838fb7d9fd");
        houseCourtyardBase.setCourtyardName("123");
        houseCourtyardBaseMapper.updateById(houseCourtyardBase);
    }

    @Test
    public void update() {
        HouseCourtyardBase houseCourtyardBase = new HouseCourtyardBase();
/*
        houseCourtyardBase.setCourtyardId("ee596e44-6a34-43cd-955a-1f838fb7d9fd");
*/
        houseCourtyardBase.setCourtyardName("456");
        houseCourtyardBaseMapper.update(houseCourtyardBase, new QueryWrapper<HouseCourtyardBase>().lambda().eq(HouseCourtyardBase::getCourtyardId, "ee596e44-6a34-43cd-955a-1f838fb7d9fd"));
    }

    @Test
    public void selectById() {
        HouseCourtyardBase houseCourtyardBase = houseCourtyardBaseMapper.selectById("ee596e44-6a34-43cd-955a-1f838fb7d9fd");
        log.info(houseCourtyardBase.toString());
    }

    @Test
    public void selectBatchByIds() {
        List<String> idList = new ArrayList<>();
        idList.add("ee596e44-6a34-43cd-955a-1f838fb7d9fd");
        idList.add("fa041b05-1902-4d51-918b-47364fb38c51");
        List<HouseCourtyardBase> houseCourtyardBaseList = houseCourtyardBaseMapper.selectBatchIds(idList);
        log.info(houseCourtyardBaseList.get(1).toString());
    }

    @Test
    public void selectByMap() {
        Map<String, Object> paramsMap = new HashMap<>(16);
        paramsMap.put("courtyard_name", "456");
        List<HouseCourtyardBase> houseCourtyardBaseList = houseCourtyardBaseMapper.selectByMap(paramsMap);
        log.info(houseCourtyardBaseList.get(0).toString());
    }

    @Test
    public void selectOne() {
        HouseCourtyardBase houseCourtyardBase = houseCourtyardBaseMapper.selectOne(new QueryWrapper<HouseCourtyardBase>().lambda()
                .like(HouseCourtyardBase::getAreaId, "11")
                .last("limit 1")
        );
        log.info(houseCourtyardBase.toString());
    }

    @Test
    public void selectCount() {
        Integer integer = houseCourtyardBaseMapper.selectCount(new QueryWrapper<HouseCourtyardBase>().lambda()
                .like(HouseCourtyardBase::getAreaId, "11")
        );
        log.info(String.valueOf(integer));
    }

    @Test
    public void selectList() {
        List<HouseCourtyardBase> houseCourtyardBaseList = houseCourtyardBaseMapper.selectList(new QueryWrapper<HouseCourtyardBase>().lambda()
                .like(HouseCourtyardBase::getAreaId, "11")
        );
        for (HouseCourtyardBase houseCourtyardBase:houseCourtyardBaseList){
            log.info(houseCourtyardBase.toString());
        }
    }

    @Test
    public void selectMaps() {
        List<Map<String,Object>> mapList = houseCourtyardBaseMapper.selectMaps(new QueryWrapper<HouseCourtyardBase>().lambda()
                .eq(HouseCourtyardBase::getCourtyardName, "456")
        );
        for (Map<String,Object> houseCourtyardBase:mapList){
            log.info(houseCourtyardBase.toString());
        }
    }

    @Test
    public void selectObjects() {
        List<Object> objects = houseCourtyardBaseMapper.selectObjs(new QueryWrapper<HouseCourtyardBase>().lambda()
                .like(HouseCourtyardBase::getAreaId, "11")
        );
        for (Object houseCourtyardBase:objects){
            System.out.println(houseCourtyardBase);
        }
    }
}
