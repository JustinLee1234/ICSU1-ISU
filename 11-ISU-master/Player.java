import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;


public class Player extends Entity implements KeyListener {
  //most of the variables required by the player class
  private int lives = 5;
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
  //getters and setters for private variables
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

  public void move(){  //moves the player
    moving = false; // default is the player is not moving
    if (movingRight ||  movingLeft || movingUp || movingDown){ //if a movement key is pressed
      count++;
      if ((count%3) == 0){ //moving is set to true every count of 8 in order to prevent super speed
        moving = true;
      }
    }
    if (moving){ //when its moving, it moves in the coresponding direction to whatever key was pressed
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
  
  public void keyPressed(KeyEvent e) { //detect key press, each letter changes a boolean to true to represent direction
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
    if (key == 'x'){ //debugging keys
      System.out.println(this.getCurrentX());
    }
    if (key == 'y'){
      System.out.println(this.getCurrentY());
    }
    if (key == 'l'){
      System.out.println(this.getLives());
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



