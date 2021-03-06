package core;

public class Sampling {
    
	public static Vector3 uniformSampleOnHemisphere(double u1, double u2) {
        final double sin_theta = Math.sqrt(Math.max(0.0, 1.0 - u1 * u1));
        final double phi = 2.0 * MathUtils.M_PI * u2;
        return new Vector3(Math.cos(phi) * sin_theta, Math.sin(phi) * sin_theta, u1);
    }
	
	public static Vector3 cosineWeightedSampleOnHemisphere(double u1, double u2) {
        final double cos_theta = Math.sqrt(1.0 - u1);
        final double sin_theta = Math.sqrt(u1);
        final double phi = 2.0 * MathUtils.M_PI * u2;
        return new Vector3(Math.cos(phi) * sin_theta, Math.sin(phi) * sin_theta, cos_theta);
    }
}
