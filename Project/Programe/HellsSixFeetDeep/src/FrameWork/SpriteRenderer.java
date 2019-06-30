package FrameWork;

import javafx.scene.image.*;


import javafx.scene.layout.*;


public class SpriteRenderer {

    private Image image;
    public ImageView imageContainer;
    private double xPos;
    private double yPos;
    private double rot;
    private double xSize;
    private double ySize;


    public  SpriteRenderer(String imagePath,double xPos , double yPos , double ySize , double xSize , double rot){

        image = new Image(imagePath);
        this.imageContainer = new ImageView(image);

        this.xPos = xPos;
        this.rot = rot;
        this.xSize = xSize;
        this.yPos = yPos;

        this.ySize = ySize;
    }
    public double GetXPos(){
        return xPos;

    }
    public double GetYPos(){
        return yPos;
    }
    public void SetXPos(double Xpos){
        this.imageContainer.setX(Xpos);
    }
    public void SetYPos(double yPos){
        this.imageContainer.setY(yPos);
    }
    public void SetNewImage(Image imageToSet){
        this.image = imageToSet;
    }
    public void ChangeImageSize(double newXSize, double newYSize){
        this.imageContainer.setFitWidth(newXSize);
        this.imageContainer.setFitHeight(newYSize);
    }
    public void RenderSprite(Pane scene){
        this.imageContainer.setFitWidth(this.xSize);
        this.imageContainer.setFitHeight(this.ySize);
        this.imageContainer.setRotate(rot);
        this.imageContainer.setX(this.xPos);
        this.imageContainer.setY(this.yPos);

        scene.getChildren().add(this.imageContainer);

    }


}
