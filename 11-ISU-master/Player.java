import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Player extends Entity {
  
  private int lives;
  
  public Player(){
    loadImage();
  }
  
  
  }
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    
    if (key == KeyEvent.VK_LEFT) {
      xStep = -2;
    }
    
    if (key == KeyEvent.VK_RIGHT) {
      xStep = 2;
    }
    
    if (key == KeyEvent.VK_UP) {
      yStep = -2;
    }
    
    if (key == KeyEvent.VK_DOWN) {
      yStep = 2;
    }
  }
  
  public void keyReleased(KeyEvent e) {
    
    int key = e.getKeyCode();
    
    if (key == KeyEvent.VK_LEFT) {
      xStep = 0;
    }
    
    if (key == KeyEvent.VK_RIGHT) {
      xStep = 0;
    }
    
    if (key == KeyEvent.VK_UP) {
      yStep = 0;
    }
    
    if (key == KeyEvent.VK_DOWN) {
      yStep = 0;
    }
  }
}



