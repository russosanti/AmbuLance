package Applets;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Polygon;

public class Mi_Applet extends Applet {

	private static final long serialVersionUID = 1L;

	
	public Mi_Applet() {
		super();
	}

	
	public void init() {
		this.setSize(500,500);
	}

	public void paint(Graphics gr) {
		gr.draw3DRect(0,0,100,100,true);
		int x[] = {0,10,20,40,360,400};
		int y[] = {0,20,30,40,100,500};
		gr.drawPolygon(x,y,6);
		gr.fillPolygon(x, y,6);
		super.paint(gr);
	}
}
