package authRetail;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServer extends ResourceServerConfigurerAdapter {
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.requestMatchers().antMatchers("/service/**").and() // "/**",
			.authorizeRequests()
			.anyRequest().access(
					"#oauth2.clientHasRole('ROLE_CLIENT') and (hasRole('ROLE_USER') " +
					" or #oauth2.isClient()) and #oauth2.hasScope('read')");
	}
}