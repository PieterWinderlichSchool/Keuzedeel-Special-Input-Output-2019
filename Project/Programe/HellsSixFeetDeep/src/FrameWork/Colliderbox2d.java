package FrameWork;


import java.util.ArrayList;

public class Colliderbox2d extends StandardBehaviour {

    public SpriteRenderer sprite;
    private double _locationX;
    private double _locationY;
    private double _width;
    private double _height;
    public ArrayList<SpriteRenderer> list = new ArrayList<SpriteRenderer>();
    public boolean collisionDetected = false;

    
    public Colliderbox2d(SpriteRenderer sprite){
        update.start();
    this.sprite = sprite;




    }
    public void SetSprite(SpriteRenderer sprite){
        this.sprite = sprite;
    }
    public void SetList(ArrayList<SpriteRenderer> spriteList){
        this.list = spriteList;


    }

    public boolean checkCollision(double obj_x, double obj_y, double obj_width, double obj_height)
    {
        if( _locationX <= obj_x + obj_width &&
                _locationX + _width >= obj_x &&
                _locationY <= obj_y + obj_height &&
                _locationY + _height >= obj_y ) return true;
        else return false;
    }


    @Override

    public void Update(long nanoTime) {
        _locationY = this.sprite.GetYPos();
        _locationX = this.transform.GetXPos();
        _width = this.sprite.imageContainer.getFitWidth();
        _height = this.sprite.imageContainer.getFitWidth();




        for(int i = 0; i < list.size(); i++){
            if(checkCollision(list.get(i).GetXPos(),list.get(i).GetYPos(),list.get(i).imageContainer.getFitWidth(),list.get(i).imageContainer.getFitHeight())){

                collisionDetected = true;
            } else{

                collisionDetected = false;


            }

        }

    }

}
