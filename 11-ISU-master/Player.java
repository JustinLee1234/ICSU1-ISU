import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;


public class Player extends Entity implements KeyListener {
  //most of the variables required by the player class
  private int lives;
  private boolean dead;
  private BufferedImage sprite;
  private TileMap tileMap;
  private TilePanel p;
  private double currentX;
  private double currentY;
  private int step = 1;
  public boolean movingRight;
  public boolean movingLeft;
  public boolean movingUp;
  public boolean movingDown;
  public boolean moving;
  public boolean outOfBounds;
  public int count = 0;
  public Rectangle playerRect;

  public Player(){
    this.lives = lives;
  }  
  
  public void setLives(int lives){
    this.lives = lives;
  }
  public int getLives(){
    return lives;
  }
  public double getCurrentX(){
    return currentX;
  }
  public double getCurrentY(){
    return currentY;
  }
  public void setCurrentX(double currentX){
    this.currentX = currentX;
  }
  public void setCurrentY(double currentY){
    this.currentY = currentY;
  }
  public void setStep(int step){
    this.step = step;
  }
  public int getStep(){
    return step;
  }

  public void move(){ 
    moving = false;
    if (movingRight ||  movingLeft || movingUp || movingDown){
      count++;
      if ((count%8) == 0){
        moving = true;
      }
    }
    if (moving){
      if (movingRight){
        setX(getX() + getStep());
      }
      if (movingLeft){
        setX(getX() - getStep());
      }
      if(movingUp){
        setY(getY() - getStep());
      }
      if(movingDown){
        setY(getY() + getStep());
      }
    }
  }
  
  
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
    if (key == 'x'){
      System.out.println(this.getCurrentX());
    }
    if (key == 'y'){
      System.out.println(this.getCurrentY());
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



