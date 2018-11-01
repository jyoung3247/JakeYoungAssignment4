/*
 * Created on Mar 31, 2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package imageloading;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Frame to demonstrate the WeightedGraph object.
 * Creation date: (3/7/2002 5:02:28 PM)
 * @author: George Sellman modified by brandon broschinsky
 */

public class GraphFrame extends JFrame {
	private JButton loadButton;
	private JPanel picturePanel;
	private JLabel pictureLabel;
	private int pictureCount = 0;
	private JFileChooser chooser;
	private JList imagelist;
	private DefaultListModel<String> imageModel;
	private JTextField thename;
	private HashMap theMap;

private class DoButtons implements ActionListener {
	//Process events for each of the buttons
	public void actionPerformed(ActionEvent e) {
		
		chooser = new JFileChooser();
		int returnvalue = chooser.showOpenDialog(null);
		if(returnvalue == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			String picturename = file.getAbsolutePath();
			System.out.println(picturename);
			Image img = new ImageIcon(picturename).getImage();
			pictureLabel.setIcon(new ImageIcon(img));
			theMap.put(thename.getText(), file);
			imageModel.addElement(thename.getText());
		}
		thename.setText(null);
	}
}
/**
 * GraphFrame constructor.
 */
public GraphFrame() {

	theMap = new HashMap();
	Container ctPane = getContentPane();
	loadButton = new JButton("Load Image");
	loadButton.addActionListener(new DoButtons());
	ctPane.add(loadButton, BorderLayout.SOUTH);
	
	thename = new JTextField(25);
	ctPane.add(thename, BorderLayout.NORTH);
	
	imagelist = new JList<String>();
	imageModel = new DefaultListModel<String>();
	//imageModel.addElement("      ");
	imagelist.setModel(imageModel);
	ctPane.add(imagelist, BorderLayout.EAST);
	
	imagelist.addListSelectionListener(new ListSelectionListener() {
		public void valueChanged(ListSelectionEvent e) {
			
		}	
	});
	
	pictureLabel = new JLabel();
	ctPane.add(pictureLabel, BorderLayout.CENTER);
	

}
/**
 * GraphFrame constructor.
 * @param title java.lang.String
 */
public GraphFrame(String title) {
	this();
	setTitle(title);
}
/**
 * Starts the application.
 * @param args an array of command-line arguments
 */
public static void main(java.lang.String[] args) {
	GraphFrame frame = new GraphFrame("Graph Bonanza!");
	frame.setSize(500,400);
	frame.setVisible(true);
	frame.setLocation(200,200);
}
}
