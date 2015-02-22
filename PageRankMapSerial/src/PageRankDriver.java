public class PageRankDriver {
    public static void main(String[] args) throws Exception {
        String filename = args[0];
        int totalUrls = Integer.parseInt(args[1]);

        PageRankMapTask mt = new PageRankMapTask();
        mt.configure(new FileData(args[0]));

        double[][] initPageRanks = new double[1][2];
        initPageRanks[0][0] = totalUrls; // the num of all urls
        initPageRanks[0][1] = 1.0; // the sum of prob of all urls = 1.0
        DoubleVectorData tmpCompressedDvd = new DoubleVectorData(initPageRanks, 1, 2);
        mt.map(new BytesValue(tmpCompressedDvd.getBytes()));
    }
}
