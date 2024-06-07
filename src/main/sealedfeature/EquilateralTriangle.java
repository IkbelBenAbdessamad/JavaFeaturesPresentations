package main.sealedfeature;

public final class EquilateralTriangle extends Triangle {
    public EquilateralTriangle(double side) {
        super(side, Math.sqrt(3) / 2 * side);
    }
}