public class ArrayTest {
    public static void main(String[] args) {
//        short seqLen = 492;
//        short numSeq = 100;
//
//        byte dummmy = 0;
//        byte[] arr;
//
//        short row, col;
//        int cell = 0;
//
//        long time = System.currentTimeMillis();
//        for (int i = 0; i < numSeq; i++) {
//            for (int j = 0; j < numSeq; j++) {
//                cell = 0;
//                arr = new byte[seqLen * seqLen];
//                for (row = 0; row < seqLen; row++) {
//                    for (col = 0; col < seqLen; col++, cell++) {
//                        arr[cell] = dummmy;
//                    }
//                }
//            }
//        }
//        time = System.currentTimeMillis() - time;
//        System.out.println("Elapsed: " + time + "ms");

        ForLoopTest3();
    }


    public static void ForLoopTest3() {
        System.out.println("working ...");
        int seqLen = 492;
        int numSeq = 100;

        byte[] arr = new byte[seqLen * seqLen];
        int cell = 0;

        long time = System.currentTimeMillis();
        for (int i = 0; i < numSeq; i++) {
            for (int j = 0; j < numSeq; j++) {
                cell = 0;
                for (short row = 0; row < seqLen; row++) {
                    for (short col = 0; col < seqLen; col++) {
                        arr[cell++] = 0;
                    }
                }
            }
//            System.out.println("row " + i + "done");
        }
        time = System.currentTimeMillis() - time;
        System.out.println("Elapse: "+ time + "ms");

    }
}