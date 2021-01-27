package academy.elqoo.java8.defaultmethods;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collection;

public interface Shape {

    int getXPos();

    int getYPos();

    void setXPos(int xPOs);

    void setYPos(int yPos);

    default String getName(){
        return "";
    }
    default void move(int xPos, int yPos) {
        setXPos(xPos);
        setYPos(yPos);
    }

    static void moveXPosWith10(Collection<Shape> shapes){
        shapes.forEach(shape -> shape.setXPos(shape.getXPos()+10));
    }
    default void notImplementedMethod(){
        throw new NotImplementedException();
    }


}
