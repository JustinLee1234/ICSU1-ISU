import java.io.File; //import function
import java.util.Scanner;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;

public class TileMap extends JFrame{ //Class for tile map
  
  public TileMap(TilePanel p) //Create tile panel
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

  
    



