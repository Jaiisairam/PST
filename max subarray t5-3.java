import java.io.*;
import java.util.*;

public class Solution {

    static int[] maxSubarray(int[] arr) {
        int currentMax = arr[0];
        int globalMax = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            globalMax = Math.max(globalMax, currentMax);
        }
        int posSum = 0;
        int maxElement = arr[0];
        boolean hasPositive = false;
        for (int x : arr) {
            if (x > 0) {
                posSum += x;
                hasPositive = true;
            }
            if (x > maxElement) {
                maxElement = x;
            }
        }
        int subseqMax = hasPositive ? posSum : maxElement;
        return new int[] { globalMax, subseqMax };
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;   
        int t = scanner.nextInt();
        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int[] result = maxSubarray(arr);
            System.out.println(result[0] + " " + result[1]);
        }
        scanner.close();
    }
}