package ua.nure.myronova.finalproject.util;

import ua.nure.myronova.finalproject.exception.Messages;
import ua.nure.myronova.finalproject.exception.UtilException;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingSHA {

    public static String encode(String s) throws UtilException {
        String hashString = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] bytes = md.digest(s.getBytes());
            BigInteger no = new BigInteger(1, bytes);
            hashString = no.toString(16);
            while (hashString.length() < 32) {
                hashString = "0" + hashString;
            }

        } catch (NoSuchAlgorithmException e) {
            throw new UtilException(Messages.ERR_CANNOT_ENCODE_PASSWORD, e);
        }
        System.out.println(s + " ---> " + hashString);
        return hashString;
    }
}
