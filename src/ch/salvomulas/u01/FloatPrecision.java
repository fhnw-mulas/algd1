package ch.salvomulas.u01;

/**
 * Created by Salvatore Mulas
 */

public class FloatPrecision {

    private float value;
    private int loopCount;
    private float max = Long.MAX_VALUE;
    private float min = Long.MIN_VALUE;

    public FloatPrecision (float value) {
        this.value = value;
    }

    public void loop () {
        for (int i = 0; i < 20; ++i) {
            value *= 256;
            ++loopCount;
            System.out.println(value + " / " + loopCount);
        }
    }

    public float getMax () {
        return max;
    }

    public float getMin () {
        return min;
    }

}
