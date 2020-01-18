//Tile Maps
//Marian Wong and Justin Lee
//Create the tile panel

import java.io.File; //import classes
import java.util.Scanner;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;

public class TileMap extends JFrame{
  
  public TileMap(TilePanel p) //set contents and sizing of the frame
  {
    this.setTitle("Screen");
    this.setContentPane(p);
    this.pack(); //takes preferred size of TilePanel and sets window size to it
    this.setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
  }
  public void refresh() { 
    this.repaint(); //display
  }
}

  
    



