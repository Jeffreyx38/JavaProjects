/*
 * Photo Album application
 * created for CSCI 111
 * last modified April 9, 2015
 *@author Jefferson
 */
package photoalbum;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

public class PhotoAlbum {

    /**
     * The main method organizes a GUI photo album
     */
    public static void main(String[] args) {

        // create a frame to hold the components
        JFrame myJFrame = new JFrame();

        // create a Borderlayout and assign it to the JFrame
        myJFrame.setLayout(new BorderLayout());

        //Short descrition -welcome (North zone)
        JButton header = new JButton("Welcome to the collection album of dog breeds");

        //Explains the photo album features -East zone
        JButton descrition = new JButton("Click for more info.");
        descrition.setPreferredSize(new Dimension(145, 0)); //resize the button dimension 

        // Create a panel for the imagine buttons  
        // Grid with 2 columns and 3 rows (Center zone)
        JPanel buttonsPanel = new JPanel(new GridLayout(2, 3));

        //declare line border for the buttons
        Border blackLine = BorderFactory.createLineBorder(Color.black, 2);

        // Create JButtons with programming images (center)
        JButton jbAiredale = new JButton(new ImageIcon("dogs/Airedale.jpg"));
        buttonsPanel.add(jbAiredale);
        jbAiredale.setBorder(blackLine);

        JButton jbAlaskan = new JButton(new ImageIcon("dogs/Alaskan.jpg"));
        buttonsPanel.add(jbAlaskan);
        jbAlaskan.setBorder(blackLine);

        JButton jbBulldog = new JButton(new ImageIcon("dogs/Bulldog.jpg"));
        buttonsPanel.add(jbBulldog);
        jbBulldog.setBorder(blackLine);

        JButton jbChiwawa = new JButton(new ImageIcon("dogs/Chiwawa.png"));
        buttonsPanel.add(jbChiwawa);
        jbChiwawa.setBorder(blackLine);

        JButton jbCollie = new JButton(new ImageIcon("dogs/Collie.jpg"));
        buttonsPanel.add(jbCollie);
        jbCollie.setBorder(blackLine);

        JButton jbEskimo = new JButton(new ImageIcon("dogs/Eskimo.jpg"));
        buttonsPanel.add(jbEskimo);
        jbEskimo.setBorder(blackLine);

        // Create a panel for the direction buttons  
        // Grid with 1 columns and 4 rows
        JPanel buttonsPanel2 = new JPanel(new GridLayout(1, 4));

        // Create a south directional button field 
        JButton zoomIN = new JButton("ZoomIn");
        buttonsPanel2.add(zoomIN);
        JButton previous = new JButton("Previous");
        buttonsPanel2.add(previous);
        JButton jtResult = new JButton("Next");
        buttonsPanel2.add(jtResult);
        JButton delete = new JButton("Delete");
        buttonsPanel2.add(delete);
        //add the header field to the north side 
        myJFrame.add(header, BorderLayout.NORTH);

        //add the descrition of the program feature to the east side
        myJFrame.add(descrition, BorderLayout.EAST);
        // add the main pictures button panel to the JFrame
        myJFrame.add(buttonsPanel, BorderLayout.CENTER);
        // add the directional field to the JFrame
        myJFrame.add(buttonsPanel2, BorderLayout.SOUTH);

        // set the title, size, location and exit behavior for the frame
        myJFrame.setTitle("Dog breeds");
        myJFrame.setSize(800, 600);
        myJFrame.setLocation(200, 100);
        myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // make the frame visible (activate the frame)
        myJFrame.setVisible(true);
    }//end main()

}//end class ()
