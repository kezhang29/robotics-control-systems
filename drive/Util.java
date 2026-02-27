package drive;

public class Util {
    public static double reduceAngle180(double degrees) {
        while (degrees >  180) degrees -= 360;
        while (degrees < -180) degrees += 360;
        return degrees;
    }

    public static double reduceAngle90(double degrees) {
        while (degrees >  90) degrees -= 180;
        while (degrees < -90) degrees += 180;
        return degrees;
    }

    public static boolean isLineSettled(double targetX, double targetY,
                                        double startAngle,
                                        double robotX, double robotY) {
        double dx = targetX - robotX;
        double dy = targetY - robotY;
        double angleToTarget = Math.toDegrees(Math.atan2(dx, dy));
        double diff = Math.abs(reduceAngle180(angleToTarget - startAngle));
        return diff > 90;
    }
}
