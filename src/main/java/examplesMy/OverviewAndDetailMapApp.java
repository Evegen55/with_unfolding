package examplesMy;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.events.EventDispatcher;
import de.fhpotsdam.unfolding.interactions.MouseHandler;
import processing.core.PApplet;

public class OverviewAndDetailMapApp extends PApplet {

    UnfoldingMap mapDetail;
    UnfoldingMap mapOverview;

    @Override
    public void settings() {
        size(800, 600);

        mapDetail = new UnfoldingMap(this, "detail", 10, 10, 585, 580);
        mapOverview = new UnfoldingMap(this, "overview", 605, 10, 185, 185);

        EventDispatcher eventDispatcher = new EventDispatcher();

        // Add mouse interaction to both maps
        MouseHandler mouseHandler = new MouseHandler(this, mapDetail, mapOverview);
        eventDispatcher.addBroadcaster(mouseHandler);

        // Maps listen to each other, i.e. each interaction in one map is reflected in the other
        eventDispatcher.register(mapDetail, "pan", mapDetail.getId(), mapOverview.getId());
        eventDispatcher.register(mapDetail, "zoom", mapDetail.getId(), mapOverview.getId());
        eventDispatcher.register(mapOverview, "pan", mapDetail.getId(), mapOverview.getId());
        eventDispatcher.register(mapOverview, "zoom", mapDetail.getId(), mapOverview.getId());
    }

    @Override
    public void draw() {
        background(0);
        mapDetail.draw();
        mapOverview.draw();
    }
}
