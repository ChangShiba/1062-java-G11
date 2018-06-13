import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.glass.events.WindowEvent;

public class GameFrame extends JFrame implements MouseListener,MouseMotionListener{
	public static int x=900,y=1300,x2=x+100,y2=y+125;
	public static int speedx=20,speedy=20;
	public static int mx,my;
	public static boolean enemyappear=false;
	JLabel e[] =new JLabel [10];
	JLabel wordLabel = null, bgLabel = null;
	JPanel contentPanel = null, imagePanel = null;
	 ImageIcon background = null;
	 JFrame game = new JFrame("game");

	public GameFrame() {
		super(); 
		
	 game.setTitle("Little Planet");
     game.setLayout(new java.awt.BorderLayout());
//     game.add(enemy, BorderLayout.CENTER);
     game.setMinimumSize(new java.awt.Dimension(1000, 600));
     game.setResizable(false);
     game.setLocationRelativeTo(null);
     game.addMouseListener(this);
 	game.addMouseMotionListener(this);
     // 3.於JFrame中設置背景圖片 - 圖片無法縮放大小
     background = new ImageIcon("src/Resource/center.jpg");       // 背景圖片
     bgLabel = new JLabel(background);      // 把背景圖顯示在Label中
     bgLabel.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());    // 把含有背景圖之Label位置設置為圖片剛好填充整個版面
     // 把内容視窗轉為JPanel，否則不能使用setOpaque()來使視窗變成透明
     imagePanel = (JPanel) game.getContentPane();
     imagePanel.setOpaque(false);
     game.getLayeredPane().add(bgLabel, new Integer(Integer.MIN_VALUE));     // 把背景圖添加到分層窗格的最底層以作為背景
     
     
     game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     game.setVisible(true);
     //加入敵人
    for(int i=0;i<10;i++) {
    	ImageIcon img= new ImageIcon("src/Resource/enemy.png");
   	 e[i]= new JLabel(img);
    }
	game.pack();
	game.setVisible(true);
	
    
	game.addWindowListener(new WindowAdapter()
	{
	public void windowClosing(WindowEvent e)
	{
	System.exit(0);
	}
	});

	}
	
	public void enemys() {
		 if(enemyappear==true) {
			
			 new Thread(){  
		            public void run(){  
		            	System.out.println("enemy0");
		            		enemyrun(0);
		            	
		            }  
		        }.start();

	    	  
	     }
	}
	public void enemys1() {
		 
			 new Thread(){  
		            public void run(){  
		            	System.out.println("enemy1");
		            		enemyrun(1);
		        
		            }    
		        }.start();

	    	  
	     
	}
	
	public void enemyrun(int n) {
		
        while (x>=0) {  
            if(n==0) {
            	speedx+=(int)(Math.random()*30);  
                speedy+=(int)(Math.random()*20);
            }else {
            	speedx+=(int)(Math.random()*40);  
                speedy+=(int)(Math.random()*60);
            }
            e[n].setBounds(x-speedx,y-speedy, 100, 125);
            setX2(x-speedx);
            setY2(y-speedy);
            game.getLayeredPane().add(e[n], new Integer(Integer.MIN_VALUE)+1);
            try {  
                Thread.sleep(10);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }
            if(x-speedx<=0) {
            	x=900;
            	speedx=0;
            }if(y-speedy<=0) {
            	y=1300;
            	speedy=0;
            }
            
        }  	
	}
	
	public void crash() {
		 new Thread(){  
	            public void run(){  
	            	while(true) {
	            		if(mx<=x2+100&&mx>=x2&&my<=y+125&&my>=y) {
	            			System.out.println("!!!");
	            		}
	            	}
	        
	            }    
	        }.start();
	}
	
	public  int getX() {
		return x;
	}

	public static void setX(int x) {
		GameFrame.x = x;
	}

	public  int getY() {
		return y;
	}

	public static void setY(int y) {
		GameFrame.y = y;
	}

	public static int getSpeedx() {
		return speedx;
	}

	public static void setSpeedx(int speedx) {
		GameFrame.speedx = speedx;
	}

	public static int getSpeedy() {
		return speedy;
	}

	public static void setSpeedy(int speedy) {
		GameFrame.speedy = speedy;
	}


	public static boolean isEnemyappear() {
		return enemyappear;
	}

	public static void setEnemyappear(boolean enemyappear) {
		GameFrame.enemyappear = enemyappear;
	}

	public static int getX2() {
		return x2;
	}

	public static void setX2(int x2) {
		GameFrame.x2 = x2;
	}

	public static int getY2() {
		return y2;
	}

	public static void setY2(int y2) {
		GameFrame.y2 = y2;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO 自動產生的方法 Stub
		mx=e.getX();
		my=e.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO 自動產生的方法 Stub
		mx=e.getX();
		my=e.getY();
		System.out.printf("getx=%d,gety=%d%n",e.getX(),e.getY());
//		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自動產生的方法 Stub
		mx=e.getX();
		my=e.getY();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mx=e.getX();
		my=e.getY();
		GameFrame.enemyappear=true;
		System.out.println("***");
		enemys();
		enemys1();


		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自動產生的方法 Stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自動產生的方法 Stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自動產生的方法 Stub
		
	}

	
	
}
