
import java.awt.Color;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.List;

public class Snake {
	
	List<point> snakePoints;
	int xDir, yDir;
	boolean isMoving , elongate;
	final int StartSize = 20 , StartX=150, StartY = 150; 

public Snake() {
	snakePoints = new ArrayList<point>();
	xDir =0;
	yDir = 0;
	isMoving=false;
	elongate=false;
	snakePoints.add(new point(StartX,StartY));
	for(int i=1;i<StartSize;i++) {
		snakePoints.add(new point(StartX-i*4, StartY));
	}
}

public void draw(Graphics g) {
	g.setColor(Color.white);
	for(point p: snakePoints) {
		g.fillRect(p.getx(), p.gety(), 4, 4);
		
	}
}

public void move() {
	if(isMoving){
	point temp = snakePoints.get(0);
	point last = snakePoints.get(snakePoints.size()-1);
	point newStart = new point(temp.getx()+xDir*4,temp.gety()+yDir*4);
	for(int i = snakePoints.size()-1;i>=1;i--) {
		snakePoints.set(i, snakePoints.get(i-1));
		
	}
	snakePoints.set(0, newStart);
	if(elongate) {
		snakePoints.add(last);
		elongate = false;
	}
	}
}

public boolean isMoving() {
	
	return isMoving;
}

public boolean snakeCollision() {
	int x= this.getX();
	int y= this.getY();
	for(int i=1; i < snakePoints.size();i++) {
		if(snakePoints.get(i).getx() == x && snakePoints.get(i).gety()==y) {
			return true;
		}
		
	}
return false;
}

public void setIsMoving(boolean p) {
	
	isMoving = p;
}

public int getXDir() {
	return xDir;
}

public int getYDir() {
	return yDir;
}

public void setXDir(int x) {
	xDir=x;
}

public void setYDir(int y) {
	yDir=y;
}

public int getX() {
	return snakePoints.get(0).getx();
	
}

public int getY() {
	return snakePoints.get(0).gety();
	
}

public void setElongate(boolean b) {
	
	elongate = b;
	
	
}

}
