package ch.salvomulas.u04;

/**
 * Created by Salvatore Mulas
 */

public class Sorting {

    private double [] toSort;
    private double cache;

    /**
     * Prints the double array
     */
    public void printDouble () {
        for (int i = 0; i < this.toSort.length; i++) {
            System.out.println(toSort[i]);
        }
    }

    /**
     * Implementation of Insertion Sort within the double array
     */
    public void insSort () {

        for (int i = 1; i < this.toSort.length; i++) {

            int j = i;
            double cache = this.toSort[j];
            while (j > 0 && cache < this.toSort[j-1]) {
                this.toSort[j] = this.toSort[j-1];
                --j;
            }
            this.toSort[j] = cache;

        }
    }

    /**
     * Implementation of binary search within the double array
     * @param lookup
     * @return
     */
    public int binSearch (double lookup) {

        int firstValue = 0;
        int middleValue;
        int lastValue = (this.toSort.length)-1;

        while (lastValue >= firstValue) {

            middleValue = (firstValue + lastValue) >>> 1;
            if (this.toSort[middleValue] < lookup) {
                firstValue = middleValue+1;
            } else if (this.toSort[middleValue] > lookup) {
                lastValue = middleValue-1;
            } else {
                return middleValue;
            }
        }

        // Returns negative value in case of failure
        return -1;
    }

    /**
     * Setter for the double array
     * @param source    Source for the double array
     */
    public void setDouble (double [] source) {
        this.toSort = source;
    }

}
