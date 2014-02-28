package ch.salvomulas.u01;

/**
 * Created by Salvatore Mulas
 */

public class IntegerLimits {

    private int value;
    private int max = Integer.MAX_VALUE;
    private int min = Integer.MIN_VALUE;

    public IntegerLimits (int value) {
        this.value = value;
    }

    public void loop () {
        for (int i = 0; i < 5; i++) {
            value *= 256;
            System.out.println(value);
        }
    }

    public int getMax () {
        return max;
    }

    public int getMin () {
        return min;
    }

}