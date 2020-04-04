package com.fanhehe.user;


import lombok.SneakyThrows;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import com.fanhehe.user.pojo.PO.User;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fanhehe.user.pojo.respository.UserRepository;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@EnableFeignClients
@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserApplication.class)
class UserApplicationTests {

    MockMvc mockMvc;

    @Autowired
    UserRepository userRepository;

    @Autowired
    protected WebApplicationContext webApplicationContext;

    private static final Logger logger = LoggerFactory.getLogger(UserApplicationTests.class);

    @BeforeEach
    public void setMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @SneakyThrows
    void contextLoads() {

        logger.info("============");

        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/user/query")
                        .accept(MediaType.APPLICATION_JSON)
                        .queryParam("userId", "3746846603775757")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value("3746846603775757"))
                .andReturn();

        logger.info("================");
    }

    @Test
    void service() {
        User user = new User();
        user.setUserId((int) (Math.random() * 10000000000L));
        user.setUserNick("===========================");
        user.setUserAvatar("===========================");
        user.setCreateAt((int) System.currentTimeMillis() / 1000);
        user.setUpdateAt((int) System.currentTimeMillis() / 1000);

        User storage = userRepository.save(user);

        Assert.assertNotNull(storage);
        Assert.assertEquals(storage.getUserId(), user.getUserId());
    }
}
