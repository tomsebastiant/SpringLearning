package com.tomsebastiant.springcoredemo.common;

import org.springframework.stereotype.Component;

// Primary marks an implementation as the default one
// @Primary

// Lazy marks that a class is not to be initiated unless specifically called for
// @Lazy

// Scope of every bean is singleton by default.ie every object created in DemoController
// is assigned the same instance.
// Setting it to prototype, each object will have a different instance.
// @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)

@Component


public class TrackCoach implements Coach{

    public TrackCoach() {
        System.out.println("In constructor: "+ getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

//  Define our init method. It gets invoked after bean initialization
//    @PostConstruct
//    public void doMyStartupStuff(){
//        System.out.println("In doMyStartupStuff of"+getClass().getSimpleName());
//    }
//
//    Define our destroy method. It gets invoked after bean destruction
//    @PreDestroy
//    public void doMyDestroyStuff(){
//        System.out.println("In doMyDestroyStuff of"+getClass().getSimpleName());
//    }

}
