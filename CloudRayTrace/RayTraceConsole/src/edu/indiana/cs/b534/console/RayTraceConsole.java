package edu.indiana.cs.b534.console;

import com.amazonaws.elasticmapreduce.AmazonElasticMapReduceException;
import edu.indiana.cs.b534.clients.EMClient;
import edu.indiana.cs.b534.clients.FSClient;
import edu.indiana.cs.b534.clients.S3Client;
import edu.indiana.cs.b534.thread.MonitorThread;
import edu.indiana.cs.b534.ui.RayTraceDisplay;
import org.jets3t.service.S3ServiceException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;

public class RayTraceConsole {
    private S3Client s3c;
    private FSClient fsc;
    private EMClient emc;
    private MonitorThread mt;
    private RayTraceDisplay display;

    public RayTraceConsole(String accessKey, String secretKey, String keyPair, String jarPath, String dump)
            throws S3ServiceException {
        s3c = new S3Client(accessKey, secretKey);
        fsc = new FSClient();
        mt = new MonitorThread(accessKey, secretKey, s3c, dump);
        emc = new EMClient(accessKey, secretKey, keyPair, s3c, jarPath, dump, mt);
        Thread t = new Thread(mt);
        t.start();
    }

    public void startConsole() throws IOException, S3ServiceException, NoSuchAlgorithmException, AmazonElasticMapReduceException {
        System.out.print(">>");
        String cmd;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String [] args;
        while (!"exit".equalsIgnoreCase(cmd = reader.readLine())) {
            if (cmd.startsWith("ls")) {
                fsc.ls();
            } else if (cmd.startsWith("cd")) {
                fsc.cd(cmd.substring(cmd.indexOf(" ") + 1));
            } else if (cmd.startsWith("pwd")) {
                fsc.pwd();
            } else if (cmd.startsWith("als")) {
                s3c.als();
            } else if (cmd.startsWith("put")) {
                args = cmd.split(" ");
                s3c.put(args[1], args[2]);
            } else if (cmd.startsWith("get")) {
                args = cmd.split(" ");
                s3c.get(args[1], args[2]);
            } else if (cmd.startsWith("rt")) {
                args = cmd.split(" ");
                emc.rt(args[1], args[2], Integer.parseInt(args[3]));
            } else if (cmd.startsWith("int")) {
                args = cmd.split(" ");
                display = new RayTraceDisplay(emc, args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3]));
                display.createAndShowUI();
            } else if (cmd.startsWith("kill")) {
                args = cmd.split(" ");
                emc.terminateJobFlow(args[1]);
            }
            System.out.print("\n>>");
        }
        mt.setStop(true);
        System.exit(0);
    }
}
