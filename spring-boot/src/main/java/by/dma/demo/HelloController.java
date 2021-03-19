package by.dma.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
class HelloController {

    @GetMapping("/hello")
    Collection<String> list() {
        return Arrays.asList("Hello", "Hi", "Nice to meet you", "Welcome");
    }
}
