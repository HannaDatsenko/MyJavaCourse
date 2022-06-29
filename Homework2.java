package ua.levelup;

import java.util.Arrays;

public class Homework2 {
    public static void main(String[] args) {
        int[] FirstArray;
        FirstArray = new int[100];
        for(int i=0; i<100; i++) {
            FirstArray[i] = i;
        }
        System.out.println(Arrays.toString(FirstArray));

        int[] SecondArray = new int[100];
        for(int i=SecondArray.length; i>0; i--) {
        SecondArray[SecondArray.length - i] = i;
        }
        System.out.println(Arrays.toString(SecondArray));

        int[][] ThirdArray = new int[5][];
        int step = 1;
        for(int i = 0; i<ThirdArray.length; i++){
            ThirdArray[i] = new int[i+1];
            for(int j=0; j<ThirdArray[i].length; j++) {
                ThirdArray[i][j] = step++;
            }
        }
        System.out.println(Arrays.deepToString(ThirdArray));
    }
}
