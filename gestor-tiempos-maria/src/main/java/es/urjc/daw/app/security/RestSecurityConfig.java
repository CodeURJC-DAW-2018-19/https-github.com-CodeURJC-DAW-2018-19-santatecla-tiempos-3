package es.urjc.daw.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(1)
public class RestSecurityConfig extends WebSecurityConfigurerAdapter { 
	@Autowired
	public UserRepositoryAuthProvider userRepoAuthProvider;
	
    @Override
	protected void configure(HttpSecurity http) throws Exception {
		///Public pages 
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/logIn").authenticated();
		//http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/signupOk").authenticated();
		
		// URLs that need authentication to access to it
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/**").hasRole("ADMIN");

		// Login form
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("email");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/");
        http.formLogin().failureUrl("/loginerror");

        // Logout
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/");
        
        
		String [] publicUrls = new String [] {
				"/api/**"
		};
		
		// Disable CSRF protection (it is difficult to implement in REST APIs)
		http.csrf().disable();
		http.csrf().ignoringAntMatchers(publicUrls);


		// Use Http Basic Authentication
		http.httpBasic();

		// Do not redirect when logout
		http.logout().logoutSuccessHandler((rq, rs, a) -> {	});
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Database authentication provider
		auth.authenticationProvider(userRepoAuthProvider);
	}
}
