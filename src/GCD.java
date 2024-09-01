public class GCD {
    //Euclidean Algorithm
    private static long gcd(long a,long b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    /*
    The Euclidean algorithm is efficient with a time complexity of
    O(log(min(a,b))).
    This method is highly optimized for finding the GCD and works well even with large numbers.
     */
    public static void main(String[] args) {
        long a=48,b=18;
        System.out.println(gcd(a,b));
    }
}

