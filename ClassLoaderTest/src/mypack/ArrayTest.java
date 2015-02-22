package mypack;

public class ArrayTest {
    public static void main(String[] args) {
        int[][] arr = new int[5][];
        for (int i = 0; i < 5; ++i){
            arr[i] = new int[i+1];
            for (int j = 0; j < i+1; ++j ){
                arr[i][j] = j;
            }
        }

        for (int i = 0; i < 5; ++i){
            for (int j = 0; j < i+1; ++j ){
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
