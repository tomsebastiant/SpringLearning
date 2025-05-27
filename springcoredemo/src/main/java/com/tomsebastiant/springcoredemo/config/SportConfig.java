package com.tomsebastiant.springcoredemo.config;

import com.tomsebastiant.springcoredemo.common.Coach;
import com.tomsebastiant.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// This is the config class that creates our third party class SwimCoach and injects into the DemoController
// Default name of Bean will be swimCoach
// If you need custom bean name, annotate like @Bean("aquatic"), the use aquatic in the qualifier

@Configuration
public class SportConfig {

    @Bean
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
