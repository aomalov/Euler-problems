import java.util.Arrays;

public class Codi {

    static int getSubstr(int A,int B) {
        String strA=Integer.toString(A);
        String strB=Integer.toString(B);

        return strB.indexOf(strA);
    }

    static int solution(int n) {
        int[] d = new int[30];
        int l = 0;
        int p;
        while (n > 0) {
            d[l] = n % 2;
            n /= 2;
            l++;
        }
        System.out.println(Arrays.toString(d));

        for (p = 1; p <= l/2; ++p) {
            int i;
            boolean ok = true;
            for (i = 0; i < l - p; ++i) {
                if (d[i] != d[i + p]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return p;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        //System.out.println(getSubstr(0,0));
        System.out.println(Integer.toBinaryString(90).length()/2);
        System.out.println(solution(90));
    }
}
