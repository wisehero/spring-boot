package hello.embed;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import hello.spring.HelloConfig;

/**
 * 내장 톰캣에 스프링 연동하기
 */
public class EmbedTomcatSpringMain {

	public static void main(String[] args) {
		System.out.println("EmbedTomcatSpringMain.main");

		// 톰캣 설정
		Tomcat tomcat = new Tomcat();
		Connector connector = new Connector();
		connector.setPort(8080);
		tomcat.setConnector(connector);

		// 스프링 컨테이너 생성
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(HelloConfig.class);

		// 스프링 MVC 디스패처 서블릿 생성, 스프링 컨테이너 연결
		DispatcherServlet dispatcher = new DispatcherServlet(appContext);

		// 디스패처 서블릿 등록
		Context context = tomcat.addContext("", "/");
		tomcat.addServlet("", "dispatcher", dispatcher);
		context.addServletMappingDecoded("/", "dispatcher");

		/**
		 * 메인 메서드 실행시
		 *  1. 내장 톰캣 생성 후 8080 포트에 연결
		 *  2. 스프링 컨테이너를 만들고 필요한 빈 등록
		 *  3. 스프링 MVC 디스패처 서블릿을 만들고 앞서 만든 스프링 컨테이너에 연결
		 *  4. 디스패처 서블릿을 내장 톰캣에 등록한다.
		 *  5. 내장 톰캣 실행
		 */
	}
}
