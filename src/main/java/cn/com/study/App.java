package cn.com.study;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 启动主类
 *
 * @author LIU
 */

@SpringBootApplication
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
		};
	}

	//
	// // 配置mybatis的分页插件pageHelper
	// @Bean
	// public PageHelper pageHelper() {
	// PageHelper pageHelper = new PageHelper();
	// Properties properties = new Properties();
	// properties.setProperty("reasonable", "true");
	// properties.setProperty("supportMethodsArguments", "true");
	// properties.setProperty("returnPageInfo", "check");
	// properties.setProperty("params",
	// "pageNum=pageNum;pageSize=pageSize;count=countSql;reasonable=reasonable;pageSizeZero=pageSizeZero");
	// properties.setProperty("offsetAsPageNum", "true");
	// properties.setProperty("rowBoundsWithCount", "true");
	// properties.setProperty("reasonable", "true");
	// // properties.setProperty("dialect", "mysql"); // mysql方言 可自动检测
	// pageHelper.setProperties(properties);
	// return pageHelper;
	// }
}
