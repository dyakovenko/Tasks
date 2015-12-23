package QuickHull;

import java.util.ArrayList;
import java.util.Scanner; 

class Init{
    public static void main (String[] args) 
    {
    	Scanner scan = new Scanner(System.in);
        System.out.println("Введите количество точек :");
        int n = scan.nextInt();
        ArrayList<QPoint> points = new ArrayList<QPoint>();
        System.out.println("Введите "+ n +" x и y координат через пробел (пример: 0 3 4 2 3 5 5 3 3 0 1 1 1 2 2 2)");
        for (int i = 0; i < n; i++)
        {
        	 int x = scan.nextInt();
             int y = scan.nextInt();
             QPoint e = new QPoint(x, y);
             points.add(i, e);
        }  
        QuickHull qh = new QuickHull();
        ArrayList<QPoint> p = qh.quickHull(points);
        System.out.println("\n Convex Hull points : ");
            for (int i = 0; i < p.size(); i++){
            	 System.out.println("(" + p.get(i).getX() + ", " + p.get(i).getY() + ")");
            }
    }
}