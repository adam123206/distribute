package hello;

import hello.log.LogDemo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    
    @RequestMapping("/")
    public String index() {
    	LogDemo.log("test in action", this.getClass());
        return "Greetings from Spring Boot by huyaohzong";
    }
    
}
