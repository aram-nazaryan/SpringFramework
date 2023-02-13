package com.sourcemind.users;


import java.util.ArrayList;
import java.util.List;


public class ImMemoryUsers {

    //private final static Logger log = LoggerFactory.getLogger(ImMemoryUsers.class);
    private static Integer number = 1;

    private final String usernamePrefix;
    private final static String passwordPostfix = "@M0402";

    private final List<MyUser> users;

    public ImMemoryUsers(DataSourceConfigurationProperties properties) {
        this.usernamePrefix = properties.getUsername();
        users = new ArrayList<>();
    }

    public void addUsers() {
        MyUser user = new MyUser();
        for (int i = 0; i < 10; ++i) {
            user.setUsername(usernamePrefix + Integer.toString(number++));
            user.setPassword(user.getUsername() + passwordPostfix);
            this.users.add(user);
            System.out.printf("New added user - %s%n", user);
        }
    }

    public List<MyUser> getUsers() {
        return users;
    }
}
