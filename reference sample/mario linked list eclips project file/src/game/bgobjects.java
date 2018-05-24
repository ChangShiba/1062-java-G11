package game;


import java.util.LinkedList;

import game.enemy.levelupmush;



public class bgobjects extends gameObjects {
	public LinkedList<gameObjects> bgobject=new LinkedList<gameObjects>();
	
	public long ly;
	public boolean hit=false;
	public long pos;
	
	public bgobjects(int x, int y,int i,long levelx) {
		super(x, y);
		super.im=i;
		this.pos=levelx;
	ly=y;
	
	
	
	
	
		
	}
	public void genclouds(){
		
		
	}
	
public static void changepos(int l,int m,int y, boolean d){
	
	
		for(int i=0;i<level.size;i++){
			bgobjects tx=level.rlist.get(i);
			if(tx.getY()<y&&tx.getY()>y-80){
				if(l%600==(tx.pos/40)){
					if(tx.im!=9){
						if((tx.im!=8&&tx.im!=21)&&d){
						level.removecollision(l);
						sounds.bricksh.play();
						}else{
							sounds.bump.play();
						}
						if(!tx.hit){
							tx.setVY(-5);
							checkenemyabove(tx.getX(), y);
						tx.hit=true;}
					}if(tx.im==21){
						level.addenemy(tx.getX(),tx.getY()-60,tx.pos,3);
					}
					else if(tx.im==8){
						sounds.coinsound.play();
						level.addenemy(tx.getX(),tx.getY()-30,tx.pos,6);
					}
					}
				if(l!=m&&m%600==(tx.pos/40)){
					if(tx.im!=9){
						if((tx.im!=8&&tx.im!=21)&&d){
						level.removecollision(m);
						sounds.bricksh.play();}
						else{
							sounds.bump.play();
						}
						if(!tx.hit){
							tx.setVY(-5);
							checkenemyabove(tx.getX(), y);
						tx.hit=true;}
					}
						if(tx.im==21){
						level.addenemy(tx.getX(),tx.getY()-50,tx.pos,3);
					}
					else if(tx.im==8){
						sounds.coinsound.play();
						level.addenemy(tx.getX(),tx.getY()-30,tx.pos,6);
					}
				}
			}
			
		}
			
		
		
	}

private static void checkenemyabove(int x, int y) {
		gameObjects ref;
	for(int i=0;i<enemy.enemy.size();i++){
		ref=enemy.enemy.get(i);
		if((ref.getY()+90)>y&&(ref.getY()+40)<y){
			if((ref.getX()+70)>x&&(x+40)>ref.getX()){
				if(ref instanceof levelupmush){
					ref.setVX(-(ref.getVX()));
				}else{
				mario.score+=200;
				ref.dead=true;
				ref.setVY(-15);
				ref.setVX(2);
				ref.im=12;}
				
			}
		}
		
	}
	
}
	public void update(){
		setX((int) (pos-player.levelx));
		
		
		if(hit){
			
			setY((getY()+(int) getVY()));
			setVY(getVY()+1);
			
				
			if(getVY()>0&&getY()>=ly&&player.size==80&&im!=8&&im!=21){
				genbrickpieces();
				level.removebrick(this);
				
			}
			
			if(getVY()>3&&getY()>=ly){
				setVY(0);
				hit=false;
				setY((int) ly);
				if(im==8||im==21){
					im=9;
					
				}
			}
		
		
		
		}
	}
	
	public void genbrickpieces(){
		bgobjects brickpiece[]=new bgobjects[4];
		brickpiece[0]=new bgobjects(x,y,30,0);
		brickpiece[1]=new bgobjects(x+20,y,40,0);
		brickpiece[2]=new bgobjects(x,y+20,40,0);
		brickpiece[3]=new bgobjects(x+20,y+20,30,0);
		brickpiece[0].setVX(-3);
		brickpiece[1].setVX(3);
		brickpiece[2].setVX(-5);
		brickpiece[3].setVX(5);
		brickpiece[0].setVY(-8);
		brickpiece[2].setVY(-7);
		brickpiece[1].setVY(-8);
		brickpiece[3].setVY(-7);
		for(int i=0;i<4;i++){
		level.brickpeices.add(brickpiece[i]);}
	}
	
	public void brickpupdate(){
		x+=vx;
		x-=bx;
		y+=vy;
		vy=vy+1;
		if(y>750){
			level.removebrickp(this);
		}
	}

	
	public void bgupdate(){
		if(im==20){
		x-=(bx/4);}
		else if(im==25){
			x-=(bx/2);
		}
		else{
			x-=bx;
		}
		if(x<=(-800)){
			x=1600+(x-(-801));
		}

		if(x>(1600)){
			x=-800+(x-1601);}
	}
		
		
	

}
