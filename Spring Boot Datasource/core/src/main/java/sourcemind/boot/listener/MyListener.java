package sourcemind.boot.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import sourcemind.boot.user.UserRepository;

@Component
public class MyListener implements ApplicationListener<ContextRefreshedEvent> {

    private final TableCreator creator;

    public MyListener(TableCreator creator){
        this.creator = creator;
    }
    @Override
    public void onApplicationEvent(@NonNull ContextRefreshedEvent event) {
        creator.createTable();
    }
}
