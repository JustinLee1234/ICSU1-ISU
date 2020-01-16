import java.awt.Graphics; //Import classes
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;


public class Player extends Entity implements KeyListener { 
  
  private int lives; //Create private and public variables
  private boolean dead;
  private BufferedImage sprite;
  public boolean movingRight;
  public boolean movingLeft;
  public boolean movingUp;
  public boolean movingDown;
  public int count = 0;
  
  
  public Player(){ //setters and getters
    this.lives = lives; 
  }  
  
  public void setLives(int lives){
    this.lives = lives; 
  }
  public int getLives(){
    return lives;
  }
  
  
  public void move(){
    boolean moving = false; //The player does not move unless true
    if (movingRight ||  movingLeft || movingUp || movingDown){ // If a key is pressed (it is true), add numbers to count
      count++;
      if ((count%8) == 0){ // Allows movement of 8 pixels per tick speed
        moving = true; //Movement occurs
      }
    }
    if (moving){
      if (movingRight){
        setX(getX() + 1); // If right key is pressed, add one to the x coordinates of player
      }
      if (movingLeft){// If left key is pressed, deduct one to the x coordinates of player
        setX(getX() - 1);
      }
      if(movingUp){// If up key is pressed, deduct one to the y coordinates of player
        setY(getY() - 1);
      }
      if(movingDown){// If down key is pressed, add one to the y coordinates of player
        setY(getY() + 1 );
      }
  }
  }
  
  //setX(getX() + (getXStep()));
  //setY(getY() + (getYStep()));   
  
  public void keyTyped(KeyEvent e) {
    
  }
  
  public void keyPressed(KeyEvent e) { //Method tracking the pressed keys
    int key = e.getKeyChar();
    
    if (key == 'a') { // Depending on the character pressed, the direction of the player changes
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
  
  public void keyReleased(KeyEvent e) {// Method tracking released keys
    
    int key = e.getKeyChar(); // Depending on the character key released, the movement in that direction stops
    
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



