import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author: Saliya Ekanayake (esaliya at gmail dot com)
 * Date: 10/12/12 Time: 2:40 PM
 */
public class PowerSet {
    /*E.g. s = {1 2 3} then P(s) = {{1},{2},{3},{1,2},{1,3},{2,3},{1,2,3},{}}
    2^n number of subsets*/

//    {} -> 
//
//    {1} = {{2,1} {2}, {1}, {}}
//
//    add 2 to {{1}, {}}
//    {{2,1}, {2}}
//
//    {2,1} = {{1}, {2}, {2,1}, {}}
    

    // Recursive call
    public static ArrayList<int[]> numberOfSubsets(int[] arr, int start, int end){
        if (start > end) {
            int [] emptyArray = new int[0];
            ArrayList<int[]> ls = new ArrayList<int[]>();
            ls.add(emptyArray);
            return ls;
        } else {
            ArrayList<int[]> ls = numberOfSubsets(arr, start+1, end);
            
            int originalSize = ls.size();
            for(int j = 0; j < originalSize; ++j){
                int[]a = ls.get(j);
                int [] b = new  int[a.length+1];
                b[0] = arr[start];

                // Probably there's a method in Arrays for this
                for (int i = 0; i < a.length; ++i){
                    b[i+1] = a[i];
                }
                ls.add(b);
            }
            return ls;
        }
    }

    public static void main(String[] args) {
        int [] set = createSet(3);
        
        ArrayList<int[]> powerSet = numberOfSubsets(set, 0, set.length-1);
        printSubSets(powerSet);
    }

    private static void printSubSets(ArrayList<int[]> powerSet) {
        StringBuffer sb = new StringBuffer("{");
        for(int[] arr : powerSet){
            if (arr.length == 0){
                sb.append("{},");

            }  else {
                sb.append("{");
                for(int a : arr){
                    sb.append(a);
                    sb.append(',');
                }
                sb.setCharAt(sb.length() - 1, '}');
                sb.append(',');
            }
        }
        sb.setCharAt(sb.length() - 1, '}');
        System.out.println(sb.toString());
    }

    public static int[] createSet(int n){
        int [] arr = new int[n];
        for (int i = 0; i < n; ++i){
            arr[i] = i;
        }
        return arr;
    }


}
