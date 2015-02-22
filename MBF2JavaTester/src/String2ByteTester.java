public class String2ByteTester {
    public static void main(String[] args) {
        String s = "asdfghjASDFGHJKLkl";
        System.out.println(s.length());
        byte[] bytes = s.getBytes();
        System.out.println(bytes.length);
    }
}
