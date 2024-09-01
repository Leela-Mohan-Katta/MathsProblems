import java.util.Scanner;

public class Fountain {
    /*For example, say there are 4 fountains with firing intervals of 2, 3, 1, and 1 respectively,
    then if they fire all together at t=0, they will fire together again at t=6.*/
    //https://www.hackerearth.com/problem/algorithm/magnificent-fountains/
    /*
    4
        2 4 6 8
        o/p:24
     */
    /*
    Logic:
    when t=0->0/2=0,0/4=0.0/6=0,0/8=0;
    likewise by which number all these 2,4,6,8 will give remainder zero
    LCM(2,4,6,8)
     */
    private static final int MOD = 1000000007;

    // Function to calculate GCD of two numbers
    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    /*
    GCD Function: The greatest common divisor is computed using the Euclidean algorithm.
    LCM Function: We calculate the LCM using the formula
                    LCM(𝑎,𝑏)=𝑎×𝑏/GCD(𝑎,𝑏), and we use modulo to avoid overflow.
    Iterative LCM Calculation: Start with the LCM of the first interval,
     then iteratively calculate the LCM with the next interval.
     */

    // Function to calculate LCM of two numbers under modulo
    private static long lcm(long a, long b) {
        return (a * (b / gcd(a, b))) % MOD;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases

        while (T-- > 0) {
            int n = sc.nextInt(); // Number of fountains
            long[] intervals = new long[n];

            for (int i = 0; i < n; i++) {
                intervals[i] = sc.nextInt();
            }

            long result = intervals[0];
            for (int i = 1; i < intervals.length; i++) {
                result = lcm(result, intervals[i]);
            }

            System.out.println(result);
        }

        sc.close();
    }
}
