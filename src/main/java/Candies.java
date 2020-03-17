public class Candies {
    public static int countCandies(int startingAmount, int newEvery) {
        if(startingAmount<newEvery) return startingAmount;
        else return newEvery+countCandies(startingAmount-newEvery+1,newEvery);
    }

    public static int countCandies1(int startingAmount, int newEvery) {
        int startTimes=startingAmount/(newEvery-1)-1;
        return startTimes*newEvery+(startingAmount-startTimes*(newEvery-1));
    }

        public static void main(String[] args) {
        System.out.println(Candies.countCandies1(3, 2));
    }
}
