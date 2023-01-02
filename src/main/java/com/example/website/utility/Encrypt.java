package com.example.website.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypt {

    private final static Logger logger = LogManager.getLogger(Encrypt.class);

    public static String encryptSHA3(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA3-256");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            while (hashtext.length() < 64) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            logger.error("Error while encrypting string with SHA3-256", e);
            throw new RuntimeException(e);
        }
    }
}