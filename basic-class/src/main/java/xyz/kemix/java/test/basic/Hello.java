package xyz.kemix.java.test.basic;

/**
 * 
 * @author Kemix Koo
 *
 */
public class Hello {

    public Hello() {

    }

    public String sayHello(String name) {
        return "Hello " + name;
    }

    public String sayHi(String name) {
        return "Hi " + name;
    }

    public String helloUser() {
        return "Hi " + DelegateUtil.getUser();
    }

}
