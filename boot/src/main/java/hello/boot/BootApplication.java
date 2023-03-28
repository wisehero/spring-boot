package hello.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootApplication {

	public static void main(String[] args) {
		// 이 한줄에서 스프링 컨테이너를 생성하고 WAS를 생성하여 둘을 연결한다.
		SpringApplication.run(BootApplication.class, args);
	}

}
