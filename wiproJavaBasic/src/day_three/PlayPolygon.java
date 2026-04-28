package day_three;


interface Polygon{
	
	  default double getPerimeter(int... sides) {
	        int sum = 0;
	        for (int side : sides) {
	            sum += side;
	        }
	        return sum;
	    }

	    // static method
	    static String shapeInfo() {
	        return "polgons are mathematics shapes";
	    }
	
}

class Rectangle implements Polygon {
    int length;
    int width;

    Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public double getArea() {
        return length * width;
    }
}


class Triangle implements Polygon {
    int base;
    int height;

    Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    public double getArea() {
        return 0.5 * base * height;
    }
}


public class PlayPolygon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Rectangle ra= new Rectangle(6,2);
		
		Triangle ta=new Triangle(5,10);
		
		System.out.println(ra.getArea());
		System.out.println(ta.getArea());
		System.out.println(ta.getArea());
		
		
		
		System.out.println(ra.getPerimeter(6,2,6,2));
		

	}

}
