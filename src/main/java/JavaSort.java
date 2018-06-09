import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JavaSort {

    private List<Integer> qsort(List<Integer> unsorted) {
        if(unsorted.size()==0)
            return Collections.EMPTY_LIST;
        else if(unsorted.size()==1)
            return Arrays.asList(unsorted.get(0));
        else {
            Integer pivot=unsorted.get(0);
            List<Integer> left=new ArrayList<>();
            List<Integer> right=new ArrayList<>();
            for (int i = 1; i < unsorted.size(); i++) {
              if(unsorted.get(i)<pivot) left.add(unsorted.get(i));
              else right.add(unsorted.get(i));
            }
            List<Integer> res=new ArrayList<>();
            res.addAll(qsort(left));
            res.add(pivot);
            res.addAll(qsort(right));
            return res;
        }
    }

    public static void main(String[] args) {
        JavaSort sorter=new JavaSort();
        List<Integer> lst = Arrays.asList(1,2,6,8,5,0,3,9,8,22);

        System.out.println(sorter.qsort(lst));
    }
}
