package game;

import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;

import javax.swing.ImageIcon;





public class level {
	
	
	
	public static LinkedList<bgobjects> brickpeices=new LinkedList<bgobjects>();
	public LinkedList<bgobjects> frontobjects=new LinkedList<bgobjects>();
	public LinkedList<bgobjects> backobjects=new LinkedList<bgobjects>();
	public static LinkedList<bgobjects> rlist=new LinkedList<bgobjects>();
	private bgobjects ref;
	private static enemy enemyref;
	
	int next=-1;
player p1;
	int back=-1;
	int m=0;

	public static int size=0;
	int size1=0;
	
	
	public level(player p1,enemy en){
		enemyref=en;
		this.p1=p1;
		resetlevel();
		
	}
	
	
	public  void resetlevel(){
		
		mario.score=0;
		
		player.size=60;
		p1.dead=false;
		p1.setX(300);
		p1.setY(400);
		p1.levelx=0;
		p1.d=false;
		enemy.enemy.clear();
		enemy.backenemy.clear();
		enemy.frontenemy.clear();
		frontobjects.clear();
		backobjects.clear();
		rlist.clear();
		 next=-1;
		 back=-1;
		 m=0;
		 size=0;
		 size1=0;
		
		
		enemyref.addenemy(1299,530,4050,1);
		enemyref.addenemy(1299,530,3500,4);
		enemyref.addenemy(1299,530,3400,5);
		enemyref.addenemy(1299,530,3200,5);
		enemyref.addenemy(1299,450,3000,5);
		enemyref.addenemy(1299,450,2400,5);
		enemyref.addenemy(1299,450,2150,5);
		
		enemyref.addenemy(1299,530,2100,5);
	
		gameObjects.collision= new LinkedList<Integer>();
		for(int i=0;i<10800;i++){
			//for(int i=0;i<gameObjects.collision.length;i++){
			//gameObjects.collision[i]=false;
			//gameObjects.collision[i]=0;
			///gameObjects.collision.set(i, 0);
				gameObjects.collision.add(0);
		}
			
			for(int m=0;m<18;m++){
				for(int n=0;n<600;n++){
					if(m>11&&m<15){
						if(n>38&&n<41){
						//gameObjects.collision[m*600+n]=true;}
						//gameObjects.collision[m*600+n]=1;}
							gameObjects.collision.set(m*600+n,1);}
						if(n>79&&n<81){
							//gameObjects.collision[m*600+n]=true;}
							//gameObjects.collision[m*600+n]=1;}
						gameObjects.collision.set(m*600+n,1);}
						if(n>93&&n<95){
							//gameObjects.collision[m*600+n]=true;
							//gameObjects.collision[m*600+n]=1;
							gameObjects.collision.set(m*600+n,1);
						}if(n>137&&n<139){
							//gameObjects.collision[m*600+n]=true;
							//gameObjects.collision[m*600+n]=1;
							gameObjects.collision.set(m*600+n,1);
						}
						if(n>167&&n<169){
							//gameObjects.collision[m*600+n]=1;
							gameObjects.collision.set(m*600+n,1);
							//gameObjects.collision[m*600+n]=true;
						}
					}
					
					
					if(m==10){
						if(n>20&&n<30){
						//gameObjects.collision[m*600+n]=true;}
						//gameObjects.collision[m*600+n]=1;}
							gameObjects.collision.set(m*600+n,1);}
						
						if(n>144&&n<162){
							//gameObjects.collision[m*600+n]=true;
							//gameObjects.collision[m*600+n]=1;
							gameObjects.collision.set(m*600+n,1);
						}
					}
					
					if(m==6){
						if(n>22&&n<28){
							//gameObjects.collision[m*600+n]=true;}
							gameObjects.collision.set(m*600+n,1);}
							//gameObjects.collision[m*600+n]=1;}
							
						if(n>146&&n<160){
							//gameObjects.collision[m*600+n]=1;
							gameObjects.collision.set(m*600+n,1);
							//gameObjects.collision[m*600+n]=true;
						}
					}
					if(m==14&&n==50){
						//gameObjects.collision[m*600+n]=1;
						gameObjects.collision.set(m*600+n,1);
						//gameObjects.collision[m*600+n]=true;
					}
					if(m==14&&n==113){
						//gameObjects.collision[m*600+n]=1;
						gameObjects.collision.set(m*600+n,1);
						//gameObjects.collision[m*600+n]=true;
					}
					if(n==60&&m<15&&m>11){
						//gameObjects.collision[m*600+n]=true;
						gameObjects.collision.set(m*600+n,1);
						//gameObjects.collision[m*600+n]=1;
					}
					
				
					if(m==15){
						if(n>40&&n<50){}
						else if(n>60&&n<70){}
						else if(n>113&&n<124){}
						else if(n>124&&n<134){}
						else{
							
							//gameObjects.collision[m*600+n]=1;}
						gameObjects.collision.set(m*600+n,1);}
							//gameObjects.collision[m*600+n]=true;}
						
					}
				}
			
		}
		

			
				for(int n=599;n>=0;n--){
					for(int m=17;m>=0;m--){
						
						if(m==10&&n>20&&n<30){
							if(n==22){
								frontobjects.add(new bgobjects(600, m*40, 8,n*40));
								size1++;
								next++;
							}
							else if(n==27){
							frontobjects.add(new bgobjects(600, m*40, 21,n*40));
							size1++;
							next++;}
							else{
								frontobjects.add(new bgobjects(600, m*40, 2,n*40));
								size1++;
								next++;
							}
						}
						
						if(m==10&&n>144&&n<162){
							
							if(n==148||n==149||n==157){
								frontobjects.add(new bgobjects(600, m*40, 8,n*40));
								size1++;
								next++;
							}else{
							frontobjects.add(new bgobjects(600, m*40, 2,n*40));
							size1++;
							next++;}
						}
							if(m==6){
									if(n>146&&n<160){
							
							if(n==150||n==151){
								frontobjects.add(new bgobjects(600, m*40, 8,n*40));
								size1++;
								next++;
							}else{
							frontobjects.add(new bgobjects(600, m*40, 2,n*40));
							size1++;
							next++;}
						}else if(n>22&&n<28){
							if(n==24||n==25){
								frontobjects.add(new bgobjects(600, m*40, 8,n*40));
								size1++;
								next++;
							}else{
							frontobjects.add(new bgobjects(600, m*40, 2,n*40));
							size1++;
							next++;}
						}
									
							}
							
							if(m==6&&n>146&&n<160){
								
								if(n==150||n==151){
									frontobjects.add(new bgobjects(600, m*40, 8,n*40));
									size1++;
									next++;
								}else{
								frontobjects.add(new bgobjects(600, m*40, 2,n*40));
								size1++;
								next++;}
							}
						
						// placing pipes
						if(m==14){
							if(n==39||n==94||n==138||n==80||n==168){
							frontobjects.add(new bgobjects(600, m*40, 23,n*40));
							size1++;
							next++;
						}
						
						if(n==50||n==113){
							frontobjects.add(new bgobjects(600, m*40, 24,n*40));
							size1++;
							next++;
						}
						
						}
						if(n==60&&m<15&&m>11){
							frontobjects.add(new bgobjects(600, m*40, 24,n*40));
							size1++;
							next++;
						}
						
						if(n>40&&n<50){}
						else if(n>60&&n<70){}
						else if(n>113&&n<124){}
						else if(n>124&&n<134){}
						else if(m==15){
						if(n%4==0){
							frontobjects.add(new bgobjects(600, m*40, 1,n*40));}
							else if(n%4==1){
								frontobjects.add(new bgobjects(600, m*40, 4,n*40));
							}else if(n%4==2){
								frontobjects.add(new bgobjects(600, m*40, 6,n*40));
							}else{
								frontobjects.add(new bgobjects(600, m*40, 7,n*40));
							}
						
						
						
						
						size1++;
						next++;
					}else if(m>15&&m<18){
						if(n%4==0){
							frontobjects.add(new bgobjects(600, m*40, 3,n*40));}
							else if(n%4==1){
								frontobjects.add(new bgobjects(600, m*40, 5,n*40));
							}else if(n%4==2){
								frontobjects.add(new bgobjects(600, m*40, 26,n*40));
							}else {
								frontobjects.add(new bgobjects(600, m*40, 27,n*40));
							}
						
						size1++;
						next++;
					}
				}
			}
				sounds.levelsound.loop();
	}

	
	public level(player p1,enemy en,int x){
		enemyref=en;
		this.p1=p1;
	}
	
	
	public int setVY;
	
	public void update(){
		if(p1.dead&&p1.getY()>1550){
			
			if(mario.Lives>0){
			resetlevel();
			mario.Lives--;
			}
			else{
				
				mario.gameover=true;
				mario.GameMode=1;
				mario.time2=mario.time-5;
				sounds.gosound.play();
			}
		}
		
		
		
		if(next>-1){
	
		while(frontobjects.get(next).pos<player.levelx+1320){
			rlist.add(frontobjects.get(next));
			size++;
			frontobjects.remove(next);
			next--;
			if(next<0){
				break;
			}
			
		}}
		if(back>-1){
		
		while(backobjects.get(back).pos>player.levelx-40){
			rlist.add(backobjects.get(back));
			size++;
			backobjects.remove(back);
			back--;
			if(back<0){
				break;
			}
			
		}}
		removeObject();
		for(int i=0;i<size;i++){
			bgobjects ref1=rlist.get(i);
			ref1.update();
			if(rlist.size()<size){
				size--;
				i--;
			}
			
		}

		int size2=brickpeices.size();
		for (int i=0;i<size2;i++){
			bgobjects ref2=brickpeices.get(i);
			ref2.brickpupdate();
			if(brickpeices.size()<size2){
				size2=brickpeices.size();
						i--;
			}
		}
		
		
	}
	
	
	
	public static void removebrick(bgobjects bgobjects){
		rlist.remove(bgobjects);
		
	}
	public static void removecollision(int l){
		//gameObjects.collision[l]=false;
		gameObjects.collision.set(l,0);
		//gameObjects.collision[l]=0;
	
	}
	
	public void removeObject(){
		for(int i=0;i<size;i++){
			ref=rlist.get(i);
			if(ref.pos<player.levelx-40){
				backobjects.add(rlist.get(i));
				back++;
				rlist.remove(i);
				
				size--;
			}
			if(ref.pos>player.levelx+1320){
				frontobjects.add(rlist.get(i));
				next++;
				rlist.remove(i);
				
				size--;
			}
		}
	}
	

	public void render(Graphics g) {
	
		
	}
	
	public static void addenemy(int x,int y,long pos,int id){
		
		enemyref.addenemy(x,y,pos,id);
		
		}



	public static void removebrickp(bgobjects bgobjects) {
		brickpeices.remove(bgobjects);
		
	}

}
