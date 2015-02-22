package edu.indiana.cs.b534;

import com.amazonaws.elasticmapreduce.AmazonElasticMapReduceException;
import edu.indiana.cs.b534.console.RayTraceConsole;
import edu.indiana.cs.b534.thread.MonitorThread;
import org.apache.log4j.*;
import org.jets3t.service.S3ServiceException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: RayTraceConsole credentialsFile jarFile dumpFolder");
            System.exit(1);
        }

        Logger.getRootLogger().removeAllAppenders();
        try {
            PatternLayout layout = new PatternLayout();
            Logger.getRootLogger().addAppender(new FileAppender(layout, args[2]));
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String accessKey = reader.readLine();
            String secretKey = reader.readLine();
            String keyPair = reader.readLine();
            reader.close();
            RayTraceConsole console = new RayTraceConsole(accessKey, secretKey, keyPair, args[1], args[3]);
            console.startConsole();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found Exception\n" + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Exception\n" + e.getMessage());
        } catch (S3ServiceException e) {
            System.out.println("S3 Exception\n" + e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No Such Algorithm Exception\n" + e.getMessage());
        } catch (AmazonElasticMapReduceException e) {
            System.out.println("EMR Exception\n" + e.getMessage());
        }
    }
}
