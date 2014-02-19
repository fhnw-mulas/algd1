package ch.salvomulas.u01;
import java.util.Scanner;

/**
 * Created by Salvatore Mulas
 */
public abstract class Limit <T> {

    private static int multiplier = 256;
    private static boolean request = true;
    private Scanner s = new Scanner(System.in);
    private T type;
    private T value;

    protected Limit(T value) {
        this.value = value;
    }

    public void multiplyValue () {
        while (request) {
            System.out.println("Actual value: " + value);
        }
    }

}
