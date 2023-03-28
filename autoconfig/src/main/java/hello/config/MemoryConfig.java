package hello.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import memory.MemoryController;
import memory.MemoryFinder;

@Configuration
// 이 클래스 안의 matches 결과가 True면 아래 설정정보가 추가되고 아니면 추가되지 않는다.
// @Conditional(MemoryCondition.class)
@ConditionalOnProperty(name = "memory", havingValue = "on")
public class MemoryConfig {

	@Bean
	public MemoryController memoryController() {
		return new MemoryController(memoryFinder());
	}

	@Bean
	public MemoryFinder memoryFinder() {
		return new MemoryFinder();
	}
}
