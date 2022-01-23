package com.eurekaserver.eurekaserver;

import com.netflix.discovery.shared.Application;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = EurekaServerApplication.class)
@TestPropertySource("classpath:application-test.properties")
@ContextConfiguration
class EurekaServerApplicationTests {

	@Value("${server.port}")
	private int port = 8761;

	@Test
	public void test() {
		ResponseEntity<Map> entity = new TestRestTemplate().getForEntity("http://discovery-server:8761" + "/eureka/apps", Map.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}

}
