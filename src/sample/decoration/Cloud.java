package sample.decoration;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import sample.Main;

public class Cloud extends Decoration{
    public Cloud(double speed, double xPos, double yPos) {
        super(speed, xPos, yPos);
        ImageView imageView = new ImageView(Main.image);
        imageView.setViewport(new Rectangle2D(90, 0, 40, 15));
        super.getChildren().addAll(imageView);
    }
}
