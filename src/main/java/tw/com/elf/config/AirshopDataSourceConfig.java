package tw.com.elf.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages = {"tw.com.elf.mapper.airshop, tw.com.elf.mapper.airshop.customerMapper"}, sqlSessionFactoryRef = "airshopSqlSessionFactory")
public class AirshopDataSourceConfig  {
	
	@Bean
    @ConfigurationProperties("spring.datasource.airshop")
    public DataSource airshopDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "airshopSqlSessionFactory")
    public SqlSessionFactory airshopSqlSessionFactory(@Qualifier("airshopDataSource") DataSource dataSource) throws Exception {
    	SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/airshop/**/*.xml"));
        return bean.getObject();
    }

    @Bean
    public SqlSessionTemplate airshopSqlSessionTemplate(@Qualifier("airshopSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    
}
