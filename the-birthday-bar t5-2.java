import java.io.*;
import java.util.*;

public class Solution {

    public static int birthday(List<Integer> s, int d, int m) {
        int count = 0;
        int sum = 0;

        // First window of size m
        for (int i = 0; i < m; i++) {
            sum += s.get(i);
        }

        if (sum == d) {
            count++;
        }

        // Slide the window
        for (int i = m; i < s.size(); i++) {
            sum += s.get(i);       // Add new element
            sum -= s.get(i - m);   // Remove old element

            if (sum == d) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Number of squares
        int n = sc.nextInt();

        // Chocolate bar
        List<Integer> s = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            s.add(sc.nextInt());
        }

        // d = birth day, m = birth month
        int d = sc.nextInt();
        int m = sc.nextInt();

        // Find number of valid segments
        int result = birthday(s, d, m);

        System.out.println(result);

        sc.close();
    }
}
