package environment.framework.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import environment.Env;
import environment.framework.temp.Temp;

/*****************************************************
 * Author: Novikov Artem
 * Date: 07.04.2018
 * Module name: Common
 * Description: Класс, реализующий общую функциональность
 *****************************************************/
public class Common {
    // Сюда помещается функционал, который используется
    // в нескольких местах в приложении

    // MD5 hash
    public static String hash(String in) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
            digest.reset();
            digest.update(in.getBytes());
            byte[] a = digest.digest();
            int len = a.length;
            StringBuilder sb = new StringBuilder(len << 1);
            for (int i = 0; i < len; i++) {
                sb.append(Character.forDigit((a[i] & 0xf0) >> 4, 16));
                sb.append(Character.forDigit(a[i] & 0x0f, 16));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Проверка является ли строка набором чисел
    public boolean isDigits(char[] string) {
        boolean res = true;

        if(string.length == 0) {
            res = false;
        } else {
            for (int i = 0; i < string.length; i++) {
                // Проверка на число
                res = Character.isDigit(string[i]);
                if(!res) {
                    break;
                }
            }
        }
        return res;
    }

}
