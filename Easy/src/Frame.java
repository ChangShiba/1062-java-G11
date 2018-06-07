package pp;
import java.awt.Color;  
import java.awt.Graphics;  
import java.awt.image.BufferedImage;  
import java.util.ArrayList;  
  
import javax.swing.ImageIcon;  
import javax.swing.JFrame;  
  
/*import com.huaxin.enery.Enery;  
import com.huaxin.enery.Pipe;  
  
import Util.Map;  */
  
public class Frame extends JFrame{  
      
    public Mario mario;  
    public Enery pipe,cion,brick;  
    //背景圖片  
    public BackgroundImage bg ;  
      
    //敵人 範圍
    public ArrayList<Enery> eneryList = new ArrayList<Enery>();  
      
    //子彈
    //public ArrayList<Boom> boomList = new ArrayList<Boom>();  
      
    //子彈速度  
    public int bspeed=0;  
      
    //1->磚頭(磚頭)，2->金幣(星星)，3->水管(火箭)  
    public int [][] map =null;  
      
    //初始化背景圖片和人物
    public Frame() throws Exception {  
        bg = new BackgroundImage();  
        mario = new Mario(this);  
        mario.start();  
        Map mp= new Map();  
          
          
        map=mp.readMap();  
        //讀地圖，配置地圖  
        /*for (int i = 0; i < map.length; i++) {  
            for (int j = 0; j < map[0].length; j++) {  
                //1->磚頭 
                if(map[i][j]==1){  
                    brick = new Pipe(j*30,i*30,30,30,new ImageIcon("image/brick.png").getImage());  
                    eneryList.add(brick);  
                }  
                //2->星星
                if(map[i][j]==2){  
                    cion = new Pipe(j*30,i*30,30,30,new ImageIcon("image/coin_brick.png").getImage());  
                    eneryList.add(cion);  
                }  
                //3->火箭  
                if(map[i][j]==3){  
                    pipe = new Pipe(j*30,i*30,60,120,new ImageIcon("image/pipe.png").getImage());  
                    eneryList.add(pipe);  
                }  
                  
            }  
        }*/  
        //設背景音樂 
        //com.huaxin.music.Util.startMusic("music/bg1.wav"); 
        //視窗重繪
        new Thread(){  
            public void run(){  
                while(true){   
                    repaint();  
                    //檢查子彈是否出界  
                    //checkBoom();  
                    try {  
                        Thread.sleep(10);  
                    } catch (InterruptedException e) {  
                        e.printStackTrace();  
                    }  
                }  
            }  
        }.start();//only for thread
        
    }  
    public void initFrame(){  
        //設置相關屬性 
        this.setSize(1000,600);  
        this.setTitle("little_planet");  
        this.setResizable(false); //視窗不可伸縮 
        this.setLocationRelativeTo(null);  //置中
        this.setDefaultCloseOperation(3);  //按X關閉視窗
        this.setVisible(true); //視窗可視化 
          
        //視窗添加監聽
        Mouse m1 = null;
		try {
			m1 = new Mouse(this);
		} catch (Exception e) {
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		}  
        this.addMouseListener(m1);  
        this.addMouseMotionListener(m1);
    }  
      
    public void paint(Graphics g) {  
        //利用雙緩衝 畫背景圖片和人物  
        BufferedImage bi =(BufferedImage)this.createImage(this.getSize().width,this.getSize().height);  
        Graphics big =bi.getGraphics();  
        big.drawImage(bg.img, bg.x, bg.y, null);
        
          
        for (int i = 0; i <eneryList.size(); i++) {  
            Enery e =eneryList.get(i);//障礙物偵測  
            big.drawImage(e.img, e.x, e.y, e.width, e.height,null);  
        }  
          
        //畫子彈  
        /*for (int i = 0; i < boomList.size(); i++) {  
            Boom b =boomList.get(i);  
            Color c =big.getColor();  
            big.setColor(Color.red);  
            big.fillOval(b.x+=b.speed, b.y, b.width, b.width);  
            big.setColor(c);  
        }  */
          
        //畫人物
        big.drawImage(mario.img, mario.x, mario.y, mario.width, mario.height,null);  
        //全部畫面執行
        g.drawImage(bi,0,0,null);  
          
    } 
      
    //檢查子彈
/*   public void checkBoom(){  
       for (int i = 0; i < boomList.size(); i++) {  
            Boom b = boomList.get(i);  
            if(b.x<0 || b.x>800){  
                boomList.remove(i);  
            }  
        }  
    }*/
  
}  