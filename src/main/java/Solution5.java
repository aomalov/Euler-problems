import java.util.*;

class Solution5 {

    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int len = A.length;
        int K_real = K % len;
        int[] result = new int[len];
        System.arraycopy(A, 0, result, K_real, len - K_real);
        for (int cnt = 0; cnt < K_real; cnt++) {
            result[cnt] = A[len - K_real + cnt];
        }
        return result;
    }

//    private int verifyTriplet(int a,int b,int[] rest,int current_c) {
//        if(a+b<rest[0]) return 0;
//        else for (int i = current_c; i < rest.length; i++) {
//            if(a+b<rest[i]) return 0;
//            if(a+b>rest[i] && a+rest[i]>b && b+rest[i]>a) return 1;
//        }
//        return 0;
//    }
//
//    public int Trianges(int[] A) {
//        Arrays.sort(A);
//        for (int i = 0; i < A.length-2; i++) {
//
//        }
//
//    }

    public static int gcp(int a, int b) { //a>b
        if (a % b == 0) return b;
        else return gcp(b, a / b);
    }


    public int minPerimeter(int Square) {
        int n = 1, res = Integer.MAX_VALUE;
        while (n * n < Square) {
            if (Square % n == 0)
                res = Math.min(res, (n + Square / n) * 2);
            n++;
        }
        return res;
    }

    public int properlyNested(String s) {
        Stack<Character> stack = new Stack<>();

        for (int cnt = 0; cnt < s.length(); cnt++) {
            switch (s.charAt(cnt)) {
                case '(':
                    stack.push('(');
                    break;
                case ')':
                    if (stack.empty()) return 0;
                    else stack.pop();
                    break;
            }
        }
        return stack.empty() ? 1 : 0;
    }


    private static int getLastLeap(List<Integer> fibs,int[] leafs,int lastIndex,int leapCnt) {
        int pos=lastIndex-1;
        while(pos>0) {
            if(leafs[pos]==1&&fibs.contains(lastIndex-pos)) {
              if(fibs.contains(pos)) {
                  System.out.println(pos);
                  return leapCnt+1;
              }
              else {
                  System.out.println(pos);
                  return getLastLeap(fibs,leafs,pos,leapCnt+1);
              }
            }
            pos--;
        }
        return -1;
    }


    private static int getNearestLeap(List<Integer> fibs,List<Integer> fibDist,int firstIndex,int lastIndex,boolean fromEnd) {
        if(fromEnd) {
            for(int cnt=lastIndex-1;cnt>firstIndex;cnt--)
                if(fibs.contains(fibDist.get(cnt))) {
                    System.out.println(cnt);
                    return getNearestLeap(fibs,fibDist,firstIndex,cnt,!fromEnd);
                }
        }
        else {
            for(int cnt=firstIndex+1;cnt<lastIndex;cnt++)
                if(fibs.contains(fibDist.get(cnt))) {
                    System.out.println(cnt);
                    return getNearestLeap(fibs,fibDist,firstIndex,cnt,!fromEnd);
                }
        }
        return -1;
    }

    public static int getMinimalLeaps(int[] leafs) {
        int len = leafs.length;

        List<Integer> fibs = new ArrayList<>();
        List<Integer> fibDist = new ArrayList<>();
        List<Integer> fibPrefDist = new ArrayList<>();
        fibs.add(1);
        fibs.add(1);
        int cntFib = 2;
        while (fibs.get(cntFib - 2) + fibs.get(cntFib - 1) < 100000) {
            fibs.add(fibs.get(cntFib - 2) + fibs.get(cntFib - 1));
            cntFib++;
        }

        for (int i = 0; i < leafs.length; i++) {
            if(leafs[i]==1) fibDist.add(i+1);
        }





        return getLastLeap(fibs,leafs,leafs.length,0);
    }


    public int solution_p7v(int[] A) {
        int len = A.length, permSum = 0, realSum = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        for (int cnt = 0; cnt < len; cnt++) {
            permSum += cnt + 1;
            realSum += A[cnt];
            if (map.containsKey(A[cnt]))
                return 0;
            else
                map.put(A[cnt], true);
        }
        return (permSum == realSum) ? 1 : 0;
    }

    public static void main(String[] args) {
//        Solution5 s=new Solution5();
//
        int[] arr = {0,0,0,1,1,0,1,0,0,0,0};
//        System.out.println(Arrays.toString(s.solution( arr,2)));

//        System.out.println(gcp(24,18));
        getMinimalLeaps(arr);
    }
}