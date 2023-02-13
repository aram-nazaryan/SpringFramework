package sourcemind.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import sourcemind.boot.user.User;
import sourcemind.boot.user.UserRepository;

@SpringBootApplication
public class SpringBootApp5 {

    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(SpringBootApp5.class, args);

        UserRepository repository = context.getBean(UserRepository.class);

        User user = new User("Aram");
        repository.save(user);

    }
}

