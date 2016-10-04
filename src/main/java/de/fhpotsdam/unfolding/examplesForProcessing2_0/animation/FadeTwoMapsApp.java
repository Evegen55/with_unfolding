package de.fhpotsdam.unfolding.examplesForProcessing2_0.animation;

import processing.core.PApplet;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;

/**
 * Load two maps and fade between.
 * <p>
 * Press key '1' to fade once, and press key '2' to start fading animation.
 */
public class FadeTwoMapsApp extends PApplet {
    //basic view variables
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private static final int ZOOM = 10;

    private UnfoldingMap map1;
    private UnfoldingMap map2;

    // Create and set variable we need to fade between our two maps.
    private static boolean fadeOnce = false;
    private static boolean fadeAlways = false;
    private static int fadeVal = 255;
    private static int fadeDelta = 5;
    private static int fadeMin = 0;
    private static int fadeMax = 255;


    public void settings() {
        size(WIDTH, HEIGHT, JAVA2D);

        // Set the position and size of our two maps.
        final int mapXposition = 0;
        final int mapYposition = 30;
        final int mapWidth = width;
        final int mapHeight = height - mapYposition;
        // Set our location of the maps
        final float lon = 52.5f;
        final float lat = 13.4f;

        // Initialize two maps
        map1 = new UnfoldingMap(this, mapXposition, mapYposition, mapWidth, mapHeight);
        map1.zoomAndPanTo(ZOOM, new Location(lon, lat));
        map2 = new UnfoldingMap(this, mapXposition, mapYposition, mapWidth, mapHeight, new Microsoft.AerialProvider());
        map2.zoomAndPanTo(ZOOM, new Location(lon, lat));
        MapUtils.createDefaultEventDispatcher(this, map1, map2);
    }

    public void draw() {
        background(0);

        // Calculate Fade Value
        if (fadeAlways) {
            fadeOnce = false;
            if (fadeVal == 0 || fadeVal == 255)
                fadeDelta = -fadeDelta;
            fadeVal += fadeDelta;
        }

        if (fadeOnce) {
            if (fadeVal == 0 || fadeVal == 255) {
                fadeDelta = -fadeDelta;
                fadeOnce = false;
            }
            fadeVal += fadeDelta;
        }

        // Draw maps
        tint(255);
        map1.draw();
        tint(255, fadeVal);
        map2.draw();

        // Description at the Top
        fill(255);
        text("Press key '1' to fade once   |   Press key '2' to fade always", 10, 20);
    }

    public void keyPressed() {
        switch (key) {
            case '1':
                fadeAlways = false;
                fadeOnce = true;
                break;
            case '2':
                fadeAlways = true;
                fadeOnce = false;
                break;
        }
    }

    public static void main(String[] args) {
        PApplet.main(new String[]{"de.fhpotsdam.unfolding.examplesForProcessing2_0.animation.FadeTwoMapsApp"});
    }
}
