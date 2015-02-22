package edu.indiana.cs.b534.ui;

import edu.indiana.cs.b534.thread.callback.MonitorCallback;
import edu.indiana.cs.b534.ui.custom.TextLabel;
import edu.indiana.cs.b534.ui.util.IconUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class ResponseUI implements MonitorCallback {
    private String title;
    public ResponseUI(String title) {
        this.title = title;
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
        frame.getContentPane().add(mainPane);
        frame.pack();
        frame.setVisible(true);
    }

    public void onComplete(String path, String startTime, String endTime) {
        try {
            ImageIcon icon = IconUtil.createFromFile(path);
            TextLabel text = new TextLabel(generateInfo(path, startTime, endTime));
            createAndShowUI(title, text, new JLabel(icon));
        } catch (IOException e) {
            System.out.println("I/O Exception\n" + e.getMessage());
        }
    }

    private String generateInfo(String path, String startTime, String endTime) {
        StringBuffer sb = new StringBuffer();
        sb.append("File Path:\n  ");
        sb.append(path);
        sb.append("\nStart Time:\n  ");
        sb.append(startTime);
        sb.append("\nEnd Time:\n  ");
        sb.append(endTime);
        return sb.toString();
    }
}
