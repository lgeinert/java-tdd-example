package example.hello;

import org.springframework.stereotype.Service;

@Service
class HelloService {

    String greeting() {
        return "Hello!";
    }

    String greeting(String name) {
        return String.format("Hello %s!", name);
    }

}
