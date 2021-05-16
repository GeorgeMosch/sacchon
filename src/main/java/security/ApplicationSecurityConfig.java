package security;

import jwt.JwtConfig;
import jwt.JwtTokenVerifier;
import jwt.JwtUsernameAndPasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.SecretKey;

@Configuration
public class ApplicationSecurityConfig {

//    private final PasswordEncoder passwordEncoder;
////    private final ApplicationUserService applicationUserService;
//
//    private final SecretKey secretKey;
//    private final JwtConfig jwtConfig;
//
//    @Autowired
//    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder,
////                                     ApplicationUserService applicationUserService,
//                                     SecretKey secretKey,
//                                     JwtConfig jwtConfig) {
//        this.passwordEncoder = passwordEncoder;
////        this.applicationUserService = applicationUserService;
//        this.secretKey = secretKey;
//        this.jwtConfig = jwtConfig;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
////                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
////                .and()
//                .csrf().disable()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), jwtConfig, secretKey))
//                .addFilterAfter(new JwtTokenVerifier(secretKey, jwtConfig), JwtUsernameAndPasswordAuthenticationFilter.class)
//                .authorizeRequests()
//                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
////                .antMatchers("/api/**").hasRole(Student.name())
////                .antMatchers(HttpMethod.DELETE, "/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
////                .antMatchers(HttpMethod.POST, "/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
////                .antMatchers(HttpMethod.PUT, "/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
////                .antMatchers(HttpMethod.GET,"/management/api/**").hasAnyRole(ADMIN.name(), ADMINTRAINEE.name())
//                .anyRequest()
//                .authenticated();
////                .and()
////                .formLogin() // Form Auth
////                    .loginPage("/login")
////                    .permitAll()
////                    .defaultSuccessUrl("/courses", true)
////                    .passwordParameter("password")
////                    .usernameParameter("username")
////                .and()
////                .rememberMe()
////                    .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21)) // 2 weeks by Default
////                    .key("something really secure")
////                    .rememberMeParameter("remember-me")
////                .and()
////                .logout()
////                    .clearAuthentication(true)
////                    .invalidateHttpSession(true)
////                    .deleteCookies("JSESSIONID", "remember-me")
////                    .logoutSuccessUrl("/login");
////                .httpBasic();  // Basic Auth
//    }
//
////    @Override
////    @Bean
////    protected UserDetailsService userDetailsService() {
////        UserDetails annaSmithUser = User.builder()
////                    .username("annasmith")
////                    .password(passwordEncoder.encode("password"))
//////                    .roles(STUDENT.name())
////                    .authorities(STUDENT.getGrantedAuthorities())
////                    .build();
////
////        UserDetails georgeUser = User.builder()
////                .username("george")
////                .password(passwordEncoder.encode("password123"))
//////                .roles(ADMIN.name())
////                .authorities(ADMIN.getGrantedAuthorities())
////                .build();
////
////        UserDetails tomUser = User.builder()
////                .username("tom")
////                .password(passwordEncoder.encode("password123"))
//////                .roles(ADMINTRAINEE.name())
////                .authorities(ADMINTRAINEE.getGrantedAuthorities())
////                .build();
////
////        return new InMemoryUserDetailsManager(
////                annaSmithUser,
////                georgeUser,
////                tomUser
////        );
////    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(daoAuthenticationProvider());
//    }
//
//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(passwordEncoder);
//        provider.setUserDetailsService(applicationUserService);
//        return provider;
//    }


}
