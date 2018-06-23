package xyz.kemix.java.test.basic;

/**
 * 
 * @author Kemix Koo
 *
 */
public class DelegateUtil {
    public static String getUser() {
        // Because can't mock java.lang.XXX, so use proxy
        return System.getProperty("user.name");
    }
}
