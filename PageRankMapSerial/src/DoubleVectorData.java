
import java.io.*;

public class DoubleVectorData {

    private double data[][];
    private boolean dataLoaded = false;

    private int numData;
    private int vecLen;

    public DoubleVectorData() {
    }

    public DoubleVectorData(double[][] data, int numData, int vecLen) {
        this.data = data;
        this.numData = numData;
        this.vecLen = vecLen;
        this.dataLoaded = true;
    }

    public void fromBytes(byte[] bytes) throws Exception {
        ByteArrayInputStream baInputStream = new ByteArrayInputStream(bytes);
        DataInputStream din = new DataInputStream(baInputStream);

        try {

            this.numData = din.readInt();
            this.vecLen = din.readInt();

            this.data = new double[numData][vecLen];

            for (int i = 0; i < numData; i++) {
                for (int j = 0; j < vecLen; j++) {
                    data[i][j] = din.readDouble();
                }
            }
            din.close();
            baInputStream.close();

        } catch (IOException ioe) {
            throw new Exception(ioe);
        }
    }

    public byte[] getBytes() throws Exception {
        ByteArrayOutputStream baOutputStream = new ByteArrayOutputStream();

        DataOutputStream dout = new DataOutputStream(baOutputStream);
        byte[] marshalledBytes = null;

        try {
            dout.writeInt(numData);
            dout.writeInt(vecLen);
            for (int i = 0; i < numData; i++) {
                for (int j = 0; j < vecLen; j++) {
                    dout.writeDouble(data[i][j]);
                }
            }
            dout.flush();
            marshalledBytes = baOutputStream.toByteArray();
            baOutputStream = null;
            dout = null;
        } catch (IOException ioe) {
            throw new Exception(ioe);
        }
        return marshalledBytes;
    }

    public double[][] getData() {
        return data;
    }

    public int getNumData() {
        return numData;
    }

    public int getVecLen() {
        return vecLen;
    }

    public boolean isDataLoaded() {
        return dataLoaded;
    }

    /**
     * Loads data from a binary file. First two integer values gives the number
     * of rows and the number of columns to read. The remaining double values
     * contains the vector data.
     */
    public double[][] loadDataFromBinFile(String fileName) throws IOException {
        File file = new File(fileName);
        BufferedInputStream bin = new BufferedInputStream(new FileInputStream(
                file));
        DataInputStream din = new DataInputStream(bin);

        numData = din.readInt();
        vecLen = din.readInt();

        if (!(numData > 0 && numData <= Integer.MAX_VALUE && vecLen > 0 && vecLen <= Integer.MAX_VALUE)) {
            throw new IOException("Invalid number of rows or columns.");
        }

        this.data = new double[numData][vecLen];
        for (int i = 0; i < numData; i++) {
            for (int j = 0; j < vecLen; j++) {
                data[i][j] = din.readDouble();
            }
        }
        din.close();
        bin.close();
        return this.data;
    }

    /**
     * Loads data from a text file. Sample input text file is shown below. First
     * line indicates the number of lines. Second line gives the length of the
     * vector. 5 2 1.2 2.3 5.6 3.3 1.0 2.5 3.0 6.5 5.5 6.3
     *
     */
    public double[][] loadDataFromTextFile(String fileName) throws IOException {

        File file = new File(fileName);

        // ZBJ: could limit the buffer size, but slow
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String inputLine = reader.readLine();
        if (inputLine != null) {
            numData = Integer.parseInt(inputLine);
        } else {
            new IOException("First line = number of rows is null");
        }

        inputLine = reader.readLine();
        if (inputLine != null) {
            vecLen = Integer.parseInt(inputLine);
        } else {
            new IOException("Second line = size of the vector is null");
        }

        this.data = new double[numData][vecLen];
        // ZBJ: Do gc in order to load larger file
        Runtime.getRuntime().gc();


        String[] vectorValues = null;
        int numRecords = 0;
        while ((inputLine = reader.readLine()) != null) {
            vectorValues = inputLine.split(" ");
            if (vecLen != vectorValues.length) {
                throw new IOException("Vector length did not match at line "
                        + numRecords);
            }
            for (int i = 0; i < vecLen; i++) {
                data[numRecords][i] = Double.valueOf(vectorValues[i]);
            }
            numRecords++;
        }

        // ZBJ: Do close
        reader.close();

        // ZBJ: Do gc in order to load largeer file
        Runtime.getRuntime().gc();

        return this.data;
    }

    /**
     * Write the vector data into a binary file.
     *
     * @param fileName
     * @throws IOException
     */
    public void writeToBinFile(String fileName) throws IOException {
        BufferedOutputStream bout = new BufferedOutputStream(
                new FileOutputStream(fileName));
        DataOutputStream dout = new DataOutputStream(bout);

        // First two parameters are the dimensions.
        dout.writeInt(numData);
        dout.writeInt(vecLen);
        for (int i = 0; i < numData; i++) {
            for (int j = 0; j < vecLen; j++) {
                dout.writeDouble(data[i][j]);
            }
        }
        dout.flush();
        bout.flush();
        dout.close();
        bout.close();
    }

    /**
     * Write the vector data into a text file. First two lines give numData and
     * vecLen.
     *
     * @param fileName
     *            - Name of the file to write.
     * @throws IOException
     */
    public void writeToTextFile(String fileName) throws IOException {
        // Data as string
        BufferedOutputStream bout = new BufferedOutputStream(
                new FileOutputStream(fileName));
        PrintWriter writer = new PrintWriter(bout);
        writer.println(numData);
        writer.println(vecLen);
        StringBuffer line;
        for (int i = 0; i < numData; i++) {
            line = new StringBuffer();
            for (int j = 0; j < vecLen; j++) {
                if (j == (vecLen - 1)) {
                    line.append(data[i][j]);
                } else {
                    line.append(data[i][j] + " ");
                }
            }
            writer.println(line.toString());
        }
        writer.flush();
        writer.close();
        bout.flush();
        bout.close();
    }
}
