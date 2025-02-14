package com.mxdlzg.rental.controller.greeting;

import com.mxdlzg.rental.dao.service.UserService;
import com.mxdlzg.rental.domain.model.enums.ResponseEnums;
import com.mxdlzg.rental.domain.model.exception.RentalRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired UserService userService;
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        if (name.equals("World")){
            throw new RentalRuntimeException(ResponseEnums.BAD_REQUEST);
        }
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}