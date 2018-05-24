package game;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Arrays;
import java.util.LinkedList;



public class gameObjects {
	
	protected int x;
	protected int y;
	protected float vx;
	protected float vy;
	public boolean jumping,left,falling,dead;
	protected static double bx;
	public int im=0;
	public static long levelx=0;
	public long pos;
	
	//////////////////////////// array for the collision detection/////////////////////////////////////////////////////
	
	//public static int[] collision12=new int[10800]; 
	public static LinkedList<Integer> collision = new LinkedList<Integer>();
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	public gameObjects(int x,int y) {
		
		this.x=x;
		this.y=y;
		
	}

	
	public int getX() {
		
		return x;
	}

	public int getY() {
		
		return y;
	}
	 public void setY(int y) {
			
			this.y=y;
		}
	 public void setX(int x) {
			
			this.x=x;
		}
    public void setVY(float vy) {
		
		this.vy=vy;
	}
    public void setVX(float vx) {
		
		this.vx=vx;
	}

	public void update() {
		
		
	}


	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}


	public float getVY() {
		// TODO Auto-generated method stub
		return vy;
	}


	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}


	public void update(int j) {
		// TODO Auto-generated method stub
		
	}


	public float getVX() {
		// TODO Auto-generated method stub
		return vx;
	}

	
}
