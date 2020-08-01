package com.bdata.cap.web.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Date: 2018/10/12.
 *
 * @author zhaotianxiang
 */
@Configuration
@MapperScan(basePackages = {"com.bdata.cap.web.dao.mapper.db1"}, sqlSessionTemplateRef = "capSqlSessionTemplate")
public class CapDBConfig {

    @Bean(name = "capDataSource")
    @ConfigurationProperties(prefix = "db")
    @Primary
    public DataSource capDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "capSqlSessionFactory")
    @Primary
    public SqlSessionFactory capSqlSessionFactory(@Qualifier("capDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);

        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mybatis/*/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "capTransactionManager")
    @Primary
    public DataSourceTransactionManager capTransactionManager(@Qualifier("capDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "capSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate capSqlSessionTemplate(@Qualifier("capSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
