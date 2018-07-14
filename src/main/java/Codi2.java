import java.util.*;

public class Codi2 {

    static class Tank implements Comparable<Tank> {

        String name;
        Integer blockTime;
        Integer fuel;

        public Tank(String name, Integer blockTime, Integer fuel) {
            this.name = name;
            this.blockTime = blockTime;
            this.fuel = fuel;
        }

        public void addCar(int car) {
            this.blockTime+=car;
            this.fuel-=car;
        }

        @Override
        public int compareTo(Tank o) {
            int blockingTimeDiff=this.blockTime-o.blockTime;
            if(blockingTimeDiff==0)
                return this.name.compareTo(o.name);
            else 
                return blockingTimeDiff;
        }

        @Override
        public String toString() {
            return "Tank{" +
                    "name='" + name + '\'' +
                    ", blockTime=" + blockTime +
                    ", fuel=" + fuel +
                    '}';
        }
    }
    
    static Tank findTank(List<Tank> tanks,int car) {
        Collections.sort(tanks);
        System.out.println(">>> "+car);
        System.out.println(Arrays.toString(tanks.toArray()));
        for (Tank tank : tanks) {
            if(tank.fuel>=car) {
                tank.addCar(car);
                return tank;
            }
        }
        return null;
    }
    
    static int solution(int[] cars,int X,int Y,int Z) {
        List<Tank> tanks=new ArrayList<>();
        tanks.add(new Tank("X",0,X));
        tanks.add(new Tank("Y",0,Y));
        tanks.add(new Tank("Z",0,Z));

        Tank res=null;

        for (int i = 0; i < cars.length; i++) {
            res=findTank(tanks,cars[i]);
            if(null==res)
              return -1;
        }

        return res.blockTime-cars[cars.length-1];
    }


    public static void main(String[] args) {
        int[] cars={2,8,4,3,3};

        System.out.println(solution(cars,7,11,3));
    }
}
