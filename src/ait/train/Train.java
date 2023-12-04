package ait.train;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;
/*
1. Подсчитайте общую стоимость проезда.
2. Подсчитайте средний тариф для 1,2,3 классов путешествия.
3.Подсчитайте общее количество выживших и погибших пассажиров.
4. Подсчитайте общее количество выживших и погибших мужчин, женщин и детей (до 18 лет).
 */

public class Train {


    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("train.csv"))) {
            String str = br.readLine();
            String[] cells = str.split(",");
            printCells(cells);
            str = br.readLine();
            double totalprice = 0;
            int counter = 0;
            int totalquantityofsurvived = 0;

            while ((str != null)) {
                cells = str.split(",");
                totalprice += Double.parseDouble(cells[10]);
                int pclas = Integer.parseInt(cells[2]);
                int survived = Integer.parseInt(cells[1]);
                Stream stream = Stream.of(survived).filter(n -> n == 1);
                totalquantityofsurvived +=stream.count();

                counter ++;
//                printCells(cells);
                str = br.readLine();

            }
            System.out.println("Total totalprice :" + totalprice);
            System.out.println("Total counter :" + counter);
            System.out.println("Total averageprice :" + totalprice/counter);
            System.out.println("Total total quantity of survived  :" + totalquantityofsurvived);
            System.out.println("Total total quantity of not survived  :" + (counter - totalquantityofsurvived));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printCells(String[] cells) {
        for (String s : cells) {
            System.out.print(s + "\t");
        }
        System.out.println();
    }
}
