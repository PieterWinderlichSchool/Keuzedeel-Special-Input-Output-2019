package Objects;

import FrameWork.*;
import sample.Main;
import javafx.application.*;

import javax.swing.text.html.ImageView;

public class Enemy extends StandardBehaviour {

    private int Health = 100;
    private int speed = 3;
    public double xSize;
    public double ySize;
    public String path = "Objects/images/GermanSoldier.png";
    public SpriteRenderer sprite;
    public Colliderbox2d collider;
    public Enemy(double xSize , double ySize ,  double xPos , double yPos , double rot){
        this.update.start();
        transform.SetXPos(xPos);
        transform.SetYPos(yPos);
        transform.SetRot(rot);

        this.xSize = xSize;
        this.ySize = ySize;

         sprite = new SpriteRenderer(path,transform.GetXPos(),transform.GetYPos(),this.ySize,this.xSize,transform.GetRot());
         AddComponent(sprite);

        sprite.RenderSprite(Main.myPane);
        collider = new Colliderbox2d(sprite);
    }
    public void DeconstructEnemy(int i){


        Main.myPane.getChildren().remove(sprite.imageContainer);
        Main.sceneListEnemy.remove(Main.sceneListEnemy.get(i));

    }

    public int GetHealth(){
        return Health;

    }
    public void SetHealth(int health){
        Health = health;
    }
    public int GetSpeed(){
        return speed;
    }
    public void SetSpeed(int speed){
        this.speed = speed;
    }


    @Override
    public void Update(long nanoTime){
        transform.AddVelocityY(speed);
        sprite.SetYPos(transform.GetYPos());
        sprite.SetXPos(transform.GetXPos());
        collider.SetSprite(this.sprite);
        collider.SetList(Main.getSpriteListBullet());
    }


}
