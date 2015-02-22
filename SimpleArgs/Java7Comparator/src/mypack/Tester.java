package mypack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tester {
    public static void main(String[] args) {
        DP dp1 = new DP(10.00342211);
        DP dp2 = new DP(10.00342211);
        DP dp4 = new DP(10.013435);
        DP dp3 = new DP(3.23);

        List<DP> dps = new ArrayList<DP>();
        dps.add(dp1);
        dps.add(dp2);
        dps.add(dp4);
        dps.add(dp3);

        System.out.println("before sort");
        for (DP dp : dps){
            System.out.println(dp.getX());
        }
        Collections.sort(dps);
        System.out.println("after sort");
        for (DP dp : dps){
            System.out.println(dp.getX());
        }
    }
}
