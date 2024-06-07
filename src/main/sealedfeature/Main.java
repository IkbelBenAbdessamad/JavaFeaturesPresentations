package main.sealedfeature;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);
        Shape equilateralTriangle = new EquilateralTriangle(3);
        Shape isoscelesTriangle = new IsoscelesTriangle(5, 8);

        printShapeInfo(circle);
        printShapeInfo(rectangle);
        printShapeInfo(equilateralTriangle);
        printShapeInfo(isoscelesTriangle);
    }

    public static void printShapeInfo(Shape shape) {
        switch (shape) {
            case Circle c -> System.out.println("Circle with radius: " + c.getRadius() + ", area: " + c.area());
            case Rectangle r ->
                    System.out.println("Rectangle with width: " + r.width() + ", height: " + r.height() + ", area: " + r.area());
            case EquilateralTriangle et ->
                    System.out.println("Equilateral Triangle with side: " + et.getBase() + ", area: " + et.area());
            case IsoscelesTriangle it ->
                    System.out.println("Isosceles Triangle with base: " + it.getBase() + ", height: " + it.getHeight() + ", area: " + it.area());
            case Triangle t ->
                    System.out.println("Triangle with base: " + t.getBase() + ", height: " + t.getHeight() + ", area: " + t.area());
            default -> throw new IllegalStateException("Unexpected value: " + shape);
        }
    }
}
