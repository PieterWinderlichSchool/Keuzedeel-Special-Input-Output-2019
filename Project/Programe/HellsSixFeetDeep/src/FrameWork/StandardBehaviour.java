package FrameWork;

import javafx.application.Application;

import java.util.ArrayList;


public abstract class StandardBehaviour  {

    public Vector2d transform = new Vector2d(0,0,0);
    public CustomAnimationTimer update = new CustomAnimationTimer(this::Update);
    protected ArrayList<Object> componentList = new ArrayList<Object>();


    public abstract void Update(long nanoTime);






    public void AddComponent(Object instance) {
        Object myInstance = instance;
        /*for (int i = 0; i <= componentList.size(); i++) {
            if (componentList.get(i) == null) {
               componentList.add(i , myInstance);
                return;
            }
            }
        */
        componentList.add(myInstance);
    }
    public void RemoveComponent(int objToRemove){
        componentList.remove(componentList.get(objToRemove));
    }
    public Object GetComponent(int i){
        return componentList.get(i);
    }

}
