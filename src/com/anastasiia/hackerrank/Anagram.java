package com.anastasiia.hackerrank;

import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");


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

    static boolean isAnagram(String a, String b) {

        String aLowerCase = a.toLowerCase();
        String bLowerCase = b.toLowerCase();
        char[] myA = aLowerCase.toCharArray();
        char[] myB = bLowerCase.toCharArray();

        if (myA.length != myB.length) {
            return false;
        }

        char[] finalA = sort(myA);
        char[] finalB = sort(myB);

        for (int i = 0; i < finalA.length; i++) {
            if (finalA[i] != finalB[i]) {
                return false;
            }
        }

        return true;
    }
}
