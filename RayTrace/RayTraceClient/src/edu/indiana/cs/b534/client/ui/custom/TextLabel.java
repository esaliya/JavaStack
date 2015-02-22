package edu.indiana.cs.b534.client.ui.custom;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

/**
 * @author Saliya Ekanayake (sekanaya@cs.indiana.edu)
 */

/**
 * A custom <code>JTextArea</code> which appear
 * as a multi line text label
 */
public class TextLabel extends JTextArea {

    public TextLabel(String text) {
        super(8, 30);
        JLabel lbl = new JLabel();
        setFocusable(false);
        setEditable(false);
        setBackground(lbl.getBackground());
        setLineWrap(true);
        setWrapStyleWord(true);
        setFont(lbl.getFont());
        setForeground(Color.black);
        setHighlighter(null);
        setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        append((text == null || text.length() == 0) ? " " : text);
    }
}
