package de.fhpotsdam.unfolding.examplesForProcessing3_0.animation;

import processing.core.PApplet;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.examplesForProcessing3_0.interaction.NaviButtonMapApp;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.utils.MapUtils;

/**
 * Pans smoothly between three locations, in an endless loop.
 * <p>
 * Press SPACE to switch tweening off (and on again).
 * <p>
 * See {@link NaviButtonMapApp} for an interactive example on how to animate between two locations.
 */
public class PanAnimationMapApp extends PApplet {

    UnfoldingMap map;

    Location[] locations = new Location[]{new Location(52.5, 13.4), new Location(53.6f, 10),
            new Location(51.34, 12.37)};
    int currentLocation = 0;

    public void settings() {
        size(800, 600, JAVA2D);
    }

    public void setup() {
        map = new UnfoldingMap(this);
        map.setTweening(true);
        map.zoomAndPanTo(8, locations[currentLocation]);

        MapUtils.createDefaultEventDispatcher(this, map);
    }

    public void draw() {
        background(0);
        map.draw();

        if (frameCount % 120 == 0) {
            map.panTo(locations[currentLocation]);
            currentLocation++;
            if (currentLocation >= locations.length) {
                currentLocation = 0;
            }
        }
    }

    public void keyPressed() {
        if (key == ' ') {
            map.switchTweening();
        }
    }

    public static void main(String[] args) {
        PApplet.main(new String[]{PanAnimationMapApp.class.getName()});
    }

}