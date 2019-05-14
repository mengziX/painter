package cn.zj.chen.ObjectPrinciple;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class MyLine extends Shape{

	public void drawingShape(Graphics g) {
		Graphics2D g2d=(Graphics2D) g;
		Line2D line=new Line2D.Double(x, y, x+width, y+height);
		g2d.draw(line);
	}

}
