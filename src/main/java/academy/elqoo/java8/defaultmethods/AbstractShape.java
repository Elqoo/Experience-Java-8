package academy.elqoo.java8.defaultmethods;

public class AbstractShape implements Shape {

    private int xPos = 0;

    private int yPos = 0;

    @Override
    public int getXPos() {
        return xPos;
    }

    @Override
    public int getYPos() {
        return yPos;
    }

    @Override
    public void setXPos(int xPOs) {
        this.xPos = xPOs;
    }

    @Override
    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    @Override
    public String getName() {
        return "Abstract Shape";
    }
}
