package cn.zj.chen.ObjectPrinciple;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
public class MyRectangle extends Shape{

	@Override
	public void drawingShape(Graphics g) {
		Graphics2D g2d=(Graphics2D) g;
		Rectangle2D rect=new Rectangle2D.Double(x, y,width,height);
		g2d.draw(rect);
	}

}
