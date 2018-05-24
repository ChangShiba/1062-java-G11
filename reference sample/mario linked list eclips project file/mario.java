package game;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;



public class mario extends Canvas implements Runnable,MouseMotionListener,MouseListener{
	public static long score=0;
	private static int height=720;
	private static int width=1280;
	private static final long serialVersionUID = 1L;
	private Graphics g;
	public static sounds sound;
	private Graphics2D g2;
	private static keyHandler key;
	static boolean gameover=false;
	private int mx,my;
	private boolean mousedraged=false;
	private boolean mouseclicked=false;
	private Images im ;
	private Image im2;
	private Image en;
	Image icon;
	static enemy e;
	static int GameMode=0;
	static int time=300;
	static int time2=0;
	Thread t1;
	static JFrame frame;
	int i=0;
	public static int Lives=0;
	private long startt;
	private long currentstartt;
	private long currentt;
	private long timeSpend;
	private objectHandler obj=new objectHandler();
	private static gameObjects p1;
	private boolean menu=false;
	private gameObjects enemyref;
	private static level l1;
	 private static levelEditor le;
	private int sizebg=40;
	bgobjects background[]=new bgobjects[6];
	private static double totalFrameCount=0.0;
	private static double loopsCount=0.0;
	private double avarageFps=0.0;
	
	
	
	
	
	

	public static void main(String []args){
		
		mario game=new mario();
		frame=new JFrame("Mario");
		frame.add(game);
		frame.setSize(width, height);
		frame.setResizable(false);
		frame.setUndecorated(false);
		frame.setFocusable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		game.start();
	}
	
	
		//Start game in new thread
		
		private void start() {
			t1=new Thread(this,"mario");
			t1.start();
		
	}
		
		//Stop thread
		private void stop(){
			try{
				t1.join();
			}catch(InterruptedException e){
				e.printStackTrace();
				
			}
		}




public void init(){
	addMouseMotionListener(this);
	addMouseListener(this);
	im=new Images();
	sound=new sounds();
	 key=new keyHandler();
	addKeyListener(key);
	obj.addObject(new player(300,300,l1));
	p1=obj.object.get(0);
	e=new enemy((player)p1);
	
	 background[0]=new bgobjects(0, 0, 20,0);
	 background[1]=new bgobjects(800, 0, 20,0);
	 background[2]=new bgobjects(1600, 0, 20,0);
	 background[3]=new bgobjects(0, 5, 25,0);
	 background[4]=new bgobjects(800, 5, 25,0);
	 background[5]=new bgobjects(1600, 5, 25,0);
	 obj.addObject(background[0]);
	 obj.addObject(background[1]);
	 obj.addObject(background[2]);
	 obj.addObject(background[3]);
	 obj.addObject(background[4]);
	 obj.addObject(background[5]);
	
}


		public void run(){
			
			init();
			keyHandler.running=true;
			int fps = 0;
			int ups = 0;
			long timer = 0;
			
			
			
			startt=System.currentTimeMillis();
													//game loop start
				while(keyHandler.running){	
					
					try{
						
						
					currentt=System.currentTimeMillis();	//check the current time with the start time and update game every 15 millisec

					/*if(currentt-startt>=35){
						startt=System.currentTimeMillis();
						update();
						update();
						update();
						ups++;
					}else if(currentt-startt>=25){
						startt=System.currentTimeMillis();
						update();
						update();
						ups++;
					}else */
					if(currentt-startt>=15){
						startt=System.currentTimeMillis();
						currentstartt=System.nanoTime();
							update();
							ups++;		
							timeSpend=(System.nanoTime()-currentstartt);
					}
					if(currentt-timer>=1000){
						totalFrameCount+=timeSpend;
						loopsCount++;
						avarageFps=(totalFrameCount/ups);
						System.out.println("Fps = "+fps+"  ups ="+ups);			//display the frame rate
						frame.setTitle("Super Mario       ||  Fps = "+fps+"  ups ="+ups+"  ||   Avarage FPS="+avarageFps);
						fps=0;
						ups=0;
						totalFrameCount=0.0;
						time--;
						timer=currentt;
					}
					render();
					fps++;
				}
						
					catch(Exception e){
						e.printStackTrace();
					}
					
				}
			
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			
			
			
		}

		private void menu() {
			while(true){
		rendermenu();
			}
			
		}
		private void rendermenu(){
			g.setColor(Color.BLACK);
			g.fillRect(0,0, width, height);
		}



		private void update() {
			
			if(GameMode==0){
				
				if(time==285){
					GameMode=1;
					
					
				}
			}else if(GameMode==1){
				key.update(mx,my,mouseclicked,mousedraged);
				
			}
			
			else if(GameMode==2){
				
				e.update();
				l1.update();          
				im.update();
				obj.update(key.imageIndex);
				if(!p1.dead){
					key.update(p1);
				}
			}else if(GameMode==3){
				e.updatelevele();
				key.update(mx,my,mouseclicked,mousedraged);
				l1.update();
				le.update(mx,my,mousedraged);
				im.update();
				obj.update(key.imageIndex);
				if(!p1.dead){
					key.update(p1);
				}
			}
			 
			
		}
	
		private void render() {
			

			// get the bufferstrategy from the canvas class
			BufferStrategy bs= getBufferStrategy();
			if(bs==null){
				createBufferStrategy(3);
				return;
			}
			g=bs.getDrawGraphics();
			if(menu){
				rendermenu();
			}
		
			if(g instanceof Graphics2D){
				g2=(Graphics2D)g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			}
			// drawing graphics
			if(GameMode==2){
			for(int m=0;m<6;m++){
					g.drawImage(im.back[m],background[m].getX(),background[m].getY(),801,720,null);}
		
			bgobjects ref1;
			for(int i=0;i<level.size;i++){
				
					ref1=level.rlist.get(i);
				sizebg=40;
					if(ref1.im==1){
						im2=im.bg[0];
						g.drawImage(im2,ref1.getX(),ref1.getY(),40,50,null);
					}
					else if(ref1.im==4){
						im2=im.bg[1];
						g.drawImage(im2,ref1.getX(),ref1.getY(),40,50,null);
					}
					else if(ref1.im==2){
						im2=im.brick;
						g.drawImage(im2,ref1.getX(),ref1.getY(),40,40,null);
					}else if (ref1.im==3){
						im2=im.bg[2];
						g.drawImage(im2,ref1.getX(),ref1.getY()+10,40,50,null);
					}else if(ref1.im==5){
						im2=im.bg[3];
						g.drawImage(im2,ref1.getX(),ref1.getY()+10,40,50,null);
					}else if(ref1.im==6){
						im2=im.bg[4];
						g.drawImage(im2,ref1.getX(),ref1.getY(),40,50,null);
					}else if(ref1.im==7){
						im2=im.bg[5];
						g.drawImage(im2,ref1.getX(),ref1.getY(),40,50,null);
					}else if(ref1.im==26){
						im2=im.bg[6];
						g.drawImage(im2,ref1.getX(),ref1.getY()+10,40,50,null);
					}else if(ref1.im==27){
						im2=im.bg[7];
						g.drawImage(im2,ref1.getX(),ref1.getY()+10,40,50,null);
					}
					else if(ref1.im==24){
						im2=im.block;
						g.drawImage(im2,ref1.getX(),ref1.getY(),40,40,null);
					}
					
					else if(ref1.im==9){
						im2=im.block;
						g.drawImage(im2,ref1.getX(),ref1.getY(),40,40,null);
					}
					
					else if(ref1.im==8||ref1.im==21){
						
						im2=im.blockup;
						g.drawImage(im2,ref1.getX(),ref1.getY(),40,40,null);
					}
					
					else if(ref1.im==23){
						im2=im.tube;
						g.drawImage(im2,ref1.getX()-10,ref1.getY()-79,80,119,null);
					}
				
			}
			
			for(int i=0;i<enemy.enemy.size();i++){
				enemyref=enemy.enemy.get(i);
				if(enemyref.im==10){
					en=im.en[1];
					g.drawImage(en,enemyref.getX(),enemyref.getY(),70,70,null);
				}else if(enemyref.im==11){
					en=im.en[0];
					g.drawImage(en,enemyref.getX(),enemyref.getY(),70,70,null);
				}else if(enemyref.im==12){
					en=im.en[2];
					g.drawImage(en,enemyref.getX(),enemyref.getY(),70,70,null);
				}else if(enemyref.im==13){
					en=im.en[3];
					g.drawImage(en,enemyref.getX(),enemyref.getY(),70,70,null);
				}else if(enemyref.im==14){
					en=im.en[4];
					g.drawImage(en,enemyref.getX(),enemyref.getY(),70,70,null);
				}
				else if(enemyref.im==15){
					en=im.en[6];
					g.drawImage(en,enemyref.getX(),enemyref.getY(),70,70,null);
				}else if(enemyref.im==16){
					en=im.en[5];
					g.drawImage(en,enemyref.getX(),enemyref.getY(),70,70,null);
				}else if(enemyref.im==17){
					en=im.en[7];
					g.drawImage(en,enemyref.getX(),enemyref.getY(),70,70,null);
				}else if(enemyref.im==18){
					en=im.en[8];
					g.drawImage(en,enemyref.getX(),enemyref.getY(),70,70,null);
				}else if(enemyref.im==0){
					en=im.levelup;
					g.drawImage(en,enemyref.getX(),enemyref.getY(),55,55,null);
				}
				else if(enemyref.im==19){
					en=im.en[9];
					g.drawImage(en,enemyref.getX(),enemyref.getY(),70,70,null);
				}else if(enemyref.im==40){
					en=im.en[11];
					g.drawImage(en,enemyref.getX(),enemyref.getY(),70,70,null);
				}else if(enemyref.im==41){
					en=im.en[10];
					g.drawImage(en,enemyref.getX(),enemyref.getY(),70,70,null);
				}else if(enemyref.im==42){
					en=im.en[12];
					g.drawImage(en,enemyref.getX(),enemyref.getY(),70,70,null);
				}else if(enemyref.im==43){
					en=im.en[13];
					g.drawImage(en,enemyref.getX(),enemyref.getY(),70,70,null);
				}
				else if(enemyref.im==44){
					en=im.en[14];
					g.drawImage(en,enemyref.getX(),enemyref.getY(),70,70,null);
				}else if(enemyref.im==50){
					en=im.coin;
					g.drawImage(en,enemyref.getX(),enemyref.getY(),40,40,null);
				}
				
			}
			
			
			for(int i=0;i<level.brickpeices.size();i++){
				ref1=level.brickpeices.get(i);
				if(ref1.im==30){
					g.drawImage(im.bkpr,ref1.getX(),ref1.getY(),30,30,null);
				}
				else{
					g.drawImage(im.bkpl,ref1.getX(),ref1.getY(),30,30,null);
				}
				
			}
					
			g.drawImage(p1.getImage(),p1.getX(),p1.getY(),player.size+15,player.size+15,null);
			
			g.setColor(Color.BLACK);
			g.setFont(new Font("TimesRoman", Font.BOLD, 27));
			g.drawString("Score :"+score,30, 32);
			g.drawString("x "+Lives,640, 32);
			g.drawString("Time :"+time,980, 32);
			
			g.setColor(Color.WHITE);
			g.drawString("Score :"+score,33, 32);
			g.drawString("Time :"+time,983, 32);
			g.drawString("x "+Lives,643, 32);
			
			
			g.drawImage(im.timer,930,2,40,40,null);
			g.drawImage(im.lives,590,2,40,40,null);
			
		
			
			}
			
			
			else if(GameMode==0){
				g.drawImage(im.intro,0,0,frame.getWidth(),frame.getHeight(),null);
			}
			
			
			else if(GameMode==1){
				
				if(gameover){
					
				
					l1=null;
					g.drawImage(im.gameover, 350, 250, 600, 200, null);
					
					if(time2==time){
						
					gameover=false;}
				}
				else {
					g.drawImage(im.menu1,0,0,frame.getWidth(),frame.getHeight(),null);
					if(mx>850&&mx<1150&&my>220&&my<345){
						g.drawImage(im.start,850,200,320,135,null);
					}else{
						g.drawImage(im.start,850,220,300,125,null);
						
					} if(mx>850&&mx<1150&&my>370&&my<495){
						g.drawImage(im.levele,850,350,320,135,null);
					}else{
						g.drawImage(im.levele,850,370,300,125,null);
						}
					if(mx>850&&mx<1150&&my>520&&my<645){
						g.drawImage(im.exit,850,500,320,135,null);
					}	
					else{g.drawImage(im.exit,850,520,300,125,null);}
					g.fillOval(mx-10,my-10, 30, 30);
				}
			}else if(GameMode==3){
					
					for(int m=0;m<6;m++){
						g.drawImage(im.back[m],background[m].getX(),background[m].getY(),801,720,null);}
			
				bgobjects ref1;
				for(int i=0;i<level.size;i++){
					
						ref1=level.rlist.get(i);
					sizebg=40;
						if(ref1.im==1){
							im2=im.bg[0];
							g.drawImage(im2,ref1.getX(),ref1.getY(),40,50,null);
						}
						else if(ref1.im==4){
							im2=im.bg[1];
							g.drawImage(im2,ref1.getX(),ref1.getY(),40,50,null);
						}
						else if(ref1.im==2){
							im2=im.brick;
							g.drawImage(im2,ref1.getX(),ref1.getY(),40,40,null);
						}else if (ref1.im==3){
							im2=im.bg[2];
							g.drawImage(im2,ref1.getX(),ref1.getY()+10,40,50,null);
						}else if(ref1.im==5){
							im2=im.bg[3];
							g.drawImage(im2,ref1.getX(),ref1.getY()+10,40,50,null);
						}else if(ref1.im==6){
							im2=im.bg[4];
							g.drawImage(im2,ref1.getX(),ref1.getY(),40,50,null);
						}else if(ref1.im==7){
							im2=im.bg[5];
							g.drawImage(im2,ref1.getX(),ref1.getY(),40,50,null);
						}else if(ref1.im==26){
							im2=im.bg[6];
							g.drawImage(im2,ref1.getX(),ref1.getY()+10,40,50,null);
						}else if(ref1.im==27){
							im2=im.bg[7];
							g.drawImage(im2,ref1.getX(),ref1.getY()+10,40,50,null);
						}
						else if(ref1.im==24){
							im2=im.block;
							g.drawImage(im2,ref1.getX(),ref1.getY(),40,40,null);
						}
						
						else if(ref1.im==9){
							im2=im.block;
							g.drawImage(im2,ref1.getX(),ref1.getY(),40,40,null);
						}
						
						else if(ref1.im==8||ref1.im==21){
							
							im2=im.blockup;
							g.drawImage(im2,ref1.getX(),ref1.getY(),40,40,null);
						}
						
						else if(ref1.im==23){
							im2=im.tube;
							g.drawImage(im2,ref1.getX()-10,ref1.getY()-79,80,119,null);
						}
					
				}
				
				for(int i=0;i<enemy.enemy.size();i++){
					enemyref=enemy.enemy.get(i);
					if(enemyref.im==10){
						en=im.en[1];
						g.drawImage(en,enemyref.getX(),enemyref.getY(),70,70,null);
					}else if(enemyref.im==11){
						en=im.en[0];
						g.drawImage(en,enemyref.getX(),enemyref.getY(),70,70,null);
					}else if(enemyref.im==12){
						en=im.en[2];
						g.drawImage(en,enemyref.getX(),enemyref.getY(),70,70,null);
					}else if(enemyref.im==13){
						en=im.en[3];
						g.drawImage(en,enemyref.getX(),enemyref.getY(),70,70,null);
					}else if(enemyref.im==14){
						en=im.en[4];
						g.drawImage(en,enemyref.getX(),enemyref.getY(),70,70,null);
					}
					else if(enemyref.im==15){
						en=im.en[6];
						g.drawImage(en,enemyref.getX(),enemyref.getY(),70,70,null);
					}else if(enemyref.im==16){
						en=im.en[5];
						g.drawImage(en,enemyref.getX(),enemyref.getY(),70,70,null);
					}else if(enemyref.im==17){
						en=im.en[7];
						g.drawImage(en,enemyref.getX(),enemyref.getY(),70,70,null);
					}else if(enemyref.im==18){
						en=im.en[8];
						g.drawImage(en,enemyref.getX(),enemyref.getY(),70,70,null);
					}else if(enemyref.im==0){
						en=im.levelup;
						g.drawImage(en,enemyref.getX(),enemyref.getY(),55,55,null);
					}
					else if(enemyref.im==19){
						en=im.en[9];
						g.drawImage(en,enemyref.getX(),enemyref.getY(),70,70,null);
					}else if(enemyref.im==40){
						en=im.en[11];
						g.drawImage(en,enemyref.getX(),enemyref.getY(),70,70,null);
					}else if(enemyref.im==41){
						en=im.en[10];
						g.drawImage(en,enemyref.getX(),enemyref.getY(),70,70,null);
					}else if(enemyref.im==42){
						en=im.en[12];
						g.drawImage(en,enemyref.getX(),enemyref.getY(),70,70,null);
					}else if(enemyref.im==43){
						en=im.en[13];
						g.drawImage(en,enemyref.getX(),enemyref.getY(),70,70,null);
					}
					else if(enemyref.im==44){
						en=im.en[14];
						g.drawImage(en,enemyref.getX(),enemyref.getY(),70,70,null);
					}
					
				}
				
				
				for(int i=0;i<level.brickpeices.size();i++){
					ref1=level.brickpeices.get(i);
					if(ref1.im==30){
						g.drawImage(im.bkpr,ref1.getX(),ref1.getY(),30,30,null);
					}
					else{
						g.drawImage(im.bkpl,ref1.getX(),ref1.getY(),30,30,null);
					}
					
				}
					if(le.selected)	{
						if(le.selectid==1){
							icon=im.brick;
							g.drawImage(icon,mx-20,my-10,40,40,null);
						}else if(le.selectid==2){
							icon=im.block;
							g.drawImage(icon,mx-20,my-10,40,40,null);
						}else if(le.selectid==3){
							icon=im.blockup;
							g.drawImage(icon,mx-20,my-10,40,40,null);
						}else if(le.selectid==4){
							icon=im.blockup;
							g.drawImage(icon,mx-20,my-10,40,40,null);
						}else if(le.selectid==4){
							icon=im.coin;
							g.drawImage(icon,mx-20,my-10,40,40,null);
						}else if(le.selectid==7){
							icon=im.en[0];
							g.drawImage(icon,mx,my,70,70,null);
						}
						else if(le.selectid==8){
							icon=im.en[6];
							g.drawImage(icon,mx,my,70,70,null);
						}
						else if(le.selectid==6){
							icon=im.tube;
							g.drawImage(icon,mx-20,my-30,80,119,null);
						}
					}
					g.drawString("mx"+mx+"   my"+my,643, 32);
				g.drawImage(p1.getImage(),p1.getX(),p1.getY(),player.size+15,player.size+15,null);
				g.drawImage(im.leveleditor,1000,0,280,720,null);
				
				
				
			}
			
			
			g.dispose();
			bs.show();
		
			
		}


		
		public void mouseDragged(MouseEvent e) {
			mx=e.getX();
			my=e.getY();
			mousedraged=true;
			mouseclicked = true;
		}


		public void mouseMoved(MouseEvent e) {
			mx=e.getX();
			my=e.getY();
			mousedraged=false;
			mouseclicked = false;
			
		}


		public static void changeGameMode(int j, int k) {
			if(j==1&&k==2){
				totalFrameCount=0.0;
				loopsCount=0.0;
				e.reset();
			l1=new level((player)p1,e);
			GameMode=2;}
			else{
				p1.dead=true;
				
				l1=new level((player)p1,e);
				e.reset();
				 le=new levelEditor(l1,e);
				 ((player)p1).size=80;
					((player)p1).d=false;
				
				GameMode=3;
			}
		}


		public void mouseClicked(MouseEvent e) {
			mx=e.getX();
			my=e.getY();
			 mouseclicked = true;
			
		}


		
		public void mouseEntered(MouseEvent e) {
			
			
		}


		public void mouseExited(MouseEvent e) {
			
			
		}


	
		public void mousePressed(MouseEvent e) {
			
		}


		public void mouseReleased(MouseEvent e) {
			
			
			
		}



	

		
}


