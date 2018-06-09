public class AbsDistinctCount {


    public int sign(int a) {
        return Integer.compare(a, 0);
    }

    public int doCount(int[] A) {
        int res=0;
        int startPos=0;
        int cnt=0;
        while(cnt<A.length+1&&A[cnt]!=0&&(sign(A[cnt])==sign(A[cnt+1]))) {
            cnt++;
        }

        return res;
    }

    public static void main(String[] args) {
        AbsDistinctCount absDistinctCount=new AbsDistinctCount();

        int[] a={-5,-3,-1,0,3,6};
        System.out.println(absDistinctCount.doCount(a));
    }
}
