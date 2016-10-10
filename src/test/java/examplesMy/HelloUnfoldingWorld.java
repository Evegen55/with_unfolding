package examplesMy;

import de.fhpotsdam.unfolding.UnfoldingMap;
import processing.core.PApplet;

/**
 * @author Evgenii_Lartcev
 * Hello Unfolding World.
 */
public class HelloUnfoldingWorld extends PApplet {

    UnfoldingMap map;

    @Override
    public void settings() {
        size(800, 600, P2D);
        map = new UnfoldingMap(this);

    }

    @Override
    public void setup() {
        surface.setResizable(true);
    }

    @Override
    public void draw() {
        map.draw();
    }

    public static void main(String[] args) {
        PApplet.main(new String[]{HelloUnfoldingWorld.class.getName()});
    }

}
