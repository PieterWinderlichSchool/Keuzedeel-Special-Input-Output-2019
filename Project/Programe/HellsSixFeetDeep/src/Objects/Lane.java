package Objects;

import FrameWork.SpriteRenderer;
import FrameWork.StandardBehaviour;

import sample.Main;

import java.util.ArrayList;

public class Lane extends StandardBehaviour {

    private double xSize;
    private double ySize;
    public ArrayList<Object> containmentList = new ArrayList<Object>();
    public SpriteRenderer sprite;



    public Lane(double xPos, double yPos){
        transform.SetXPos(xPos);
        transform.SetYPos(yPos);

    }
    public Lane(double xPos, double yPos ,double xSize , double ySize, double rot, String path){
        this.update.start();
        transform.SetXPos(xPos);
        transform.SetYPos(yPos);
        transform.SetRot(rot);
        this.xSize = xSize;
        this.ySize = ySize;
        sprite = new SpriteRenderer(path,transform.GetXPos() , transform.GetYPos() ,this.ySize , this.xSize , transform.GetRot());
        AddComponent(sprite);
        sprite.RenderSprite(Main.myPane);
    }
    public void AddToContainment(Object object){
        containmentList.add(object);
    }
    public void RemoveFromContainment(int objectToRemove){
        containmentList.remove(containmentList.get(objectToRemove));
    }

    @Override
    public void Update(long nanoTime){

    }




}
