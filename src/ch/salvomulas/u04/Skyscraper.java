package ch.salvomulas.u04;

/**
 * Created by Salvatore Mulas
 */

public class Skyscraper {

    private int size;
    private int[][] matrix;
    private int[][] visibility;

    /**
     * Class constructor which immediately defines the size of the matrix
     * @param size  The width and height of the skyscrapers matrix
     */
    public Skyscraper (int size) {
        this.size = size;
    }

    /**
     * Generates the matrix and fills it with linear numbers
     */
    public void genLinear () {

        int fill;

        // Instantiate the matrix with the given size
        matrix = new int [this.size][this.size];

        // Fill the matrix with linear numbers
        for (int i = 0; i < this.size; i++) {

            // Sets the first number of the actual row
            fill = i+1;

            for (int j = 0; j < this.size; j++) {

                // Resets the filler to 1 if it exceeds the matrix length
                if (fill > this.size) {
                    fill = 1;
                }
                matrix[i][j] = fill;

                // Increments the filler by one for the next operation
                ++fill;

            }
        }

    }

    /**
     * Generates the matrix from an external source instead of generating it
     * with linear numbers
     * @param source    The external 2d array to be inserted into the class
     */
    public void genFromSource (int[][] source) {
        if (validateSource(source)) {
            this.matrix = source;
        }
    }

    /**
     * Checks if the matrix which can be passed to the class manually consists of the
     * same width and height as defined in the "size" attribute
     * @param source    The multi-dimensional array to be used as the skyscrapers matrix
     * @return          True if the width and height of the array match
     * @throws          java.lang.IndexOutOfBoundsException if the 2d array is not of the same height and width
     */
    private boolean validateSource (int[][] source) throws IndexOutOfBoundsException {
        if (source.length == this.size) {
            for (int i = 0; i < this.size; i++) {
                if (source[i].length != this.size) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Generates the visibility matrix for the skyscrapers
     * First row:   view from the top
     * Second row:  view from the left
     * Third row:   view from the right
     * Fourth row:  view from the bottom
     */
    public void genVisibility () {

        // Search index to find the highest skyscraper
        int pointer = 0;

        // Instantiate the matrix for the visibility
        visibility = new int [4][this.size];

        // Initialize every element of visibility with zero
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < this.size; j++) {
                visibility[i][j] = 0;
            }
        }

        // Calculate visibility
        for (int i = 0; i < this.size; i++) {

            // from the left
            for (int j = 0; j < this.size; j++) {
                if (j > 0) {
                    if (matrix[i][j] > matrix[i][j-1]) {
                        visibility[1][i]++;
                    }
                }
            }

            // from the right
            for (int j = (this.size-1); j >= 0; --j) {
                if (j < (this.size-1)) {
                    if (matrix[i][j] > matrix[i][j+1]) {
                        visibility[2][i]++;
                    }
                }
            }

        }

        for (int i = 0; i < this.size; i++) {

            // from the top
            for (int j = 0; j < this.size; j++) {
                if (j > 0) {
                    if (matrix[0][j] > matrix[j-1][i]) {
                        visibility[1][i]++;
                    }
                }
            }

            // from the bottom
            for (int j = (this.size-1); j >= 0; --j) {
                if (j < (this.size-1)) {
                    if (matrix[j][i] > matrix[j+1][i]) {
                        visibility[3][j]++;
                    }
                }
            }
        }
    }

    /**
     * Prints the skyscraper matrix on the console
     * This method is not recommended if the matrix size is higher than 9
     */
    public void printMatrix () {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    /**
     * Prints the visibility matrix on the console
     * This method is not recommended if the matrix size is higher than 9
     */
    public void printVisibility () {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < this.size; j++) {
                System.out.print(visibility[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

}