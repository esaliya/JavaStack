/*
 * Created by JFormDesigner on Wed Mar 24 11:15:34 EDT 2010
 */

package ui;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.TableModel;

/**
 * @author unknown
 */
public class TableTest extends JFrame {
    public void updateModel() {

//        TableModel tm = new AbstractTableModel() {
//            String[] columnNames = {"First Name"};
//
////            String[] columnNames = {"First Name",
////                                    "Last Name",
////                                    "Sport",
////                                    "# of Years",
////                                    "Vegetarian"};
//            Object[][] data = {
//                {"Mary", "Campione",
//                 "Snowboarding", new Integer(5), new Boolean(false)},
//                {"Alison", "Huml",
//                 "Rowing", new Integer(3), new Boolean(true)},
//                {"Kathy", "Walrath",
//                 "Knitting", new Integer(2), new Boolean(false)},
//                {"Sharon", "Zakhour",
//                 "Speed reading", new Integer(20), new Boolean(true)},
//                {"Philip", "Milne",
//                 "Pool", new Integer(10), new Boolean(false)}
//            };
//
//
//            public int getRowCount() {
//                return data.length;
//            }
//
//            public int getColumnCount() {
//                return columnNames.length;
//            }
//
//            public Object getValueAt(int rowIndex, int columnIndex) {
//                return data[rowIndex][columnIndex];
//
//            }
//        };
//
//        tb.setModel(tm);
//        tb.setShowGrid(false);
//        tb.setRowSelectionAllowed(true);
//        tb.setCellSelectionEnabled(false);
//        tb.setRowSelectionAllowed(true);
////        tb.setShowHorizontalLines(false);
//    }

    }

    public void updateModel(TableModel tm) {
        tb.setModel(tm);
        tb.setShowGrid(false);
        tb.setShowHorizontalLines(false);
        tb.setShowVerticalLines(false);

    }

    public TableTest() {
        initComponents();
        tb.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    tb.getModel().getValueAt(tb.getSelectedRow(), 0);
                }
            }
        });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - saliya ekanayake
        scrollPane1 = new JScrollPane();
        tb = new JTable();
        textField1 = new JTextField();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(tb);
        }
        contentPane.add(scrollPane1, BorderLayout.CENTER);
        contentPane.add(textField1, BorderLayout.NORTH);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - saliya ekanayake
    private JScrollPane scrollPane1;
    private JTable tb;
    private JTextField textField1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
