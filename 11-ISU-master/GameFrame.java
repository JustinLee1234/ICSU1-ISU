import java.io.File;
import java.util.Scanner;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;

public class GameFrame extends JFrame{ //create frame for game itself
  public GameFrame(TilePanel p, boolean visible) //pass in tilePanel as a parameter
  {
    this.setTitle("Screen");
    this.setContentPane(p);
    this.pack(); //takes preferred size of TilePanel and sets window size to it
    this.setVisible(visible);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
  }
  public void refresh() { //refreshes what's inside the frame at a constant rate
    this.repaint();
  }
}

  
    



