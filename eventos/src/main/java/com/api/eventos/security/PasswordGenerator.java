package com.api.eventos.security;


import java.util.ArrayList;
import java.util.List;

public class PasswordGenerator {

    public static  String NUMEROS = "0123456789";
    public static String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";

    public static String generatedAlphabeticKey(int len) {

        List<String> keys = new ArrayList<>();


        String key = MAYUSCULAS + MINUSCULAS;
        String pswd = "";

        for (int i = 0; i < len; i++) {
            pswd += (key.charAt((int)(Math.random() * key.length())));
        }

        if (keys.indexOf(pswd) < 0) {
            keys.add(pswd);
            return pswd;
        }else {
            generatedAlphabeticKey(len);
        }

        return null;

    }

    public static String generatedAlphanumericKey(int len) {

        String key = MAYUSCULAS + MINUSCULAS + NUMEROS;
        String pswd = "";

        for (int i = 0; i < len; i++) {
            pswd += (key.charAt((int)(Math.random() * key.length())));
        }

        return pswd;
    }

}
