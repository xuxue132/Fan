package one;

public class Fan1 {
    static final int SLOW=1;
    static final int MEDIUM=2;
    static final int FAST=3;
    private int speed=SLOW;
    private Boolean on=false;
    private double radius;
    private String color="blue";

    public Fan1() {
    }
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Boolean getOn() {
        return on;
    }

    public void setOn(Boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString(){
        return "The speed is "+getSpeed()+" and the radius is "+getRadius()+" the color is "+
                getColor();
    }
}

class Test{
    public static void main(String[] args){
        Fan1 fan1=new Fan1();
        fan1.setSpeed(fan1.FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);
        System.out.print(fan1.toString());
    }
}