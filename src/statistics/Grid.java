package statistics;

import java.awt.*;
import java.awt.geom.Path2D;
import java.util.*;
import java.awt.image.BufferedImage;
public class Grid {
	
	int color;
	int red;
	int green;
	int blue;
	static String xAxis = "<line x1=\"%s\" y1=\"%s\" x2=\"%s\" y2=\"%s\" style=\"stroke:red;stroke-width:2\" />";
	static String yAxis = "<line x1=\"%s\" y1=\"%s\" x2=\"%s\" y2=\"%s\" style=\"stroke:red;stroke-width:2\" />";
	static Stack<String> gridH = new Stack<>();
	static Stack<String> gridV = new Stack<>();
	static boolean xAxisIsInPicture = true;
	static boolean yAxisIsInPicture = true;
	public static int moveUpDown = 0;
	public static int moveSide = 0;
	
	public Grid() {
		
	}
	
	
	public static void moveLeft(int dX) {
		moveSide -= dX/2;

	}
	
	public static void moveRight(int dX) {
			moveSide += dX/2;
	}
		
	public static void moveUp(int dX) {
			moveUpDown -= dX/2;
	}
	
	public static void moveDown(int dX) {
		moveUpDown += dX/2;


	}
		
	
	public void drawAxisOnScreen(Graphics2D g2d, boolean saveGraph, int red, int green, int blue) {
		 xAxis = "<line x1=\"%s\" y1=\"%s\" x2=\"%s\" y2=\"%s\" style=\"stroke:red;stroke-width:2\" />";
		 yAxis = "<line x1=\"%s\" y1=\"%s\" x2=\"%s\" y2=\"%s\" style=\"stroke:red;stroke-width:2\" />";
		Path2D.Double pathX = new Path2D.Double();
		Path2D.Double pathY = new Path2D.Double();

		int centerX = (int) Panel.WIDTH / 2;
		int centerY = (int) Panel.HEIGHT / 2;
		pathX.moveTo(centerX + moveSide, 0);
		pathX.lineTo(centerX + moveSide, Panel.HEIGHT);
		int x1 = centerX + moveSide;

		yAxis = String.format(yAxis, x1, 0, x1, Panel.HEIGHT);
//		System.out.println("yAxis" + yAxis + '\n'+ "centerX = " + centerX + " moveSide = " + moveSide + " sum = " + (moveSide + centerX));
		if(centerX + moveSide < 0 || centerX + moveSide > Panel.WIDTH) {
			yAxisIsInPicture = false;
		}
		pathY.moveTo(0, centerY + moveUpDown);
		pathY.lineTo(Panel.WIDTH, centerY + moveUpDown);
		xAxis = String.format(xAxis,0 , (centerY + moveUpDown), Panel.WIDTH, (centerY + moveUpDown));
//		System.out.println(xAxis);
		if(centerY + moveUpDown < 0 || centerY + moveUpDown > Panel.HEIGHT) {
			xAxisIsInPicture = false;
		}
		g2d.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
		g2d.setColor(new Color(150, 150, 150));
		g2d.draw(pathX);
		g2d.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
		g2d.setColor(new Color(150, 150, 150));
		g2d.draw(pathY);
		
	}
	
	public void drawAxisOnImage(BufferedImage img, Graphics2D g2d1, boolean saveGraph, int red, int green, int blue) {
		
		Path2D.Double pathX = new Path2D.Double();
		Path2D.Double pathY = new Path2D.Double();

		int centerX = (int) Panel.WIDTH / 2;
		int centerY = (int) Panel.HEIGHT / 2;
		pathX.moveTo(centerX + moveSide, 0);
		pathX.lineTo(centerX + moveSide, Panel.HEIGHT);
		pathY.moveTo(0, centerY + moveUpDown);
		pathY.lineTo(Panel.WIDTH, centerY+ moveUpDown);
		g2d1.setStroke(new BasicStroke(1.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
		g2d1.setColor(new Color(150, 150, 150));
		g2d1.draw(pathX);
		g2d1.setStroke(new BasicStroke(1.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
		g2d1.setColor(new Color(150, 150, 150));
		g2d1.draw(pathY);
		g2d1.drawImage(img, null, 0, 0);
		
	}
	
	public void saveBackground(double dX, Graphics2D g2d1) {
		
	}
	
	public void drawGridOnImage(double dX,BufferedImage img, Graphics2D g2d1) {
		Path2D.Double pathX = new Path2D.Double();
		Path2D.Double pathY = new Path2D.Double();
		
		int centerX = (int) Panel.WIDTH / 2;
		int centerY = (int) Panel.HEIGHT / 2;
		
		int numOfLinesH =(int)(Panel.WIDTH / dX);
		int numOfLinesV = (int) (Panel.HEIGHT/dX);
		double leftDX = -dX;
		double rightDX = dX;
		double lowDY = -dX;
		double upDY = dX;
		int startPointX = centerX + moveSide;
		int startPointY = centerY+ moveUpDown;
		centerX = startPointX % ((int) dX);
		centerY = startPointY % ((int) dX);
		
		for(int x = 0 ; x <= numOfLinesH ; x ++) {
			pathX.moveTo(centerX + (x * leftDX), 0);
			pathX.lineTo(centerX + (x * leftDX), Panel.HEIGHT);
			pathX.moveTo(centerX + (x * rightDX), 0);
			pathX.lineTo(centerX + (x * rightDX), Panel.HEIGHT);
			g2d1.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
			g2d1.setColor(new Color(150, 150, 150));
			g2d1.draw(pathX);
			if(x <= numOfLinesV) {
				pathY.moveTo(0, centerY + (x * lowDY));
				pathY.lineTo(Panel.WIDTH, centerY + (x * lowDY));
				pathY.moveTo(0, centerY  + (x * upDY));
				pathY.lineTo(Panel.WIDTH, centerY + (x * upDY));
				g2d1.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
				g2d1.setColor(new Color(150, 150, 150));
				g2d1.draw(pathY);
				g2d1.drawImage(img, null, 0, 0);
			}
		}
	}
	
	

	

	
	public void drawGridOnScreen(double dX, Graphics2D g2d) {
		if(!gridV.empty() && !gridH.empty()) {
			gridV.clear();
			gridH.clear();
		}
		String lineH1;
		String lineH2;
		String lineV1;
		String lineV2;
		Path2D.Double pathX = new Path2D.Double();
		Path2D.Double pathY = new Path2D.Double();
		
		int centerX = (int) Panel.WIDTH / 2;//1. the reference point is always the middle
		int centerY = (int) Panel.HEIGHT / 2;
		
		int numOfLinesH =(int)(Panel.WIDTH / dX);
		int numOfLinesV = (int) (Panel.HEIGHT/dX);
		
		double leftDX = -dX;
		double rightDX = dX;
		double lowDY = -dX;
		double upDY = dX;
		int startPointX = centerX + moveSide;//2. when some offset happens, the center moves to a certain place, at every point of repaint() the offset center is the point of reference
		int startPointY = centerY+ moveUpDown;
		centerX = startPointX % ((int) dX);/*3. although the new center is at some side now, by adding the same distance dX back to it, at some point you still
		 									get to the correct offset center, by adding lines, so that is why even though the center is not in the center anymore,
		 									it still looks as if the scaling is in respect center, because due to it being the starting point of the calculation,
		 									it remains wherever it would be if the drawing loop was actually at the center
		 									!!! Despite the likely retarded way to do this what would be the center remains at the right place, 
		 									that is why the scaleing looks fine*/
		
											
		centerY = startPointY % ((int) dX);
		

		System.out.println("centerX = " + centerX);
		
		for(int x = 0; x <= numOfLinesH; x ++) {
			
			double lineStartH1 = centerX + (x * leftDX);
			double lineStartH2 = centerX + (x * rightDX);
			
			if(lineStartH1 >= 0 && lineStartH1 <= Panel.WIDTH) {
				pathX.moveTo(centerX + (x * leftDX), 0);
				pathX.lineTo(centerX + (x * leftDX), Panel.HEIGHT);
				lineH1 = String.format("<line x1=\"%s\" y1=\"%s\" x2=\"%s\" y2=\"%s\" style=\"stroke:black;stroke-width:1\" />", (centerX + (x * leftDX)), 0, (centerX + (x * leftDX)), Panel.HEIGHT);				
				gridH.add(lineH1);
			}
			if(lineStartH2 >= 0 && lineStartH2 <= Panel.WIDTH) {
				pathX.moveTo(centerX + (x * rightDX), 0);
				pathX.lineTo(centerX + (x * rightDX), Panel.HEIGHT);
				lineH2 = String.format("<line x1=\"%s\" y1=\"%s\" x2=\"%s\" y2=\"%s\" style=\"stroke:black;stroke-width:1\" />", (centerX + (x * rightDX)), 0, (centerX + (x * rightDX)), Panel.HEIGHT);			
				gridH.add(lineH2);
			}
			g2d.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
			g2d.setColor(new Color(150, 150, 150));
			g2d.draw(pathX);
			if(x <= numOfLinesV) {
				
				double lineStartV1 = centerY + (x * lowDY);
				double lineStartV2 = centerY + (x * upDY);
				
				if(lineStartV1 >= 0 && lineStartV1 <= Panel.HEIGHT) {
					pathY.moveTo(0, centerY + (x * lowDY));
					pathY.lineTo(Panel.WIDTH, centerY + (x * lowDY));
					lineV1 = String.format("<line x1=\"%s\" y1=\"%s\" x2=\"%s\" y2=\"%s\" style=\"stroke:black;stroke-width:1\" />", 0, (centerY + (x * lowDY)), Panel.WIDTH, ( centerY + (x * lowDY)));
					gridV.add(lineV1);
				}
				if(lineStartV2 >=0 && lineStartV2 <= Panel.HEIGHT) {
					pathY.moveTo(0, centerY + (x * upDY));
					pathY.lineTo(Panel.WIDTH, centerY + (x * upDY));
					lineV2 = String.format("<line x1=\"%s\" y1=\"%s\" x2=\"%s\" y2=\"%s\" style=\"stroke:black;stroke-width:1\" />", 0, (centerY + (x * upDY)), Panel.WIDTH, (centerY + (x * upDY)));			
					gridV.add(lineV2);
				}
				g2d.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
				g2d.setColor(new Color(150, 150, 150));
				g2d.draw(pathY);
			}
		}
	}
	

}