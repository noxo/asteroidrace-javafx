package org.noxo;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;


//noxo 2009 // noxo@mbnet.fi

public class Sprite {

	private double x;
	private double y;
	private double px;
	private double py;
	private Image frame[];
	private boolean visible;
	private int animSpeed;
	private double width;
	private double height;

	private Rectangle2D cRect = Rectangle2D.EMPTY;
	private int currentFrame = 0;
	private long animTime = 0;
	private int flags = 0;
	private int typeId;
	
	public Sprite(Image frame[], int x, int y) {
		this.frame = frame;
		this.x = x;
		this.y = y;
		this.width = frame[0].getWidth();
		this.height = frame[0].getHeight();
	}
	
	public Sprite(Image frame) {
		this.frame = new Image[] { frame };
		this.width = frame.getWidth();
		this.height = frame.getHeight();
	}
	
	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.py = this.y;
		this.y = y;
	}

	public void setX(double x) {
		this.px = this.x;
		this.x = x;
	}

	public double getX() {
		return x;
	}
	
	public Rectangle2D getPosRect() {
		cRect = new Rectangle2D(x,y,width,height);
		return cRect;
	}
//
//	public Rectangle2D getPrevPosRect() {
//		pRect = new Rectangle2D(px,py,width,height);
//		return pRect;
//	}

	public void setAnimSpeed(int animSpeed) {
		this.animSpeed = animSpeed;
	}

	public int getAnimSpeed() {
		return animSpeed;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public double getWidth() {
		return width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getHeight() {
		return height;
	}
	
	public void move(double x, double y) {
		setX(x);
		setY(y);
	}
	
//	public void setManager(SpriteManager manager) {
//		this.manager = manager;
//	}
//
//	public SpriteManager getManager() {
//		return manager;
//	}

	public void setPx(int px) {
		this.px = px;
	}

	public double getPx() {
		return px;
	}

	public void setPy(double py) {
		this.py = py;
	}

	public double getPy() {
		return py;
	}
	
	public Image getCurrentFrame() {
		
		if (animSpeed > 0) {
			
			long ct = System.currentTimeMillis();
			long t = ct - animTime;
			
			if (t >= animSpeed) {
				animTime = ct;
				
				if ( currentFrame + 1 < frame.length - 1)
					currentFrame++;
				else 
					currentFrame = 0;
			}
			
		}
		
		return frame[currentFrame];
	}

	public void setFlags(int flags) {
		this.flags = flags;
	}

	public int getFlags() {
		return flags;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getTypeId() {
		return typeId;
	}
}
