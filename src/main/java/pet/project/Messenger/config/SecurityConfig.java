package pet.project.Messenger.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import pet.project.Messenger.model.User;
import pet.project.Messenger.repository.UserRepository;

@Configuration
public class SecurityConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
	return new BCryptPasswordEncoder(); }

	 @Bean
	 public UserDetailsService userDetailsService(UserRepository userRepo) {
	  return email -> {
	    User user = userRepo.findByEmail(email);
	    if (user != null) return user;
	    throw new UsernameNotFoundException("User ‘" + email + "’ not found");
	  };
	 }
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	http.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests.requestMatchers("/login", "/register").permitAll()
            .anyRequest().authenticated())
		.formLogin((formLogin) -> formLogin.loginPage("/login").defaultSuccessUrl("/chats").usernameParameter("email").passwordParameter("password").permitAll())
		.logout((logout) -> logout.logoutUrl("/logout").logoutSuccessUrl("/login").invalidateHttpSession(true).deleteCookies("JSESSIONID").permitAll());
	return http.build();
	}

}
