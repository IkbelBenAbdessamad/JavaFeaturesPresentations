package main.patternmatchingswitch;

import main.generic.record.ColoredPoint;
import main.generic.record.Point;
import main.recordpatterns.Color;

public class PatternMatchSwitch {

    public static void start() {
        System.out.println("--------PatternMatchSwitch-------");
        checkObjInSwitchPriorTo21(null);
        checkObjInSwitchPriorTo21("Hello there");
        checkObjInSwitchPriorTo21(new ColoredPoint(new Point(1,1), Color.RED));
        checkObjInSwitch(null);
        checkObjInSwitch("Hello there");
        checkObjInSwitch(new ColoredPoint(new Point(1,1), Color.RED));
        matchPriority("hello");
        matchPriority("");
        multiCase(Color.RED);
        System.out.println("--------PatternMatchSwitch-------");
    }

    public static void checkObjInSwitchPriorTo21(Object o) {
        if (o == null) {
            System.out.println("p is null");
        } else if (o instanceof String s && s.equals("Hello")) {
            System.out.println("General Kenobi");
        } else if(o instanceof ColoredPoint coloredPoint) {
            System.out.println("Point is " + coloredPoint.c());
        } else {
            System.out.println("...");
        }
    }

    public static void checkObjInSwitch(Object o) {
        switch (o) {
            case null -> System.out.println("p is null");
            case String s when s.equals("Hello there") -> System.out.println("General Kenobi");
            case String s when s.equals("Hi") -> System.out.println("Hi!");
            case ColoredPoint coloredPoint -> System.out.println("Point is " + coloredPoint.c());
            default -> System.out.println("...");
        }
    }

    public interface CardClassification {}
    public enum Suit implements CardClassification { CLUBS, DIAMONDS, HEARTS, SPADES }
    public class Tarot implements CardClassification {}

    // very verbose
    public static void exhaustiveSwitchWithoutEnumSupport(CardClassification c) {
        switch (c) {
            case Suit s when s == Suit.CLUBS -> {
                System.out.println("It's clubs");
            }
            case Suit s when s == Suit.DIAMONDS -> {
                System.out.println("It's diamonds");
            }
            case Suit s when s == Suit.HEARTS -> {
                System.out.println("It's hearts");
            }
            case Suit s -> {
                System.out.println("It's spades");
            }
            case Tarot t -> {
                System.out.println("It's a tarot");
            }
            default -> System.out.println("Undefined");
        }
    }

    static void exhaustiveSwitchWithBetterEnumSupport(CardClassification c) {
        switch (c) {
            case Suit.CLUBS -> { // must qualify Suit.XXX if parameter is not of class Suit
                System.out.println("It's clubs");
            }
            case Suit.DIAMONDS -> {
                System.out.println("It's diamonds");
            }
            case Suit.HEARTS -> {
                System.out.println("It's hearts");
            }
//            case Suit.SPADES -> {
//                System.out.println("It's spades");
//            }
            case Tarot t -> {
                System.out.println("It's a tarot");
            }
//            default -> System.out.println("Undefined");
        }
    }

    public static void matchPriority(Object o) {
        switch(o) {
            case String s when !s.isEmpty() -> System.out.println("I am a non empty string");
            case String s -> System.out.println("I am a string " + s);
            case CharSequence cs -> System.out.println("I am a char sequence " + cs);
            default -> throw new IllegalStateException("Unexpected value: " + o);
        }
    }

    public static void handlingOfNull(Object o) {
        switch(o) {
            case Point p -> System.out.println("o is a point");
            case null, default ->
                    System.out.println("The rest (including null)");
        }
    }

    public static void multiCase(Object o) {
        switch(o) {
            case Point p -> System.out.println("o is a point");
            case ColoredPoint cp -> System.out.println("o is a colored point");
            case Tarot _, Color _ -> System.out.println("is Tarot or Color");
            case null, default ->
                    System.out.println("The rest (including null)");
        }
    }

    public static void deconstruct(Object o) {
        switch(o) {
            case Point(int x, int _) -> System.out.println("o is a point with x value of " + x);
            case null, default ->
                    System.out.println("The rest (including null)");
        }
    }
//    https://symflower.com/en/company/blog/2023/what-is-new-in-java-21/#445-unnamed-classes-and-instance-main-methods-previewhttpsopenjdkorgjeps445
//    https://www.oracle.com/java/technologies/javase/21-relnote-issues.html
//    https://openjdk.org/jeps/441
//    https://openjdk.org/jeps/406
}
