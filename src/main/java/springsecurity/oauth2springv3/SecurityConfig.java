package springsecurity.oauth2springv3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        HttpSecurity httpSecurity = http
                .authorizeHttpRequests(authorizationRequests -> authorizationRequests
                        .anyRequest().authenticated()
                )
                .formLogin(withDefaults());
        httpSecurity.apply(new CustomSecurityConfigurer().setFlag(false));
        return httpSecurity.build();
    }
}
