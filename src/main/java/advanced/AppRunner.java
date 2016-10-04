package advanced;

import processing.core.PApplet;

/**
 * @author Evgenii_Lartcev (10/4/2016).
 */
public class AppRunner {

    /**
     * @param args name of classes that have to start
     */
    public static void main(String[] args) {
        PApplet.main(new String[]{
                        MapWithFeautures.class.getName(),
                        //ViewToEPAM.class.getName(),
                        //HelloUnfoldingWorld.class.getName()
                }
        );
    }
}
