package Objects;

import FrameWork.SpriteRenderer;
import FrameWork.StandardBehaviour;
import sample.Main;
import javafx.scene.input.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.event.EventHandler.*;


public class Player extends StandardBehaviour {

    private int health = 100;
    private double speed = 50;
    public double xSize;
    public double ySize;
    public String path = "Objects/images/UsSoldier.png";
    private EventHandler<KeyEvent> refOnKeyPressed = this::Move;
    private AmmoClip clip;

    private SpriteRenderer sprite;

    public Player(double xSize , double ySize ,  double xPos , double yPos , double rot){
        this.update.start();
        this.transform.SetXPos(xPos);
        this.transform.SetYPos(yPos);
        this.transform.SetRot(rot);

        this.xSize = xSize;
        this.ySize = ySize;

        sprite = new SpriteRenderer(path,transform.GetXPos(),transform.GetYPos(),this.ySize,this.xSize,transform.GetRot());
        AddComponent(sprite);
        Main.myPane.addEventHandler(KeyEvent.KEY_PRESSED, this::Move);
        sprite.RenderSprite(Main.myPane);
        clip = new AmmoClip(this.transform);

    }

    public int GetHealth(){
        return health;

    }
    public void SetHealth(int health){
        health = health;
    }
    public double GetSpeed(){
        return speed;
    }
    public void SetSpeed(int speed){
        this.speed = speed;
    }

    @Override
    public void Update(long nanoTime){
        clip.transform = this.transform;

    }

    public void Move(KeyEvent event){

        if(event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT){

            if(transform.GetXPos() <= 0 ){

                return;
            }else{

                transform.AddVelocityX(-speed);
                sprite.SetXPos(transform.GetXPos());
            }
        }
        if(event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT){

            if(transform.GetXPos() >= 1750){
                return;
            }else{
                transform.AddVelocityX(speed);
                sprite.SetXPos(transform.GetXPos());
            }
        }







    }
}
//|| transform.GetXPos() >= Main.screenWidth
