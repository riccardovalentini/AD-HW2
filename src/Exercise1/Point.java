import java.util.*;

public class Point
{
	private int x;
	private int y;
	public Point(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
	public void setX(int x)
	{
		this.x=x;
	}
	public void setY(int y)
	{
		this.y=y;
	}
	
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	
	public double distance(Point p)
	{
		double distance=0;
		distance=Math.sqrt((p.x-this.x)*(p.x-this.x) + (p.y-this.y)*(p.y-this.y));
		if(distance<0) distance=-distance;
		return distance;
	}
	
	public static double getDistance(Point p1, Point p2)
	{
		return p1.distance(p2);
	}
	
	public static double getDiameter(List<Point> cloud)
	{
		double max=0;
		for(Point p1: cloud)
		{
			for(Point p2: cloud)
			{
				double d = getDistance(p1,p2);
				if(d>max) max=d;
			}
		}
		return max;
	}
	
	public static double getApproxDiameter(List<Point> cloud)
	{
		int maxY=cloud.get(0).getY();
		int minX=cloud.get(0).getX();
		int maxX=cloud.get(0).getX();
		int minY=cloud.get(0).getY();
		for(Point p1: cloud)
		{
			if(p1.getX()<minX) minX=p1.getX();
			if(p1.getX()>maxX) maxX=p1.getX();
			if(p1.getY()>maxY) maxY=p1.getY();
			if(p1.getY()<minY) minY=p1.getY();
		}
		int x=maxX-minX;
		int y=maxY-minY;
		double l=0;
		if(x>y) l=x;
		else l=y;
		return l;
	}
	
	
	public static void main(String[]args)
	{
		ArrayList<Point> points = new ArrayList<Point>();
		Point p1=new Point(3,8);
		Point p2=new Point(6,5);
		Point p3=new Point(2,2);
		Point p4=new Point(1,4);
		Point p5=new Point(6,2);
		Point p6=new Point(4,6);
		points.add(p1);
		points.add(p2);
		points.add(p3);
		points.add(p4);
		points.add(p5);
		points.add(p6);

		double realDiameter=getDiameter(points);
		double sqrtApproxDiameter=getApproxDiameter(points);
		System.out.println("Diameter of point clound is: "+realDiameter);
		System.out.println("Approx Diameter of point clound is: "+sqrtApproxDiameter);
		System.out.println("Diameter / Approx Diameter = "+(realDiameter/sqrtApproxDiameter));
		System.out.println("Diameter / Approx Diameter < sqrt(2)? "+((realDiameter/sqrtApproxDiameter)<Math.sqrt(2)));

	}
}
