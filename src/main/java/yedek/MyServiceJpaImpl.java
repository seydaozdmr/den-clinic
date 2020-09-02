package yedek;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"jpa","default"})
public class MyServiceJpaImpl implements MyService {
    @Override
    public String sayHello() {
        return "JAP Implementation";
    }
}
