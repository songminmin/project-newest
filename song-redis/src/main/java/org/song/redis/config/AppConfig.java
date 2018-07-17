package org.song.redis.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:redis-dubbo.xml")
public class AppConfig {
	
}