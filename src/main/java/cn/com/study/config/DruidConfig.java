package cn.com.study.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * @author LIU
 *
 */
@Configuration
// 配置文件简化设定方法
// @ConfigurationProperties(prefix = "spring.datasource.druid")
public class DruidConfig {

	private Logger log = LoggerFactory.getLogger(DruidConfig.class);

	@Value("${spring.datasource.url}")
	private String connectionUrl;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;

	@Value("${spring.datasource.druid.initial-size}")
	private Integer initialSize;
	@Value("${spring.datasource.druid.min-idle}")
	private Integer minIdle;
	@Value("${spring.datasource.druid.max-active}")
	private Integer maxActive;
	@Value("${spring.datasource.druid.max-wait}")
	private Integer maxWait;
	@Value("${spring.datasource.druid.time-between-eviction-runs-millis}")
	private Integer timeBetweenEvictionRunsMillis;
	@Value("${spring.datasource.druid.min-evictable-idle-time-millis}")
	private Integer minEvictableIdleTimeMillis;
	@Value("${spring.datasource.druid.validation-query}")
	private String validationQuery;
	@Value("${spring.datasource.druid.test-while-idle}")
	private Boolean testWhileIdle;
	@Value("${spring.datasource.druid.test-on-borrow}")
	private Boolean testOnBorrow;
	@Value("${spring.datasource.druid.test-on-return}")
	private Boolean testOnReturn;
	@Value("${spring.datasource.druid.pool-prepared-statements}")
	private Boolean poolPreparedStatements;
	@Value("${spring.datasource.druid.max-pool-prepared-statement-per-connection-size}")
	private Integer maxPoolPreparedStatementPerConnectionSize;
	@Value("${spring.datasource.druid.filters}")
	private String filters;

	@Value("${spring.datasource.druid.loginUsername}")
	private String loginUsername;
	@Value("${spring.datasource.druid.loginPassword}")
	private String loginPassword;

	// 配置数据源
	@Bean(name = "basisDataSource", initMethod = "init", destroyMethod = "close")
	public DruidDataSource initDataSource() {
		log.info("初始化DruidDataSource");
		DruidDataSource dds = new DruidDataSource();
		dds.setDriverClassName("com.mysql.jdbc.Driver");
		dds.setUrl(connectionUrl);
		dds.setUsername(username);
		dds.setPassword(password);
		dds.setInitialSize(initialSize);
		dds.setMinIdle(minIdle);
		dds.setMaxActive(maxActive);
		dds.setMaxWait(maxWait);
		dds.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		dds.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
		dds.setValidationQuery(validationQuery);
		dds.setTestWhileIdle(testWhileIdle);
		dds.setTestOnBorrow(testOnBorrow);
		dds.setTestOnReturn(testOnReturn);
		dds.setPoolPreparedStatements(poolPreparedStatements);
		dds.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
		try {
			dds.setFilters(filters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dds;
	}

	@Bean
	public ServletRegistrationBean druidServlet() {
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),
				"/druid/*");
		servletRegistrationBean.addInitParameter("loginUsername", loginUsername);
		servletRegistrationBean.addInitParameter("loginPassword", loginPassword);
		return servletRegistrationBean;
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		return filterRegistrationBean;
	}
}
