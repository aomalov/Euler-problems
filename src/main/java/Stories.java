import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Stories {
    public static List<String> results=new ArrayList<>();

    public static int numberOfArrangements(int numberOfStories,String prevResult) {
//        System.out.println(prevResult);
        if(numberOfStories<=0) return 0;
        if(numberOfStories==1) {
//            System.out.printf(prevResult+"[small]");
            return 1; //one small only
        }
        else if(numberOfStories==2) {
//            System.out.println(prevResult+"[big]");
            return 2;  //one big or 2 smalls
        }
        else return numberOfArrangements(numberOfStories-1,prevResult+"[small]")
                    +numberOfArrangements(numberOfStories-2,prevResult+"[big]");

    }

    public static int numberOfArrangementsMemo(int numberOfStories) {
        List<Integer> splits=new ArrayList<>();
        int res=0;

        if(numberOfStories<3) return numberOfStories;
        //Filling the SPLITS memoization structure
        splits.add(numberOfStories-1);
        splits.add(numberOfStories-2);
        List<Integer> reducedSplit=new ArrayList<>(splits);
        res+=reducedSplit.stream().filter(x -> x<3).reduce(0, Integer::sum);
        reducedSplit=reducedSplit.stream().filter(x->x>2).collect(Collectors.toList());
        while(reducedSplit.size()>0) {
            int len=reducedSplit.size();
            for (int i = 0; i < len; i++) {
                int elem=reducedSplit.get(i);
                reducedSplit.add(elem-1);
                reducedSplit.add(elem-2);
                reducedSplit.remove(i);
            }
            //REDUCE, collect sum and repeat
            res+=reducedSplit.stream().filter(x -> x<3).reduce(0, Integer::sum);
            reducedSplit=reducedSplit.stream().filter(x->x>2).collect(Collectors.toList());
        }

        return res;
    }

    public static void main(String[] args) {
//        System.out.println(numberOfArrangements(5,""));
        System.out.println(numberOfArrangementsMemo(5));
    }
}
