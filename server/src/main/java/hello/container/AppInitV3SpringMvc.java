package hello.container;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import hello.spring.HelloConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class AppInitV3SpringMvc implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("AppInitV3SpringMvc.onStartup");

		// 스프링 컨테이너 생성
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(HelloConfig.class);

		DispatcherServlet dispatcher = new DispatcherServlet(appContext);

		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcherV3", dispatcher);

		// 모든 요청이 디스패처 서블릿을 통하도록 설정
		servlet.addMapping("/");
	}
}
