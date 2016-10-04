package de.fhpotsdam.unfolding.examplesForProcessing2_0.marker.labelmarker;

import processing.core.PApplet;
import processing.core.PFont;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.utils.MapUtils;

/**
 * When user hovers over the marker its label is displayed.
 * 
 * The highlight check is done manually for the marker in mouseMoved().
 */
public class LabeledMarkerApp extends PApplet {

	UnfoldingMap map;

	Location berlinLocation = new Location(52.5f, 13.4f);
	LabeledMarker berlinMarker;
	PFont font;

	public void setup() {
		size(800, 600, OPENGL);

		map = new UnfoldingMap(this, "map", 50, 50, 700, 500);
		map.zoomToLevel(3);
		map.panTo(berlinLocation);
		MapUtils.createDefaultEventDispatcher(this, map);

		font = loadFont("ui/OpenSans-12.vlw");
		berlinMarker = new LabeledMarker(berlinLocation, "Berlin", font, 15);
		map.addMarkers(berlinMarker);
	}

	public void draw() {
		background(240);
		map.draw();
	}

	/**
	 * Check for hit test directly with marker.
	 * 
	 * See {@link MultiLabeledMarkerApp} for using MarkerManager to handling hit tests.
	 */
	public void mouseMoved() {
		if (berlinMarker.isInside(map, mouseX, mouseY)) {
			berlinMarker.setSelected(true);
		} else {
			berlinMarker.setSelected(false);
		}
	}

}
