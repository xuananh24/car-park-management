package com.example.car_park_management.security;

import com.example.car_park_management.common.constant.AuthorityConstant;
import com.example.car_park_management.common.constant.Message;
import com.example.car_park_management.common.constant.PathConstant;
import com.example.car_park_management.repository.EmployeeRepository;
import com.example.car_park_management.security.filter.JwtAuthFilter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig {
    private final EmployeeRepository employeeRepository;

    public SecurityConfig(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> employeeRepository.findEmployeeByAccount(username)
                .map(EmployeeDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(Message.NOT_FOUND));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .addFilterBefore(getJwtAuthFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(PathConstant.API_HR_URL + "/**").hasAuthority(AuthorityConstant.ROLE_HUMAN_RESOURCE_MANAGEMENT)
                        .requestMatchers(PathConstant.API_CAR_PARK_ADMIN_URL + "/**").hasAuthority(AuthorityConstant.ROLE_CAR_PARK_ADMIN)
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    public JwtAuthFilter getJwtAuthFilter() {
        return new JwtAuthFilter();
    }


//    @Bean
//    public AuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(userDetailsService());
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        return authenticationProvider;
//    }
}
