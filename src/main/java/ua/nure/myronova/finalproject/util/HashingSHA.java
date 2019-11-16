package ua.nure.myronova.finalproject.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingSHA {

    public static String encode(String s) {
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
            e.printStackTrace();
        }
        System.out.println(s + " ---> " + hashString);
        return hashString;
    }
}
