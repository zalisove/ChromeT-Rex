package sample.person.enemies;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public  abstract class Enemies extends Pane {
    private final ImageView body ;
    public static double speed = 2.5;

    public Enemies(double x, double y, double width, double height, int  offsetX, int offsetY, Image image) {
        this.body = new ImageView(image);
        this.body.setViewport(new Rectangle2D(offsetX,offsetY,width,height));
        this.getChildren().addAll(this.body);
        setTranslateX(x);
        setTranslateY(y);
    }

    public ImageView getBody() {
        return body;
    }

    public void update(){
        setTranslateX(getTranslateX()-speed);
    }

}
