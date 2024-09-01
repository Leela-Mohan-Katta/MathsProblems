import java.util.Arrays;

public class HighestOccurringDigitInPrimes {
    //https://www.geeksforgeeks.org/problems/find-the-highest-occurring-digit-in-prime-numbers-in-a-range3634/1
    // Helper function to generate primes using Sieve of Eratosthenes
    private static boolean[] sieveOfEratosthenes(int max) {
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    // Function to find the highest occurring digit in primes between L and R
    public static int maxDigit(int L, int R) {
        // Get primes up to R
        boolean[] isPrime = sieveOfEratosthenes(R);

        // Array to store the count of each digit (0 to 9)
        int[] digitCount = new int[10];
        boolean primeExists = false;

        // Traverse primes between L and R
        for (int i = Math.max(L, 2); i <= R; i++) {
            if (isPrime[i]) {
                primeExists = true;
                // Convert the number to string and count digits
                char[] digits = String.valueOf(i).toCharArray();
                for (char digit : digits) {
                    digitCount[digit - '0']++;
                }
            }
        }

        // If no prime numbers were found, return -1
        if (!primeExists) {
            return -1;
        }

        // Find the digit with the highest frequency
        int maxFreqDigit = -1;
        int maxFreq = 0;

        for (int i = 0; i < 10; i++) {
            if (digitCount[i] > maxFreq || (digitCount[i] == maxFreq && i > maxFreqDigit)) {
                maxFreq = digitCount[i];
                maxFreqDigit = i;
            }
        }

        return maxFreqDigit;
    }

    public static void main(String[] args) {
        System.out.println(maxDigit(2, 10)); // Output: 7
        System.out.println(maxDigit(2, 20)); // Output: 1
        System.out.println(maxDigit(21, 40)); //Output: 3
    }
}
