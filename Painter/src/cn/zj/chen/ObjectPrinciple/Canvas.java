package cn.zj.chen.ObjectPrinciple;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

public class Canvas extends JPanel{
	private int todoAction;
	private Shape shape;
	private Rectangle scope;
	ArrayList<Shape> shapes;
	
	public void setTodoAction(int todoAction) {
		this.todoAction = todoAction;
	}
	
	public Canvas() {
		shapes=new ArrayList();
		
		addMouseMotionListener(mouseHandler); 
		addMouseListener(mouseHandler);
	}
	public void clear(){
		shapes.removeAll(shapes);
		repaint();
	}
	private MouseInputListener mouseHandler=new MouseInputAdapter(){
		Point startPoint;
		@Override
		public void mousePressed(MouseEvent e) {
			// 确定起始点
			startPoint=e.getPoint();
			scope=new Rectangle();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			//需要一个队列，把需要画的图形加到这个对列
			setScope(startPoint, e.getPoint());
			if(scope.width>0 || scope.height>0){
				if(todoAction ==0){
					Shape line =new MyLine();
					line.setShape(scope.x,scope.y,scope.width,scope.height,0,"line");
					paintShape(line);
				}else if(todoAction ==1){
					Shape rect =new MyRectangle();
					rect.setShape(scope.x,scope.y,scope.width,scope.height,1,"Rectangle");
					paintShape(rect);
				}
			}
			
			// 消除矩形
			scope=null;
			repaint();
		}

		public void paintShape(Shape shape) {
			shapes.add(shape);
			repaint();
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			//不断改变矩形框
			
			if(scope!=null){
				setScope(startPoint, e.getPoint());
			}
			repaint();
		}
		
	};
	
	private void setScope(Point startPoint,Point endPoint){
		
		if(todoAction==1){
			int x=Math.min(startPoint.x, endPoint.x); //返回参数中最小的值。
			int y=Math.min(startPoint.y, endPoint.y);
			int w=Math.abs(startPoint.x-endPoint.x);
			int h=Math.abs(startPoint.y-endPoint.y);
			scope.setBounds(x, y, w, h);
		}else if(todoAction==0){
			
		}

	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.red);
		
		if(scope!=null){
			
			g.drawRect(scope.x, scope.y, scope.width, scope.height);
		}
		//需要一个队列，把需要画的图形加到这个对列，遍历队列，调用每个元素的drawshap()
		if(shapes!=null){
			for(Drawing d:shapes){
				d.drawingShape(g);
			}
		}
		
	}
	
}
