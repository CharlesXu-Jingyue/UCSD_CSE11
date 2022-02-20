// Point class, DO NOT MODIFY
class Point {
	int x, y;
	Point(int x, int y) { this.x = x; this.y = y; }
	boolean belowLeftOf(Point p) { return this.x < p.x && this.y < p.y; }
	boolean aboveRightOf(Point p) { return this.x > p.x && this.y > p.y; }
	double distance(Point p) {
	  int dx = p.x - this.x;
	  int dy = p.y - this.y;
	  return Math.sqrt(dx * dx + dy * dy);
	}
}

interface Region { 
    boolean contains(Point p); 
    
    // Task 1.3: onEdge
    // Your code here
    boolean onEdge(Point p);
}

class RectRegion implements Region {
	Point lowerLeft, upperRight;
	
    RectRegion(Point lowerL, Point upperR) {
	  this.lowerLeft = lowerL;
	  this.upperRight = upperR;
	}
	
    public boolean contains(Point p) { 
        return this.lowerLeft.belowLeftOf(p) && this.upperRight.aboveRightOf(p); 
    }
    
    // Task 1.3: onEdge
    // Your code here
    public boolean onEdge(Point p) {
        if((p.x == this.lowerLeft.x && this.lowerLeft.y <= p.y && p.y < this.upperRight.y) ||
        (p.y == this.upperRight.y && this.lowerLeft.x <= p.x && p.x < this.upperRight.x) ||
        (p.x == this.upperRight.x && p.y <= this.upperRight.y && this.lowerLeft.y <= p.y) ||
        (p.y == this.lowerLeft.y && this.upperRight.x >= p.x && p.x > this.lowerLeft.x)) {
            return true;
        } else {
            return false;
        }
    }
}

class CircleRegion implements Region {
	Point center;
	int radius;
	
    CircleRegion(Point center, int radius) { 
        this.center = center; 
        this.radius = radius; 
    }
	
    public boolean contains(Point p) { 
        return this.center.distance(p) < this.radius; 
    }
    
    // Task 1.3: onEdge
    // Your code here
    public boolean onEdge(Point p) {
        int dx = p.x - this.center.x;
	    int dy = p.y - this.center.y;
        if((int)Math.sqrt(dx * dx + dy * dy) == radius) {
            return true;
        } else {
            return false;
        }
    }
}
