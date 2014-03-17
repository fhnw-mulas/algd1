package ch.salvomulas.u02;

/**
 * Created by Salvatore Mulas
 */

public class Converter {

    // Both variables are only used for utf32to16 method
    private char i1 = 0, i2 = 0;
    private int length = 1;

    /**
     * Aufgabe 2:   Convert UTF16 to Latin1
     * @param s     Valid UTF16 code sequence
     * @return      Byte-Array with all the matching latin1 characters
     */
    public static byte[] utfToLatin1 (String s) {
        byte[] latin1 = new byte[s.length()];
        int loop = -1;
        for (int i = 0; i < latin1.length; ++i) {
            char c = s.charAt(i);
            // Validity range of char: 0 - 256 == 0xDC00 - 0xDFFF)
            if ((c < 0xdc00 || c > 0xdfff) && c >= 256) {
                latin1[++loop] = (byte) '?';
            }
            else if (c < 256) {
                latin1[++loop] = (byte) c;
            }
        }
        // Used for completing the array with dummy values (0)
        for (int i = loop; i < latin1.length; ++i) {
            latin1[i] = (byte) 0;
        }
        return latin1;
    }

    /**
     * Aufgabe 3b:      Convert UTF32 to UTF16
     * @param c         The UTF32 code sequence which will be converted
     * @param array     UTF16 character array where the characters will be stored
     * @param pos       Index used to store the characters within array
     * @return          Returns an Integer indicating the number of coding units
     */
    public int utf32to16(int c, char[] array, int pos)
    {

        if (array == null || !Character.isValidCodePoint(c)) {
            throw new IllegalArgumentException();
        }

        // Checks for necessity of surrogate pairs
        if (c > 0xFFFF) {
            if ((array.length - pos) <= 2) {
                throw new ArrayIndexOutOfBoundsException();
            }
            ++length;

            // If necessary, creates the surrogate pairs
            int surrogateFirst = 0xD800;
            int surrogateSecond = 0xDC00;
            int bit = 0x10000;
            int mask = 0x3FF;

            // First pair
            c -= bit;
            int pairFirst = (c >>> 10) | surrogateFirst;

            // Second pair
            int pairSecond = (c & mask) | surrogateSecond;

            array[pos] = (char) i1;
            array[pos+1] = (char) i2;

        } else {

            // No need for surrogate pairs
            if ((array.length - pos) <= 1) {
                throw new ArrayIndexOutOfBoundsException();
            }
            array[pos] = (char) c;
        }
        return length;
    }

    public char getI1 () {
        return i1;
    }

    public char getI2 () {
        return i2;
    }

}