package ch.salvomulas.u01;

/**
 * Created by Salvatore Mulas
 */

public class LongLimits {

    private long value;
    private long max = Long.MAX_VALUE;
    private long min = Long.MIN_VALUE;

    public LongLimits (long value) {
        this.value = value;
    }

    public long getMax () {
        return max;
    }

    public long getMin () {
        return min;
    }

}