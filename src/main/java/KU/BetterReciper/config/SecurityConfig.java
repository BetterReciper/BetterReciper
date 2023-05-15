package KU.BetterReciper.config;

import KU.BetterReciper.service.UserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Value("${auth0.audience}")
    private String audience;


    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    private String issuer;


    @Autowired
    private UserDetailsServiceImp userDetailsService;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable()

                .authorizeRequests()

                .mvcMatchers(HttpMethod.GET, "/api/recipe")
                .hasAuthority("SCOPE_read:recipe")
                .mvcMatchers(HttpMethod.POST, "/api/recipe")
                .hasAuthority("SCOPE_create:recipe")
                .mvcMatchers(HttpMethod.DELETE, "api/recipe/{id}")
                .hasAuthority("SCOPE_delete:recipe")

                .antMatchers("/home", "/api/**", "/signup", "/css/**", "/js/**").permitAll()
                .anyRequest().authenticated()

                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .oauth2ResourceServer()
                .jwt()
                .decoder(jwtDecoder());

        return http.build();
    }

    private JwtDecoder jwtDecoder() {
        OAuth2TokenValidator<Jwt> withAudience =
                new AudienceValidator(audience);

        OAuth2TokenValidator<Jwt> withIssuer =
                JwtValidators.createDefaultWithIssuer(issuer);

        OAuth2TokenValidator<Jwt> validator =
                new DelegatingOAuth2TokenValidator<>(withAudience, withIssuer);

        NimbusJwtDecoder jwtDecoder = (NimbusJwtDecoder)
                JwtDecoders.fromOidcIssuerLocation(issuer);

        jwtDecoder.setJwtValidator(validator);
        return jwtDecoder;
    }




    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(12);
    }


    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/h2-console/**");
    }

}
