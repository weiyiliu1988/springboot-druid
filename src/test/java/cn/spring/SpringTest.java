package cn.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import cn.com.study.App;
import cn.com.study.entity.Person;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class SpringTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void insertTest() {
		try {
			Person p = new Person();
			p.setDateStr("1990-01-01 11:11:11");
			p.setCity("LY");
			p.setName("QQQ");
			p.setSex(0);
			testRestTemplate.postForEntity("/person/insert", p, Integer.class).getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
