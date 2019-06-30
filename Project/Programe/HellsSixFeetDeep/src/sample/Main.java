package sample;


import FrameWork.*;
import Objects.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.layout.Pane;

import javafx.stage.Stage;
import javafx.scene.image.*;

import java.util.ArrayList;


public class Main extends Application {
    public CustomAnimationTimer update = new CustomAnimationTimer(this::Update);
    public Image image = new Image("Objects/images/Field.png");
    public ImageView backgroundImage = new ImageView(image);
    public static Pane myPane = new Pane();
    public Enemy enemy;
    public Player player;
    public static ArrayList<Enemy> sceneListEnemy = new ArrayList<Enemy>();
    public static ArrayList<Bullet> sceneListBullet = new ArrayList<Bullet>();
    public static int screenWidth = 1920;
    public static int screenHeight = 1080;
    private int _spawnTimer = 0;
    @Override
    public void start(Stage primaryStage) throws Exception{

        this.update.start();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hells six feet deep");
        primaryStage.setScene(new Scene(myPane, screenWidth, screenHeight));
        backgroundImage.setFitWidth(1920);backgroundImage.setFitHeight(1080);
        myPane.getChildren().add(backgroundImage);
        primaryStage.show();

        for(int i = 0; i<7; i++){
            SpawnLane(i);

        }

        SpawnLane(0,875,"Objects/images/Planks.png");



        player = new Player(250,250,800,790,0);

        //myPane.addEventHandler(KeyEvent.KEY_PRESSED, player::Move);
        myPane.requestFocus();
        //SpawnUnits();


        /*Pane pane = new Pane();
        primaryStage.setScene(new Scene(pane,500,500));
        ImageView imageV = new ImageView(new Image("sample/images/GermanSoldier.png"));
        pane.getChildren().add(imageV);
        primaryStage.show();

         */
    }
    public void SpawnUnits(double i){

       Enemy enemy = new Enemy(150,150, i*290,10, 180);
        sceneListEnemy.add(enemy);
    }

    public static void SpawnBullet(Bullet bullet){
        sceneListBullet.add(bullet);
    }

    public void SpawnLane(int i){
        Object Lane = new Lane(i*290,0);

    }
    public void SpawnLane(double xPos, double yPos, String Path){
        Object Lane = new Lane(xPos, yPos , 1920 , 250 ,0 , Path);

    }


    public void Update(long nanoTime){

        for (int i = 0; i <sceneListEnemy.size(); i++ ){

            if(sceneListEnemy.get(i).transform.GetYPos()>= screenHeight || sceneListEnemy.get(i).collider.collisionDetected){

                sceneListEnemy.get(i).DeconstructEnemy(i);

            }
        }

        for (int i = 0; i <sceneListBullet.size(); i++){
           // System.out.println(sceneListBullet);

            if(sceneListBullet.get(i).transform.GetYPos() <= 0 ){

                sceneListBullet.get(i).DeconstructBullet(i);


            }
        }



        _spawnTimer++;
        if(_spawnTimer >= 80){

            SpawnUnits((int) Math.floor(Math.random() * 7));
            _spawnTimer = 0;
        }
    }


    public static void main(String[] args) {


        launch(args);
    }
    public static ArrayList<SpriteRenderer> getSpriteListEnemy(){

        ArrayList<SpriteRenderer> spriteList = new ArrayList<SpriteRenderer>();

        for(int i = 0; i < sceneListEnemy.size(); i++){

            spriteList.add(sceneListEnemy.get(i).sprite);

        }
        return spriteList;
    }


    public static ArrayList<SpriteRenderer> getSpriteListBullet(){
        ArrayList<SpriteRenderer> spriteList = new ArrayList<SpriteRenderer>();
        for(int i = 0; i < sceneListBullet.size(); i++){
            spriteList.add(sceneListBullet.get(i).sprite);

        }
        return spriteList;
    }




}
