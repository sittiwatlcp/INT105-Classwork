package int105.abstraction;

import int105.enumerate.Color;

public abstract class GeometricObject implements Colorful {

    Color color;

    @Override
    public Color getColor() {
        return color;
    }

    public void setColor(Color c) {
        this.color = c;
    }

    public abstract double getArea();

    public abstract double getPerimeter();
    
    public String toString() {
        return color.toString();
    }
}
