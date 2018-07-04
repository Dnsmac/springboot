package org.qidian.config.datasource;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.github.pagehelper.PageHelper;

@Configuration
@MapperScan(basePackages = LogCenterDatasource.PACKAGE, sqlSessionTemplateRef  = "logCenter")
public class LogCenterDatasource {

    // 精确到 cluster 目录，以便跟其他数据源隔离
    static final String PACKAGE = "org.qidian.dao.logCenter";
    static final String MAPPER_LOCATION = "classpath:mapper/logCenter/*.xml";
    
    
    @Bean(name = "logCenterBeanDatasource")
    @ConfigurationProperties(prefix = "spring.datasource.logCenter")
//    @Primary
    public DataSource logCenterDatasource() {
        return DataSourceBuilder.create().build();
    }

    
    @Bean(name = "logCenterSqlSessionFactory")
//    @Primary
    public SqlSessionFactory textlogSqlSessionFactory(@Qualifier("logCenterBeanDatasource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(LogCenterDatasource.MAPPER_LOCATION));
        
        // 分页拦截器-begin
        //添加分页插件、打印sql插件  
        Interceptor[] plugins = new Interceptor[]{pageHelper()};  
        bean.setPlugins(plugins);
        // 分页拦截器-end
        return bean.getObject();
    }

    @Bean(name = "logCenterTransactionManager")
//    @Primary
    public DataSourceTransactionManager textTransactionManager(@Qualifier("logCenterBeanDatasource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "logCenter")
//    @Primary
    public SqlSessionTemplate sessionTemplat(@Qualifier("logCenterSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    
    public PageHelper pageHelper() {  
        PageHelper pageHelper = new PageHelper();  
        Properties p = new Properties();  
        p.setProperty("offsetAsPageNum", "true");  
        p.setProperty("rowBoundsWithCount", "true");  
        p.setProperty("reasonable", "true");  
        p.setProperty("returnPageInfo", "check");  
        p.setProperty("params", "count=countSql");  
        pageHelper.setProperties(p);  
        return pageHelper;  
    }  
    
}
