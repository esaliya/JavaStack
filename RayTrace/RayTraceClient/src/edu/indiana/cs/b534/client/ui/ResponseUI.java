package edu.indiana.cs.b534.client.ui;

import edu.indiana.cs.b534.client.ui.custom.TextLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.concurrent.CountDownLatch;

/**
 * @author Saliya Ekanayake (sekanaya@cs.indiana.edu)
 */

/**
 * Response UI which shows response images
 */
public class ResponseUI {

    private CountDownLatch doneSignal;
    private Animator animator;
    public ResponseUI(String title, String info, ImageIcon icon) {
        TextLabel textLabel = new TextLabel(info);
        JLabel imageLabel = new JLabel(icon);
        createAndShowUI(title, textLabel, imageLabel);
    }

    public ResponseUI(String title, String info, ImageIcon[] icons) {
        TextLabel textLabel = new TextLabel(info);
        // assume if we came here then icons has at least one
        JLabel imageLabel = new JLabel(icons[0]);
        doneSignal = new CountDownLatch(1);
        animator = new Animator();
        animator.setIcons(icons);
        animator.setInterval(200);
        animator.setLabel(imageLabel);
        animator.setDoneSignal(doneSignal);
        createAndShowUI(title, textLabel, imageLabel);
        Thread t = new Thread(animator);
        t.start();
    }

    private void createAndShowUI(String title, TextLabel textLabel, JLabel imageLabel) {
        JFrame frame = new JFrame(title);
        JSplitPane mainPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        JScrollPane textPane = new JScrollPane(textLabel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.setMinimumSize(new Dimension(500, 400));
        mainPane.add(imageLabel);
        mainPane.add(textPane);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.addWindowListener(closeListener);
        frame.getContentPane().add(mainPane);
        frame.pack();
        frame.setVisible(true);
    }

    private WindowListener closeListener = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            if (animator != null) {
                animator.setStop(true);
                try {
                    doneSignal.await();
                } catch (InterruptedException e1) {
                    JOptionPane.showMessageDialog(null, "Interrupted " + e1.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    };

    class Animator implements Runnable {
        private CountDownLatch doneSignal;
        private boolean stop = false;
        private long interval;
        private ImageIcon[] icons;
        private JLabel label;

        public void setDoneSignal(CountDownLatch doneSignal) {
            this.doneSignal = doneSignal;
        }

        public void setLabel(JLabel label) {
            this.label = label;
        }

        public void setInterval(long interval) {
            this.interval = interval;
        }

        public void setIcons(ImageIcon[] icons) {
            this.icons = icons;
        }

        public void setStop(boolean stop) {
            this.stop = stop;
        }

        public void run() {
            int count = 0;
            int length = icons.length;
            while (!stop) {
                count = count % length;
                label.setIcon(icons[count]);
                count++;
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted " + e.getMessage());
                    doneSignal.countDown();
                }
            }
            doneSignal.countDown();
        }
    }
}
