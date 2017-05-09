package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@SpringBootApplication
public class UiApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(UiApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(UiApplication.class, args);
	}

	@Configuration
	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {

			// @formatter:off
			http.httpBasic().and().authorizeRequests().antMatchers("/login.html").permitAll().anyRequest()
					.authenticated().and().authorizeRequests()
					.antMatchers("/home.html", "/index.html", "/modify.html", "/products.html", "/orders.html",
							"/upload.html")
					.hasAnyAuthority("ADMIN").anyRequest().authenticated().and().csrf()
					.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
			// @formatter:on
		}

		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication().withUser("user").password("password").roles("ADMIN").authorities("ADMIN");
			auth.inMemoryAuthentication().withUser("guest").password("guest").roles("USER");
		}
	}

	// @Configuration
	// @EnableConfigurationProperties(ApplicationClients.class)
	// protected static class AuthenticationManagerConfig extends
	// GlobalAuthenticationConfigurerAdapter {
	//
	// @Autowired
	// ApplicationClients application;
	//
	// @Override
	// public void init(AuthenticationManagerBuilder auth) throws Exception {
	// for (ApplicationClient client : application.getClients()) {
	// auth.inMemoryAuthentication().withUser(client.getUsername()).password(client.getPassword())
	// .roles(client.getRoles());
	// }
	// }
	//
	// }

}
