package ua.nure.your_last_name.SummaryTask4.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final Pattern loginPattern = Pattern.compile("(?ui)[a-z0-9_-]{4,16}");

    private static final Pattern passwordPattern = Pattern.compile("(?ui)[a-z0-9_]{6,18}");

    private static final Pattern emailPattern = Pattern.compile("(?ui)[a-z0-9_]{6,18}");

    private final static Pattern pName = Pattern.compile("([A-Za-zА-Яа-я]){2,25}");

    private final static Pattern pSurname = Pattern.compile("([A-Za-zА-Яа-я]){2,25}");

    public static boolean validateLogin(String login) {
        Matcher loginMatcher = loginPattern.matcher(login);
        return loginMatcher.matches();
    }

    public static boolean validatePassword(String password) {
        Matcher passwordMatcher = passwordPattern.matcher(password);
        return passwordMatcher.matches();
    }



}
