package sample.person.enemies;

import javafx.scene.image.Image;
import javafx.util.Duration;
import sample.Main;
import sample.person.SpriteAnimation;

public class Pterodactyl extends Enemies {
    public static Pterodactyl LOW(double x){
        return new Pterodactyl(x,410 - 43,137,3, Main.image);
    }
    public static Pterodactyl HIGH(double x){
        return new Pterodactyl(x,315,137,3, Main.image);
    }
    public static Pterodactyl AVERAGE(double x){
        return new Pterodactyl(x,410-43-30,137,3, Main.image);
    }

    private Pterodactyl(double x, double y,int offsetX, int offsetY, Image image) {
        super(x, y, 45, 40,offsetX,offsetY,image);
        int width = 43;
        int height = 45;
        SpriteAnimation animation = new SpriteAnimation(super.getBody(), Duration.millis(200), 2, 2, offsetX, offsetY, width, height);
        animation.play();
    }

}
