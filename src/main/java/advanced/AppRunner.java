package advanced;

import examples.HelloUnfoldingWorld;
import examples.OverviewAndDetailMapApp;
import examples.ViewToEPAM;
import processing.core.PApplet;

/**
 * Created by Evgenii_Lartcev on 10/4/2016.
 */
public class AppRunner {

    /**
     * @param args name of classes that have to start
     */
    public static void main(String[] args) {
        PApplet.main(new String[]{
                //MapWithFeautures.class.getName(),
                //ViewToEPAM.class.getName(),
                //HelloUnfoldingWorld.class.getName()
                OverviewAndDetailMapApp.class.getName(),
                }
        );
    }
}
