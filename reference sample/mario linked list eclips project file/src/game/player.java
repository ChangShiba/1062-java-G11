package game;


import java.awt.Image;




import javax.swing.ImageIcon;

public class player extends gameObjects{
	

	public static long displacement=0;
	public static int size=60;
	private Image[] imrr =new Image[12];
	private Image[] imlr =new Image[12];
	private Image imr ;
	private Image iml ;
	private Image imd ;
	private Image imjl ;
	private Image imjr ;
	int t=0;
	int u=0;
	boolean d=false;
	Image im;
	long a=x+80;
	long b=y+80;
	
	
	public player( int x, int y,level l) {
		super( x, y);
		
	
		for(int i=0;i<12;i++){
		imrr[i] = new ImageIcon(getClass().getResource("/player/rr"+(i+1)+".png")).getImage();
		}

		for(int i=0;i<12;i++){
		imlr[i] =  new ImageIcon(getClass().getResource("/player/lr"+(i+1)+".png")).getImage();
		}	
		
		iml = new ImageIcon(getClass().getResource("/player/sr.png")).getImage();
		imr = new ImageIcon(getClass().getResource("/player/sl.png")).getImage();
		imjl =new ImageIcon(getClass().getResource("/player/jl.png")).getImage();
		imjr =new ImageIcon(getClass().getResource("/player/jr.png")).getImage();
		imd= new ImageIcon(getClass().getResource("/player/rr7.png")).getImage();
	}
	
	public Image getImage() {
		

	
		return im;
	
		
	}
	public void update(int i) {
		a=x+size;
		b=y+size;
		
		
		
		if(b<=700&&y>=-20&&!dead){
			if(vx>0){	
						
				//when player run right check collision with background objects
				int l=(int)(((int)(b/40))*600+((int)(levelx+a+20))/40);
				int m=(int)(((int)(y/40))*600+((int)(levelx+a+20))/40);
				int n=(int)(((int)((y+40)/40))*600+((int)(levelx+a+20))/40);
				
				//if(gameObjects.collision[l]||gameObjects.collision[n]||gameObjects.collision[m]){
				//if((gameObjects.collision[l]==1)||(gameObjects.collision[n]==1)||(gameObjects.collision[m]==1)){
							if((gameObjects.collision.get(l)==1)||(gameObjects.collision.get(n)==1)||(gameObjects.collision.get(m)==1)){
							vx=0;
						}
				
						
				//when player run left check collision with background objects
				}else{
					int l=(int)(((int)(y/40))*600+((int)(levelx+x-20))/40);
					int m=(int)(((int)(b/40))*600+((int)(levelx+x-20))/40);
					int n=(int)(((int)((y+40)/40))*600+((int)(levelx+x-20))/40);
					//if(gameObjects.collision[l]||gameObjects.collision[n]||gameObjects.collision[m]){
					//if((gameObjects.collision[l]==1)||(gameObjects.collision[n]==1)||(gameObjects.collision[m]==1)){
						if((gameObjects.collision.get(l)==1)||(gameObjects.collision.get(n)==1)||(gameObjects.collision.get(m)==1)){
						vx=0;
					}
				}
			
			//when player jump up check collision with background objects
			if(vy<0){
					int l=(int)(((int)((y+10)/40))*600+((int)(levelx+x+22))/40);
					int m=(int)(((int)((y+10)/40))*600+((int)(levelx+a-22))/40);
					
					//if(gameObjects.collision[l]||gameObjects.collision[m]){
					//if((gameObjects.collision[l]==1)||(gameObjects.collision[m]==1)){
						if((gameObjects.collision.get(l)==1)||(gameObjects.collision.get(m)==1)){
						vy=0;
						falling=true;
						if(size==80){
							d=true;
						}      
						bgobjects.changepos(l,m,y,d);
					}
			}
			
			//when player fall down check collision with background objects
			else{
				int l=(int)(((int)((b+15)/40))*600+((int)(levelx+x+24))/40);
				int m=(int)(((int)((b+15)/40))*600+((int)(levelx+a-24))/40);
				
				//if(gameObjects.collision[l]||gameObjects.collision[m]){
				//if((gameObjects.collision[l]==1)||(gameObjects.collision[m]==1)){
					if((gameObjects.collision.get(l)==1)||(gameObjects.collision.get(m)==1)){
					vy=0;
					jumping=false;
					falling=false;
				}
				else{
					falling=true;
				}
			}
		
		}
		
		displacement=levelx%40;
		
		// player fall down end the game
		if(y>720){
			if(!dead){
				dead=true;
				vx=0;
				sounds.mdead.play();}
			
		}
		
		if(i==0){
			im=iml;
		}
		else if(i==1){
			
			im=imr;
		}
		
		else if(i==2){
			im=imlr[t];
			u++;
			
			if(u==3){
				t++;
				u=0;
			}
			if(t==12){
				t=0;
			}
		}
			
		else if(i==3){
			
			im=imrr[t];
			u++;
			
			if(u==3){
				t++;
				u=0;
			}
			if(t==12){
				t=0;
			}
		}
		
		else if(i==4){
			
			im=imjr;
		}
		else if(i==5){
			im=imjl;
		}
		
		if(dead){
			sounds.levelsound.stop();
			if(vy<0){
				vy=vy+1;}
			else{
				vy=8;
			}
			im=imd;
		}
		
		
		y+=vy;
		if(vy!=0){
			vy+=1;
		}
		if(x<-10){
			x=-10;
			bx=vx;
		}
		if(x>=600 && vx>0&&levelx<22720){
			bx=vx;
			levelx+=vx;
		}
		else if(x<=550 && vx<0&& levelx>0){
			bx=vx;
			levelx+=vx;
		}
		else{
			x+=vx;
			bx=0;
		}
		
	}

}
