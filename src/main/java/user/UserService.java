package user;

import java.util.Arrays;

public class UserService {

    private final UserDao userDao;

    {
        userDao = new UserDao();
    }

    public User[] viewAllUsers() {
        User[] users = userDao.getUsers();

        Arrays.stream(users)
                .forEach(System.out::println);

        return users;
    }
}
