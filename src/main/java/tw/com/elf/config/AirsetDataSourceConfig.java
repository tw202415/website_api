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
@MapperScan(basePackages = {"tw.com.elf.mapper.airset", "tw.com.elf.mapper.airset.customerMapper"}, sqlSessionFactoryRef = "airsetSqlSessionFactory")
public class AirsetDataSourceConfig  {
	
	@Bean(name = "airsetDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.airset")
    public DataSource airsetDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "airsetSqlSessionFactory")
    public SqlSessionFactory airsetSqlSessionFactory(@Qualifier("airsetDataSource") DataSource dataSource) throws Exception {
    	SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/airset/**/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "airsetSqlSessionTemplate")
    public SqlSessionTemplate airsetSqlSessionTemplate(@Qualifier("airsetSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    
}
