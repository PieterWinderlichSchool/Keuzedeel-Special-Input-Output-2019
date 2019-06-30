package Objects;

import FrameWork.StandardBehaviour;
import FrameWork.Vector2d;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyEvent;
import sample.Main;


public class AmmoClip extends StandardBehaviour {
    private EventHandler<MouseEvent> refOnMouseClicked = this::Fire;
    private EventHandler<KeyEvent> refOnKeyPressed = this::Reload;
    private boolean mouseClicked = false;
    public Bullet[] clip = new Bullet[6];
    public int bulletcount = 0;


    public AmmoClip(Vector2d transform){
        Main.myPane.addEventHandler(MouseEvent.MOUSE_CLICKED, this::Fire);
        Main.myPane.addEventHandler(KeyEvent.KEY_PRESSED, this::Reload);

    //this.transform = transform;

    Reload();
    }



    @Override
    public void Update(long nanoTime) {

    }
    public void Fire(MouseEvent event){

        if(event.getEventType() == MouseEvent.MOUSE_CLICKED ) {



            if (clip[bulletcount] != null) {

                clip[bulletcount].Fire(this.transform.GetXPos(), this.transform.GetYPos(), this.transform.GetRot());

                Main.SpawnBullet(clip[bulletcount]);
                clip[bulletcount] = null;
                bulletcount += 1;

                if (bulletcount >= 6) {
                    bulletcount = 0;
                }


            }else{

                return;
            }

        }




    }
    public void Reload(KeyEvent event){
        if(event.getCode() == KeyCode.SPACE || event.getCode() == KeyCode.R){

            for (int i = 0; i <= 5; i++) {
                if (clip[i] == null) {
                    clip[i] = new Bullet( 20, 20);
                }
            }
        }

    }
    public void Reload(){
        for (int i = 0; i <= 5; i++) {
            if (clip[i] == null) {
                clip[i] = new Bullet( 20, 20);
            }else;// You better work you piece of shit;
        }
    }



}
