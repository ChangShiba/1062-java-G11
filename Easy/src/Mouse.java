
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;



public class Mouse extends Frame implements MouseListener,MouseMotionListener{
	public boolean run=false;
	public boolean press=true;
	
	public Mouse(Frame frame) throws Exception {
		super();
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
		if(run==true&&press==false) {
			mario.setX2(e.getX());
			mario.setY2(e.getY());
			System.out.printf("x2=%d,y2=%d%n",mario.getX2(),mario.getY2());
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//如果滑鼠點到人物，監測座標，並使人物移動
		System.out.println("mousePressed");
		if(mario.getX2()-mario.getX()<=45 && mario.getY2()-mario.getY()<=57 && press==true) {
			run=true;
			press=false;
			System.out.printf("x2=%d,y2=%d%n",mario.getX2(),mario.getY2());
		}else if(run==true&&press==false) {
			run=false;
			press=true;
		}
		
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