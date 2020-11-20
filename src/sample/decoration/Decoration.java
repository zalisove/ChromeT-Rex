package sample.decoration;

import javafx.scene.layout.Pane;

abstract public class Decoration extends Pane {

    private double speed;
    private double xPos;

    public Decoration(double speed, double xPos, double yPos) {
        this.speed = speed;
        this.xPos = xPos;
        this.setTranslateX(xPos);
        this.setTranslateY(yPos);
    }

    public void acceleration(double acc){
        speed +=acc;
    }

    public void setyPos(double yPos) {
        this.setTranslateY(yPos);
    }

    public double getXPos() {
        xPos = getTranslateX();
        return xPos;
    }

    public void setXPos(double xPos) {
        this.xPos = xPos;
        this.setTranslateX(xPos);
    }

    public void update(){
        setTranslateX(getTranslateX() - speed);
    }

}
