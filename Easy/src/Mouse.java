
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;



public class Mouse extends Frame implements MouseListener,MouseMotionListener{
	public boolean run=false;
	public boolean press=true;
	JFrame game;
	public Mario current;
	
	public Mouse(JFrame game) throws Exception {
		super();
		this.game=game;
	}
	
	public void Mouse(Frame Frame) {  
        mario.setGf(Frame); 
    }
	
	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("MouseDragged");
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		
			mario.setX2(e.getX());
			mario.setY2(e.getY());
			System.out.printf("getx=%d,gety=%d%n",e.getX(),e.getY());
//			System.out.printf("x1=%d,y1=%d%n",mario.getX(),mario.getY());
			System.out.printf("x2=%d,y2=%d%n",mario.getX2(),mario.getY2());
//		
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		gameFrame.setEnemyappear(true);
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
}