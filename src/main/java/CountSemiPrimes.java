import java.util.Arrays;

public class CountSemiPrimes {

    static int[] factorize(int a,int b) {
        int[] res=new int[b];
        int i=2;
        while(i*i<=b) {
            if(res[i-1]==0) {
                int k=i*i;
                while(k<=b) {
                    res[k-1]=i;
                    k+=i;
                }
            }
            i++;
        }
        return res;
    }

    static int countSemiPrime(int A,int B) {
        int res=0;
        int[] factorized=factorize(A,B);
        for(int N=A;N<=B;N++)
          if(factorized[N-1]!=0 && factorized[N/factorized[N-1]-1]==0) res++;
        return res;
    }


    public static void main(String[] args) {
        System.out.println(countSemiPrime(16,20));
    }



}
