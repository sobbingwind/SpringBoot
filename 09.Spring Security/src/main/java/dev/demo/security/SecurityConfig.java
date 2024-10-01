package dev.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	InMemoryUserDetailsManager userDetailsManager() {

		UserDetails haolv1 = User.builder().username("haolv1").password("{noop}test123").roles("USER").build();

		UserDetails haolv2 = User.builder().username("haolv2").password("{noop}test123").roles("USER", "MANAGER").build();

		UserDetails haolv3 = User.builder().username("haolv3").password("{noop}test123").roles("USER", "MANAGER", "ADMIN").build();

		return new InMemoryUserDetailsManager(haolv1, haolv2, haolv3);
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(configurer -> 
			configurer
				.requestMatchers(HttpMethod.GET, "/api/employee").hasRole("USER")
				.requestMatchers(HttpMethod.POST, "/api/employee").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT, "/api/employee/**").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE, "/api/employee/**").hasRole("ADMIN")
		);
		http.httpBasic(Customizer.withDefaults());
		http.csrf(csrf -> csrf.disable());

		return http.build();
	}
}
