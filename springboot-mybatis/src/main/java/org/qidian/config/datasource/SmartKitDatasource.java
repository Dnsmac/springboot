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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.github.pagehelper.PageHelper;


/**
 * Created by summer on 2016/11/25.
 */
@Configuration
@MapperScan(basePackages = SmartKitDatasource.PACKAGE, sqlSessionTemplateRef  = "smartKit")
public class SmartKitDatasource {

    // 精确到 cluster 目录，以便跟其他数据源隔离
    static final String PACKAGE = "org.qidian.dao.smartkit";
    static final String MAPPER_LOCATION = "classpath:mapper/smartkit/*.xml";
    
    
    @Bean(name = "smartKitBeanDatasource")
    @ConfigurationProperties(prefix = "spring.datasource.smartkit")
    @Primary
    public DataSource textDatasource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "smartKitSqlSessionFactory")
    @Primary
    public SqlSessionFactory textSessionFactory(@Qualifier("smartKitBeanDatasource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(SmartKitDatasource.MAPPER_LOCATION));
        // 分页拦截器-begin
        
        //添加分页插件、打印sql插件  
        Interceptor[] plugins = new Interceptor[]{pageHelper()};  
        bean.setPlugins(plugins);
        // 分页拦截器-end
        return bean.getObject();
    }

    @Bean(name = "smartKitTransactionManager")
    @Primary
    public DataSourceTransactionManager textTransactionManager(@Qualifier("smartKitBeanDatasource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "smartKit")
    @Primary
    public SqlSessionTemplate textSessionTemplat(@Qualifier("smartKitSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
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
