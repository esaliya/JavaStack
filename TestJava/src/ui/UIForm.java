/*
 * Created by JFormDesigner on Tue Feb 23 16:43:26 EST 2010
 */

package ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import org.jdesktop.layout.*;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;

/**
 * @author unknown
 */
public class UIForm extends JFrame {
    public UIForm() {
        initComponents();
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
        locZ2 = new JTextField();
        locY2 = new JTextField();
        locX2 = new JTextField();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        locX3 = new JTextField();
        locX4 = new JTextField();
        label12 = new JLabel();
        label13 = new JLabel();
        textField1 = new JTextField();
        panel1 = new JPanel();
        rb1 = new JRadioButton();
        rb2 = new JRadioButton();
        rb3 = new JRadioButton();
        label14 = new JLabel();
        textField2 = new JTextField();
        rb4 = new JRadioButton();
        label15 = new JLabel();
        textField3 = new JTextField();
        button1 = new JButton();
        invokeBtn = new JButton();
        exitBtn = new JButton();
        statusLb = new JLabel();
        countLb = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();

        //======== configPane ========
        {
            configPane.setBorder(new TitledBorder("Configuration"));

            // JFormDesigner evaluation mark
            configPane.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), configPane.getBorder())); configPane.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


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
                                            .add(locX2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.UNRELATED)
                                        .add(configPaneLayout.createParallelGroup()
                                            .add(label7)
                                            .add(label3))
                                        .addPreferredGap(LayoutStyle.UNRELATED)
                                        .add(configPaneLayout.createParallelGroup()
                                            .add(locY, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                            .add(locY2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.RELATED)
                                        .add(configPaneLayout.createParallelGroup()
                                            .add(label8)
                                            .add(label4))
                                        .addPreferredGap(LayoutStyle.UNRELATED)
                                        .add(configPaneLayout.createParallelGroup()
                                            .add(locZ, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                            .add(locZ2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.RELATED)
                                        .add(configPaneLayout.createParallelGroup()
                                            .add(label9, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                            .add(label5)))
                                    .add(textField1, GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                                    .add(configPaneLayout.createParallelGroup(GroupLayout.TRAILING, false)
                                        .add(GroupLayout.LEADING, locX3)
                                        .add(GroupLayout.LEADING, locX4, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))))
                            .add(label10))
                        .addContainerGap())
            );
            configPaneLayout.linkSize(new Component[] {label11, label12, label13}, GroupLayout.HORIZONTAL);
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
                                        .add(locX2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .add(label7)
                                        .add(locY2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .add(label8)
                                        .add(locZ2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.RELATED)
                                .add(configPaneLayout.createParallelGroup(GroupLayout.BASELINE)
                                    .add(label11)
                                    .add(locX3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.RELATED)
                                .add(configPaneLayout.createParallelGroup(GroupLayout.TRAILING)
                                    .add(label12)
                                    .add(locX4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .add(label9))
                        .addPreferredGap(LayoutStyle.UNRELATED)
                        .add(configPaneLayout.createParallelGroup(GroupLayout.BASELINE)
                            .add(label13)
                            .add(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
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

            //---- label15 ----
            label15.setText("Input XML:");

            //---- button1 ----
            button1.setText("...");

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
                                .add(textField2, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
                            .add(panel1Layout.createSequentialGroup()
                                .add(panel1Layout.createParallelGroup()
                                    .add(panel1Layout.createSequentialGroup()
                                        .add(rb4)
                                        .add(454, 454, 454))
                                    .add(panel1Layout.createSequentialGroup()
                                        .add(35, 35, 35)
                                        .add(label15)
                                        .addPreferredGap(LayoutStyle.RELATED)
                                        .add(textField3, GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)))
                                .addPreferredGap(LayoutStyle.RELATED)
                                .add(button1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
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
                            .add(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.RELATED)
                        .add(rb4)
                        .addPreferredGap(LayoutStyle.RELATED)
                        .add(panel1Layout.createParallelGroup(GroupLayout.BASELINE)
                            .add(label15)
                            .add(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .add(button1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            panel1Layout.linkSize(new Component[] {textField2, textField3}, GroupLayout.VERTICAL);
        }

        //---- invokeBtn ----
        invokeBtn.setText("Invoke");

        //---- exitBtn ----
        exitBtn.setText("Exit Gracefully");

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
        contentPaneLayout.linkSize(new Component[] {exitBtn, invokeBtn}, GroupLayout.HORIZONTAL);
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
    private JTextField locZ2;
    private JTextField locY2;
    private JTextField locX2;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JTextField locX3;
    private JTextField locX4;
    private JLabel label12;
    private JLabel label13;
    private JTextField textField1;
    private JPanel panel1;
    private JRadioButton rb1;
    private JRadioButton rb2;
    private JRadioButton rb3;
    private JLabel label14;
    private JTextField textField2;
    private JRadioButton rb4;
    private JLabel label15;
    private JTextField textField3;
    private JButton button1;
    private JButton invokeBtn;
    private JButton exitBtn;
    private JLabel statusLb;
    private JLabel countLb;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


}
