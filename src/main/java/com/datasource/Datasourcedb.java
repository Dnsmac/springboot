package com.datasource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 * Created by summer on 2016/11/25.
 */
@Configuration
public class Datasourcedb {

    /**
     * qidianVip
    * @author 骆峰
    * @date 2018年3月29日 下午2:43:21
    * @return
     */
    @Bean(name = "logCenterDataSource")
    @Qualifier("logCenterDataSource")
    @ConfigurationProperties(prefix="spring.datasource.logCenter")
    public DataSource logCenterDataSource() {
        return DataSourceBuilder.create().build();
    }
    
    @Bean(name = "logCenterJdbcTemplate")
    public JdbcTemplate logCenterJdbcTemplate(
            @Qualifier("logCenterDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    
    
    /**
     * qidianVip
     * @author 骆峰
     * @date 2018年3月29日 下午2:43:21
     * @return
     */
    @Bean(name = "smartkitDataSource")
    @Qualifier("smartkitDataSource")
    @ConfigurationProperties(prefix="spring.datasource.smartkit")
    public DataSource smartkitDataSource() {
        return DataSourceBuilder.create().build();
    }
    
    @Bean(name = "smartkitJdbcTemplate")
    public JdbcTemplate smartkitJdbcTemplate(
            @Qualifier("smartkitDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    
    

    
}
