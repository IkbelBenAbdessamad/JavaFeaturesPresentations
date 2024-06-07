package main.sealedfeature;

public non-sealed class Rectangle implements Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    public double width() {
        return width;
    }

    public double height() {
        return height;
    }
}