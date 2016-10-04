package de.fhpotsdam.unfolding.examplesForProcessing2_0.geo;

import java.util.List;

import processing.core.PApplet;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.utils.GeoUtils;
import de.fhpotsdam.unfolding.utils.MapUtils;

public class ZoomToFitApp extends PApplet {

	UnfoldingMap map;

	public void setup() {
		size(800, 800, OPENGL);

		map = new UnfoldingMap(this);
		MapUtils.createDefaultEventDispatcher(this, map);
		map.setTweening(true);

		List<Feature> countryFeatures = GeoJSONReader.loadData(this, "countries.geo.json");
		List<Marker> countryMarkers = MapUtils.createSimpleMarkers(countryFeatures);
		map.addMarkers(countryMarkers);
	}

	public void draw() {
		background(240);
		map.draw();
	}

	public void mouseClicked() {
		Marker marker = map.getFirstHitMarker(mouseX, mouseY);
		if (marker != null) {
			map.zoomAndPanToFit(GeoUtils.getLocations(marker));
		} else {
			map.zoomAndPanTo(2, new Location(0, 0));
		}
	}

}
