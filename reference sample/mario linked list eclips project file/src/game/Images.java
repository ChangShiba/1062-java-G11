package game;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Images {
	int time=0;
	Image tube = null;
	Image brick;
	Image menu1;
	Image leveleditor;
	Image block;
	Image blocki[]=new Image[14];
	Image coini[]=new Image[8];
	Image turtleri[]=new Image[8];
	Image turtleli[]=new Image[8];
	Image coin;
	Image blockup;
	Image timer;
	Image lives;
	Image levelup;
	Image gameover;
	Image exit;
	Image levele;
	Image start;
	Image en[]=new Image[15];
	Image intro;
	Image bkpr;
	Image bkpl;
	Image[] bg=new Image[8];
	Image[] back=new Image[6];
	
	public Images(){
		leveleditor= new ImageIcon(getClass().getResource("/bg/leveleditor.png")).getImage();
		gameover=new ImageIcon(getClass().getResource("/bg/gameover.png")).getImage();
		timer=new ImageIcon(getClass().getResource("/bg/timer.png")).getImage();
		lives=new ImageIcon(getClass().getResource("/bg/lives.png")).getImage();
		start=new ImageIcon(getClass().getResource("/bg/start.png")).getImage();
		exit= new ImageIcon(getClass().getResource("/bg/exit.png")).getImage();
		levele=new ImageIcon(getClass().getResource("/bg/levele.png")).getImage();
		intro= new ImageIcon(getClass().getResource("/bg/a.gif")).getImage();
		brick= new ImageIcon(getClass().getResource("/bg/brick.jpg")).getImage();
		menu1=new ImageIcon(getClass().getResource("/bg/menu.jpg")).getImage();
		for(int i=0;i<8;i++){
		coini[i]= new ImageIcon(getClass().getResource("/bg/coin"+i+".png")).getImage();}
		
		for(int i=0;i<14;i++){
		blocki[i]= new ImageIcon(getClass().getResource("/bg/block"+i+".png")).getImage();}
		
		block=new ImageIcon(getClass().getResource("/bg/block.jpg")).getImage(); 
		
		
		for(int i=0;i<8;i++){
			turtleri[i]= new ImageIcon(getClass().getResource("/turtle/r"+i+".png")).getImage();}
		for(int i=0;i<8;i++){
			turtleli[i]= new ImageIcon(getClass().getResource("/turtle/l"+i+".png")).getImage();}
		
		
		
		//new ImageIcon(getClass().getResource("/bg/back1.png")).getImage();
		levelup= new ImageIcon(getClass().getResource("/bg/levelup.png")).getImage();
		tube=new ImageIcon(getClass().getResource("/bg/tube.png")).getImage();
		
		back[0] = new ImageIcon(getClass().getResource("/bg/back1.png")).getImage();
		 back[1] =new ImageIcon(getClass().getResource("/bg/back2.png")).getImage();
		 back[2] =new ImageIcon(getClass().getResource("/bg/back3.png")).getImage();
		 back[3] =new ImageIcon(getClass().getResource("/bg/fore1.png")).getImage();
		 back[4] =new ImageIcon(getClass().getResource("/bg/fore2.png")).getImage();
		 back[5] =new ImageIcon(getClass().getResource("/bg/fore3.png")).getImage();
		 
		 
		 
		 
		
		
		en[0] =new ImageIcon(getClass().getResource("/mush/ml.gif")).getImage();
		en[1] = new ImageIcon(getClass().getResource("/mush/mr.gif")).getImage();
		en[2] = new ImageIcon(getClass().getResource("/mush/mi.png")).getImage();
		en[3] = new ImageIcon(getClass().getResource("/mush/md.png")).getImage();
		en[4] = new ImageIcon(getClass().getResource("/mush/md.png")).getImage();
		en[5] = new ImageIcon(getClass().getResource("/beetle/br.png")).getImage();
		en[6] = new ImageIcon(getClass().getResource("/beetle/bl.png")).getImage();
		en[7] = new ImageIcon(getClass().getResource("/beetle/bi.png")).getImage();
		en[8] = new ImageIcon(getClass().getResource("/beetle/bd.png")).getImage();
		en[9] = new ImageIcon(getClass().getResource("/beetle/bd.png")).getImage();
		
		en[12] = new ImageIcon(getClass().getResource("/turtle/ti.png")).getImage();
		en[13] = new ImageIcon(getClass().getResource("/turtle/td.png")).getImage();
		en[14] = new ImageIcon(getClass().getResource("/turtle/td.png")).getImage();
		
		bkpr = new ImageIcon(getClass().getResource("/bg/brickp.gif")).getImage();
		bkpl = new ImageIcon(getClass().getResource("/bg/brickpl.gif")).getImage();
		
		
		for(int i=0;i<8;i++){
			
		bg[i] =new ImageIcon(getClass().getResource("/bg/bg"+(i+2)+".png")).getImage();
		}
		
	}
	public void update(){
		time++;
		en[11]=turtleri[((int)(time/4))%8];
		en[10]=turtleli[((int)(time/4))%8];
		blockup=blocki[((int)(time/2))%14];;
		coin=coini[((int)(time/2))%8];
		if(time==60){
			time=0;
		}
	}
}
