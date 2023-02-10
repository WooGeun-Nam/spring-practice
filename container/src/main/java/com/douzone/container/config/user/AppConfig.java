package com.douzone.container.config.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.douzone.container.user.Friend;

@Configuration
// auto scanning
@ComponentScan(basePackages={"com.douzone.container.user"})
public class AppConfig {

//  명시적 설정
//	@Bean
//	public User user() {
//		return new User();
//	}
	
	@Bean
	public Friend friend() {
		return new Friend("Loopy");
	}
}
