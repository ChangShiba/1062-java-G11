package game;

import java.util.LinkedList;

public class enemy {
	
	
	
	public static LinkedList<gameObjects> enemy=new LinkedList<gameObjects>();
	public static LinkedList<gameObjects> frontenemy=new LinkedList<gameObjects>();
	public static LinkedList<gameObjects> backenemy=new LinkedList<gameObjects>();
	gameObjects ref;
	int front=-1;
	int back=-1;
	int t=0;
	player p;

	public enemy(player p1){
		p=p1;
		
		
	}
	public void reset(){
		enemy.clear();
		frontenemy.clear();
		backenemy.clear();
		front=-1;
		back=-1;
	}
	public void addenemy(int x,int y,long pos,int id){
		if(id==1){
		frontenemy.add(new mushroom(x,y,pos));
		front++;}
		else if(id==2){
			frontenemy.add(new beetle(x,y,pos));
			front++;
		}else if(id==3){
			frontenemy.add(new levelupmush(x,y,pos));
			front++;
		}else if(id==4){
			frontenemy.add(new turtle(x,y,pos));
			front++;
		}else if(id==5){
		
			frontenemy.add(new coin(x,y,pos));
			front++;
			
		}else if(id==6){
		
			frontenemy.add(new coin(x,y,pos));
			
			front++;
			((coin)frontenemy.get(front)).brickcoin=true;
			
		}
		
	}
	public void removenemy(gameObjects g){
		enemy.remove(g);
	}
	public void updatelevele(){
		if(front>-1){
		ref=frontenemy.get(front);
		while(ref.pos<gameObjects.levelx+1300){
			enemy.add(ref);
			frontenemy.remove(front);
			front--;
			if(front==-1){
				break;
			}else{
				ref=frontenemy.get(front);
			}
		}}
		if(back>-1){
		ref=backenemy.get(back);
		while(ref.pos>gameObjects.levelx-20){
			enemy.add(ref);
			backenemy.remove(back);
			
			back--;
			if(back==-1){
				break;
			}else{
				ref=backenemy.get(back);
			}
		}}
		
	
		for(int i=0;i<enemy.size();i++){
			ref=enemy.get(i);
			if(ref.pos>(gameObjects.levelx+1300)){
				frontenemy.add(ref);
				front++;
				enemy.remove(i);
				i--;
				
			}else if(ref.pos<(gameObjects.levelx-20)){
				backenemy.add(ref);
				enemy.remove(i);
				back++;
				i--;
			}
		}
		
		for(int i=(enemy.size()-1);i>=0;i--){
			ref=enemy.get(i);
			if(ref instanceof mushroom){
				((mushroom)ref).update();
				
			}
			else if(ref instanceof beetle){
				((beetle)ref).update();
				
			}else if(ref instanceof levelupmush){
				((levelupmush)ref).update();
			}
			else if(ref instanceof turtle){
				((turtle)ref).update();
			}else if(ref instanceof coin){
				((coin)ref).update();
			}
		}
		
		
		
		
		
	}
	
	
	
	
	public void update(){
		if(front>-1){
		ref=frontenemy.get(front);
		while(ref.pos<gameObjects.levelx+1300){
			enemy.add(ref);
			frontenemy.remove(front);
			front--;
			if(front==-1){
				break;
			}else{
				ref=frontenemy.get(front);
			}
		}}
		if(back>-1){
		ref=backenemy.get(back);
		while(ref.pos>gameObjects.levelx-20){
			enemy.add(ref);
			backenemy.remove(back);
			
			back--;
			if(back==-1){
				break;
			}else{
				ref=backenemy.get(back);
			}
		}}
		
	
		for(int i=0;i<enemy.size();i++){
			ref=enemy.get(i);
			if(ref.pos>(gameObjects.levelx+1300)){
				frontenemy.add(ref);
				front++;
				enemy.remove(i);
				i--;
				
			}else if(ref.pos<(gameObjects.levelx-20)){
				backenemy.add(ref);
				enemy.remove(i);
				back++;
				i--;
			}
		}
		
		
		
		
		for(int i=(enemy.size()-1);i>=0;i--){
			ref=enemy.get(i);
			if(ref instanceof mushroom){
				((mushroom)ref).update();
				((mushroom)ref).checkcollision();
			}
			else if(ref instanceof beetle){
				((beetle)ref).update();
				((beetle)ref).checkcollision();
			}else if(ref instanceof levelupmush){
				((levelupmush)ref).update();
			}else if(ref instanceof turtle){
				((turtle)ref).update();
				((turtle)ref).checkcollision();
			}
			else if(ref instanceof coin){
				((coin)ref).update();}
		}
	}
	
	
	
	class mushroom extends gameObjects{
		int a=0;
		int b=0;
		int n=0;
		int m=0;
		
	
		public mushroom(int x, int y,long pos) {
			super(x, y);
			super.pos=pos;
			vx=-3;
			dead=false;
			im=10;
			
		}
		
		public void checkcollision(){
			if(y<620&&!dead){
			if(!p.dead){
				if((p.getY()+10+p.size)<(y+40)&&(p.getY()+10+p.size)>y){
					if((p.getX()+70>x&&p.getX()<x)||(p.getX()>x&&p.getX()<(x+60))){
						dead=true;
						sounds.ecrush.play();
						mario.score+=200;
						vy=0;
						vx=0;
						im=13;
						p.jumping=true;
						p.falling=false;
						p.setVY(-13);
						
					}
				}
				else if((p.getY()+p.size)>(y+40)&&p.getY()<(y+70)){
					if((p.getX()+80>x&&p.getX()<x)||(p.getX()>x&&p.getX()<(x+80))){
						p.dead=true;
						sounds.mdead.play();
						p.setVY(-20);
						p.setVX(0);
						
					}
				}
				}
			}
			
		}
		
		
		public void update() {
			a=x+80;
			b=y+80;
			
			if(y>800){
				dead=true;
				removenemy(this);
			}
			
			if(y<620&&!dead){
				
				int v=(int)(((int)((b-10)/40))*600+((int)(levelx+x+20))/40);
				int c=(int)(((int)((b-10)/40))*600+((int)(levelx+a-20))/40);
				//if((gameObjects.collision[v]==1)||(gameObjects.collision[c]==1)){
					if((gameObjects.collision.get(v)==1)||(gameObjects.collision.get(c)==1)){
					
					vy=0;
					falling=false;
				}
				else{
					vy=8;
					falling=true;
				}
			if(vx>0){
					
					m=(int)(((int)(y/40))*600+((int)(levelx+a+20))/40);
					n=(int)(((int)((y+40)/40))*600+((int)(levelx+a+20))/40);
					//if((gameObjects.collision[n]==1)||(gameObjects.collision[m]==1)){
							if((gameObjects.collision.get(n)==1)||(gameObjects.collision.get(n)==1)){
								vx=-3;
								im=10;
							}
					
			}else{
					m=(int)(((int)(y/40))*600+((int)(levelx+x-20))/40);
				
					n=(int)(((int)((y+40)/40))*600+((int)(levelx+x-20))/40);
					//if((gameObjects.collision[m]==1)||(gameObjects.collision[n]==1)){
						if((gameObjects.collision.get(m)==1)||(gameObjects.collision.get(n)==1)){
						vx=3;
						im=11;
					}
			}
		
			
				
			}
			if(dead){
				
				if(vy<8&&im==12){
					vy+=2;
				}else if(im==13){
					t++;
					if(t==40){
						t=0;
						removenemy(this);
							
					}
				}
				
				
				
				
			}
			
			
			x+=vx;
			x-=bx;
			pos=levelx+x;
			y+=vy;
			
			}
			
			
			
		
		
		
	}
	
	class beetle extends gameObjects{
		int a=0;
		int b=0;
		int n=0;
		int m=0;
		
	
		public beetle(int x, int y,long pos) {
			super(x, y);
			super.pos=pos;
			vx=-3;
			dead=false;
			im=15;
			
		}
		
		public void checkcollision(){
			if(!p.dead){
				if((p.getY()+90)<(y+30)&&(p.getY()+90)>y){
					if((p.getX()+70>x&&p.getX()<x)||(p.getX()>x&&p.getX()<(x+60))){
						sounds.ecrush.play();
						mario.score+=200;
						vy=0;
						vx=0;
						im=18;
						p.jumping=true;
						p.falling=false;
						p.setVY(-13);
						p.setY(y-90);
						
						
					}
				}
				else if((p.getY()+80)>(y+40)&&p.getY()<(y+70)){
					if((p.getX()+80>x&&p.getX()<x)||(p.getX()>x&&p.getX()<(x+80))){
						sounds.mdead.play();
							p.dead=true;
							p.setVY(-20);
							p.setVX(0);
						
						
						
					}
				}
				}
		}
		
		public void update() {
			a=x+80;
			b=y+80;
			if(y>800){
				removenemy(this);
			}
			if(!dead){
			
			
			
			if(y<620&&im!=18){
				
				int v=(int)(((int)((b-10)/40))*600+((int)(levelx+x+20))/40);
				int c=(int)(((int)((b-10)/40))*600+((int)(levelx+a-20))/40);
				//if((gameObjects.collision[v]==1)||(gameObjects.collision[c]==1)){
				//if((gameObjects.collision[v]==1)||(gameObjects.collision[c]==1)){
					if((gameObjects.collision.get(v)==1)||(gameObjects.collision.get(c)==1)){
						
					
					vy=0;
					falling=false;
				}
				else{
					vy=8;
					falling=true;
				}
			if(vx>0){
					
					m=(int)(((int)(y/40))*600+((int)(levelx+a+20))/40);
					n=(int)(((int)((y+40)/40))*600+((int)(levelx+a+20))/40);
							//if((gameObjects.collision[n]==1)||(gameObjects.collision[m]==1)){
							if((gameObjects.collision.get(n)==1)||(gameObjects.collision.get(m)==1)){
								if(im==19){
									vx=-8;
								}else{vx=-3;
								}
							}
					
			}else{
					m=(int)(((int)(y/40))*600+((int)(levelx+x-20))/40);
				
					n=(int)(((int)((y+40)/40))*600+((int)(levelx+x-20))/40);
					//if((gameObjects.collision[m]==1)||(gameObjects.collision[n]==1)){
					if((gameObjects.collision.get(m)==1)||(gameObjects.collision.get(n)==1)){
						if(im==19){
							vx=8;
						}else{
						vx=3;}
						
					}
				}
				
			}
			if(im==18){
				if((p.getY()+90)<(y+40)&&(p.getY()+90)>y&&p.falling){
					if((p.getX()+70>x&&p.getX()<x)||(p.getX()>x&&p.getX()<(x+60))){
						vx=-8;
						im=19;
						x=p.getX()-80;
					}
					}
				else if((p.getY()+80)>(y+40)&&p.getY()<(y+70)){
					if((p.getX()+80>x&&p.getX()<x)||(p.getX()>x&&p.getX()<(x+80))){
						im=19;
					if(p.getVX()>0){
						vx=8;
						x=p.getX()+90;
					}else{
						vx=-8;
						x=p.getX()-80;
					}
						
					}
				}
			}
			
		}
			if(im==19){
				
			}
			else if(vx<0){
				im=15;
			}else if(vx>0){
				im=16;
			}
			
			if(dead){
				im=17;
				
				if(vy<8){
					vy+=2;
				}
				
				
			}
			
			
			x+=vx;
			x-=bx;
			pos=levelx+x;
			y+=vy;
			
		}
				
		
	}
	class turtle extends gameObjects{
		int a=0;
		int b=0;
		int n=0;
		int m=0;
		
	
		public turtle(int x, int y,long pos) {
			super(x, y);
			super.pos=pos;
			vx=-3;
			dead=false;
			im=41;
			
		}
		
		public void checkcollision(){
			if(!p.dead){
				if((p.getY()+90)<(y+30)&&(p.getY()+90)>y){
					if((p.getX()+70>x&&p.getX()<x)||(p.getX()>x&&p.getX()<(x+60))){
						sounds.ecrush.play();
						mario.score+=200;
						vy=0;
						vx=0;
						im=43;
						p.jumping=true;
						p.falling=false;
						p.setVY(-13);
						p.setY(y-90);
						
						
					}
				}
				else if((p.getY()+80)>(y+40)&&p.getY()<(y+70)){
					if((p.getX()+80>x&&p.getX()<x)||(p.getX()>x&&p.getX()<(x+80))){
						sounds.mdead.play();
							p.dead=true;
							p.setVY(-20);
							p.setVX(0);
						
						
						
					}
				}
				}
		}
		
		public void update() {
			a=x+80;
			b=y+80;
			if(y>800){
				removenemy(this);
			}
			if(!dead){
			
			
			
			if(y<620&&im!=43){
				
				int v=(int)(((int)((b-10)/40))*600+((int)(levelx+x+20))/40);
				int c=(int)(((int)((b-10)/40))*600+((int)(levelx+a-20))/40);
				//if((gameObjects.collision[v]==1)||(gameObjects.collision[c]==1)){
					if((gameObjects.collision.get(v)==1)||(gameObjects.collision.get(c)==1)){
					
					vy=0;
					falling=false;
				}
				else{
					vy=8;
					falling=true;
				}
			if(vx>0){
					
					m=(int)(((int)(y/40))*600+((int)(levelx+a+20))/40);
					n=(int)(((int)((y+40)/40))*600+((int)(levelx+a+20))/40);
							//if((gameObjects.collision[n]==1)||(gameObjects.collision[m]==1)){
							if((gameObjects.collision.get(n)==1)||(gameObjects.collision.get(m)==1)){
								if(im==44){
									vx=-8;
								}else{vx=-3;
								}
							}
					
			}else{
					m=(int)(((int)(y/40))*600+((int)(levelx+x-20))/40);
				
					n=(int)(((int)((y+40)/40))*600+((int)(levelx+x-20))/40);
					//if((gameObjects.collision[m]==1)||(gameObjects.collision[n]==1)){
					if((gameObjects.collision.get(m)==1)||(gameObjects.collision.get(n)==1)){
						if(im==44){
							vx=8;
						}else{
						vx=3;}
						
					}
				}
				
			}
			if(im==43){
				if((p.getY()+90)<(y+40)&&(p.getY()+90)>y&&p.falling){
					if((p.getX()+70>x&&p.getX()<x)||(p.getX()>x&&p.getX()<(x+60))){
						vx=-8;
						im=44;
						x=p.getX()-80;
					}
					}
				else if((p.getY()+80)>(y+40)&&p.getY()<(y+70)){
					if((p.getX()+80>x&&p.getX()<x)||(p.getX()>x&&p.getX()<(x+80))){
						im=44;
					if(p.getVX()>0){
						vx=8;
						x=p.getX()+90;
					}else{
						vx=-8;
						x=p.getX()-80;
					}
						
					}
				}
			}
			
		}
			if(im==44){
				
			}
			else if(vx<0){
				im=40;
			}else if(vx>0){
				im=41;
			}
			
			if(dead){
				im=42;
				
				if(vy<8){
					vy+=2;
				}
				
				
			}
			
			
			x+=vx;
			x-=bx;
			pos=levelx+x;
			y+=vy;
			
		}
	}
	class levelupmush extends gameObjects{

	
		int a=0;
		int b=0;
		int n=0;
		int m=0;
		
	
		public levelupmush(int x, int y,long pos) {
			
			super(x, y);
			super.pos=pos;
			vx=3;
			dead=false;
			im=0;
			
		}
		
		
		public void update() {
			a=x+60;
			b=y+60;
			
			if(y>800){
				dead=true;
				removenemy(this);
			}
			
			if(y<620){
				
				if((p.getY()+60)<(y+40)&&(p.getY()+60)>y){
					if((p.getX()+70>x&&p.getX()<x)||(p.getX()>x&&p.getX()<(x+60))){
						dead=true;
						
						p.size=80;
						sounds.pupsound.play();
						p.setY(p.getY()-20);
					}
				}
				else if(p.getY()>(y+40)&&p.getY()<y){
					if((p.getX()+80>x&&p.getX()<x)||(p.getX()>x&&p.getX()<(x+80))){
						dead=true;
						p.size=80;	
						sounds.pupsound.play();
						p.setY(p.getY()-20);     
					}
				}
				}
				int v=(int)(((int)((b-10)/40))*600+((int)(levelx+x+20))/40);
				int c=(int)(((int)((b-10)/40))*600+((int)(levelx+a-20))/40);
				//if((gameObjects.collision[v]==1)||(gameObjects.collision[c]==1)){
					if((gameObjects.collision.get(v)==1)||(gameObjects.collision.get(c)==1)){
					
					vy=0;
					falling=false;
				}
				else{
					vy=8;
					falling=true;
				}
			if(vx>0){
					
					m=(int)(((int)(y/40))*600+((int)(levelx+a+20))/40);
					n=(int)(((int)((y+40)/40))*600+((int)(levelx+a+20))/40);
					//if((gameObjects.collision[n]==1)||(gameObjects.collision[m]==1)){
					if((gameObjects.collision.get(n)==1)||(gameObjects.collision.get(m)==1)){
								vx=-3;
					}
					
			}else{
					m=(int)(((int)(y/40))*600+((int)(levelx+x-20))/40);
				
					n=(int)(((int)((y+40)/40))*600+((int)(levelx+x-20))/40);
					//if((gameObjects.collision[m]==1)||(gameObjects.collision[n]==1)){
					if((gameObjects.collision.get(m)==1)||(gameObjects.collision.get(n)==1)){
						vx=3;
						
					}
			}
		
			
				
			
			if(dead){
						removenemy(this);
							
				
			}
			
			
			x+=vx;
			x-=bx;
			pos=levelx+x;
			y+=vy;
			
			}
			
			
			
		
		
		
	
		
		
		
		
	}
class coin extends gameObjects{
		
		
	boolean brickcoin=false;
	int time=0;
		int a=0;
		int b=0;
		int n=0;
		int m=0;
	
	public coin(int x, int y,long pos) {
		
		super(x, y);
	
		super.pos=pos;
		vx=0;
		dead=false;
		im=50;
		
	}
	
	
	public void update() {
		a=x+60;
		b=y+60;
		
	
		
		if(y<620){
			
			if((p.getY()+60)<(y+40)&&(p.getY()+60)>y){
				if((p.getX()+70>x&&p.getX()<x)||(p.getX()>x&&p.getX()<(x+60))){
					dead=true;
					

					mario.score+=100;
					sounds.coinsound.play();
					
				}
			}
			else if(p.getY()>(y+40)&&p.getY()<y){
				if((p.getX()+80>x&&p.getX()<x)||(p.getX()>x&&p.getX()<(x+80))){
					dead=true;

					mario.score+=100;
					sounds.coinsound.play();
				
				}
			}
			}
		
		if(dead){
					removenemy(this);
						
			
		}
		if(brickcoin){
			vy=-4;
			time++;
			if(time==10){
				enemy.remove(this);
			}
		}
		
		
		y+=vy;
		x-=bx;
		pos=levelx+x;
		
		
		}
		
		
		
	
	
	

	
	
	
	
}
	
}
