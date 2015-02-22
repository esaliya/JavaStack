//package ui;
//import java.awt.Component;
//import javax.swing.BorderFactory;
//import javax.swing.GroupLayout;
//import javax.swing.JButton;
//import javax.swing.JComponent;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JRadioButton;
//import javax.swing.JTabbedPane;
//import javax.swing.JTextField;
//import javax.swing.LayoutStyle;
//import javax.swing.SwingConstants;
//
//import javax.swing.WindowConstants;
//import javax.swing.border.LineBorder;
//import javax.swing.border.TitledBorder;
//import org.jdesktop.application.Application;
//import javax.swing.SwingUtilities;
//
//
///**
//* This code was edited or generated using CloudGarden's Jigloo
//* SWT/Swing GUI Builder, which is free for non-commercial
//* use. If Jigloo is being used commercially (ie, by a corporation,
//* company or business for any purpose whatever) then you
//* should purchase a license for each developer using Jigloo.
//* Please visit www.cloudgarden.com for details.
//* Use of Jigloo implies acceptance of these licensing terms.
//* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
//* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
//* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
//*/
//public class MainUI extends javax.swing.JFrame {
//	private JTextField locX;
//	private JTextField locY;
//	private JPanel configPane;
//	private JLabel camLb;
//	private JLabel locYlb;
//	private JLabel locZlb;
//	private JLabel directLb;
//	private JTextField directX;
//	private JLabel directXlb;
//	private JTextField directY;
//	private JLabel directYlb;
//	private JTextField directZ;
//	private JRadioButton rb1;
//	private JPanel optionPane;
//	private JTextField hTb;
//	private JTextField inputTb;
//	private JButton exitBtn;
//	private JButton browseBtn;
//	private JLabel inputLb;
//	private JRadioButton rb4;
//	private JButton invokeBtn;
//	private JTextField blockTb;
//	private JLabel blockLb;
//	private JRadioButton rb3;
//	private JRadioButton rb2;
//	private JTextField scenTb;
//	private JLabel hLb;
//	private JLabel wLb;
//	private JTextField wTb;
//	private JLabel sceneLb;
//	private JLabel dimLb;
//	private JLabel locLb;
//	private JLabel directZlb;
//	private JTextField locZ;
//	private JLabel locXlb;
//
//	/**
//	* Auto-generated main method to display this JFrame
//	*/
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				MainUI inst = new MainUI();
//				inst.setLocationRelativeTo(null);
//				inst.setVisible(true);
//			}
//		});
//	}
//
//	public MainUI() {
//		super();
//		initGUI();
//	}
//
//	private void initGUI() {
//		try {
//			;
//			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
//			getContentPane().setLayout(thisLayout);
//			this.setName("frame");
//			{
//				configPane = new JPanel();
//				GroupLayout paneLayout = new GroupLayout((JComponent)configPane);
//				configPane.setLayout(paneLayout);
//				configPane.setBorder(BorderFactory.createTitledBorder(null, "Configuration", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION));
//				{
//					locY = new JTextField();
//					locY.setName("locY");
//				}
//				{
//					locXlb = new JLabel();
//					locXlb.setName("locXlb");
//				}
//				{
//					locYlb = new JLabel();
//					locYlb.setName("locYlb");
//				}
//				{
//					locZ = new JTextField();
//				}
//				{
//					locZlb = new JLabel();
//					locZlb.setName("locZlb");
//				}
//				{
//					locLb = new JLabel();
//					locLb.setName("locLb");
//				}
//				{
//					directZlb = new JLabel();
//					directZlb.setName("directZlb");
//				}
//				{
//					directZ = new JTextField();
//				}
//				{
//					directYlb = new JLabel();
//					directYlb.setName("directYlb");
//				}
//				{
//					directY = new JTextField();
//					directY.setName("directY");
//				}
//				{
//					directXlb = new JLabel();
//					directXlb.setName("directXlb");
//				}
//				{
//					directX = new JTextField();
//					directX.setName("directX");
//				}
//				{
//					directLb = new JLabel();
//					directLb.setName("directLb");
//				}
//				{
//					camLb = new JLabel();
//					camLb.setName("camLb");
//				}
//				{
//					sceneLb = new JLabel();
//					sceneLb.setName("sceneLb");
//				}
//				{
//					wTb = new JTextField();
//				}
//				{
//					hTb = new JTextField();
//				}
//				{
//					wLb = new JLabel();
//					wLb.setName("wLb");
//				}
//				{
//					hLb = new JLabel();
//					hLb.setName("hLb");
//				}
//				{
//					scenTb = new JTextField();
//				}
//				{
//					dimLb = new JLabel();
//					dimLb.setName("dimLb");
//				}
//				{
//					locX = new JTextField();
//					locX.setName("locX");
//				}
//					paneLayout.setHorizontalGroup(paneLayout.createSequentialGroup()
//					.addContainerGap()
//					.addGroup(paneLayout.createParallelGroup()
//					    .addGroup(GroupLayout.Alignment.LEADING, paneLayout.createSequentialGroup()
//					        .addComponent(dimLb, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
//					        .addGap(12))
//					    .addComponent(camLb, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
//					    .addGroup(GroupLayout.Alignment.LEADING, paneLayout.createSequentialGroup()
//					        .addComponent(sceneLb, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
//					        .addGap(12))
//					    .addGroup(paneLayout.createSequentialGroup()
//					        .addPreferredGap(dimLb, locLb, LayoutStyle.ComponentPlacement.INDENT)
//					        .addGroup(paneLayout.createParallelGroup()
//					            .addComponent(locLb, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
//					            .addComponent(directLb, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
//					            .addComponent(wLb, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
//					            .addComponent(hLb, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
//					        .addGap(10)))
//					.addGroup(paneLayout.createParallelGroup()
//					    .addGroup(paneLayout.createSequentialGroup()
//					        .addGroup(paneLayout.createParallelGroup()
//					            .addComponent(directX, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
//					            .addComponent(locX, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
//					            .addComponent(wTb, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
//					            .addComponent(hTb, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
//					        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//					        .addGroup(paneLayout.createParallelGroup()
//					            .addComponent(directXlb, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
//					            .addComponent(locXlb, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
//					        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//					        .addGroup(paneLayout.createParallelGroup()
//					            .addComponent(directY, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
//					            .addComponent(locY, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
//					        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//					        .addGroup(paneLayout.createParallelGroup()
//					            .addComponent(directYlb, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
//					            .addComponent(locYlb, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
//					        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//					        .addGroup(paneLayout.createParallelGroup()
//					            .addComponent(locZ, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
//					            .addComponent(directZ, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
//					        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//					        .addGroup(paneLayout.createParallelGroup()
//					            .addGroup(paneLayout.createSequentialGroup()
//					                .addComponent(directZlb, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
//					            .addGroup(paneLayout.createSequentialGroup()
//					                .addComponent(locZlb, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
//					        .addGap(0, 296, Short.MAX_VALUE))
//					    .addComponent(scenTb, GroupLayout.Alignment.LEADING, 0, 599, Short.MAX_VALUE))
//					.addContainerGap());
//					paneLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {hLb, wLb, locLb});
//					paneLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {sceneLb, dimLb});
//					paneLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {locZ, locY, locX});
//					paneLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {locZlb, locYlb, locXlb});
//					paneLayout.setVerticalGroup(paneLayout.createSequentialGroup()
//					.addComponent(camLb, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
//					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//					.addGroup(paneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//					    .addComponent(directZ, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
//					    .addComponent(locZlb, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
//					    .addComponent(locYlb, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
//					    .addComponent(locY, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
//					    .addComponent(locXlb, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
//					    .addComponent(locX, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
//					    .addComponent(directLb, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
//					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//					.addGroup(paneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//					    .addComponent(locZ, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
//					    .addComponent(directZlb, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
//					    .addComponent(directYlb, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
//					    .addComponent(directY, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
//					    .addComponent(directXlb, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
//					    .addComponent(directX, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
//					    .addComponent(locLb, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
//					.addGap(18)
//					.addComponent(dimLb, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
//					.addGroup(paneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//					    .addComponent(wTb, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
//					    .addComponent(wLb, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
//					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//					.addGroup(paneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//					    .addComponent(hTb, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
//					    .addComponent(hLb, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
//					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
//					.addGroup(paneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//					    .addComponent(scenTb, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
//					    .addComponent(sceneLb, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
//					.addGap(8));
//			}
//			{
//				optionPane = new JPanel();
//				GroupLayout optionPaneLayout = new GroupLayout((JComponent)optionPane);
//				optionPane.setLayout(optionPaneLayout);
//				optionPane.setBorder(BorderFactory.createTitledBorder(null, "Operation", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION));
//				{
//					browseBtn = new JButton();
//					browseBtn.setName("browseBtn");
//				}
//				{
//					inputTb = new JTextField();
//				}
//				{
//					inputLb = new JLabel();
//					inputLb.setName("inputLb");
//				}
//				{
//					blockTb = new JTextField();
//				}
//				{
//					blockLb = new JLabel();
//					blockLb.setName("blockLb");
//				}
//				{
//					rb3 = new JRadioButton();
//					rb3.setName("rb3");
//				}
//				{
//					rb2 = new JRadioButton();
//					rb2.setName("rb2");
//				}
//				{
//					rb1 = new JRadioButton();
//					rb1.setName("rb1");
//				}
//				{
//					rb4 = new JRadioButton();
//					rb4.setName("rb4");
//				}
//					optionPaneLayout.setHorizontalGroup(optionPaneLayout.createSequentialGroup()
//					.addContainerGap()
//					.addGroup(optionPaneLayout.createParallelGroup()
//					    .addGroup(GroupLayout.Alignment.LEADING, optionPaneLayout.createSequentialGroup()
//					        .addComponent(rb4, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
//					        .addGap(31))
//					    .addGroup(GroupLayout.Alignment.LEADING, optionPaneLayout.createSequentialGroup()
//					        .addComponent(rb1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
//					        .addGap(31))
//					    .addGroup(GroupLayout.Alignment.LEADING, optionPaneLayout.createSequentialGroup()
//					        .addComponent(rb2, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
//					        .addGap(31))
//					    .addGroup(GroupLayout.Alignment.LEADING, optionPaneLayout.createSequentialGroup()
//					        .addComponent(rb3, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
//					        .addGap(26))
//					    .addGroup(optionPaneLayout.createSequentialGroup()
//					        .addGap(77)
//					        .addGroup(optionPaneLayout.createParallelGroup()
//					            .addComponent(blockLb, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
//					            .addComponent(inputLb, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))))
//					.addGroup(optionPaneLayout.createParallelGroup()
//					    .addGroup(GroupLayout.Alignment.LEADING, optionPaneLayout.createSequentialGroup()
//					        .addComponent(blockTb, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
//					        .addGap(606))
//					    .addComponent(inputTb, GroupLayout.Alignment.LEADING, 0, 664, Short.MAX_VALUE))
//					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, 1, GroupLayout.PREFERRED_SIZE)
//					.addComponent(browseBtn, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
//					.addContainerGap());
//					optionPaneLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {inputLb, blockLb});
//					optionPaneLayout.setVerticalGroup(optionPaneLayout.createSequentialGroup()
//					.addComponent(rb1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
//					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//					.addComponent(rb2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
//					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//					.addComponent(rb3, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
//					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//					.addGroup(optionPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//					    .addComponent(blockTb, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
//					    .addComponent(blockLb, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
//					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//					.addComponent(rb4, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
//					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//					.addGroup(optionPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//					    .addComponent(browseBtn, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
//					    .addComponent(inputLb, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
//					    .addComponent(inputTb, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
//					.addContainerGap(27, 27));
//					optionPaneLayout.linkSize(SwingConstants.VERTICAL, new Component[] {blockTb, inputTb});
//			}
//			{
//				invokeBtn = new JButton();
//				invokeBtn.setName("invokeBtn");
//			}
//			{
//				exitBtn = new JButton();
//				exitBtn.setName("exitBtn");
//			}
//			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
//				.addContainerGap()
//				.addGroup(thisLayout.createParallelGroup()
//				    .addComponent(configPane, GroupLayout.Alignment.LEADING, 0, 928, Short.MAX_VALUE)
//				    .addComponent(optionPane, GroupLayout.Alignment.LEADING, 0, 928, Short.MAX_VALUE)
//				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
//				        .addGap(0, 712, Short.MAX_VALUE)
//				        .addComponent(exitBtn, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
//				        .addGap(0, 18, GroupLayout.PREFERRED_SIZE)
//				        .addComponent(invokeBtn, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
//				.addContainerGap());
//			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
//				.addContainerGap()
//				.addComponent(configPane, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
//				.addGap(19)
//				.addComponent(optionPane, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
//				.addGap(17)
//				.addGroup(thisLayout.createParallelGroup()
//				    .addComponent(invokeBtn, GroupLayout.Alignment.LEADING, 0, 24, Short.MAX_VALUE)
//				    .addGroup(thisLayout.createSequentialGroup()
//				        .addComponent(exitBtn, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
//				        .addGap(0, 0, Short.MAX_VALUE)))
//				.addContainerGap(21, 21));
//			thisLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {exitBtn, invokeBtn});
//			thisLayout.linkSize(SwingConstants.VERTICAL, new Component[] {exitBtn, invokeBtn});
//			pack();
//			Application.getInstance().getContext().getResourceMap(getClass()).injectComponents(getContentPane());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//}
