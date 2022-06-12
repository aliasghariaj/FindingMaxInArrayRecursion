package com.aj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String lines = null;
        try {
            lines = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] strs = lines.trim().split("\\s+");

        int[] array = new int[strs.length];

        for (int i = 0; i < strs.length; i++) {
            array[i] = Integer.parseInt(strs[i]);
        }

        System.out.println("Result of method 1: " + getMax1(array, 0, array.length - 1));
        System.out.println("Result of method 2: " + getMax2(array, array.length, 0));
    }

    //A method that find maximum element in an array using recursive function (similar to Binary Search)
    private static int getMax1(int n[], int start, int end) {
        if (start == end) return n[start];
        else {
            int mid = (start + end) / 2;
            int max1 = getMax1(n, start, mid);
            int max2 = getMax1(n, mid + 1, end);

            if (max1 > max2) return max1;
            return max2;
        }
    }

    //A method that find maximum of array element by linear search using recursion
    public static int getMax2(int a[], int end, int temp) {
        if (end - 1 == 0) return temp;
        if (a[end - 1] > temp) temp = a[end - 1];
        return getMax2(a, end - 1, temp);
    }
}
