package core;

public class Ray {
    
	public Vector3 o;
    public Vector3 d;
    public double tmin;
    public double tmax;
    public int depth;

    public Ray(Vector3 o, Vector3 d) {
        this(o, d, 0);
    }
    public Ray(Vector3 o, Vector3 d, double tmin) {
        this(o, d, tmin, Double.POSITIVE_INFINITY, 0);
    }
    public Ray(Vector3 o, Vector3 d, double tmin, double tmax, int depth) {
        this.o = o.clone();
        this.d = d.clone();
        this.tmin = tmin;
        this.tmax = tmax;
        this.depth = depth;
    }

    public Vector3 eval(double t) {
        return Vector3.add(this.o, Vector3.mul(this.d,  t));
    }

    @Override
    public String toString() {
        return "o: " + o.toString() + '\n' + "d: " + d.toString() + '\n';
    }
}