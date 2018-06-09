import java.util.Arrays;

public class FindPathCount {

    private static int getPathCount(int X,int Y) {
        if(X==0||Y==0) return 1;
        return getPathCount(X-1,Y)+getPathCount(X,Y-1);
    }


    private static int getPathDynamic(int X,int Y) {
        int[][] pathHistory=new int[Y+1][];
        for(int cnt=0;cnt<Y+1;cnt++) {
            pathHistory[cnt] = new int[X+1];
            pathHistory[cnt][0]=1;
        }
        Arrays.fill(pathHistory[0],1);
        for(int y=1;y<Y+1;y++)
            for(int x=1;x<X+1;x++) {
                pathHistory[y][x]=pathHistory[y-1][x]+pathHistory[y][x-1];
            }
        return pathHistory[Y][X];
    }

    private static int getPathDynamicMemOptimized(int X, int Y) {
        int[] pathHistory=new int[X+1];
        int[] prevHistory=new int[X+1];
        Arrays.fill(prevHistory,1);
        pathHistory[0]=1;

        for(int y=1;y<Y+1;y++) {
            for (int x = 1; x < X + 1; x++) {
                pathHistory[x] = prevHistory[x] + pathHistory[x - 1];
            }
            prevHistory=Arrays.copyOf(pathHistory,pathHistory.length);
        }
        return pathHistory[X];
    }

    public static void main(String[] args) {
        System.out.println(getPathDynamic(3,8));
        System.out.println(getPathCount(3,8));
        System.out.println(getPathDynamicMemOptimized(3,8));
    }

}
