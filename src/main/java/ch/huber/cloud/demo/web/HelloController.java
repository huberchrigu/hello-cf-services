package ch.huber.cloud.demo.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author christoph.huber
 */
@RestController
public class HelloController {
    private static final String[] NAMES = {"Hero", "Clown", "X", "President", "Wizard"};
    private static final String NAME_ATTRIBUTE = "hello-cloud.name";

    @Value("${hello.title:local}")
    private String title;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(HttpSession session) {
        return "Hello " + title + " " + getName(session);
    }

    private String getName(HttpSession session) {
        String name = (String) session.getAttribute(NAME_ATTRIBUTE);
        if (name == null) {
            name = generateNewName();
            session.setAttribute(NAME_ATTRIBUTE, name);
        }
        return name;
    }

    private String generateNewName() {
        int index = (int) (Math.random() * NAMES.length);
        return NAMES[index];
    }
}