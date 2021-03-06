package advanced;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

/**
 * @author Evgenii_Lartcev.
 */
public class ViewToRechka extends PApplet {

    private UnfoldingMap map;
    //zoom for map
//    private float zoomScaleFirstMap;

    @Override
    public void settings() {
        size(800, 600, P2D);
//        map = new UnfoldingMap(this, new EsriProvider.NatGeoWorldMap()); //try it or more - see javaDoc for unfolding
        map = new UnfoldingMap(this, new Microsoft.AerialProvider());
        //zoom to a Saint-Petersburg
        map.zoomAndPanTo(16, new Location(59.985755f, 30.306048f));
//        zoomScaleFirstMap = 1.85F;
//        map.zoomTo(zoomScaleFirstMap);
        MapUtils.createDefaultEventDispatcher(this, map);

    }

    @Override
    public void setup() {
        surface.setResizable(true);
    }

    @Override
    public void draw() {
        background(0);
        map.draw();
    }

    /**
     *
     * @param args name of classes that have to start
     */
    public static void main(String[] args) {
        PApplet.main(new String[]{ViewToRechka.class.getName()});
    }

}
