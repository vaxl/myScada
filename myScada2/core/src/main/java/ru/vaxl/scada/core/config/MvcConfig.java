package ru.vaxl.scada.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by U7 on 21.08.2017.
 */

@Configuration
@EnableWebMvc
@ImportResource("classpath:spring.xml")
@ComponentScan(basePackages = "ru.vaxl.scada.core.api")
public class MvcConfig {

}
