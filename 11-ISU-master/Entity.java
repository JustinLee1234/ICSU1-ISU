//Entity
//Justin Lee and Marian Wong
//Entity shares its variables and methods to classes extending to it and returns and assigns values to private variables

import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Entity{
  //Private variables for abstract entity, these variables and methods will be shared with any class that extend entities
  private int x;
  private int y;
  private int w;
  private int h;
  
  public Entity() { //constructor is empty 
  } 
  //in order to access private variables, "getters" and "setters" are needed to return and assign values to the variables
  public int getX() {  
    return x;
  }
  
  public int getY() {
    return y;
  }
  
  public int getWidth() {
    return w;
  }
  
  public int getHeight() {
    return h;
  }    

  public void setX(int x){
    this.x = x;
  }
  public void setY(int y){
    this.y = y;
  }

}

