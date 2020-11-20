package sample.person;

import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import sample.GameMusic;
import sample.person.enemies.Enemies;


public class Dino extends Pane {
    private int offsetX = 936;
    private int offsetY = 3;
    private int width = 44;
    private int height = 47;

    private final SpriteAnimation animation;

    private final ObservableList<Enemies> enemies;
    private double impuls;
    private boolean isJump = false;

    public Dino(ObservableList<Enemies> enemies, Image image) {
        ImageView dino = new ImageView(image);
        dino.setViewport(new Rectangle2D(offsetX,offsetY,width,height));
        int columns = 2;
        int count = 2;
        this.animation = new SpriteAnimation(dino, Duration.millis(200), count, columns,offsetX,offsetY,width,height);
        this.animation.play();
        this.enemies = enemies;
        this.getChildren().addAll(dino);
        this.setTranslateX(10);
        this.setTranslateY(410-height);
    }

    private boolean intersects(Enemies enem){
        double coordinateShift = 4;
        double shiftCharacteristics = -8;
        double leftX = Math.max (getTranslateX ()+coordinateShift, enem.getTranslateX()+coordinateShift);
        double rightX =  Math.min (getTranslateX() + getWidth () + shiftCharacteristics,
                enem.getTranslateX () + enem.getWidth ()+shiftCharacteristics);
        double topY = Math.max (getTranslateY()+coordinateShift, enem.getTranslateY ()+coordinateShift);
        double bottomY =  Math.min (getTranslateY () + getHeight () + shiftCharacteristics,
                enem.getTranslateY() + enem.getHeight ()+shiftCharacteristics);
        return ( leftX < rightX && topY < bottomY );
    }



    public boolean update(){

        if(isJump){
            setTranslateY(getTranslateY() + impuls);
            impuls += 0.14;
        }

        if((int)(getTranslateY()) > 410-height){
            isJump = false;
            this.setTranslateY(410-height);
            animation.setOffsetX(936);
        }

        if(enemies.size() > 2)
        for (int i = 0; i < 2; i++) {

            if (intersects(enemies.get(i))){
                height = 47;
                width = 44;
                offsetX = 1024;
                offsetY = 3;
                animation.setOffsetX(offsetX);
                animation.setOffsetY(offsetY);
                animation.setHeight(height);
                animation.setWidth(width);
                return true;
            }
        }
        return false;
    }

    public void jump(){
        if(!isJump) {
            height = 47;
            width = 44;
            offsetX = 936;
            offsetY = 3;
            animation.setOffsetX(offsetX);
            animation.setOffsetY(offsetY);
            animation.setHeight(height);
            animation.setWidth(width);
            setTranslateY(410 - height);
            animation.setOffsetX(848);
            isJump = true;
            impuls = -4.9;
            GameMusic.jump();
        }
    }

    public boolean bendDown(){
        if(!isJump) {
            height = 30;
            width = 60;
            offsetX = 1111;
            offsetY = 20;
            animation.setOffsetX(offsetX);
            animation.setOffsetY(offsetY);
            animation.setHeight(height);
            animation.setWidth(width);
            setTranslateY(410 - height);
            return false;
        }
        return true;
    }

    public boolean align(){
        if(!isJump) {
            height = 47;
            width = 44;
            offsetX = 936;
            offsetY = 3;
            animation.setOffsetX(offsetX);
            animation.setOffsetY(offsetY);
            animation.setHeight(height);
            animation.setWidth(width);
            setTranslateY(410 - height);
            return false;
        }
        return true;
    }


}
