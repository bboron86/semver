package hello;

/**
 * @author Bartosz Boron, MaibornWolff GmbH
 */
public class Greeting {

    public static final String TEMPLATE_V1 = "Hello, %s!";
    public static final String TEMPLATE_V2 = "Hello, %s, age %d!";

    private String message;

    public Greeting() { }

    public Greeting(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
