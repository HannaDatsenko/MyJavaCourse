package ua.levelup;

import java.util.Arrays;

public class Homework8 {


    public static void main(String[] args) {
        int [] arraySort = new int[]{96, 2, 8, 20, 52, 35, 23, 63, 41, 12, 56};

        Sorter bubble = new Bubble();
        System.out.println("Bubble sorting " + Arrays.toString(bubble.sort(arraySort)));
        Sorter selection = new Selection();
        System.out.println("Selection sorting " + Arrays.toString(selection.sort(arraySort)));
    }

}
