package com.baomidou;

import com.baomidou.po.courtyard.HouseCourtyardBase;
import com.baomidou.service.courtyard.HouseCourtyardBaseService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AppTest {
    @Resource
    private HouseCourtyardBaseService houseCourtyardBaseService;
    @Test
    public void test_01(){
        List<HouseCourtyardBase> houseCourtyardBaseList = houseCourtyardBaseService.list();
        houseCourtyardBaseList.stream().forEach(houseCourtyardBase -> {
            log.info(houseCourtyardBase.getDateCreated().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        });
    }
}
