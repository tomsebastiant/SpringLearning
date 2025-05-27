package com.tomsebastiant.springcoredemo.rest;

import com.tomsebastiant.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

//  define a private field for the dependency
//  We can also autowiring on the field to use field injection
//  but this is not recommended now due to difficulty to unit test
    private Coach myCoach;

//  Constructor injection. If we annotate with Autowired on the constructor spring
//  will use it for injection

//  Qualifier to be used if we have multiple implementations for a interface and we need
//  to define which one to use here only.
//  Qualifier can also be used with setter injection
//  Qualifier has higher priority than primary
    @Autowired
    public DemoController(@Qualifier("swimCoach") Coach myCoach) {
        System.out.println("In constructor: "+ getClass().getSimpleName());
        this.myCoach = myCoach;
    }

//    @Autowired
//    public DemoController(Coach myCoach) {
//        this.myCoach = myCoach;
//    }

//  Setter injection. If we annotate with Autowired on the constructor spring
//  will use it for injection
//    @Autowired
//    public void setCoach(Coach theCoach){
//        myCoach=theCoach;
//    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
