package game;

import java.util.LinkedList;

import game.enemy.mushroom;

public class levelEditor {
	public LinkedList<bgobjects> backgroundobjects=new LinkedList<bgobjects>();
	private final int brick=1;
	private final int block=2;
	private final int coinblock=3;
	private final int levelupblock=4;
	private final int coin=5;
	private final int pipe=6;
	private final int enemymush=7;
	private final int enemybeetle=8;
	private level l;
	private enemy e;
	public static int id=0;
	 public int selectid=0;
	 public boolean selected=false;
	 int mx=0;
		int my=0;
	public levelEditor(level l1,enemy e){
		this.e=e;
		l=l1;
		gameObjects.collision= new LinkedList<Integer>();
		//for(int i=0;i<gameObjects.collision.;i++){
		for(int i=0;i<10800;i++){
			//gameObjects.collision[i]=false;
			//gameObjects.collision[i]=0;
			gameObjects.collision.add(0);
			
		}
		for(int m=0;m<18;m++){
			for(int n=0;n<600;n++){
		if(m==15){
			//gameObjects.collision[m*600+n]=true;}
			//gameObjects.collision[m*600+n]=1;}
		gameObjects.collision.set(m*600+n,1);}
		
			}
			
		}
			for(int n=599;n>=0;n--){
				for(int m=17;m>=0;m--){
					
					if(m==15){
						if(n%4==0){
							l1.frontobjects.add(new bgobjects(600, m*40, 1,n*40));}
							else if(n%4==1){
								l1.frontobjects.add(new bgobjects(600, m*40, 4,n*40));
							}else if(n%4==2){
								l1.frontobjects.add(new bgobjects(600, m*40, 6,n*40));
							}else{
								l1.frontobjects.add(new bgobjects(600, m*40, 7,n*40));
							}
						
						
						
						
						l1.size1++;
						l1.next++;
					}
					
		if(m>15&&m<18){
				if(n%4==0){
						l1.frontobjects.add(new bgobjects(600, m*40, 3,n*40));}
						else if(n%4==1){
							l1.frontobjects.add(new bgobjects(600, m*40, 5,n*40));
						}else if(n%4==2){
							l1.frontobjects.add(new bgobjects(600, m*40, 26,n*40));
						}else {
							l1.frontobjects.add(new bgobjects(600, m*40, 27,n*40));
						}
					
					l1.size1++;
					l1.next++;
				}
			}
			
			
		}
	}
	
	public void update(int mx,int my,boolean draged ){
		this.mx=mx;
		this.my=my;
		if(draged&&!selected){
			selectid=id;
			selected=true;
		}else if(!draged&&selected&&mx<1000){
			if(my>90){
			addobject(selectid);}
			selected=false;
		}
		
		
		
	}
	public void addobject(int id){
		int x=(int)(mx/40);
		int y=(int)(my/40);
		int m=(int)(player.levelx/40);
		int c=y*600+x+m;
		if(id==brick){
			if(gameObjects.collision.get(c)==1){
				//if(gameObjects.collision[c]==1){
			}else{
			//gameObjects.collision[c]=1;
			gameObjects.collision.set(c,1);
			//gameObjects.collision[c]=true;
			level.rlist.add(new bgobjects(x*40, y*40, 2,(x+m)*40));
			level.size++;}
		}else if(id==block){
			if(gameObjects.collision.get(c)==1){
				//if(gameObjects.collision[c]==1){
			}else{
			//gameObjects.collision[y*600+x+m]=true;
			//gameObjects.collision[y*600+x+m]=1;
			gameObjects.collision.set(y*600+x+m,1);
			level.rlist.add(new bgobjects(x*40, y*40, 9,(x+m)*40));
			level.size++;}
		}else if(id==coinblock){
			if(gameObjects.collision.get(c)==1){
			}else{
			//gameObjects.collision[y*600+x+m]=true;
			//gameObjects.collision[y*600+x+m]=1;
			gameObjects.collision.set(y*600+x+m,1);
			level.rlist.add(new bgobjects(x*40, y*40, 8,(x+m)*40));
			level.size++;}
		}else if(id==levelupblock){
			if(gameObjects.collision.get(c)==1){
			}else{
			//gameObjects.collision[y*600+x+m]=true;
			//gameObjects.collision[y*600+x+m]=1;
			gameObjects.collision.set(y*600+x+m,1);
			level.rlist.add(new bgobjects(x*40, y*40, 21,(x+m)*40));
			level.size++;}
		}else if(id==pipe){
			//if(gameObjects.collision[c]==1||my>518){
				if(gameObjects.collision.get(c)==1||my>518){
			}else{
			//gameObjects.collision[(y)*600+x+m]=true;
				gameObjects.collision.set((y)*600+x+m,1);
			//gameObjects.collision[(y)*600+x+m]=1;
			//gameObjects.collision[(y+1)*600+x+m]=true;
				gameObjects.collision.set((y+1)*600+x+m,1);
			//gameObjects.collision[(y+1)*600+x+m]=1;
			//gameObjects.collision[(y+2)*600+x+m]=true;
			gameObjects.collision.set((y+2)*600+x+m,1);
			//gameObjects.collision[(y+2)*600+x+m]=1;
			level.rlist.add(new bgobjects(600, (y+2)*40, 23,(x+m)*40));
			level.size++;}
		}else if(id==enemymush){
			e.addenemy(mx,my,(player.levelx+mx),1);
		}
		else if(id==enemybeetle){
			e.addenemy(mx,my,(player.levelx+mx),2);
		}
	}
	
	
	
	
	
	
}
