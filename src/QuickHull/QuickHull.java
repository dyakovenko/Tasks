package QuickHull;

import java.util.ArrayList;


public class QuickHull {
	
	public ArrayList<QPoint> quickHull(ArrayList<QPoint> points)
	  {
	      ArrayList<QPoint> convexHull = new ArrayList<QPoint>();

	      int minPoint = -1, maxPoint = -1;
	      int minX = Integer.MAX_VALUE;
	      int maxX = Integer.MIN_VALUE;
	      /** Находим минимальное и максимальное значение для X из набора наших значений **/ 
	      /** что бы "провести линию между ними" **/  
	      for (int i = 0; i < points.size(); i++)
	      {
	          if (points.get(i).getX() < minX)
	          {
	              minX = points.get(i).getX();
	              minPoint = i;
	          }
	          if (points.get(i).getX() > maxX)
	          {
	              maxX = points.get(i).getX();
	              maxPoint = i;
	          }
	      }
	      /** Сохраним минимальные и максимальные координаты точки **/  
	      QPoint A = points.get(minPoint);
	      QPoint B = points.get(maxPoint);
	      /** в новую последовательность запишем наши точки **/  
	      convexHull.add(A);
	      convexHull.add(B);
	      /** удаляем из старой найденые значения "Лево" и "Право" **/ 
	      points.remove(A);
	      points.remove(B);

	      ArrayList<QPoint> leftSet = new ArrayList<QPoint>();
	      ArrayList<QPoint> rightSet = new ArrayList<QPoint>();
	      /** заполним значениями "Лево" и "Право" наши последовательности **/ 
	      for (int i = 0; i < points.size(); i++)
	      {
	          QPoint p = points.get(i);
	          //начальные значени Location(0 3, 5 3, 4 2)
	          if (Location(A, B, p))
	              leftSet.add(p);
	          else
	              rightSet.add(p);
	      }
	      /** набор точек, контейнер **/ 
	      hullSet(A, B, rightSet, convexHull);
	      hullSet(B, A, leftSet, convexHull);

	      return convexHull;
	  }

	

	  public void hullSet(QPoint A, QPoint B, ArrayList<QPoint> set,
	          ArrayList<QPoint> hull)
	  {
	      int insertPosition = hull.indexOf(B);
	      if (set.size() == 0)
	          return;
	      if (set.size() == 1)
	      {
	          QPoint p = set.get(0);
	          set.remove(p);
	          hull.add(insertPosition, p);
	          return;
	      }
	      int dist = Integer.MIN_VALUE;
	      int furthestPoint = -1;
	      for (int i = 0; i < set.size(); i++)
	      {
	          QPoint p = set.get(i);
	          int distance = distance(A, B, p);
	          if (distance > dist)
	          {
	              dist = distance;
	              furthestPoint = i;
	          }
	      }
	      QPoint P = set.get(furthestPoint);
	      set.remove(furthestPoint);
	      hull.add(insertPosition, P);

	      // Определим кто находиться левее-ниже
	      ArrayList<QPoint> leftSetAP = new ArrayList<QPoint>();
	      for (int i = 0; i < set.size(); i++)
	      {
	          QPoint M = set.get(i);
	          if (Location(A, P, M))
	          {
	              leftSetAP.add(M);
	          }
	      }

	      // Определим кто находиться правее-выше
	      ArrayList<QPoint> leftSetPB = new ArrayList<QPoint>();
	      for (int i = 0; i < set.size(); i++)
	      {
	          QPoint M = set.get(i);
	          if (Location(P, B, M))
	          {
	              leftSetPB.add(M);
	          }
	      }
	      /*рекурсивной функции, которая строит выпуклую оболочку */
	      hullSet(A, P, leftSetAP, hull);
	      hullSet(P, B, leftSetPB, hull);
	  }

	  private boolean Location(QPoint A, QPoint P, QPoint M)
	    {
	        int val =  (P.getY() - A.getY()) * (M.getX() - P.getX()) - (P.getX() - A.getX()) * (M.getY() - P.getY());
	         if (val >= 0)
	             return false;
	         return true;
	    }
	  
	  public int distance(QPoint A, QPoint B, QPoint C)
	  {
	      int ABx = B.getX() - A.getX();
	      int ABy = B.getY() - A.getY();
	      int num = ABx * (A.getY() - C.getY()) - ABy * (A.getX() - C.getX());
	      if (num < 0)
	          num = -num;
	      return num;
	  }
}
