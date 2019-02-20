package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class CompositeGObject extends GObject {

	private List<GObject> gObjects;

	public CompositeGObject() {
		super(0, 0, 0, 0);
		gObjects = new ArrayList<GObject>();
	}

	public void add(GObject gObject) {
		gObjects.add(gObject);
	}

	public void remove(GObject gObject) {
		gObjects.remove(gObject);
	}

	@Override
	public void move(int dX, int dY) {
		this.x += dX;
		this.y += dY;
		for (GObject gObject: gObjects){
			gObject.move(dX,dY);
		}
	}

	public void recalculateRegion() {
		GObject firstGObject = gObjects.get(0);

		int x = firstGObject.x;
		int y = firstGObject.y;
		int dX = firstGObject.x + firstGObject.width;
		int dY = firstGObject.y + firstGObject.height;

		for (GObject child : gObjects) {
			if (child.x < x) {
				x = child.x;
			}
			if (child.x + child.width > dX) {
				dX = child.x + child.width;
			}
			if (child.y < y) {
				y = child.y;
			}
			if (child.y + child.height > dY) {
				dY = child.y + child.height;
			}
		}

		this.x = x;
		this.y = y;
		this.width = dX - x;
		this.height = dY - y;
	}

	@Override
	public void paintObject(Graphics g) {
	    for (GObject gObject: gObjects){
	        gObject.paintObject(g);
        }
	}

	@Override
	public void paintLabel(Graphics g) {
        for (GObject gObject: gObjects){
            gObject.paintLabel(g);
        }
	}

}
