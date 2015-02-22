package Bingjing10262012;

/**
 * Author: Saliya Ekanayake (esaliya at gmail dot com)
 * Date: 10/26/12 Time: 2:40 PM
 */
public class AccessMatrixElement {
    public static void main(String[] args) {
        int rows = 5;
        int cols = 8;
        int [][] mat = new int[rows][];
        for (int i = 0; i < mat.length; ++i){
            mat[i] = new int[cols];
            for (int j = 0; j < cols; ++j ){
                mat[i][j] = i*cols * j;
                System.out.print(mat[i][j] + "  ");
            }
            System.out.println();
        }


    }
}
