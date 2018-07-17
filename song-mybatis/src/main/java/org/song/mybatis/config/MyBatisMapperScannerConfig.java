package org.song.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tk.mybatis.spring.mapper.MapperScannerConfigurer;

/**
 * @author liuk-m
 *
 */
@Configuration
@AutoConfigureAfter(MyBatisConfig.class)
@MapperScan("org.song.mybatis.mapper")
public class MyBatisMapperScannerConfig {
	
	@Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("org.song.mybatis.mapper");
        mapperScannerConfigurer.setMarkerInterface(tk.mybatis.mapper.common.Mapper.class);
        return mapperScannerConfigurer;
    }
}
