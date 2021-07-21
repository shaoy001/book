package com.zwj.book.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {

	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();

		bean.setSecurityManager(securityManager);
		Map<String, String> filterMap = new LinkedHashMap<>();

		// 静态资源访问
		filterMap.put("/login", "anon");

		filterMap.put("/resources/**", "anon");
		filterMap.put("/*.css", "anon");
		filterMap.put("/*.js", "anon");
		// 对请求进行拦截
		filterMap.put("/**", "authc");

		bean.setFilterChainDefinitionMap(filterMap);
		bean.setLoginUrl("/toLogin");
		bean.setSuccessUrl("/index");
		bean.setUnauthorizedUrl("unAuth");

		return bean;
	}

	@Bean
	public DefaultWebSecurityManager defaultWebSecurityManger(MyRealm realm) {
		DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
		manager.setRealm(realm);
		return manager;
	}

	@Bean
	public MyRealm myRealm() {
		MyRealm realm = new MyRealm();
		return realm;
	}
}
