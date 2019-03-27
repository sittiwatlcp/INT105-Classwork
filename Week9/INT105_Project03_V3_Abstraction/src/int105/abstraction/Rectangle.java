package int105.abstraction;

import int105.enumerate.Color;

public class Rectangle extends GeometricObject {

    double width;
    double height;

    public Rectangle(double width, double height) {
        this.color = Color.BLACK;
        this.width = width > 0 ? width : 1.0;
        this.height = height > 0 ? height : 1.0;
    }

    public void setWidth(double width) {
        this.width = width > 0 ? width : this.width;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height > 0 ? height : this.height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
    
    public String toString() {
        return String.format("Rectangle(width=%.2f, height=%.2f, [%s])",
                width,height, super.toString());
    }
}
