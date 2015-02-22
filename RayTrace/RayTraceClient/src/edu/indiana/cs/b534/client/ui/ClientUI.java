package edu.indiana.cs.b534.client.ui;

import edu.indiana.cs.b534.client.RayTraceClient;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.xml.stream.XMLStreamException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.util.*;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Saliya Ekanayake (sekanaya@cs.indiana.edu)
 */

/**
 * Main UI of the program
 */
public class ClientUI extends JFrame {
    private AtomicInteger ai;
    public ClientUI(RayTraceClient rc) {
        this.rc = rc;
        this.ai = rc.getAi();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Saliya Ekanayake
        configPane = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        locX = new JTextField();
        label3 = new JLabel();
        locY = new JTextField();
        label4 = new JLabel();
        locZ = new JTextField();
        label5 = new JLabel();
        label6 = new JLabel();
        dirX = new JTextField();
        dirY = new JTextField();
        dirZ = new JTextField();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        widthTb = new JTextField();
        heightTb = new JTextField();
        label12 = new JLabel();
        label13 = new JLabel();
        sceneUrlTb = new JTextField();
        panel1 = new JPanel();
        rb1 = new JRadioButton();
        rb2 = new JRadioButton();
        rb3 = new JRadioButton();
        label14 = new JLabel();
        blockTb = new JTextField();
        rb4 = new JRadioButton();
        label15 = new JLabel();
        inputTb = new JTextField();
        browseBtn = new JButton();
        invokeBtn = new JButton();
        statusLb = new JLabel();
        countLb = new JLabel();
        exitBtn = new JButton();
        rbGroup = new ButtonGroup();
        fc = new JFileChooser();

        //======== this ========
        Container contentPane = getContentPane();

        //======== configPane ========
        {
            configPane.setBorder(new TitledBorder("Configuration"));

            //---- label1 ----
            label1.setText("Camera Setup:");

            //---- label2 ----
            label2.setText("Location:");

            //---- label3 ----
            label3.setText("X");

            //---- label4 ----
            label4.setText("Y");

            //---- label5 ----
            label5.setText("Z");

            //---- label6 ----
            label6.setText("Direction:");

            //---- label7 ----
            label7.setText("X");

            //---- label8 ----
            label8.setText("Y");

            //---- label9 ----
            label9.setText("Z");

            //---- label10 ----
            label10.setText("Dimensions:");

            //---- label11 ----
            label11.setText("Width:");

            //---- label12 ----
            label12.setText("Height:");

            //---- label13 ----
            label13.setText("Scene URL:");

            GroupLayout configPaneLayout = new GroupLayout(configPane);
            configPane.setLayout(configPaneLayout);
            configPaneLayout.setHorizontalGroup(
                    configPaneLayout.createParallelGroup()
                            .add(configPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .add(configPaneLayout.createParallelGroup()
                                    .add(label1)
                                    .add(configPaneLayout.createSequentialGroup()
                                            .add(configPaneLayout.createParallelGroup()
                                                    .add(label13)
                                                    .add(configPaneLayout.createSequentialGroup()
                                                    .add(11, 11, 11)
                                                    .add(configPaneLayout.createParallelGroup(GroupLayout.TRAILING)
                                                    .add(configPaneLayout.createParallelGroup()
                                                            .add(label12)
                                                            .add(label11))
                                                    .add(configPaneLayout.createSequentialGroup()
                                                    .add(configPaneLayout.createParallelGroup(GroupLayout.TRAILING)
                                                            .add(label6)
                                                            .add(label2))
                                                    .add(13, 13, 13)))))
                                            .add(18, 18, 18)
                                            .add(configPaneLayout.createParallelGroup()
                                            .add(configPaneLayout.createSequentialGroup()
                                                    .add(1, 1, 1)
                                                    .add(configPaneLayout.createParallelGroup()
                                                            .add(locX, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                                            .add(dirZ, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(LayoutStyle.UNRELATED)
                                                    .add(configPaneLayout.createParallelGroup()
                                                            .add(label7)
                                                            .add(label3))
                                                    .addPreferredGap(LayoutStyle.UNRELATED)
                                                    .add(configPaneLayout.createParallelGroup()
                                                            .add(locY, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                                            .add(dirY, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(LayoutStyle.RELATED)
                                                    .add(configPaneLayout.createParallelGroup()
                                                            .add(label8)
                                                            .add(label4))
                                                    .addPreferredGap(LayoutStyle.UNRELATED)
                                                    .add(configPaneLayout.createParallelGroup()
                                                            .add(locZ, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                                            .add(dirX, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(LayoutStyle.RELATED)
                                                    .add(configPaneLayout.createParallelGroup()
                                                    .add(label9, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                                    .add(label5)))
                                            .add(sceneUrlTb, GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                                            .add(configPaneLayout.createParallelGroup(GroupLayout.TRAILING, false)
                                            .add(GroupLayout.LEADING, widthTb)
                                            .add(GroupLayout.LEADING, heightTb, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))))
                                    .add(label10))
                            .addContainerGap())
            );
            configPaneLayout.linkSize(new Component[]{label11, label12, label13}, GroupLayout.HORIZONTAL);
            configPaneLayout.setVerticalGroup(
                    configPaneLayout.createParallelGroup()
                            .add(configPaneLayout.createSequentialGroup()
                            .add(label1)
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(configPaneLayout.createParallelGroup()
                                    .add(configPaneLayout.createParallelGroup(GroupLayout.BASELINE)
                                            .add(locX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .add(label3)
                                            .add(locY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .add(label4)
                                            .add(locZ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .add(label5))
                                    .add(label2))
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(configPaneLayout.createParallelGroup()
                                    .add(configPaneLayout.createSequentialGroup()
                                            .add(configPaneLayout.createParallelGroup()
                                                    .add(configPaneLayout.createSequentialGroup()
                                                            .add(label6)
                                                            .add(12, 12, 12)
                                                            .add(label10))
                                                    .add(configPaneLayout.createParallelGroup(GroupLayout.BASELINE)
                                                    .add(dirZ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                    .add(label7)
                                                    .add(dirY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                    .add(label8)
                                                    .add(dirX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(LayoutStyle.RELATED)
                                            .add(configPaneLayout.createParallelGroup(GroupLayout.BASELINE)
                                                    .add(label11)
                                                    .add(widthTb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(LayoutStyle.RELATED)
                                            .add(configPaneLayout.createParallelGroup(GroupLayout.TRAILING)
                                            .add(label12)
                                            .add(heightTb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                    .add(label9))
                            .addPreferredGap(LayoutStyle.UNRELATED)
                            .add(configPaneLayout.createParallelGroup(GroupLayout.BASELINE)
                                    .add(label13)
                                    .add(sceneUrlTb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            locX.setText("0.0");
            locY.setText("-1.0");
            locZ.setText("10.0");
            dirX.setText("0.0");
            dirY.setText("0.0");
            dirZ.setText("-1.0");
            widthTb.setText("100");
            heightTb.setText("100");
            sceneUrlTb.setText("http://pagodatree.cs.indiana.edu:9999/temp/RenderDemo.xml");
        }

        //======== panel1 ========
        {
            panel1.setBorder(new TitledBorder("Operation"));

            //---- rb1 ----
            rb1.setText("RayTrace");

            //---- rb2 ----
            rb2.setText("RayTraceURL");

            //---- rb3 ----
            rb3.setText("RayTraceSubView");

            //---- label14 ----
            label14.setText("Blocks:");

            //---- rb4 ----
            rb4.setText("RayTraceMovie");

            rbGroup.add(rb1);
            rbGroup.add(rb2);
            rbGroup.add(rb3);
            rbGroup.add(rb4);

            ActionListener rbActionListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == rb3) {
                        blockTb.setEnabled(true);
                        inputTb.setEnabled(false);
                        browseBtn.setEnabled(false);
                        enableConfig(true);
                    } else if (e.getSource() == rb4) {
                        blockTb.setEnabled(false);
                        inputTb.setEnabled(true);
                        browseBtn.setEnabled(true);
                        enableConfig(false);
                    } else {
                        blockTb.setEnabled(false);
                        inputTb.setEnabled(false);
                        browseBtn.setEnabled(false);
                        enableConfig(true);
                    }
                }
            };
            rb1.addActionListener(rbActionListener);
            rb2.addActionListener(rbActionListener);
            rb3.addActionListener(rbActionListener);
            rb4.addActionListener(rbActionListener);
            // set rb1 selected by default and disable other stuff
            rb1.setSelected(true);
            blockTb.setEnabled(false);
            inputTb.setEnabled(false);
            browseBtn.setEnabled(false);

            //---- label15 ----
            label15.setText("Input XML:");

            //---- fc ----
             fc.setFileFilter(new javax.swing.filechooser.FileFilter() {
                public boolean accept(File f) {
                    return f.getName().toLowerCase().endsWith(".xml")
                            || f.isDirectory();
                }

                public String getDescription() {
                    return "XML files";
                }
            });

            //---- browseBtn ----
            browseBtn.setText("...");
            browseBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int option = fc.showOpenDialog(null);
                    if (option == JFileChooser.APPROVE_OPTION) {
                        inputTb.setText(fc.getSelectedFile().getAbsolutePath());
                    }
                }
            });

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                            .add(panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .add(panel1Layout.createParallelGroup()
                                    .add(rb1)
                                    .add(rb2)
                                    .add(rb3)
                                    .add(panel1Layout.createSequentialGroup()
                                            .add(44, 44, 44)
                                            .add(label14)
                                            .addPreferredGap(LayoutStyle.UNRELATED)
                                            .add(blockTb, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
                                    .add(panel1Layout.createSequentialGroup()
                                    .add(panel1Layout.createParallelGroup()
                                            .add(panel1Layout.createSequentialGroup()
                                                    .add(rb4)
                                                    .add(454, 454, 454))
                                            .add(panel1Layout.createSequentialGroup()
                                            .add(35, 35, 35)
                                            .add(label15)
                                            .addPreferredGap(LayoutStyle.RELATED)
                                            .add(inputTb, GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)))
                                    .addPreferredGap(LayoutStyle.RELATED)
                                    .add(browseBtn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                            .add(panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .add(rb1)
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(rb2)
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(rb3)
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(panel1Layout.createParallelGroup(GroupLayout.BASELINE)
                                    .add(label14)
                                    .add(blockTb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(rb4)
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(panel1Layout.createParallelGroup(GroupLayout.BASELINE)
                                    .add(label15)
                                    .add(inputTb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .add(browseBtn, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            panel1Layout.linkSize(new Component[]{blockTb, inputTb}, GroupLayout.VERTICAL);
        }

        //---- invokeBtn ----
        invokeBtn.setText("Invoke");
        invokeBtn.addActionListener(invokeListener);


        //---- exitBtn ----
        exitBtn.setText("Exit");
        exitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleExit();
            }
        });

         //---- statusLb ----
        statusLb.setText("Active Request Count: ");

        //---- countLb ----
        countLb.setText("0");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .add(contentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(contentPaneLayout.createParallelGroup()
                                .add(GroupLayout.TRAILING, contentPaneLayout.createSequentialGroup()
                                        .add(statusLb)
                                        .addPreferredGap(LayoutStyle.RELATED)
                                        .add(countLb)
                                        .addPreferredGap(LayoutStyle.RELATED, 271, Short.MAX_VALUE)
                                        .add(exitBtn)
                                        .add(12, 12, 12)
                                        .add(invokeBtn))
                                .add(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(GroupLayout.TRAILING, configPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
        );
        contentPaneLayout.linkSize(new Component[]{exitBtn, invokeBtn}, GroupLayout.HORIZONTAL);
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .add(contentPaneLayout.createSequentialGroup()
                        .add(configPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.UNRELATED)
                        .add(panel1, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.RELATED)
                        .add(contentPaneLayout.createParallelGroup(GroupLayout.BASELINE)
                                .add(exitBtn)
                                .add(invokeBtn)
                                .add(countLb)
                                .add(statusLb))
                        .addContainerGap(7, Short.MAX_VALUE))
        );
        setSize(645, 490);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                countLb.setText(String.valueOf(ai.get()));
            }
        };
        java.util.Timer timer = new Timer(true);
        timer.schedule(tt, 0, 100);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Saliya Ekanayake
    private JPanel configPane;
    private JLabel label1;
    private JLabel label2;
    private JTextField locX;
    private JLabel label3;
    private JTextField locY;
    private JLabel label4;
    private JTextField locZ;
    private JLabel label5;
    private JLabel label6;
    private JTextField dirX;
    private JTextField dirY;
    private JTextField dirZ;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JTextField widthTb;
    private JTextField heightTb;
    private JLabel label12;
    private JLabel label13;
    private JTextField sceneUrlTb;
    private JPanel panel1;
    private JRadioButton rb1;
    private JRadioButton rb2;
    private JRadioButton rb3;
    private JLabel label14;
    private JTextField blockTb;
    private JRadioButton rb4;
    private JLabel label15;
    private JTextField inputTb;
    private JButton browseBtn;
    private JButton invokeBtn;
    private JButton exitBtn;
    private JLabel statusLb;
    private JLabel countLb;
    private ButtonGroup rbGroup;
    private JFileChooser fc;

    private RayTraceClient rc;

    private void handleExit() {
        // First I did a graceful exit, but then I thought
        // it's not necessary. So just plain old System.exit(0)
        System.exit(0);
    }

    private ActionListener invokeListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (verifyValues()) {
                try {
                    if (rb1.isSelected()) {
                        rc.rayTrace(Double.parseDouble(locX.getText()), Double.parseDouble(locY.getText()),
                                Double.parseDouble(locZ.getText()), Double.parseDouble(dirX.getText()),
                                Double.parseDouble(dirY.getText()),Double.parseDouble(dirZ.getText()),
                                Integer.parseInt(widthTb.getText()), Integer.parseInt(heightTb.getText()),
                                sceneUrlTb.getText());
                    } else if (rb2.isSelected()) {
                        rc.rayTraceUrl(Double.parseDouble(locX.getText()), Double.parseDouble(locY.getText()),
                                Double.parseDouble(locZ.getText()), Double.parseDouble(dirX.getText()),
                                Double.parseDouble(dirY.getText()),Double.parseDouble(dirZ.getText()),
                                Integer.parseInt(widthTb.getText()), Integer.parseInt(heightTb.getText()),
                                sceneUrlTb.getText());
                    } else if (rb3.isSelected()) {
                        rc.rayTraceSubView(Double.parseDouble(locX.getText()), Double.parseDouble(locY.getText()),
                                Double.parseDouble(locZ.getText()), Double.parseDouble(dirX.getText()),
                                Double.parseDouble(dirY.getText()),Double.parseDouble(dirZ.getText()),
                                Integer.parseInt(widthTb.getText()), Integer.parseInt(heightTb.getText()),
                                sceneUrlTb.getText(), Integer.parseInt(blockTb.getText()));
                    } else if (rb4.isSelected()) {
                        rc.rayTraceMovie(inputTb.getText());
                    }
                } catch (RemoteException e1) {
                    JOptionPane.showMessageDialog(null, "Remote Error\n" + e1.getMessage(),
                            "Error in Invoke", JOptionPane.ERROR_MESSAGE);
                } catch (FileNotFoundException e1) {
                    JOptionPane.showMessageDialog(null, "FileNotFound Error\n" + e1.getMessage(),
                            "Error in Invoke", JOptionPane.ERROR_MESSAGE);
                } catch (XMLStreamException e1) {
                    JOptionPane.showMessageDialog(null, "XMLStream Error\n" + e1.getMessage(),
                            "Error in Invoke", JOptionPane.ERROR_MESSAGE);
                }
            }

        }
    };
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private boolean verifyValues() {
        if (!rb4.isSelected()) {
            if (locX.getText() == null || "".equals(locX.getText())
                    || locY.getText() == null || "".equals(locY.getText())
                    || locZ.getText() == null || "".equals(locZ.getText())
                    || dirX.getText() == null || "".equals(dirX.getText())
                    || dirY.getText() == null || "".equals(dirY.getText())
                    || dirZ.getText() == null || "".equals(dirZ.getText())
                    || widthTb.getText() == null || "".equals(widthTb.getText())
                    || heightTb.getText() == null || "".equals(heightTb.getText())
                    || sceneUrlTb.getText() == null || "".equals(sceneUrlTb.getText())) {
                JOptionPane.showMessageDialog(null, "Null or empty configuration option(s)",
                        "Error in Verification", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        // at the moment check only if blocks is a perfect square.
        if (rb3.isSelected()) {
            double d = Double.parseDouble(blockTb.getText());
            if ((d <= 0) || (Math.sqrt(d) % 1 != 0)) {
                JOptionPane.showMessageDialog(null, "Blocks should be a perfect square",
                        "Error in Verification", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            if (widthTb.getText().equals(heightTb.getText())) {
                if (Double.parseDouble(widthTb.getText()) % Math.sqrt(d) != 0) {
                     JOptionPane.showMessageDialog(null, "Image dimensions should be divisible by square root of blocks",
                        "Error in Verification", JOptionPane.ERROR_MESSAGE);
                    return false;
                }

            } else {
               JOptionPane.showMessageDialog(null, "Width and height should be equal for parallelization",
                        "Error in Verification", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    private void enableConfig(boolean enable) {
        locX.setEnabled(enable);
        locY.setEnabled(enable);
        locZ.setEnabled(enable);
        dirX.setEnabled(enable);
        dirY.setEnabled(enable);
        dirZ.setEnabled(enable);
        widthTb.setEnabled(enable);
        heightTb.setEnabled(enable);
        sceneUrlTb.setEnabled(enable);
    }



    public void createAndShow() {
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                handleExit();
            }
        });
        setTitle("RayTrace Client");
        pack();
        setVisible(true);
    }
}

