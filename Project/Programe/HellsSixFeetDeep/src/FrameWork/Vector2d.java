package FrameWork;
import javafx.scene.image.*;
public class Vector2d extends ImageView {
    private double xPos;
    private double yPos;
    private double rot;
    public Vector2d(double xPos,double yPos , double rot){
        this.xPos = xPos;
        this.yPos = yPos;
        this.rot = rot;

    }

    public void AddVelocityY(double numberToAdd){

        this.yPos += numberToAdd;
    }
    public void AddVelocityX(double numberToAdd){
        this.xPos += numberToAdd;
    }


    public double GetXPos(){
        return xPos;
    }
    public double GetYPos(){
        return yPos;
    }
    public double GetRot(){return rot;}

    public void SetXPos(double xPos){
        this.xPos = xPos;
    }
    public void SetYPos(double yPos){
        this.yPos = yPos;
    }
    public void SetRot(double rot){this.rot = rot;}

}
