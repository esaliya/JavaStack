package edu.indiana.b34.s3client.simple;

import java.awt.Container;
import java.awt.FileDialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class FileBrowse extends JFrame {

    private JButton browseSwing = new JButton("Choose Swing...");
    private JButton browseNative = new JButton("Choose Native...");
    private JTextField textField = new JTextField(30);

    public FileBrowse() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        browseSwing.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                onBrowseSwing();
            }
        });
        browseNative.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                onBrowseNative();
            }
        });

        Container container = getContentPane();
        container.setLayout(new GridLayout(0, 1));
        container.add(browseSwing);
        container.add(browseNative);
        container.add(textField);

        pack();
    }

    protected void onBrowseSwing() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showDialog(this, "Open/Save");
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            textField.setText(file.toString());
        }
    }

    protected void onBrowseNative() {
        FileDialog fileDialog = new FileDialog(this, "Open/Save");
        fileDialog.show();
        if (fileDialog.getFile() != null) {
            String directory = fileDialog.getDirectory();
            if (!directory.endsWith(File.separator)) {
                directory += File.separator;
            }
            String file = fileDialog.getFile();
            textField.setText(directory + file);
        }
    }

    public static void main(String[] args) {
        new FileBrowse().show();
    }
}

