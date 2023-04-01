package hello.datasource;

import java.time.Duration;
import java.util.List;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class MyDataSource {

	public List<String> options; // 연결시 사용하는 기타 옵션
	private String url;
	private String username;
	private String password;
	private int maxConnection; // 최대 연결 수
	private Duration timeout; // 응답 지연시 타임아웃

	public MyDataSource(String url, String username, String password, int maxConnection, Duration timeout,
			List<String> options) {
		this.url = url;
		this.username = username;
		this.password = password;
		this.maxConnection = maxConnection;
		this.timeout = timeout;
		this.options = options;
	}

	@PostConstruct
	public void init() {
		log.info("url={}", url);
		log.info("username={}", username);
		log.info("password={}", password);
		log.info("maxConnection={}", maxConnection);
		log.info("timeout={}", timeout);
		log.info("options={}", options);
	}
}
