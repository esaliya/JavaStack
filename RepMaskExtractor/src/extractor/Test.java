package extractor;

public class Test {
    public static void main(String[] args) {
        String s = " hi   sdf 0.96    1223 343 ";
        String [] splits = s.split("^\\s+");
        for (int i = 0; i < splits.length; i++) {
            System.out.println(splits[i]);

        }
    }
}
