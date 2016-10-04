package de.fhpotsdam.unfolding.examplesForProcessing2_0.marker.cluster;

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.events.MapEvent;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.MarkerManager;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.utils.MapUtils;

public class MarkerClusterApp extends PApplet {

	UnfoldingMap map;
	List<Marker> markers;
	List<Marker> clusteredMarkers;

	public void setup() {
		size(600, 400);

		map = new UnfoldingMap(this);
		MapUtils.createDefaultEventDispatcher(this, map);

		markers = createRandomMarkers(200);

		// Default marker manager
		// MarkerManager<Marker> markerManager = new MarkerManager<Marker>();
		// markerManager.addMarkers(markers);
		// map.addMarkerManager(markerManager);

		// Cluster marker manager

	}

	public void draw() {
		map.draw();

	}

	public void mapChanged(MapEvent mapEvent) {
		MarkerManager<Marker> mm = map.getDefaultMarkerManager();
		mm.clearMarkers();
		clusteredMarkers = getClusteredMarkers(markers, 1000);
		println("Added " + clusteredMarkers.size() + " clusters");
		mm.addMarkers(clusteredMarkers);
	}

	public List<Marker> getClusteredMarkers(List<Marker> markers, float distance) {
		List<Marker> clusteredMarkers = new ArrayList<Marker>();

		for (Marker marker : markers) {
			for (Marker otherMarker : markers) {
				if (marker.getDistanceTo(otherMarker.getLocation()) < distance) {
					clusteredMarkers.add(marker);
				}
			}
		}

		return clusteredMarkers;
	}

	private List<Marker> createRandomMarkers(int numbers) {
		List<Marker> markers = new ArrayList<Marker>();
		for (int i = 0; i < numbers; i++) {
			SimplePointMarker m = new SimplePointMarker(new Location(random(-85, 85), random(-180, 180)));
			markers.add(m);
		}
		return markers;
	}

}
