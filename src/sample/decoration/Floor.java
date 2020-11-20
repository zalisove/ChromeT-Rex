package sample.decoration;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import sample.Main;

public class Floor extends Decoration {

    public Floor(double speed, double xPos, double yPos) {
        super(speed, xPos, yPos);
        ImageView imageView = new ImageView(Main.image);
        imageView.setViewport(new Rectangle2D(0, 52, 1200, 15));
        super.getChildren().addAll(imageView);
    }
}
