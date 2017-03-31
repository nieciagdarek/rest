package rest;

import java.util.concurrent.atomic.AtomicLong;

import javax.xml.transform.stream.StreamSource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(path="/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                           String.format(template, name));
    	//return "hello  " + name;
    }
    @RequestMapping(path="/greeting/{name}", method={RequestMethod.GET})
    public Greeting greeting1(@PathVariable(value="name") String name) {
       return new Greeting(counter.incrementAndGet(),
                          String.format(template, name));
    	//return "hello  " + name;
    }
  
    
}
