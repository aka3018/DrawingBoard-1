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
		this.x = dX;
		this.y = dY;
	}

	public void recalculateRegion() {
        int minX = gObjects.get(0).x;
        int minY = gObjects.get(0).y;
        int maxX = gObjects.get(0).x;
        int maxY = gObjects.get(0).y;
        int maxHeigh = 0;
        int maxWeidth = 0;

	    for (GObject gObject: gObjects){
	        if (gObject.x >= maxX){
	            maxX = gObject.x;
	            maxHeigh = maxX;
            }
            if (gObject.y >= maxY){
                maxY = gObject.y;
                maxWeidth = maxY;
            }
            if (gObject.x <= minX){
                minX = gObject.x;
            }

            if (gObject.y <= minY){
                minY = gObject.y;
            }
        }
        x = minX;
	    y = minY;
	    height = maxHeigh;
	    width = maxWeidth;
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
