package examples;

import processing.core.PApplet;

/**
 * @author Evgenii_Lartcev
 * Hello Unfolding World.
 */
public class HelloUnfoldingWorld extends PApplet {

    @Override
    public void settings() {
        size(800, 600, JAVA2D);
    }

    @Override
    public void setup() {
        surface.setResizable(true);
    }

    public static void main(String[] args) {
        PApplet.main(new String[]{"examplesForProcessing2_0.HelloUnfoldingWorld"});
    }

}
