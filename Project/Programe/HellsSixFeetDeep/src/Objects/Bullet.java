package Objects;


import FrameWork.SpriteRenderer;
import FrameWork.StandardBehaviour;
import FrameWork.*;



import sample.Main;

public class Bullet extends StandardBehaviour {

    public double xSize;
    public double ySize;
    public int speed = 30;

    public Colliderbox2d collider;

    public SpriteRenderer sprite;

    public Bullet(double xSize, double ySize){
        this.xSize = xSize;
        this.ySize = ySize;

        sprite = new SpriteRenderer("Objects/images/Bullet.png",transform.GetXPos(),transform.GetYPos(),ySize , xSize , transform.GetRot());
        collider = new Colliderbox2d(sprite);

    }
    public void DeconstructBullet(int i){


        Main.myPane.getChildren().remove(sprite.imageContainer);

        Main.sceneListBullet.remove(i);



    }


    @Override
    public void Update(long nanoTime){
        transform.AddVelocityY(-speed);
        sprite.SetYPos(transform.GetYPos());
        collider.SetSprite(this.sprite);
        collider.SetList(Main.getSpriteListEnemy());




    }
    public void Fire(double xPos , double yPos ,  double Rot){

        this.transform.SetXPos(xPos);
        this.transform.SetYPos(yPos);
        this.transform.SetRot(Rot);
        sprite.SetXPos(transform.GetXPos());



        sprite.RenderSprite(Main.myPane);


        sprite.SetXPos(transform.GetXPos() + 100);

        System.out.println(sprite.GetXPos());

        this.update.start();


    }

}
