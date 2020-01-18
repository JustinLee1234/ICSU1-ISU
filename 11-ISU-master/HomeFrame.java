import java.io.File;
import java.util.Scanner;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;

public class HomeFrame extends JFrame{ //class for the endScreen
  public HomeFrame(HomePanel h, boolean homeVisible) //pass in HomePanel as a parameter
  {
    this.setTitle("Pokeball Pickup");
    this.setContentPane(h);
    this.pack(); //takes preferred size of TilePanel and sets window size to it
    this.setVisible(homeVisible);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
  }
  public void refresh() { 
    this.repaint();
  }
}
