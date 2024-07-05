package main.recordpatterns;

import main.generic.record.ColoredPoint;
import main.generic.record.Point;
import main.generic.record.TwoPoints;

public class RecordPatternsRunner {

    private static final RecordPatternManager manager = new RecordPatternManager();

    public static void start() {
        System.out.println("--------RecordPatternsRunner-------");
        deconstructRecord();
        deconstructNestedRecords();

        System.out.println("--------RecordPatternsRunner-------");
    }

    public static void deconstructRecord() {
        Point point = new Point(0, 1);
        ColoredPoint coloredPoint = new ColoredPoint(point, Color.BLUE);
        Color c = manager.displayColorOfPoint(coloredPoint);
        System.out.println("Point color is: " + c);
        Color c2 = manager.displayColorOfPointV2(coloredPoint);
        System.out.println("Point color is: " + c2);
    }

    public static void deconstructNestedRecords() {

        Point point = new Point(0, 1);
        ColoredPoint coloredPoint = new ColoredPoint(point, Color.BLUE);
        ColoredPoint coloredPoint2 = new ColoredPoint(point, Color.RED);
        TwoPoints twoPoints = new TwoPoints(coloredPoint, coloredPoint2);
        Color c = manager.displayColorOfTwoPoints(twoPoints);
        System.out.println("Point color is: " + c);
    }
}
