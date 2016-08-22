package core;

public class MathUtils {
	
	public static final double M_PI = 3.14159265358979323846;
	
	public static double trunc(double x) {
		return x - x % 1;
	}
	
    public static double clamp(double x, double low, double high) {
        return (x < high) ? ((x > low) ? x : low) : high;
    }

    public static byte toByte(double x, double gamma) {
        return (byte)clamp(255.0 * Math.pow(x, 1 / gamma), 0.0, 255.0);
    }
}
