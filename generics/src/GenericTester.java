import java.util.ArrayList;
import java.util.List;

public class GenericTester {
    public static void main(String[] args) {
        ArrayList<String> ls = new ArrayList<String>();
        ArrayList<?> lo = ls;

        ls.add("wow");
        System.out.println(lo.get(0));

        ArrayList<Object> loo = new ArrayList<Object>();
        loo.add("ww");


    }
}
