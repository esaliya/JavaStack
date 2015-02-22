package edu.indiana.cs.b534.ui;

import com.amazonaws.elasticmapreduce.AmazonElasticMapReduceException;
import edu.indiana.cs.b534.bean.StepInfo;
import edu.indiana.cs.b534.clients.EMClient;
import edu.indiana.cs.b534.clients.S3Client;
import edu.indiana.cs.b534.thread.MonitorThread;
import edu.indiana.cs.b534.thread.callback.MonitorCallback;
import edu.indiana.cs.b534.ui.util.IconUtil;
import org.jets3t.service.S3ServiceException;

import java.awt.*;

import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.UUID;
import javax.swing.*;


/**
 * This calss will display a image and based on the mouse drags
 * it will calculate a new camera angles and location.
 * Simple mouse drag up and down will move the camera towards and
 * away from the origin.
 * Mouse drag with the Shift key pressed will present a rolling
 * ball camera setup.
 * @author chathura
 *
 */
public class RayTraceDisplay extends Panel implements MouseMotionListener,
		MouseListener, KeyListener, MonitorCallback {

	private static Point mouseDownPoint = null;

	private static boolean shiftPressed;

	private static double locX = 0;
	private static double locY = 0;
	private static double locZ = 10.0;

	private static double dirX = 0;
	private static double dirY = 0;
	private static double dirZ = -1;

    private JLabel label;
    private EMClient emc;
    private S3Client s3c;
    private String dump;
    private MonitorThread mt;
    private String bucketName;
    private String s3Folder;
    private int instances;
    private String name;
    private String jobFlowId;
    private int imgW;
    private int imgH;
    private int n;
    private ImageIcon icon;


    private boolean onHold;

    public RayTraceDisplay(EMClient emc, String bucketName, int instances, int n)
            throws IOException, NoSuchAlgorithmException, S3ServiceException, AmazonElasticMapReduceException {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
        icon = new ImageIcon("dummy.jpg");
        this.emc = emc;
        this.s3c = emc.getS3Client();
        this.dump = emc.getDump();
        this.mt = emc.getMonitor();
        this.bucketName = bucketName;
        this.instances = instances;
        this.imgW = icon.getIconWidth();
        this.imgH = icon.getIconHeight();
        this.n = n;
        createJobFlow();
    }

    private void createJobFlow()
            throws IOException, NoSuchAlgorithmException, S3ServiceException, AmazonElasticMapReduceException {
        name = "RTC_" + emc.formatString(new Date().toString());
        s3Folder = bucketName + "/" + name;
        jobFlowId = emc.createWaitingJobFlow(s3Folder, name, instances);
    }

    private String createInputFile (String location, String direction, String stepName) throws FileNotFoundException {
        File f = new File(dump + File.separator + stepName + ".txt");
        PrintWriter writer = new PrintWriter(f);
        int blockHeight = imgH / n;
        int minX = 0; int maxX = imgW - 1;
        int minY, maxY;
        for (int i = 0; i < n; i++) {
            minY = i * blockHeight;
            maxY = minY + blockHeight - 1;
            writer.println(minX + ";" + maxX + ";" + minY + ";" + maxY + ";" + location +
                    ";" + direction + ";" + imgW + ";" + imgH);
        }
        writer.close();
        return f.getAbsolutePath();
    }

	public void createAndShowUI() {
		JFrame frame = new JFrame("RayTrace Interactive");
        label = new JLabel(icon);
        add(label);

        frame.addWindowListener(closeListener);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().add(this);
		frame.setSize(icon.getIconWidth(), icon.getIconHeight());
		frame.setVisible(true);
	}

    private WindowListener closeListener = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            try {
                emc.terminateJobFlow(jobFlowId);
            } catch (AmazonElasticMapReduceException e1) {
                System.out.println("Error\n" + e1.getMessage());
            }
        }
    };
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 16) {
			shiftPressed = true;
		}

	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == 16) {
			shiftPressed = false;
		}
	}



	public void mousePressed(MouseEvent e) {
		mouseDownPoint = e.getPoint();

	}

	public void mouseReleased(MouseEvent e) {
        if (!onHold) {
            onHold = true;
            Point mouseDragged = e.getPoint();
            int dx = mouseDragged.x - mouseDownPoint.x;
            int dy = mouseDragged.y - mouseDownPoint.y;

            if (shiftPressed) {
                // Then we are moving towars or away in r direction on polar
                // cordinates
                double r = Math.sqrt(Math.pow(locX, 2) + Math.pow(locY, 2)
                        + Math.pow(locZ, 2));
                double thetaX = Math.acos(locX / r);
                double thetaY = Math.acos(locY / r);
                double thetaZ = Math.acos(locZ / r);

                r = r + ((double) dy) / 50;
                // direction wont change but the location does

                locX = r * Math.cos(thetaX);
                locY = r * Math.cos(thetaY);
                locZ = r * Math.cos(thetaZ);

            } else {
                // we do rolling ball around origin this would be sufficient for the
                // ray trace to notice

                double r = Math.sqrt(Math.pow(locX, 2) + Math.pow(locY, 2)
                        + Math.pow(locZ, 2));
                double r2 = Math.sqrt(Math.pow(locX + dx / 50, 2)
                        + Math.pow(locY + dy / 50, 2) + Math.pow(locZ, 2));
                double thetaX = Math.acos((locX + dx / 50) / r2);
                double thetaY = Math.acos((locY + dy / 50) / r2);
                double thetaZ = Math.acos(locZ / r2);

                locX = r * Math.cos(thetaX);
                locY = r * Math.cos(thetaY);
                locZ = r * Math.cos(thetaZ);

                // new normalized r
                r = Math.sqrt(Math.pow(locX, 2) + Math.pow(locY, 2)
                        + Math.pow(locZ, 2));
                dirX = -locX / r;
                dirY = -locY / r;
                dirZ = -locZ / r;

            }

            String location = locX + ";" + locY + ";" + locZ;
            String direction = dirX + ";" + dirY + ";" + dirZ;
            String stepName = UUID.randomUUID().toString();
            try {
                String inputFile = createInputFile(location, direction, stepName);
                emc.addJobFlowStep(s3Folder, stepName, jobFlowId, inputFile);
                mt.subscribe(stepName, new StepInfo(s3Folder + "/output/" + stepName + "/part-00000", this));
            } catch (Exception e1) {
                System.out.println("Error\n" + e1.getMessage());
            }

        }
	}

	public void keyTyped(KeyEvent e) {}

	public void mouseDragged(MouseEvent e) {}

	public void mouseMoved(MouseEvent e) {}

	public void mouseClicked(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

    public void onComplete(String path, String startTime, String endTime) {
        try {
            ImageIcon icon = IconUtil.createFromFile(path);
            label.setIcon(icon);
            onHold = false;
        } catch (IOException e) {
            System.out.println("I/O Exception\n" + e.getMessage());
        }
    }
}
