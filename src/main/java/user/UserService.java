package user;

public class UserService {

    private UserDao userDao;

    {
        userDao = new UserDao();
    }

    public User[] viewAllUsers() {
         return userDao.getUsers();
    }
}
