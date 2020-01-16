import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;


public class Player extends Entity implements KeyListener {
  
  private int lives;
  private boolean dead;
  private BufferedImage sprite;
  public boolean movingRight;
  public boolean movingLeft;
  public boolean movingUp;
  public boolean movingDown;
  public int count = 0;
  
  
  public Player(){
    this.lives = lives;
  }  
  
  public void setLives(int lives){
    this.lives = lives;
  }
  public int getLives(){
    return lives;
  }
  
  
  public void move(){
    boolean moving = false;
    if (movingRight ||  movingLeft || movingUp || movingDown){
      count++;
      if ((count%8) == 0){
        moving = true;
      }
    }
    if (moving){
      if (movingRight){
        setX(getX() + 1);
      }
      if (movingLeft){
        setX(getX() - 1);
      }
      if(movingUp){
        setY(getY() - 1);
      }
      if(movingDown){
        setY(getY() + 1 );
      }
  }
  }
  
  //setX(getX() + (getXStep()));
  //setY(getY() + (getYStep()));   
  
  public void keyTyped(KeyEvent e) {
    
  }
  
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyChar();
    
    if (key == 'a') {
      movingLeft = true;
    }
    
    if (key == 'd') {
      movingRight = true;
    }
    
    if (key == 'w') {
      movingUp = true;
    }
    
    if (key == 's') {
      movingDown = true;
    }
  }
  
  public void keyReleased(KeyEvent e) {
    
    int key = e.getKeyChar();
    
    if (key == 'a') {
      movingLeft = false;
    }
    
    if (key == 'd') {
      movingRight = false;
    }
    
    if (key == 'w') {
      movingUp = false;
    }
    
    if (key == 's') {
      movingDown = false;
    }
  }
}



