package ua.nure.myronova.finalproject.util;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static final Pattern loginPattern = Pattern.compile("(?ui)[a-z0-9_-]{4,25}");

    private static final Pattern passwordPattern = Pattern.compile("(?ui)[a-z0-9_]{6,18}");

    private final static Pattern nameSurnamePattern = Pattern.compile("((?ui)[a-z]){2,30}");

    private final static Pattern telephonePattern = Pattern.compile("(\\s*)?(\\+)?([- _():=+]?\\d[- _():=+]?){10,14}(\\s*)?");

    public static boolean validateLogin(String login) {
        Matcher loginMatcher = loginPattern.matcher(login);
        return loginMatcher.matches();
    }

    public static boolean validatePassword(String password) {
        Matcher passwordMatcher = passwordPattern.matcher(password);
        return passwordMatcher.matches();
    }

    public static boolean validateEmail(String email) {
        boolean isValid = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            isValid = false;
        }
        return isValid;
    }

    public static boolean validateNameOrSurname(String name) {
        Matcher loginMatcher = nameSurnamePattern.matcher(name);
        return loginMatcher.matches();
    }

    public static boolean validateTelephone(String telephone) {
        Matcher loginMatcher = telephonePattern.matcher(telephone);
        return loginMatcher.matches();
    }
}
