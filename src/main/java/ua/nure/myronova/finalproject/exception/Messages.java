package ua.nure.myronova.finalproject.exception;

public class Messages {
    public static final String ERR_CANNOT_OBTAIN_DATA_SOURCE = "Cannot obtain the data source";
    public static final String ERR_CANNOT_OBTAIN_CONNECTION = "Cannot obtain a connection from the pool";

    public static final String ERR_CANNOT_OBTAIN_UPCOMING_TOURS = "Cannot obtain upcoming tours";

    public static final String ERR_CANNOT_OBTAIN_USERS = "Cannot obtain all users";
    public static final String ERR_CANNOT_OBTAIN_USER = "Cannot obtain user";
    public static final String ERR_CANNOT_PREPARE_STATEMENT = "Cannot prepare statement with user data";
    public static final String ERR_CANNOT_DELETE_USER = "Cannot delete user";

    public static final String ERR_CANNOT_CHECK_LOGIN = "Cannot check if the user name and password are correct";

    public static final String ERR_CANNOT_FIND_USER_BY_LOGIN = "Cannot find user by login";
    public static final String ERR_CANNOT_FIND_USER_BY_ID = "Cannot find user by id";
    public static final String ERR_CANNOT_CREATE_USER = "Cannot create user";
    public static final String ERR_CANNOT_LOGIN = "Cannot authorize the user";

    public static final String ERR_CANNOT_CLOSE_CONNECTION = "Cannot close a connection";
    public static final String ERR_CANNOT_CLOSE_STATEMENT = "Cannot close a statement";
    public static final String ERR_CANNOT_CLOSE_RESULTSET = "Cannot close a result set";

    public static final String ERR_ENTER_CORRECT_LOGINPASS = "A user with this username and password" +
                                                            " is not registered or is blocked";

    public static final String ERR_CANNOT_ENCODE_PASSWORD = "Cannot encode user password";
}
