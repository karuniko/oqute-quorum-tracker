package com.karuniko.test.controller;
import com.karuniko.config.TestConfig;
import com.karuniko.controller.BlankApplicationController;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class, loader = AnnotationConfigWebContextLoader.class)
@WebAppConfiguration
public class BlankApplicationControllerTest {

    @Autowired
    private BlankApplicationController blankApplicationController;

    @Test
    public void testDefaultSettings() throws Exception {
        assertThat(blankApplicationController.getPerson(1L)).isEqualTo("dmitry");
    }

}