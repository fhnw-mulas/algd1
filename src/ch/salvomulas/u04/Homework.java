package ch.salvomulas.u04;

/**
 * Created by Salvatore Mulas
 */

public class Homework {

    public static void main (String [] args) {

        /**
         * Aufgabe 1 a und b
         * Ein Array mit inkrementierenden Zeilen wird generiert und getestet
         */
        Skyscraper random = new Skyscraper(4);
        random.genLinear();
        random.printMatrix();
        random.genVisibility();
        System.out.println("");
        random.printVisibility();

        System.out.println("**********");

        /**
         * Aufgabe 1 c
         * Das Array auf dem Aufgabenblatt wird an die Klasse übergeben und getestet
         */
        int [][] i = new int [4][4];
        i[0][0] = 4;
        i[0][1] = 2;
        i[0][2] = 1;
        i[0][3] = 3;
        i[1][0] = 2;
        i[1][1] = 3;
        i[1][2] = 4;
        i[1][3] = 1;
        i[2][0] = 3;
        i[2][1] = 1;
        i[2][2] = 2;
        i[2][3] = 4;
        i[3][0] = 1;
        i[3][1] = 4;
        i[3][2] = 3;
        i[3][3] = 2;

        Skyscraper fixed = new Skyscraper(4);
        fixed.genFromSource(i);
        fixed.printMatrix();
        fixed.genVisibility();
        System.out.println("");
        fixed.printVisibility();

        /**
         * Das Herauslesen der Sichtbaren Wolkenkratzer funktioniert nicht! Ich versuche mittels einer for-Schleife in die entsprechende
         * Richtung zu loopen und jeweils meinen Sichtbarkeits-Counter um eins zu erhöhen, falls das darauf folgende Gebäude grösser ist
         * als das vorherige. Allerdings scheint irgendwas nicht in Ordnung zu sein, denn das Programm spuckt seltsame Zahlen aus.
         * Alles andere funktioniert allerdings fehlerfrei.
         */

        /**
         * Aufgabe 2c
         * Testen des Insertion Sorts und Binary Search
         */

        Sorting s = new Sorting();
        double[] source = {3,8,2,14,4,5,12};
        s.setDouble(source);
        System.out.println("Nicht sortiert");
        s.printDouble();
        System.out.println("Sortiert");
        s.insSort();
        s.printDouble();

        System.out.println("Suche nach der Zahl 14:");
        System.out.println(s.binSearch(14));

    }

}
