package library.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/* А этот класс аналогичен xml файлу */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "library")
public class WebConfig implements WebMvcConfigurer {}