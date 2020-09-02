package yedek;

import org.springframework.stereotype.Controller;

@Controller
public class SomeController {
    private final MyService myService;

    public SomeController(MyService myService) {
        this.myService = myService;
    }

    public String sayHello(){
        return myService.sayHello();
    }


}
