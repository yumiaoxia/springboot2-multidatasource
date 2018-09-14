package com.example.multidatasourcedemo.config;/*
 *
 * @author 12539 1253950375@qq.com
 *  Created in 2018/9/14
 */

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.multidatasourcedemo.test1.mapper", sqlSessionFactoryRef = "test1SqlSessionFactory")
public class DatasourceConfig1 {


    @Bean(name = "test1Datasource")
    @ConfigurationProperties(prefix = "jdbc.datasource.test1")
    public DataSource createDatasource() {
        return DataSourceBuilder
                .create()
                .build();
    }

    @Bean(name = "test1SqlSessionFactory")
    public SqlSessionFactory createSqlSessionFactory(@Qualifier("test1Datasource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "test1TransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("test1Datasource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "test1SqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("test1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
