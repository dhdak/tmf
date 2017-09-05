package org.tmf.dsmapi.controller.individual;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tmf.dsmapi.Application;
import org.tmf.dsmapi.domain.individual.Individual;

/**
 * Created by weizh on 2017-8-31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class IndividualControllerTest {
    @Autowired
    IndividualController individualController;

    @Test
    public void testGet(){
        Individual individual = individualController.get(1L);
        System.out.println("aaaaaaaaaa"+individual.getIndividualIdentification().get(0).getHjid());
    }
}
