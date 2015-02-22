package ui;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class MainForm extends javax.swing.JFrame {
	private JPanel configPanel;
	private JLabel lb1;
	private JLabel lb2;
	private JLabel lb4;
	private JLabel lb6;
	private JTextField directZ;
	private JLabel lb9;
	private JLabel lb8;
	private JTextField directY;
	private JLabel lb7;
	private JTextField directX;
	private JTextField locZ;
	private JLabel lb5;
	private JTextField locY;
	private JTextField locX;
	private JLabel lb3;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainForm inst = new MainForm();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public MainForm() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				configPanel = new JPanel();
				GroupLayout configPanelLayout = new GroupLayout((JComponent)configPanel);
				configPanel.setLayout(configPanelLayout);
				configPanel.setBorder(BorderFactory.createTitledBorder("Configuration"));
				{
					lb1 = new JLabel();
					lb1.setText("Camera Setup:");
				}
				{
					lb2 = new JLabel();
					lb2.setText("Location:");
				}
				{
					lb3 = new JLabel();
					lb3.setText("Direction:");
				}
				{
					locX = new JTextField();
				}
				{
					lb4 = new JLabel();
					lb4.setText("X");
				}
				{
					locY = new JTextField();
				}
				{
					lb5 = new JLabel();
					lb5.setText("Y");
				}
				{
					locZ = new JTextField();
				}
				{
					lb6 = new JLabel();
					lb6.setText("Z");
				}
				{
					directY = new JTextField();
				}
				{
					lb8 = new JLabel();
					lb8.setText("Y");
				}
				{
					directZ = new JTextField();
				}
				{
					lb9 = new JLabel();
					lb9.setText("Z");
				}
				{
					directX = new JTextField();
				}
				{
					lb7 = new JLabel();
					lb7.setText("X");
				}
				configPanelLayout.setHorizontalGroup(configPanelLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(configPanelLayout.createParallelGroup()
					    .addGroup(GroupLayout.Alignment.LEADING, configPanelLayout.createSequentialGroup()
					        .addComponent(lb1, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					        .addGap(23))
					    .addGroup(configPanelLayout.createSequentialGroup()
					        .addPreferredGap(lb1, lb2, LayoutStyle.ComponentPlacement.INDENT)
					        .addGroup(configPanelLayout.createParallelGroup()
					            .addComponent(lb2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					            .addComponent(lb3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
					        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					        .addGroup(configPanelLayout.createParallelGroup()
					            .addComponent(locX, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					            .addComponent(directX, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addGroup(configPanelLayout.createParallelGroup()
					    .addComponent(lb4, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lb7, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(configPanelLayout.createParallelGroup()
					    .addComponent(locY, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					    .addComponent(directY, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addGroup(configPanelLayout.createParallelGroup()
					    .addComponent(lb5, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lb8, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(configPanelLayout.createParallelGroup()
					    .addComponent(locZ, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					    .addComponent(directZ, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(configPanelLayout.createParallelGroup()
					    .addGroup(configPanelLayout.createSequentialGroup()
					        .addComponent(lb9, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					    .addGroup(configPanelLayout.createSequentialGroup()
					        .addComponent(lb6, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(176, Short.MAX_VALUE));
				configPanelLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {lb6, lb5, lb4});
				configPanelLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {lb3, lb2});
				configPanelLayout.setVerticalGroup(configPanelLayout.createSequentialGroup()
					.addComponent(lb1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(configPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(locZ, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lb6, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lb5, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(locY, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lb4, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(locX, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lb2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(configPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(directZ, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lb9, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lb8, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(directY, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lb7, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(directX, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lb3, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(135, 135));
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(configPanel, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(142, Short.MAX_VALUE));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(configPanel, 0, 578, Short.MAX_VALUE)
				.addContainerGap());
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
