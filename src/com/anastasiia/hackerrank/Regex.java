
package com.anastasiia.hackerrank;

import java.util.Scanner;
import java.util.regex.*;


public class Regex {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            String pattern = in.nextLine();
            for (int i = 0; i <= testCases; i++) {
                char[] myPattern = pattern.toCharArray();
                char[] finalPattern = sort(myPattern);
                for (int j = 0; j < finalPattern.length - 1; j++) {
                    if (finalPattern[j] == finalPattern[j + 1]) {
                        boolean b = false;
                        System.out.println((b) ? "Valid" : "Invalid");
                    } else {
                        boolean b = true;
                        System.out.println((b) ? "Valid" : "Invalid");ls
                    }
                }
            }

        }
    }


    static char[] sort(char[] array) {
        int n = array.length;
        char[] output1 = new char[n];
        int[] count1 = new int[256];
        for (int i = 0; i < 256; i++) {
            count1[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            ++count1[array[i]];
        }
        for (int i = 1; i <= 255; i++) {
            count1[i] += count1[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            output1[count1[array[i]] - 1] = array[i];
            count1[array[i]]--;
        }
        for (int i = 0; i < n; ++i) {
            array[i] = output1[i];
        }
        return output1;
    }


}
