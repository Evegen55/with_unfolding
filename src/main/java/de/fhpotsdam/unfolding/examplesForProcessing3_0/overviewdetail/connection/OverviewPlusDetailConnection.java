package de.fhpotsdam.unfolding.examplesForProcessing3_0.overviewdetail.connection;

public interface OverviewPlusDetailConnection {
	
	public void setPadding(float padding);

	public void setDetailPosition(float x, float y);
	
	public void setDetailSize(float width, float height);
	
	public void setOverviewPosition(float x, float y);
	
	public void setOverviewSize(float width, float height);

	public void draw();
	
}
