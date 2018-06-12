
import java.awt.Graphics;
import java.awt.Image;  
import java.awt.Rectangle;  
  
import javax.swing.ImageIcon;  
  
//import com.huaxin.enery.Enery;  
  
//角色
public class Mario extends Thread{  
      
    public Frame gf;  
    


	public boolean jumpFlag=true;  
      
    //人物初始座標 
    public int x=5,y=358,x2=0,y2=0;
    //人物速度  
    public int xspeed=5,yspeed=1;  
    //人物圖片寬高  
    public int width=60,height=62;  
    //人物圖片
    public Image img = new ImageIcon("src/Resource/小星人.png").getImage();  
      
    public boolean left=false,right=false,down=false,up=false;  
      
    public String Dir_Up="Up",Dir_Left="Left",Dir_Right="Right",Dir_Down="Down";  
      
    Graphics big ;  
    
    public Mario (Frame gf) {  
        this.gf=gf;  
        this.Gravity();  //檢查貼地
    }  
      
    public Mario() {
		// TODO 自動產生的建構子 Stub
	}

	public void run(){  
        while(true){  
            //向左走  
            if(x2<x){  
                //已走到圖片最左邊，無法過圖左側
                if(hit(Dir_Left)){  
                    this.xspeed=0;  
                }  
                  
                if(this.x2>=0){
                    x=x2;
                    
                    //向左的圖片
                   // this.img=new ImageIcon("src/Resource/小星人.png").getImage();  
                }  
                  
                this.xspeed=5;  
            }  
              
            //向右走  
            if(x2>x){  
            	jump();
                if(hit(Dir_Right)){
                	//已走到圖片最右邊，無法破圖
                    this.xspeed=0;  
                    
                }   
                if(this.x2<400){  
                	
                	x=x2;
                    System.out.println("*");
                   
                    //向右的圖片
                    this.img=new ImageIcon("src/Resource/button.png").getImage();  
                   
                }  
                  
                if(this.x>=400){  
                    //背景向左移动  
                    gf.bg.x-=this.xspeed;  
                    //障礙物一起向左移動  
                    for (int i = 0; i <gf.eneryList.size(); i++) {  
                        Enery enery = gf.eneryList.get(i);  
                        enery.x-=this.xspeed;  
                    }  
          //          this.img=new ImageIcon("src/Resource/小星人.png").getImage();  
                }  
                this.xspeed=5;  
            }  
              
            //往上跳(飛)  
 //           if(y2<y){  
//            	jump(); 
//                if(jumpFlag && !isGravity){  
//                    jumpFlag=false;  
                    new Thread(){  
                        public void run(){  
                            jump();  
                            jumpFlag=true;  
                        }  
                    };  
//                }  
//            }
            
            /*if(y2>y) {
            	
            }*/
              
            try {  
                this.sleep(20);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
      

    public void jump(){  
        int jumpHeigh=0;  
        for (int i = 0; i < 150; i++) {  
            gf.mario.y-=this.yspeed;  
            jumpHeigh++;  
            if(hit(Dir_Up)){  
                break;  
            }  
            try {  
                Thread.sleep(5);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
        for (int i = 0; i <jumpHeigh; i++) {  
            gf.mario.y+=this.yspeed;  
            if(hit(Dir_Down)){  
                this.yspeed=0;  
            }  
            try {  
                Thread.sleep(5);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
              
              
        }  
        this.yspeed=1;//還原速度
    }  
      
    public boolean hit(String dir){  
        Rectangle myrect = new Rectangle(this.x,this.y,this.width,this.height);  
        Rectangle rect =null;  
          
        for (int i = 0; i < gf.eneryList.size(); i++) {  
            Enery enery = gf.eneryList.get(i);  
              
            if(dir.equals("Left")){  
                rect = new Rectangle(enery.x+2,enery.y,enery.width,enery.height);  
            }  
            else if(dir.equals("Right")){  
                rect = new Rectangle(enery.x-2,enery.y,enery.width,enery.height);  
            }  
              
            else if(dir.equals("Up")){  
                rect = new Rectangle(enery.x,enery.y+1,enery.width,enery.height);  
            }else if(dir.equals("Down")){  
                rect = new Rectangle(enery.x,enery.y-2,enery.width,enery.height);  
            }  
            //檢查碰撞 
            if(myrect.intersects(rect)){  
                return true;  
            }  
        }  
          
        return false;  
    }  
      
    //檢查察人物是否在地面 
    public boolean isGravity=false;  
      
    public void Gravity(){  
            new Thread(){  
                public void run(){  
                      
                    while(true){  
                        try {  
                            sleep(10);  
                        } catch (InterruptedException e) {  
                            e.printStackTrace();  
                        }  
                          
                        if(!jumpFlag){  
                              
                        }  
                          
                        while(true){  
                            if(!jumpFlag){  
                                break;  
                            }  
                              
                            if(hit(Dir_Down)){  
                                break;  
                            }  
                              
                            if(y>=358){  
                                isGravity=false;  
                            }  
                            else{  
                                isGravity=true;  
                                y+=yspeed;  
                            }  
                              
                            try {  
                                sleep(10);  
                            } catch (InterruptedException e) {  
                                e.printStackTrace();  
                            }  
                    }  
                }  
                }  
            }.start();  
      
    }  
    public Frame getGf() {
		return gf;
	}
 
	public void setGf(Frame gf) {
		this.gf = gf;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
		
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}
}  