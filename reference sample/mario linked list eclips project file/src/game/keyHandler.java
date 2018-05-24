package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyHandler implements KeyListener {
	
	
	
	
	private boolean[] key =new boolean[120];
	public boolean left,right,space,enter;
	boolean jumplow=false;
	int imageIndex=0;
	public static boolean running=false;
	gameObjects p1;
	
	public void update(gameObjects p){
		p1=p;
		
		left=key[KeyEvent.VK_LEFT]||key[KeyEvent.VK_A];
		right=key[KeyEvent.VK_RIGHT]||key[KeyEvent.VK_D];
		space=key[KeyEvent.VK_SPACE];
		
		
		if(p1.getVY()==0 && p1.jumping){
			p1.falling=true;
		}
		if(p1.falling){
			p1.setVY(12);
		}
		
		if(left && right){
			
			if(p1.left){
				p1.setVX(0);
				imageIndex=1;
				
			}else if(!p1.left){
				
				p1.setVX(0);
					imageIndex=0;
				
				
			}
		}
		
		else if(left){
			
			p1.setVX(-8);
			p1.left=true;
			imageIndex=2;
			
		}
		else if(right){
			
			
			p1.setVX(8);
			p1.left=false;
			imageIndex=3;
		}
		
		if(!p1.falling&&!p1.jumping){
			
			p1.setVY(0);
		}
		if(p1.jumping){
			if(p1.left){
				imageIndex=4;
			}else if(!p1.left){
				imageIndex=5;
			}
		}
		
		if(!left && !right){
			
			
			if(p1.left){
				if(p1.getVX()!=0){
					p1.setVX(0);}
				else{
					imageIndex=1;
				}
				
			}else if(!p1.left){
				if(p1.getVX()!=0){
					p1.setVX(0);}
				else{
					imageIndex=0;
				}
				
			}
			
		}
		if(space){
			
			if(!p1.jumping){
				p1.jumping=true;
				p1.setVY(-18);
				jumplow=true;
				sounds.jmpsound.play();
			}
			else if(jumplow){
				if(p1.getVY()>-12){
				p1.setVY(-18);
				jumplow=false;	}
		}
		
			
			
			}
		
		
		
	}
	
	public void update(int mx,int my,boolean clicked,boolean draged){
		enter=key[KeyEvent.VK_ENTER];
		if(!draged){
			if(mx>1000&&mx<1090){
				if(my>0&&my<90){
					levelEditor.id=4;
				}else if(my>90&&my<180){
					levelEditor.id=1;
				}else if(my>180&&my<270){
					levelEditor.id=5;
				}else if(my>415&&my<515){
					levelEditor.id=7;
				}
				
				
			}else if(mx>1090&&mx<1180){
				if(my>0&&my<90){
					levelEditor.id=3;
				}else if(my>90&&my<180){
					levelEditor.id=2;
				}else if(my>415&&my<515){
					levelEditor.id=8;
				}
				
			}
				else if(mx>1180&&mx<1280){
					if(my>0&&my<180){
						levelEditor.id=6;
					}
				}
			else{
				
				levelEditor.id=0;
			}
		}
		
		
	if(mario.GameMode==1&&clicked){
			
			if(mx>850&&mx<1150&&my>220&&my<345){
				mario.changeGameMode(1,2);
			}
			else if(mx>850&&mx<1150&&my>270&&my<495){
				mario.changeGameMode(1,3);
			}
			
			else if(mx>850&&mx<1150&&my>520&&my<645){
				
				running=false;
				}
		}
	}
	
	public void keyPressed(KeyEvent k) {
		key[k.getKeyCode()]=true;
		
	}

	
	public void keyReleased(KeyEvent k) {
		key[k.getKeyCode()]=false;
		
	}

	
	public void keyTyped(KeyEvent k) {
		// TODO Auto-generated method stub
		
	}
	

}
