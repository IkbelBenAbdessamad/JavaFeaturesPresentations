package main.recordpatterns;

import main.generic.record.ColoredPoint;
import main.generic.record.Point;
import main.generic.record.TwoPoints;

public class RecordPatternManager {

    // new ColoredPoint(new Point(1, 2), Color.RED)

    public Color displayColorOfPointOldWay(ColoredPoint coloredPoint) {
        if(coloredPoint instanceof ColoredPoint cp) {
            return cp.c();
        }
        return Color.DEFAULT;
    }

    public Color displayColorOfPoint(ColoredPoint coloredPoint) {
        if(coloredPoint instanceof ColoredPoint(Point p, Color c)) {
            return c;
        }
        return Color.DEFAULT;
    }

    public Color displayColorOfPointV2(ColoredPoint coloredPoint) {
        if(coloredPoint instanceof ColoredPoint(_, Color c)) {
            return c;
        }
        return Color.DEFAULT;
    }

    public Color displayColorOfTwoPoints(TwoPoints twoPoints) {
        if(twoPoints instanceof TwoPoints(_, ColoredPoint(_, Color c))) {
            return c;
        }
        return Color.DEFAULT;
    }
}
