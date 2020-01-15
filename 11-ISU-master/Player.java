import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;


public class Player extends Entity implements KeyListener {
  
  private int lives;
  private boolean colliding;
  private boolean dead;
  private BufferedImage sprite;
  
  
  public Player(){
  }  
  
  public void move(){
    setX(getX() + (getXStep()));
    setY(getY() + (getYStep()));
  }
  public void keyTyped(KeyEvent e) {
    
  }
  
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyChar();
    
    if (key == 'a') {
      this.setXStep(-1);
    }
    
    if (key == 'd') {
      this.setXStep(1);
    }
    
    if (key == 'w') {
      this.setYStep(-1);
    }
    
    if (key == 's') {
      this.setYStep(1);
    }
  }
  
  public void keyReleased(KeyEvent e) {
    
    int key = e.getKeyChar();
    
    if (key == 'a') {
      this.setXStep(0);
    }
    
    if (key == 'd') {
      this.setXStep(0);
    }
    
    if (key == 'w') {
      this.setYStep(0);
    }
    
    if (key == 's') {
      this.setYStep(0);
    }
  }
}



