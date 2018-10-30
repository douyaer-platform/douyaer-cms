package com.douyaer.cms.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@EnableAutoConfiguration
@MapperScan(basePackages = "com.douyaer.cms.dao", sqlSessionTemplateRef = "sqlSessionTemplate")
public class DataSourceConfig {

    @Bean(name = "dataSource", destroyMethod = "close", initMethod = "init")
    @ConfigurationProperties(prefix = "spring.datasource")// prefix值必须是application.properteis中对应属性的前缀
    @Primary
    public DruidDataSource dataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
	 * 创建sql工厂
	 * @param dataSource
	 * @return
	 * @throws Exception
	 */
	@Bean(name = "sqlSessionFactory")
	@Primary
	public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DruidDataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		//对应mybatis.type-aliases-package配置
		bean.setTypeAliasesPackage("com.douyaer.cms.pojo");
		//对应mybatis.mapper-locations配置
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
		//开启驼峰映射
		bean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
		return bean.getObject();
	}

	/**
	 * 配置事务管理
	 * @param dataSource
	 * @return
	 */
	@Bean(name = "transactionManager")
	@Primary
	public DataSourceTransactionManager transactionManager(@Qualifier("dataSource") DruidDataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	/**
	 * sqlSession模版，用于配置自动扫描pojo实体类
	 * @param sqlSessionFactory
	 * @return
	 * @throws Exception
	 */
	@Bean(name = "sqlSessionTemplate")
	@Primary
	public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}