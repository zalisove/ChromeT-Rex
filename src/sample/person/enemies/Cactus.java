package sample.person.enemies;


import javafx.scene.image.Image;
import sample.Main;

public class Cactus extends Enemies {



    public static Cactus THREE_SMALL(double x){
        return new Cactus(x,50,31,280,3, Main.image);
    }
    public static Cactus TWO_SMALL(double x){
        return new Cactus(x,33,31,246,3, Main.image);
    }
    public static Cactus ONE_SMALL(double x){
        return new Cactus(x,17,31,228,3, Main.image);
    }
    public static Cactus TWO_BIG(double x){
        return new Cactus(x,50,47,358,3, Main.image);
    }
    public static Cactus ONE_BIG(double x){
        return new Cactus(x,27,47,331,3, Main.image);
    }
    public static Cactus BIG_COMBO(double x){
        return new Cactus(x,75,47,408,3, Main.image);
    }


    private Cactus(double x, double width, double height, int offsetX, int offsetY, Image image) {
        super(x, 410 - height, width, height,offsetX,offsetY,image);
    }
}
