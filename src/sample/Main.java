package sample;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import sample.person.Dino;
import sample.person.enemies.Enemies;

import javax.sound.sampled.Clip;
import java.util.Timer;
import java.util.TimerTask;


public class Main extends Application {
    public static Image image ;

    private ObservableList<Enemies> enemies;
    private boolean isBendDown = false;
    private boolean isAlign = false;
    private boolean isGameGo = false;
    private Timer timer;
    private final Pane root = new Pane();
    private Dino dino ;
    private ContentMaker contentMaker ;
    public static GameMusic gameMusic;
    @Override
    public void start(Stage primaryStage) {

        gameMusic = new GameMusic();
        gameMusic.backgroundMusic();

        image = new Image( getClass().getResourceAsStream("res/100-offline-sprite.png"));

        ImageView startImage = new ImageView(new Image( getClass().getResourceAsStream("res/startImage.png")));
        startImage.setViewport(new Rectangle2D(0,0,880,90));
        startImage.setTranslateX(70);
        startImage.setTranslateY(150);
        root.getChildren().addAll(startImage);
        primaryStage.setTitle("Dino");
        Scene scene = new Scene(root, 800, 420);
        primaryStage.setScene(scene);
        scene.setOnKeyPressed(event -> {

            System.out.println(event.getCode().getName());

            if(event.getCode().getName().equals("G")){
                if(!isGameGo) {
                    image = new Image( getClass().getResourceAsStream("res/greeen.png"));
                    isGameGo = true;
                    startGame();
                }
            }
            if(event.getCode().getName().equals("B")){
                if(!isGameGo) {
                    image = new Image( getClass().getResourceAsStream("res/blue.png"));
                    isGameGo = true;
                    startGame();
                }
            }
            if(event.getCode().getName().equals("O")){
                if(!isGameGo) {
                    image = new Image( getClass().getResourceAsStream("res/orange.png"));
                    isGameGo = true;
                    startGame();
                }
            }
            if(event.getCode().getName().equals("R")){
                if(!isGameGo) {
                    image = new Image( getClass().getResourceAsStream("res/red.png"));
                    isGameGo = true;
                    startGame();
                }
            }
            if(event.getCode().getName().equals("F")){
                if(!isGameGo) {
                    image = new Image( getClass().getResourceAsStream("res/bblue.png"));
                    isGameGo = true;
                    startGame();
                }
            }
            if(event.getCode().getName().equals("Y")){
                if(!isGameGo) {
                    image = new Image( getClass().getResourceAsStream("res/yellow.png"));
                    isGameGo = true;
                    startGame();
                }
            }

            if(event.getCode().getName().equals("V")){
                if(!isGameGo) {
                    image = new Image( getClass().getResourceAsStream("res/violet.png"));
                    isGameGo = true;
                    startGame();
                }
            }
            if(event.getCode().getName().equals("S")){
                if(!isGameGo) {
                    image = new Image( getClass().getResourceAsStream("res/100-offline-sprite.png"));
                    isGameGo = true;
                    startGame();
                }
            }


            if(event.getCode().getName().equals("Space")||event.getCode().getName().equals("Up")
                    ||event.getCode().getName().equals("Down")){
                if(!isGameGo) {
                    isGameGo = true;
                    startGame();
                }
            }



            if(event.getCode().getName().equals("Space")){
                dino.jump();
            }
            if(event.getCode().getName().equals("Up") ){
                dino.jump();
            }
            if(event.getCode().getName().equals("Down")){
                isBendDown = true;
            }

        });

        scene.setOnKeyReleased(event -> {
            if(event.getCode().getName().equals("Down")){
                isAlign = true;
            }
        });
        scene.setOnMouseClicked(event ->{
            if(!isGameGo) {
                isGameGo = true;
                startGame();
            }
            dino.jump();
        });

        primaryStage.setOnCloseRequest(e -> {
            Platform.exit();
            if (timer != null) timer.cancel();
        });
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    void startGame(){
        Enemies.speed = 2.5;
        enemies = FXCollections.observableArrayList();
        dino =  new Dino(enemies,image);
        root.getChildren().clear();
        root.getChildren().addAll(dino);
        contentMaker = new ContentMaker(enemies,root);
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    if(isBendDown) isBendDown = dino.bendDown();
                    if(isAlign) isAlign = dino.align();
                    contentMaker.update();
                    if(dino.update()) {
                        stopGame();
                    }
                });
            }
        }, 0, 10);
    }

    private void stopGame(){
        isGameGo = false;
        timer.cancel();
        ImageView button = new ImageView(image);
        button.setViewport(new Rectangle2D(2,2,37,34));
        button.setFitHeight(50);
        button.setFitWidth(50);
        button.setTranslateX(370);
        button.setTranslateY(300);
        root.getChildren().add(button);
        gameMusic.death();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
