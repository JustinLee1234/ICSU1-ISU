import java.awt.image.BufferedImage; //import functions
import javax.imageio.*;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Entity{ 
  
  private int xStep; // Setting variables 
  private int yStep;
  private int x ;
  private int y;
  private int w;
  private int h;
  
  public Entity() { //methods get and set all the values
  } 
  
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
  public int getXStep(){
    return xStep;
  }
  public int getYStep(){
    return yStep;
  }
  public void setXStep(int xStep){
    this.xStep = xStep;
  }
  public void setYStep(int yStep){
    this.yStep = yStep;
  }
  public void setX(int x){
    this.x = x;
  }
  public void setY(int y){
    this.y = y;
  }
  public void move(){
    x += xStep;
    y += yStep;
  }
}

