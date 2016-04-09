package web.oqute.test.controller;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import web.oqute.OQuteApplicationBoot;
import web.oqute.controller.OQuteApplicationController;
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