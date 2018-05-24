package game;



import java.util.LinkedList;

public class objectHandler {

	LinkedList<gameObjects> object=new LinkedList<gameObjects>();
	gameObjects ref;
	public int setVY;
	
	public void update(int j){
		for(int i=0;i<object.size();i++){
			ref=object.get(i);
			if(ref instanceof bgobjects){
				((bgobjects) ref).bgupdate();
			}else{
			ref.update(j);}
		}
	}
	
	
	public void addObject(gameObjects object){
		this.object.add(object);
	}
	
	public void removeObject(gameObjects object){
		this.object.remove(object);
	}
	public void setVY(int i) {
		// TODO Auto-generated method stub
		
	}
}