package sample;


import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import sample.decoration.Cloud;
import sample.decoration.Floor;
import sample.person.enemies.Cactus;
import sample.person.enemies.Enemies;
import sample.person.enemies.Pterodactyl;

public class ContentMaker {
    private ObservableList<Enemies> enemies;
    private Floor floor[] = {new Floor(Enemies.speed,0,395),new Floor(Enemies.speed,1190,395)};
    private Cloud[] clouds = new Cloud[5];
    private Pane root;
    private Text score ;
    private int scoreInt;
    public ContentMaker(ObservableList<Enemies> enemies,Pane root) {
        this.enemies = enemies;
        this.root = root;
        score = new Text("Sсore :" + scoreInt);
        score.setTranslateX(720);
        score.setTranslateY(20);
        cloudMaker();
        root.getChildren().addAll(floor[0],floor[1],score);

        for (Cloud c : clouds) {
            root.getChildren().addAll(c);
        }
        enemies.addListener((ListChangeListener<Enemies>) c -> {
            while (c.next() && !enemies.isEmpty() ) {

                    if (c.wasRemoved()) {
                        root.getChildren().remove(9);
                    }
                    if (c.wasAdded()) {
                        root.getChildren().addAll(enemies.get(enemies.size() - 1));
                    }

            }
        });
    }

    public void update(){
        chooseEnemy();
        cloudUpdate();
        for (Floor e: floor) {
            e.update();
            if(e.getXPos() < -1190){
                e.setXPos(1190);
            }
        }

        for (Enemies e: enemies) {
            e.update();
        }
        if(enemies.get(0).getTranslateX() < -60){
            for (Floor f: floor) {
                f.acceleration(0.01);
            }
            Enemies.speed +=0.01;
            enemies.remove(0);
            scoreInt++;
            score.setText("Sсore :" + scoreInt);
        }
    }

    private void cloudMaker(){
        clouds[0] = new Cloud(1,Math.random()*200+800,Math.random()*300);
        for (int i = 1; i < 5; i++) {
            clouds[i] = new Cloud(1,clouds[i-1].getXPos()+Math.random()*200+220,Math.random()*300);
        }
    }


    private void cloudUpdate(){

        for (int i = 0; i < 5; i++) {
            if(clouds[i].getXPos() < -60){
                if (i==0){
                    clouds[i].setXPos(clouds[4].getXPos() + Math.random()*200+220);
                }else clouds[i].setXPos(clouds[i-1].getXPos() + Math.random()*200+220);
                clouds[i].setyPos(Math.random()*300);
            }
            clouds[i].update();
        }
    }
    private void chooseEnemy(){
        if(enemies.size() < 5){
            double length = 1000;
            if(!enemies.isEmpty())
                length = enemies.get(enemies.size()-1).
                        getTranslateX()+(Enemies.speed*Math.sqrt(60*0.9)*5)*2+100+Math.random()*100;

            switch ((int)(Math.random()*2)){
                case 0:{
                 switch ((int)(Math.random()*6)){
                     case 0:{
                         enemies.add(Cactus.ONE_SMALL(length));
                     }break;

                     case 1:{
                         enemies.add(Cactus.TWO_SMALL(length));
                     }break;

                     case 2:{
                         enemies.add(Cactus.THREE_SMALL(length));
                     }break;

                     case 3:{
                         enemies.add(Cactus.ONE_BIG(length));
                     }break;

                     case 4:{
                         enemies.add(Cactus.TWO_BIG(length));
                     }break;

                     case 5:{
                         enemies.add(Cactus.BIG_COMBO(length));
                     }break;
                 }
                }break;
                case 1: {
                    switch ((int)(Math.random()*3)){
                        case 0:{
                            enemies.add(Pterodactyl.LOW(length));
                        }break;
                        case 1:{
                            enemies.add(Pterodactyl.HIGH(length));
                        }break;
                        case 2:{
                            enemies.add(Pterodactyl.AVERAGE(length));
                        }break;
                    }
                }break;
            }
        }
    }


}
