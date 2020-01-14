import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;


public class Player extends Entity implements KeyListener {
  
  private int lives;
  private boolean colliding;
  private boolean dead;
  private BufferedImage sprite;
  
  
  public Player(){
  }
  
  public void move(){
    setX(getX() + getXStep());
    setY(getY() + getYStep());
  }
  public void keyTyped(KeyEvent e) {
    
  }
  
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    
    if (key == KeyEvent.VK_LEFT) {
      this.setXStep(-1);
      System.out.println("yeet left");
    }
    
    if (key == KeyEvent.VK_RIGHT) {
      this.setXStep(1);
      System.out.println("yeet right");
    }
    
    if (key == KeyEvent.VK_UP) {
      this.setYStep(-1);
      System.out.println("yeet up");
    }
    
    if (key == KeyEvent.VK_DOWN) {
      this.setYStep(1);
      System.out.println("yeet down");
    }
  }
  
  public void keyReleased(KeyEvent e) {
    
    int key = e.getKeyCode();
    
    if (key == KeyEvent.VK_LEFT) {
      this.setXStep(0);
    }
    
    if (key == KeyEvent.VK_RIGHT) {
      this.setXStep(0);
    }
    
    if (key == KeyEvent.VK_UP) {
      this.setYStep(0);
    }
    
    if (key == KeyEvent.VK_DOWN) {
      this.setYStep(0);
    }
  }
}



