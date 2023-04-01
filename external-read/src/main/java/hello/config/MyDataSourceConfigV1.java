package hello.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import hello.datasource.MyDataSource;
import hello.datasource.MyDataSourcePropertiesV1;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableConfigurationProperties(MyDataSourcePropertiesV1.class)
public class MyDataSourceConfigV1 {

	private final MyDataSourcePropertiesV1 properties;

	public MyDataSourceConfigV1(MyDataSourcePropertiesV1 properties) {
		this.properties = properties;
	}

	@Bean
	public MyDataSource dataSource() {
		return new MyDataSource(
				properties.getUrl(),
				properties.getPassword(),
				properties.getPassword(),
				properties.getEtc().getMaxConnection(),
				properties.getEtc().getTimeout(),
				properties.getEtc().getOptions());

	}
}
