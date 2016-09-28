package example.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping("/hello")
    String helloWorld() {
        return helloService.greeting();
    }

    @RequestMapping("/hello/{name}")
    String getProduct(@PathVariable String name) {
        return helloService.greeting(name);
    }

}
