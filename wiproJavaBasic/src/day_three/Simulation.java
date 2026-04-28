package day_three;


interface Movable{
	void moveUp();
	void moveDown();
	void moveRight();
	void moveLeft();
}


class MovablePoint implements Movable{
	int x;
	int y;
	int xSpeed;
	int ySpeed;
	
	MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
	

    public void moveUp() {
        y = y+ ySpeed;
    }

    public void moveDown() {
        y =y- ySpeed;
    }

    public void moveLeft() {
        x =x- xSpeed;
    }

    public void moveRight() {
        x =x+ xSpeed;
    }
    
    //extra func
    
    void getPos() {
    	System.out.println("X:"+x+"Y: "+y);
    }
    
    public String toString() {
        return "xy(" + x + ", " + y + ")";
    }
}

class MovableCircle implements Movable{
	int radius;
    MovablePoint center;
    
    MovableCircle(int radius, MovablePoint center) {
        this.radius = radius;
        this.center = center;
    }
    
    public void moveUp() {
    	
        center.moveUp();
    }

    public void moveDown() {
    	
        center.moveDown();
    }

    public void moveLeft() {
        center.moveLeft();
    }

    public void moveRight() {
        center.moveRight();
    }
    
    public String toString() {
        return "circle pos: " + center + ", rad : " + radius;
    }

}


class MovableRectangle implements Movable{
	MovablePoint topLeft;
	MovablePoint bottomRight;
	
	MovableRectangle(MovablePoint topLeft, MovablePoint bottomRight) {
        
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }
	
	

    public void moveUp() {
    	
        topLeft.moveUp();
        bottomRight.moveUp();
    }

    public void moveDown() {
    	
        topLeft.moveDown();
        bottomRight.moveDown();
    }

    public void moveLeft() {
    	
        topLeft.moveLeft();
        bottomRight.moveLeft();
    }

    public void moveRight() {
    	
        topLeft.moveRight();
        
        bottomRight.moveRight();
    }
    
    public String toString() {
        return "rec topLeft:" + topLeft +",BottomRight:" + bottomRight;
    }
}

public class Simulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MovablePoint p = new MovablePoint(0, 0, 2, 2);
        MovableCircle c = new MovableCircle(5, new MovablePoint(2, 2,2 , 2));
        
        MovableRectangle r = new MovableRectangle( new MovablePoint(0, 5, 1, 1), new MovablePoint(5, 0, 1, 1) );
        
        
        
        System.out.println(p);
        
        System.out.println(c);
        
        System.out.println(r);
        
        
        p.moveUp();
        c.moveUp();
        
        r.moveRight();
        
        
        
        System.out.println(p);
        System.out.println(c);
        System.out.println(r);
	}

}
