package com.tomsebastiant.springcoredemo.common;

// We can do dependency injection using java config. Its required in the cases
// the bean you want to use is from 3rd party jar. You cant edit the source
// code to add @Component. So instead we use @Configuration and @Bean in separate
// config class that will create this 3rd party bean. In this example SwimCoach is such a bean


public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("In constructor "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim Thousand Meters as warmup";
    }
}
