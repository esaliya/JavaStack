/*
 * Created by JFormDesigner on Wed Mar 24 17:44:14 EDT 2010
 */

package ui;

import java.awt.*;
import javax.swing.*;
import com.jgoodies.forms.layout.*;
import org.jdesktop.layout.*;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;

/**
 * @author saliya ekanayake
 */
public class ListView extends JFrame {
    public ListView() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - saliya ekanayake
        textField1 = new JTextField();
        upBtn = new JButton();
        addBtn = new JButton();
        delBtn = new JButton();
        button2 = new JButton();
        scrollPane1 = new JScrollPane();
        list1 = new JList();

        //======== this ========
        setIconImage(null);
        Container contentPane = getContentPane();

        //---- textField1 ----
        textField1.setText("/");

        //---- upBtn ----
        upBtn.setIcon(new ImageIcon("icons/up.png"));

        //---- addBtn ----
        addBtn.setIcon(new ImageIcon("icons/add.png"));

        //---- delBtn ----
        delBtn.setIcon(new ImageIcon("icons/delete.png"));

        //---- button2 ----
        button2.setIcon(new ImageIcon("icons/refresh.png"));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(list1);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .add(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(contentPaneLayout.createParallelGroup(GroupLayout.TRAILING, false)
                        .add(GroupLayout.LEADING, scrollPane1)
                        .add(GroupLayout.LEADING, contentPaneLayout.createSequentialGroup()
                            .add(textField1, GroupLayout.PREFERRED_SIZE, 618, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(upBtn, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(addBtn, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(delBtn, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(button2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(106, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .add(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(contentPaneLayout.createParallelGroup(GroupLayout.TRAILING, false)
                        .add(button2, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                        .add(delBtn, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                        .add(addBtn, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                        .add(upBtn, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                        .add(textField1))
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(scrollPane1, GroupLayout.PREFERRED_SIZE, 471, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(58, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - saliya ekanayake
    private JTextField textField1;
    private JButton upBtn;
    private JButton addBtn;
    private JButton delBtn;
    private JButton button2;
    private JScrollPane scrollPane1;
    private JList list1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
