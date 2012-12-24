package org.noxo;

import java.util.Vector;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

//noxo 2009 // noxo@mbnet.fi

public class SpriteManager {
	
	private Vector<Sprite> sprites = new Vector(0);
	private Vector collisionList = new Vector();
	
	private Image background;
	
	public SpriteManager(Image background) {
		this.background = background;
	}
	
	public void addSprite(Sprite sprite) {
		sprite.setFlags(1);
		sprites.add(sprite);
	}
	
	public void removeSprite(Sprite sprite) {
		sprite.setFlags(0);
	}
	
	public void reset() {
		sprites.clear();
	}
	
	private void handleRemovedSprites() {
		for (int i=sprites.size()-1;i>=0;i--) {
			Sprite sprite = (Sprite) sprites.elementAt(i);
			int flags = sprite.getFlags();
			
			if (flags == 0) {
				sprites.remove(i);
			}
		}
	}
	
	public void processSprites(GraphicsContext gc) {
		
		for (int i=0;i<sprites.size();i++) {
			
			Sprite sprite = sprites.elementAt(i);
			Image frame = sprite.getCurrentFrame();
			int flags = sprite.getFlags();
			
			if (flags != 0) {
				gc.drawImage(frame,sprite.getX(), sprite.getY());
			}
		}
		
		handleRemovedSprites();

	}
	
	public Vector<Sprite> getCollidedSprites(Sprite src) {
		
		collisionList.removeAllElements();
		
		for (int i=0;i<sprites.size();i++) {
			
			Sprite trg = sprites.elementAt(i);
			
			if (src == trg)
				continue;
			
			if (trg.getPosRect().intersects(src.getPosRect())) {
				collisionList.add(trg);
			}
		}
		
		return collisionList;
	}
	
	public Vector<Sprite> getSprites() {
		return sprites;
	}
}
