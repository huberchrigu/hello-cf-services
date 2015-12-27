package ch.huber.cloud.demo.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * @author christoph.huber
 */
@RestController
public class HelloController {
    private static final String[] NAMES = {"Hero", "Clown", "X", "President", "Wizard"};

    @Value("${hello.title:local}")
    private String title;
    private String name;

    @PostConstruct
    public void setName() {
        int index = (int) (Math.random() * NAMES.length);
        this.name = NAMES[index];
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello " + title + " " + name;
    }
}
