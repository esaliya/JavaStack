/**
 * Author: Saliya Ekanayake (esaliya at gmail dot com)
 * Date: 10/12/12 Time: 3:14 PM
 */
public class FinallyCheck {
    public static void main(String[] args) {
        checker();
    }

    private static int checker() {
        try{
            int x = 1+2;
            return x;
        } catch (Exception e){
            
        } finally {
            System.out.println("in finally");
        }
        return 0;
    }
}
