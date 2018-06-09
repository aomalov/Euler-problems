import java.util.Arrays;

public class MinMaxDivision {

    /**
     *
     * @param arr
     * @param maxSum
     * @return   How many splits with maxSum can we sequentially get out of the array arr
     */
    private int checkSumCoverage(int[] arr,int maxSum) {
        int res=1,runningSum=0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>maxSum) return Integer.MAX_VALUE;
            runningSum+=arr[i];
            if(runningSum>maxSum) {
                runningSum=arr[i];
                res++;
            }
        }
        return res;
    }


    private int findMMD(int[] arr,int parts,int maxElem) {
      int max= Arrays.stream(arr).sum();
      int min=0;
      int res,result=0;
      while(min<=max) {
          res=(max+min)/2;
          if(checkSumCoverage(arr,res)<=parts) {
              max=res-1;
              result=res;
          }
          else
              min=res+1;
      }
      return result;
    }

    public static void main(String[] args) {
        MinMaxDivision minMaxDivision = new MinMaxDivision();
        int[] arr={4,3};

        System.out.println(minMaxDivision.findMMD(arr,3,5));
    }
}
