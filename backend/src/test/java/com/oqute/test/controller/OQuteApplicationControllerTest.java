package com.oqute.test.controller;
import com.oqute.OQuteApplicationBoot;
import com.oqute.controller.OQuteApplicationController;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(OQuteApplicationBoot.class)
public class OQuteApplicationControllerTest {

    @Autowired
    private OQuteApplicationController oQuteApplicationController;

    @Test
    public void testDefaultSettings() throws Exception {
        assertThat(oQuteApplicationController.handle()).isEqualTo("Dmitry");
    }

}