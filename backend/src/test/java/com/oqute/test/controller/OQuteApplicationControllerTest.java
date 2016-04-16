package com.oqute.test.controller;
import com.oqute.config.WebApplicationConfiguration;
import com.oqute.controller.OQuteApplicationController;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebApplicationConfiguration.class, loader = AnnotationConfigContextLoader.class)
public class OQuteApplicationControllerTest {

    @Autowired
    private OQuteApplicationController oQuteApplicationController;

    @Test
    public void testDefaultSettings() throws Exception {
        assertThat(oQuteApplicationController.handle()).isEqualTo("Dmitry");
    }

}