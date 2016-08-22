package core;

public class Sampling {
    
	public static Vector3 uniformSampleOnHemisphere(double u1, double u2) {
        final double r = Math.sqrt(Math.max(0.0, 1.0 - u1 * u1));
        final double phi = 2.0 * MathUtils.M_PI * u2;
        return new Vector3(r * Math.cos(phi), r * Math.sin(phi), u1);
    }
}
