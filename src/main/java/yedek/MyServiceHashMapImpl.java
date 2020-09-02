package yedek;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("hashmap")
public class MyServiceHashMapImpl implements MyService {
    @Override
    public String sayHello() {
        return "HashMap hello";
    }
}
