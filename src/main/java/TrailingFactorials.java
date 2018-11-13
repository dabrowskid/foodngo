public class TrailingFactorials {


    public static int zeros(int n) {
        int trailingZeros = 0;
        int j = 1;
        while (n / powFive(j) > 0) {
            trailingZeros += n / powFive(j);
            j++;
        }
        return trailingZeros;
    }

    public static int powFive(int pow) {
        int a = 5;
        for(int i=2; i<=pow; i++) {
            a *= 5;
        }
        return a;
    }

}
