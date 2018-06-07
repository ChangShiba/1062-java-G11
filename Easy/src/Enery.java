
import java.awt.Image;  
  
//障礙物
public abstract class Enery {  
      
    public int x,y;  
    public int width,height;  
    public Image img;  
    public Enery(int x, int y, int width, int height,Image img) {  
        this.x = x;  
        this.y = y;  
        this.width = width;  
        this.height = height;  
        this.img=img;  
    }  
}