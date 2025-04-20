package pet.project.Messenger.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
	    System.out.println("Trying to authenticate with email: " + email); // 👈 добавь это
		Optional<User> user = userRepo.findByEmail(email);
	    if (!user.isEmpty()) 
	    {
	    	System.out.println(user.get().getId());
	    	return user.get();};
	    throw new UsernameNotFoundException("User ‘" + email + "’ not found");
	  };
	 }
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http, CustomAuthenticationSuccessHandler successHandler) throws Exception {
	http.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests.requestMatchers("/login","/auth/login", "/auth/register").permitAll()
            .anyRequest().authenticated())
		.formLogin((formLogin) -> formLogin.loginPage("/auth/login").loginProcessingUrl("/login").usernameParameter("email").passwordParameter("password").successHandler(successHandler))
		.logout((logout) -> logout.logoutUrl("/logout").logoutSuccessUrl("/auth/login").invalidateHttpSession(true).deleteCookies("JSESSIONID"));
	return http.build();
	}

}
