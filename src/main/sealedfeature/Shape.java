package main.sealedfeature;

public sealed interface Shape permits Circle, Rectangle, Triangle {
    double area();
}
