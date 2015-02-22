import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PageRankMapTask {
    // data structure of one item of adjacency matrix
    public class UrlData {
        public int index;
        public ArrayList<Integer> urls;
    }

    private FileData fileData;
    private int numUrls; // number of urls of all tasks
    private int numUrlsInTask; // number of urls of current map task
    private UrlData[] UrlsData; // the adjacency matrix of all urls

    public void close() throws Exception {
        // TODO Auto-generated method stub
    }

	/*
	 * Used to load the vector data from files. Since the mappers are cached
	 * across iterations, we only need to load this data from file once for all
	 * the iterations.
	 */

    public void configure(FileData fd )
            throws Exception {
        fileData = fd;
        try {
            loadDataFromFile(fileData.getFileName());
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

	/*
	 * decompress the compressed page rank values
	 * 
	 * @parameter dvd -compressed data which store page rank values changed in
	 * the last process
	 * 
	 * @return value -matrix which store all page rank values include changed
	 * and unchanged
	 */

    private double[][] decompress(DoubleVectorData dvd) {
        double[][] compressedData = dvd.getData();
        int numData = dvd.getNumData();
        this.numUrls = (int) compressedData[0][0];
        double tanglingProb = compressedData[0][1]; // random url access
        // probability

        double[][] newData = new double[numUrls][2];
        for (int i = 0; i < numUrls; i++) {
            newData[i][0] = i;
            newData[i][1] = tanglingProb / numUrls;
        }
        int index;
        for (int i = 1; i < numData; i++) {
            index = (int) compressedData[i][0];
            newData[index][1] += compressedData[i][1];
        }
        compressedData = null;
        return newData;
    }

	/*
	 * Map task in page rank algorithm
	 * 
	 * @parameter collector -used to store and emit the intermediate key value
	 * pair.
	 * 
	 * @parameter key -the index of map task.
	 * 
	 * @parameter val -the compressed changed page rank values.
	 */

    // construct the adjacency matrix of the partitioned data
    public void loadDataFromFile(String fileName) throws IOException {
        File file = new File(fileName);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String inputLine = reader.readLine();
        this.numUrlsInTask = Integer.parseInt(inputLine); // num of urls that
        // current map task
        // have
        UrlsData = new UrlData[numUrlsInTask];
        String[] vectorValues = null;

        for (int i = 0; i < numUrlsInTask; i++) {
            UrlsData[i] = new UrlData();
            UrlsData[i].urls = new ArrayList<Integer>();
            inputLine = reader.readLine();
            vectorValues = inputLine.split(" ");
            UrlsData[i].index = Integer.parseInt(vectorValues[0]);
            for (int j = 1; j < vectorValues.length; j++) {
                UrlsData[i].urls.add(Integer.valueOf(vectorValues[j]));
            }// end for j
        }// end for i
        reader.close();
    }// end loadDataFromFile

    public void map(BytesValue valbytes)
            throws Exception {
        try {
            DoubleVectorData tmpDvd = new DoubleVectorData();
            Set<Integer> urlsSet = new HashSet<Integer>();
            double tanglingProbSum = 0.0d;
            tmpDvd.fromBytes(valbytes.getBytes());
            double[][] tmpData = tmpDvd.getData();
            this.numUrls = (int) tmpData[0][0];
            tmpData = null;
            int fromUrl, toUrl;
            double[][] tmpPageRank = decompress(tmpDvd);
            double[][] newPageRank = new double[numUrls][2];
            for (int i = 0; i < numUrlsInTask; i++) {
                fromUrl = UrlsData[i].index;
                for (int j = 0; j < UrlsData[i].urls.size(); j++) {
                    toUrl = (UrlsData[i].urls.get(j)).intValue();
                    urlsSet.add(toUrl);
                    newPageRank[toUrl][1] += tmpPageRank[fromUrl][1]
                            / UrlsData[i].urls.size();
                }// end for j
                if (UrlsData[i].urls.size() == 0)
                    tanglingProbSum += tmpPageRank[fromUrl][1];
            }// end for i
            tmpPageRank = null;

            int numChangedUrls = urlsSet.size();
            double changedPageRank[][] = new double[numChangedUrls + 1][2];
            changedPageRank[0][0] = numUrls;
            changedPageRank[0][1] = tanglingProbSum;
            int[] urlsArray = new int[numChangedUrls];
            Iterator<Integer> iter = urlsSet.iterator();
            for (int i = 0; i < numChangedUrls; i++) {
                if (iter.hasNext())
                    urlsArray[i] = (iter.next()).intValue();
            }
            urlsSet = null;
            double changedUrlsValues = 0.0d;
            for (int i = 0; i < numChangedUrls; i++) {
                changedPageRank[i + 1][0] = urlsArray[i];
                changedPageRank[i + 1][1] = newPageRank[urlsArray[i]][1];
                changedUrlsValues += changedPageRank[i + 1][1];
            }
            newPageRank = null;
            DoubleVectorData resultDvd = new DoubleVectorData(changedPageRank,
                    numChangedUrls + 1, 2);
            changedPageRank = null;

            resultDvd = null;
        } catch (SerializationException e) {
            throw new Exception(e);
        }
    }// end map

}
