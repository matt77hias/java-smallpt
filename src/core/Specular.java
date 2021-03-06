package core;

public class Specular {
    
	public static double reflectance0(double n1, double n2) {
        final double sqrt_R0 = (n1 - n2) / (n1 + n2);
        return sqrt_R0 * sqrt_R0;
    }

    public static double schlickReflectance(double n1, double n2, double c) {
        final double R0 = reflectance0(n1, n2);
        return R0 + (1 - R0) * c * c * c * c * c;
    }

    public static Vector3 idealSpecularReflect(Vector3 d, Vector3 n) {
        return Vector3.sub(d, Vector3.mul(2.0 * n.dot(d), n));
    }

    public static Vector3 idealSpecularTransmit(Vector3 d, Vector3 n, double n_out, double n_in, Probability probability, RNG rng) {
        Vector3 d_Re = idealSpecularReflect(d, n);

        final boolean out_to_in = n.dot(d) < 0;
        Vector3 nl = out_to_in ? n : Vector3.minus(n);
        final double nn = out_to_in ? n_out / n_in : n_in / n_out;
        final double cos_theta = d.dot(nl);
        final double cos2_phi = 1.0 - nn * nn * (1.0 - cos_theta * cos_theta);

        // Total Internal Reflection
        if (cos2_phi < 0) {
        	probability.pr = 1.0;
            return d_Re;
        }

        Vector3 d_Tr = (Vector3.sub(Vector3.mul(nn, d), Vector3.mul(nl, (nn * cos_theta + Math.sqrt(cos2_phi))))).normalize();
        final double c = 1.0 - (out_to_in ? -cos_theta : d_Tr.dot(n));

        final double Re = schlickReflectance(n_out, n_in, c);
        final double p_Re = 0.25 + 0.5 * Re;
        if (rng.uniformFloat() < p_Re) {
        	probability.pr = (Re / p_Re);
            return d_Re;
        }
        else  {
            final double Tr = 1.0 - Re;
            final double p_Tr = 1.0 - p_Re;
            probability.pr = (Tr / p_Tr);
            return d_Tr;
        }
    }
}
