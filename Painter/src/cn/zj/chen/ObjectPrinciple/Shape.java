package cn.zj.chen.ObjectPrinciple;

public abstract class Shape implements Drawing{
	int x,y;
	int width,height;
	int shapetype;
	String shapename;
	public void setShape(int x, int y, int width, int height, int shapetype, String shapename) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.shapetype = shapetype;
		this.shapename = shapename;
	}
}
