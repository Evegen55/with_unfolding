package advanced;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.providers.EsriProvider;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

import java.awt.*;

/**
 * @author Evgenii_Lartcev.
 */
public class MapWithFeautures extends PApplet {
    //use JDK to getting a screen size
    private static final Toolkit TOOLKIT = Toolkit.getDefaultToolkit();
    private static final Dimension SCREEN_SIZE = TOOLKIT.getScreenSize();

    private static final int SCREEN_WIDTH = SCREEN_SIZE.width;
    private static final int SCREEN_HEIGHT = SCREEN_SIZE.height;

    private static final int SCREEN_WIDTH_FOR_APP = SCREEN_WIDTH - SCREEN_WIDTH / 10;
    private static final int SCREEN_HEIGHT_FOR_APP = SCREEN_HEIGHT - SCREEN_HEIGHT / 10;

    private static final int START_POINT_ON_X_FOR_MAP = SCREEN_WIDTH / 7;
    private static final int START_POINT_ON_Y_FOR_MAP = SCREEN_HEIGHT / 20;

    private static final int SCREEN_WIDTH_FOR_MAP = SCREEN_WIDTH_FOR_APP - SCREEN_WIDTH_FOR_APP / 5;
    private static final int SCREEN_HEIGHT_FOR_MAP = SCREEN_HEIGHT_FOR_APP - SCREEN_HEIGHT_FOR_APP / 15;

    private UnfoldingMap map;

    @Override
    public void settings() {
        size(SCREEN_WIDTH_FOR_APP, SCREEN_HEIGHT_FOR_APP, JAVA2D);
        map = new UnfoldingMap(this, new EsriProvider.NatGeoWorldMap());
        //zoom to a San-Diego
        map.zoomAndPanTo(10, new Location(32.9f, -117.2f));
        MapUtils.createDefaultEventDispatcher(this, map);
        //set application on a fullscreen
       // this.fullScreen();
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
     * @param args name of classes that have to start
     */
    public static void main(String[] args) {
        PApplet.main(new String[]{MapWithFeautures.class.getName()});
    }
}
