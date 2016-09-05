package zone.gemini.sample.jpa.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zone.gemini.sample.jpa.domain.user.User;

@RestController
public class HelloController {

    @RequestMapping(value = "/hello")
    public String hello(@RequestBody User user) {
        return "hello world " + user.toString();
    }
}
