import java.util.Arrays;

public class CountTriangles {

    public int doCount(int[] A) {
        Arrays.sort(A);
        int len=A.length;
        int res=0;
        for(int x=0;x<len-2;x++) {
            int z=x+2;
            for(int y=x+1;y<len;y++) {
                while(z<len && A[x]+A[y]>A[z]) {
                    if(z>y) System.out.println(String.format("%d,%d,%d",A[x],A[y],A[z]));
                    z++;
                }
                res+=z-y-1;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        CountTriangles countTriangles=new CountTriangles();
        int[] a={10,2,5,1,8,12};
        System.out.println(countTriangles.doCount(a));
    }
}
