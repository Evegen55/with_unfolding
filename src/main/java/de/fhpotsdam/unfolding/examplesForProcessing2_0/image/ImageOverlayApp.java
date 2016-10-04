package de.fhpotsdam.unfolding.examplesForProcessing2_0.image;

import processing.core.PApplet;
import processing.core.PImage;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.DebugDisplay;
import de.fhpotsdam.unfolding.utils.MapUtils;
import de.fhpotsdam.unfolding.utils.ScreenPosition;

/**
 * Shows a static image laid over an interactive background map. The north-west and south-east boundaries of the image
 * are used to position and scale the image. (There is no tile mechanism for the overlay image).
 * 
 * In this example, the image shows from where people take pictures of famous sights. The visualization is laid over a
 * satellite map. Below, you can see how people photograph the Hans-Otto-Theater in Potsdam, Germany. See
 * http://schwinki.de/splendor/ for more information.
 * 
 */
public class ImageOverlayApp extends PApplet {

	UnfoldingMap map;
	Location center = new Location(52.396, 13.058);

	DebugDisplay debugDisplay;

	PImage visImg;

	// Kaiserbahnhof Potsdam, 52.39466, 13.013944 (west)
	// Meierei, 52.421944, 13.069722 (north)
	// Schloss Babelsberg, 52.407639, 13.093289 (east)
	// Potsdam Hauptbahnhof, 52.391667, 13.066667 (south)

	Location visNorthWest = new Location(52.421944, 13.013944);
	Location visSouthEast = new Location(52.391667, 13.093289);

	public void setup() {
		size(1400, 800, OPENGL);

		// Very low quality for file size reasons. Use original from http://schwinki.de/splendor/
		visImg = loadImage("test/splendor-big.jpg");

		map = new UnfoldingMap(this, "Satellite Map", new Microsoft.AerialProvider());
		map.zoomAndPanTo(center, 14);
		MapUtils.createDefaultEventDispatcher(this, map);

		debugDisplay = new DebugDisplay(this, map);
	}

	public void draw() {
		map.draw();

		ScreenPosition topRight = map.getScreenPosition(visNorthWest);
		ScreenPosition bottomLeft = map.getScreenPosition(visSouthEast);

		float width = bottomLeft.x - topRight.x;
		float height = bottomLeft.y - topRight.y;

		tint(255, 127);
		image(visImg, topRight.x, topRight.y, width, height);

		debugDisplay.draw();
	}
}
