package online.edirect;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import online.edirect.rest.service.UploadServlet;

@Configuration
public class AppConfiguration {

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new UploadServlet(), "/upload/rawServlet");
    }
}
