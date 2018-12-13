package parkingLot.Backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
@EnableAutoConfiguration
public class WebApplication {
	@Bean
	@SuppressWarnings("static-method")
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean $ = new FilterRegistrationBean();
		$.setFilter(new JwtFilter());
		$.addUrlPatterns("/api/*");
		return $;
	}

	public static void main(final String[] args) throws Exception {
		SpringApplication.run(WebApplication.class, args);
	}
}
